package com.tarena;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tarena.bo.LogData;
import com.tarena.bo.LogRec;

/**
 * DMS系统客户端
 * 运行在电信向用户提供unix服务的服务器上。
 * 作用:
 * 周期性解析unix系统日志文件wtmpx，并将日志按照
 * 用户的登入与登出配对，最终在将配对日志全部发送至
 * DMS系统的服务端，完成用户上下线信息搜集。为日后
 * 电信计费提供数据支持。
 * 
 * 主要工作分为三步:
 * 1:解析wtmpx日志文件
 *   由于unix记录用户登录信息的日志文件是一个2进制
 *   文件，所以我们需要先按照其格式将需要的各项信息
 *   (用户名，进程ID，时间，类型，IP地址)解析出来
 *   然后以一行字符串的形式保存到一个文本文件中。
 * 2:配对日志
 *   将第一步解析出来的日志按照用户进行配对，形成若干
 *   组登入登出配对日志，并保存到一个文本文件中，等待
 *   上传到服务器
 * 3:上传配对日志
 *   将第二步配对的日志全部发送至服务端保存。
 *       
 * @author Administrator
 *
 */
public class DMSClient {
	/*
	 * 第一步需要用到的属性
	 */
	//unix系统日志文件(wtmpx)
	private File logFile;
	
	//保存解析后的日志的文件
	private File textLogFile;
	
	//书签文件
	private File lastPositionFile;
	
	//一次解析日志的条目数
	private int batch;
	
	/*
	 * 第二步需要用到的属性
	 */
	//保存配对日志的文件
	private File logRecFile;
	
	//保存没有配对的日志的文件
	private File loginLogFile;
	
	/*
	 * 第三步需要用到的属性
	 */
	//服务端地址
	private String serverHost;
	
	//服务端端口
	private int serverPort;
	
	
	/**
	 * 构造方法，用来初始化客户端
	 * @throws Exception 
	 */
	public DMSClient() throws Exception{
		try {
			//加载配置文件
			Map<String,String> config
				= loadConfig();
			//打桩
//			System.out.println(config);
			
			//根据配置项初始化相关属性
			init(config);
		} catch (Exception e) {
			System.out.println("客户端初始化失败!");
			throw e;
		}
	}
	/**
	 * 根据给定的配置信息初始化客户端的属性
	 * @param config
	 */
	private void init(Map<String,String> config){
		/*
		 * 初始化第一步需要的属性
		 */
		logFile = new File(config.get("logfile"));
		textLogFile = new File(config.get("textlogfile"));
		lastPositionFile = new File(config.get("lastpositionfile"));
		batch = Integer.parseInt(config.get("batch"));
		/*
		 * 初始化第二步需要的属性	
		 */
		logRecFile = new File(config.get("logrecfile"));
		loginLogFile = new File(config.get("loginlogfile"));
		
		/*
		 * 初始化第三步需要的属性
		 */
		serverHost = config.get("serverhost");
		
		serverPort = Integer.parseInt(config.get("serverport"));
		
	}
	
	/**
	 * 加载配置文件，并将配置文件中的每一项内容都
	 * 存入Map然后将其返回。
	 * Map中的
	 * key:配置项的名字
	 * value:配置项的值
	 * @return
	 */
	private Map<String,String> loadConfig()
						  throws Exception{
		/*
		 * 解析配置文件
		 */
		Map<String,String> config
			= new HashMap<String,String>();
		
		SAXReader reader
			= new SAXReader();
		
		Document doc
			= reader.read(
				new File("config.xml")
			);
		
		Element root = doc.getRootElement();
		
		/*
		 * 获取配置文件中<config>标签下的所有
		 * 子标签，并将标签名作为key,标签中间
		 * 的文本作为value存入Map后返回即可
		 */
		List<Element> list = root.elements();
		for(Element ele : list){
			//用标签的名字作为key
			String key = ele.getName();
			
			//用标签中间的文本作为value
			String value = ele.getTextTrim();
			
			config.put(key, value);
		}
		
		return config;
	}
	
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){
		try{
			while(true){
				//第一步:解析
				if(!parseLogs()){
					continue;
				}
				//第二步:配对
				if(!matchLogs()){
					continue;
				}
				//第三步:发送
				sendLogs();
			}
		}catch(Exception e){
			System.out.println("客户端运行失败");
		}
	}
	/**
	 * 第三步:上传配对日志
	 * @return
	 */
	private boolean sendLogs(){
		Socket socket = null;
		try {
			/*
			 * 步骤:
			 * 1:必要的判断
			 *   1.1:若保存第二步生成的配对日志
			 *       文件logRecFile不存在则无法
			 *       开始第三步
			 * 2:读取logRecFile并将每一条配对
			 *   日志读取出来并存入一个集合等待
			 *   发送
			 * 3:创建Socket连接服务端
			 * 4:通过Socket获取输出流，并包装为
			 *   PrintWriter准备发送配对日志。
			 * 5:将集合中每一条配对日志按行发送给
			 *   服务端。
			 * 6:最后发送给服务端一个字符串"OVER"
			 *   表示所有日志均已发送。
			 * 7:通过Socket获取输入流，并包装为
			 *   BufferedReader等待接收服务端的
			 *   响应
			 * 8:读取服务端发送回来的响应信息
			 * 9:若服务端发送回来的信息是"OK",则
			 *   表示服务端成功接收了所有日志，那么
			 *   就可以将第二步生成的保存配对日志的
			 *   文件LogRecFile删除并完成发送工作  
			 *               
			 */
			//1
			if(!logRecFile.exists()){
				System.out.println(logRecFile+"不存在!");
				return false;
			}
			//2
			List<String> matches 
				= IOUtil.readLogRec(logRecFile);
			
			//打桩
			for(String log : matches){
				System.out.println(log);
			}
			
			//3
			socket = new Socket(
				serverHost,serverPort
			);
			
			//4
			PrintWriter pw 
				= new PrintWriter(
				new OutputStreamWriter(
					socket.getOutputStream(),
					"UTF-8"
				)		
			);
			
			//5
			for(String log : matches){
				pw.println(log);
			}
			
			//6
			pw.println("OVER");
			pw.flush();
			
			//7
			BufferedReader br
				= new BufferedReader(
				new InputStreamReader(
					socket.getInputStream(),
					"UTF-8"
				)		
			);
			
			//8
			String response = br.readLine();
			
			//9
			if("OK".equals(response)){
				logRecFile.delete();
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	/**
	 * 第二步:配对日志
	 * @return
	 */
	private boolean matchLogs(){
		try {
			/*
			 * 步骤:
			 * 1:必要的判断
			 *   1.1:判断logRecFile文件是否存在，
			 *       若存在，说明已经成功配对过了，因为
			 *       第三步发送配对日志的工作完成后会将
			 *       该文件删除，所以该文件存在说明第三
			 *       步没有完成，那么第二步无需再重复配对
			 *   1.2:textLogFile文件不存在，不能进行
			 *       配对的
			 * 
			 *  2:先读取textLogFile文件，将所有日志读取出来
			 *    转换为若干LogData实例并存入集合等待配对。
			 *  
			 *  3:若loginLogFile文件存在，则说明有上次没配
			 *    对成功的日志，也应当将他们读取出来放入集合
			 *    等待一起配对。
			 *    
			 *  4:配对工作
			 *    4.1:创建两个Map
			 *        一个用于存放所有登入日志，另一个存放
			 *        所有登出日志。
			 *        key则是该日志:name,pid,host
			 *        value则是该日志对应的logData实例
			 *    4.2:分类
			 *        遍历带配对日志的集合，将所有登入日志
			 *        存入登入Map，登出日志存入登出Map
			 *    4.3:配对(根据登出找登入)
			 *        遍历登出Map，并使用登出日志对应的key
			 *        去登入Map中提取登入日志并构成一组配对
			 *        日志，并用一个LogRec对象保存。然后将
			 *        该对象存入另一个用于保存配对日志的集合。
			 *        然后将该登入日志从登入Map中删除。这样
			 *        以来，最终登入Map中只会剩下没有配对成
			 *        功的日志。
			 *  5:将所有配对日志写入logRecFile中
			 *  6:将未配对日志写入loginLogFile中
			 *  7:将第一步生成的textLogFile删除                             
			 */
			//1
			//1.1
			if(logRecFile.exists()){
				return true;
			}
			
			//1.2
			if(!textLogFile.exists()){
				System.out.println(textLogFile+"不存在!");
				return false;
			}
			
			//2
			List<LogData> list
				= IOUtil.readLogData(textLogFile);
			//打桩
//			for(LogData log : list){
//				System.out.println(log);
//			}
			
			//3
			if(loginLogFile.exists()){
				list.addAll(
					IOUtil.readLogData(loginLogFile)	
				);
			}
			
			//4
			Map<String,LogData> loginMap
				= new HashMap<String,LogData>();
			Map<String,LogData> logoutMap
				= new HashMap<String,LogData>();
			List<LogRec> matches 
				= new ArrayList<LogRec>();
			//分类
			for(LogData log : list){
				String key 
					= log.getUser()+","+
			          log.getPid()+","+
					  log.getHost();
				if(log.getType()==LogData.TYPE_LOGIN){
					loginMap.put(key, log);
				}else if(log.getType()==LogData.TYPE_LOGOUT){
					logoutMap.put(key, log);
				}
			}
			
			//打桩
//			System.out.println("登入map:");
//			System.out.println(loginMap);
//			
//			System.out.println("登出map:");
//			System.out.println(logoutMap);
			//遍历登出，根据登出找登入
			for(Entry<String,LogData> e:logoutMap.entrySet()){
				String key = e.getKey();
				LogData logout = e.getValue();
				LogData login = loginMap.remove(key);
				//创建配对日志实例
				LogRec logRec = new LogRec(login,logout);
				matches.add(logRec);			
			}
			
			//5
			IOUtil.saveCollection(matches, logRecFile);
			
			//6
			IOUtil.saveCollection(loginMap.values(), loginLogFile);
			
			//7
			textLogFile.delete();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 第一步:解析unix系统日志
	 * @return 若解析成功则返回true，否则返回false
	 */
	private boolean parseLogs(){
		RandomAccessFile raf = null;
		try {
			/*
			 * 解析步骤:
			 * 1:必要的判断
			 * 	 1.1:若textLogFile文件已经存在，说明
			 *       第一步已经成功执行过，无需再次
			 *       执行第一步。由于第二步配对成功
			 *       会将该文件删除，所以可以看出若
			 *       该文件存在说明第二步没有成功配对
			 *       那么第一步不能再次解析，否则会
			 *       将上次解析的日志覆盖导致数据丢失
			 *   1.2:unix系统日志文件要存在
			 *   1.3:是否还有日志可以解析，并
			 *       获取开始解析的位置
			 * 2:创建RandomAccessFile来读取
			 *   unix系统日志文件
			 * 3:移动RAF的指针到上次读取的最后
			 *   位置     
			 * 4:解析batch条日志，将每一条日志读取
			 *   出来并解析，然后将其转化为一个LogData
			 *   对象，并存入集合备用。
			 * 5:将集合中每一个LogData表示的日志以
			 *   行为单位写到textLogFile中。
			 * 6:将RAF当前指针位置写入书签文件。以便下次
			 *   从这里继续解析。         
			 */
			//1
			//1.1
			if(textLogFile.exists()){
				return true;
			}
			
			//1.2
			if(!logFile.exists()){
				System.out.println(logFile+"不存在!");
				return false;
			}
			//1.3
			long lastPosition = hasLogs();
			if(lastPosition<0){
				System.out.println("没有日志可以解析了!");
				return false;
			}
			//打桩
//			System.out.println(
//				"lastPosition:"+lastPosition
//			);
			
			
			
			//2
			raf = new RandomAccessFile(
				logFile,"r"
			);
			
			//3
			raf.seek(lastPosition);
			
			//4
			List<LogData> list
				= new ArrayList<LogData>();
			
			for(int i=0;i<batch;i++){
				/*
				 * 每次准备解析一条日志前，都应确保还有一条
				 * 可以解析，否则停止循环。
				 */
				if(logFile.length()-lastPosition<LogData.LOG_LENGTH){
					break;
				}
				
				//解析用户名
				raf.seek(lastPosition+LogData.USER_OFFSET);
				String user 
					= IOUtil.readString(
						raf, LogData.USER_LENGTH
					).trim();
				
				//解析PID
				raf.seek(lastPosition+LogData.PID_OFFSET);
				int pid = raf.readInt();
				
				//解析type
				raf.seek(lastPosition+LogData.TYPE_OFFSET);
				short type = raf.readShort();
				
				//解析time
				raf.seek(lastPosition+LogData.TIME_OFFSET);
				int time = raf.readInt();
				
				//解析host
				raf.seek(lastPosition+LogData.HOST_OFFSET);
				String host 
					= IOUtil.readString(
						raf, LogData.HOST_LENGTH
					).trim();
				
				LogData logData = new LogData(
					user, pid, type, time, host
				);
				list.add(logData);
				lastPosition = raf.getFilePointer();
			}
			
			//打桩
//			for(LogData log : list){
//				System.out.println(log);
//			}
			
			//5
			IOUtil.saveCollection(list, textLogFile);
			
			//6
			IOUtil.saveLong(lastPosition, lastPositionFile);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(raf!=null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	/**
	 * 该方法用在第一步中
	 * 作用:根据书签文件中的记录判断系统日志文件
	 * 是否还有日志可以解析，若有，则返回书签文件
	 * 中记录的上次最后解析的位置，以便开始新的解析
	 * 若没有日志可以解析则返回-1.
	 * @return
	 * @throws Exception 
	 */
	private long hasLogs() throws Exception{
		try {
			/*
			 * 首先查看书签文件是否存在，若
			 * 不存在，说明第一次解析，那就
			 * 从头开始解析即可。
			 */
			if(!lastPositionFile.exists()){
				return 0;
			}
			/*
			 * 若存在，则先将上次读取的位置获取
			 * 回来，在与系统日志文件的长度进行
			 * 比较，只要还有至少一条日志的长度
			 * 就可以返回该位置了。
			 */
			long lasPosition 
				= IOUtil.readLong(lastPositionFile);
			
			if(logFile.length()-lasPosition>=LogData.LOG_LENGTH){
				return lasPosition;
			}
			
		} catch (Exception e) {
			System.out.println(
				"判断是否还有可解析日志异常!"
			);
			throw e;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		try{
			DMSClient client 
						= new DMSClient();
			client.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}











