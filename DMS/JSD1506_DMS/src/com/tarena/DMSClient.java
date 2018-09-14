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
 * DMSϵͳ�ͻ���
 * �����ڵ������û��ṩunix����ķ������ϡ�
 * ����:
 * �����Խ���unixϵͳ��־�ļ�wtmpx��������־����
 * �û��ĵ�����ǳ���ԣ������ڽ������־ȫ��������
 * DMSϵͳ�ķ���ˣ�����û���������Ϣ�Ѽ���Ϊ�պ�
 * ���żƷ��ṩ����֧�֡�
 * 
 * ��Ҫ������Ϊ����:
 * 1:����wtmpx��־�ļ�
 *   ����unix��¼�û���¼��Ϣ����־�ļ���һ��2����
 *   �ļ�������������Ҫ�Ȱ������ʽ����Ҫ�ĸ�����Ϣ
 *   (�û���������ID��ʱ�䣬���ͣ�IP��ַ)��������
 *   Ȼ����һ���ַ�������ʽ���浽һ���ı��ļ��С�
 * 2:�����־
 *   ����һ��������������־�����û�������ԣ��γ�����
 *   �����ǳ������־�������浽һ���ı��ļ��У��ȴ�
 *   �ϴ���������
 * 3:�ϴ������־
 *   ���ڶ�����Ե���־ȫ������������˱��档
 *       
 * @author Administrator
 *
 */
public class DMSClient {
	/*
	 * ��һ����Ҫ�õ�������
	 */
	//unixϵͳ��־�ļ�(wtmpx)
	private File logFile;
	
	//������������־���ļ�
	private File textLogFile;
	
	//��ǩ�ļ�
	private File lastPositionFile;
	
	//һ�ν�����־����Ŀ��
	private int batch;
	
	/*
	 * �ڶ�����Ҫ�õ�������
	 */
	//���������־���ļ�
	private File logRecFile;
	
	//����û����Ե���־���ļ�
	private File loginLogFile;
	
	/*
	 * ��������Ҫ�õ�������
	 */
	//����˵�ַ
	private String serverHost;
	
	//����˶˿�
	private int serverPort;
	
	
	/**
	 * ���췽����������ʼ���ͻ���
	 * @throws Exception 
	 */
	public DMSClient() throws Exception{
		try {
			//���������ļ�
			Map<String,String> config
				= loadConfig();
			//��׮
//			System.out.println(config);
			
			//�����������ʼ���������
			init(config);
		} catch (Exception e) {
			System.out.println("�ͻ��˳�ʼ��ʧ��!");
			throw e;
		}
	}
	/**
	 * ���ݸ�����������Ϣ��ʼ���ͻ��˵�����
	 * @param config
	 */
	private void init(Map<String,String> config){
		/*
		 * ��ʼ����һ����Ҫ������
		 */
		logFile = new File(config.get("logfile"));
		textLogFile = new File(config.get("textlogfile"));
		lastPositionFile = new File(config.get("lastpositionfile"));
		batch = Integer.parseInt(config.get("batch"));
		/*
		 * ��ʼ���ڶ�����Ҫ������	
		 */
		logRecFile = new File(config.get("logrecfile"));
		loginLogFile = new File(config.get("loginlogfile"));
		
		/*
		 * ��ʼ����������Ҫ������
		 */
		serverHost = config.get("serverhost");
		
		serverPort = Integer.parseInt(config.get("serverport"));
		
	}
	
	/**
	 * ���������ļ������������ļ��е�ÿһ�����ݶ�
	 * ����MapȻ���䷵�ء�
	 * Map�е�
	 * key:�����������
	 * value:�������ֵ
	 * @return
	 */
	private Map<String,String> loadConfig()
						  throws Exception{
		/*
		 * ���������ļ�
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
		 * ��ȡ�����ļ���<config>��ǩ�µ�����
		 * �ӱ�ǩ��������ǩ����Ϊkey,��ǩ�м�
		 * ���ı���Ϊvalue����Map�󷵻ؼ���
		 */
		List<Element> list = root.elements();
		for(Element ele : list){
			//�ñ�ǩ��������Ϊkey
			String key = ele.getName();
			
			//�ñ�ǩ�м���ı���Ϊvalue
			String value = ele.getTextTrim();
			
			config.put(key, value);
		}
		
		return config;
	}
	
	/**
	 * �ͻ��˿�ʼ�����ķ���
	 */
	public void start(){
		try{
			while(true){
				//��һ��:����
				if(!parseLogs()){
					continue;
				}
				//�ڶ���:���
				if(!matchLogs()){
					continue;
				}
				//������:����
				sendLogs();
			}
		}catch(Exception e){
			System.out.println("�ͻ�������ʧ��");
		}
	}
	/**
	 * ������:�ϴ������־
	 * @return
	 */
	private boolean sendLogs(){
		Socket socket = null;
		try {
			/*
			 * ����:
			 * 1:��Ҫ���ж�
			 *   1.1:������ڶ������ɵ������־
			 *       �ļ�logRecFile���������޷�
			 *       ��ʼ������
			 * 2:��ȡlogRecFile����ÿһ�����
			 *   ��־��ȡ����������һ�����ϵȴ�
			 *   ����
			 * 3:����Socket���ӷ����
			 * 4:ͨ��Socket��ȡ�����������װΪ
			 *   PrintWriter׼�����������־��
			 * 5:��������ÿһ�������־���з��͸�
			 *   ����ˡ�
			 * 6:����͸������һ���ַ���"OVER"
			 *   ��ʾ������־���ѷ��͡�
			 * 7:ͨ��Socket��ȡ������������װΪ
			 *   BufferedReader�ȴ����շ���˵�
			 *   ��Ӧ
			 * 8:��ȡ����˷��ͻ�������Ӧ��Ϣ
			 * 9:������˷��ͻ�������Ϣ��"OK",��
			 *   ��ʾ����˳ɹ�������������־����ô
			 *   �Ϳ��Խ��ڶ������ɵı��������־��
			 *   �ļ�LogRecFileɾ������ɷ��͹���  
			 *               
			 */
			//1
			if(!logRecFile.exists()){
				System.out.println(logRecFile+"������!");
				return false;
			}
			//2
			List<String> matches 
				= IOUtil.readLogRec(logRecFile);
			
			//��׮
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
	 * �ڶ���:�����־
	 * @return
	 */
	private boolean matchLogs(){
		try {
			/*
			 * ����:
			 * 1:��Ҫ���ж�
			 *   1.1:�ж�logRecFile�ļ��Ƿ���ڣ�
			 *       �����ڣ�˵���Ѿ��ɹ���Թ��ˣ���Ϊ
			 *       ���������������־�Ĺ�����ɺ�Ὣ
			 *       ���ļ�ɾ�������Ը��ļ�����˵������
			 *       ��û����ɣ���ô�ڶ����������ظ����
			 *   1.2:textLogFile�ļ������ڣ����ܽ���
			 *       ��Ե�
			 * 
			 *  2:�ȶ�ȡtextLogFile�ļ�����������־��ȡ����
			 *    ת��Ϊ����LogDataʵ�������뼯�ϵȴ���ԡ�
			 *  
			 *  3:��loginLogFile�ļ����ڣ���˵�����ϴ�û��
			 *    �Գɹ�����־��ҲӦ�������Ƕ�ȡ�������뼯��
			 *    �ȴ�һ����ԡ�
			 *    
			 *  4:��Թ���
			 *    4.1:��������Map
			 *        һ�����ڴ�����е�����־����һ�����
			 *        ���еǳ���־��
			 *        key���Ǹ���־:name,pid,host
			 *        value���Ǹ���־��Ӧ��logDataʵ��
			 *    4.2:����
			 *        �����������־�ļ��ϣ������е�����־
			 *        �������Map���ǳ���־����ǳ�Map
			 *    4.3:���(���ݵǳ��ҵ���)
			 *        �����ǳ�Map����ʹ�õǳ���־��Ӧ��key
			 *        ȥ����Map����ȡ������־������һ�����
			 *        ��־������һ��LogRec���󱣴档Ȼ��
			 *        �ö��������һ�����ڱ��������־�ļ��ϡ�
			 *        Ȼ�󽫸õ�����־�ӵ���Map��ɾ��������
			 *        ���������յ���Map��ֻ��ʣ��û����Գ�
			 *        ������־��
			 *  5:�����������־д��logRecFile��
			 *  6:��δ�����־д��loginLogFile��
			 *  7:����һ�����ɵ�textLogFileɾ��                             
			 */
			//1
			//1.1
			if(logRecFile.exists()){
				return true;
			}
			
			//1.2
			if(!textLogFile.exists()){
				System.out.println(textLogFile+"������!");
				return false;
			}
			
			//2
			List<LogData> list
				= IOUtil.readLogData(textLogFile);
			//��׮
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
			//����
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
			
			//��׮
//			System.out.println("����map:");
//			System.out.println(loginMap);
//			
//			System.out.println("�ǳ�map:");
//			System.out.println(logoutMap);
			//�����ǳ������ݵǳ��ҵ���
			for(Entry<String,LogData> e:logoutMap.entrySet()){
				String key = e.getKey();
				LogData logout = e.getValue();
				LogData login = loginMap.remove(key);
				//���������־ʵ��
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
	 * ��һ��:����unixϵͳ��־
	 * @return �������ɹ��򷵻�true�����򷵻�false
	 */
	private boolean parseLogs(){
		RandomAccessFile raf = null;
		try {
			/*
			 * ��������:
			 * 1:��Ҫ���ж�
			 * 	 1.1:��textLogFile�ļ��Ѿ����ڣ�˵��
			 *       ��һ���Ѿ��ɹ�ִ�й��������ٴ�
			 *       ִ�е�һ�������ڵڶ�����Գɹ�
			 *       �Ὣ���ļ�ɾ�������Կ��Կ�����
			 *       ���ļ�����˵���ڶ���û�гɹ����
			 *       ��ô��һ�������ٴν����������
			 *       ���ϴν�������־���ǵ������ݶ�ʧ
			 *   1.2:unixϵͳ��־�ļ�Ҫ����
			 *   1.3:�Ƿ�����־���Խ�������
			 *       ��ȡ��ʼ������λ��
			 * 2:����RandomAccessFile����ȡ
			 *   unixϵͳ��־�ļ�
			 * 3:�ƶ�RAF��ָ�뵽�ϴζ�ȡ�����
			 *   λ��     
			 * 4:����batch����־����ÿһ����־��ȡ
			 *   ������������Ȼ����ת��Ϊһ��LogData
			 *   ���󣬲����뼯�ϱ��á�
			 * 5:��������ÿһ��LogData��ʾ����־��
			 *   ��Ϊ��λд��textLogFile�С�
			 * 6:��RAF��ǰָ��λ��д����ǩ�ļ����Ա��´�
			 *   ���������������         
			 */
			//1
			//1.1
			if(textLogFile.exists()){
				return true;
			}
			
			//1.2
			if(!logFile.exists()){
				System.out.println(logFile+"������!");
				return false;
			}
			//1.3
			long lastPosition = hasLogs();
			if(lastPosition<0){
				System.out.println("û����־���Խ�����!");
				return false;
			}
			//��׮
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
				 * ÿ��׼������һ����־ǰ����Ӧȷ������һ��
				 * ���Խ���������ֹͣѭ����
				 */
				if(logFile.length()-lastPosition<LogData.LOG_LENGTH){
					break;
				}
				
				//�����û���
				raf.seek(lastPosition+LogData.USER_OFFSET);
				String user 
					= IOUtil.readString(
						raf, LogData.USER_LENGTH
					).trim();
				
				//����PID
				raf.seek(lastPosition+LogData.PID_OFFSET);
				int pid = raf.readInt();
				
				//����type
				raf.seek(lastPosition+LogData.TYPE_OFFSET);
				short type = raf.readShort();
				
				//����time
				raf.seek(lastPosition+LogData.TIME_OFFSET);
				int time = raf.readInt();
				
				//����host
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
			
			//��׮
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
	 * �÷������ڵ�һ����
	 * ����:������ǩ�ļ��еļ�¼�ж�ϵͳ��־�ļ�
	 * �Ƿ�����־���Խ��������У��򷵻���ǩ�ļ�
	 * �м�¼���ϴ���������λ�ã��Ա㿪ʼ�µĽ���
	 * ��û����־���Խ����򷵻�-1.
	 * @return
	 * @throws Exception 
	 */
	private long hasLogs() throws Exception{
		try {
			/*
			 * ���Ȳ鿴��ǩ�ļ��Ƿ���ڣ���
			 * �����ڣ�˵����һ�ν������Ǿ�
			 * ��ͷ��ʼ�������ɡ�
			 */
			if(!lastPositionFile.exists()){
				return 0;
			}
			/*
			 * �����ڣ����Ƚ��ϴζ�ȡ��λ�û�ȡ
			 * ����������ϵͳ��־�ļ��ĳ��Ƚ���
			 * �Ƚϣ�ֻҪ��������һ����־�ĳ���
			 * �Ϳ��Է��ظ�λ���ˡ�
			 */
			long lasPosition 
				= IOUtil.readLong(lastPositionFile);
			
			if(logFile.length()-lasPosition>=LogData.LOG_LENGTH){
				return lasPosition;
			}
			
		} catch (Exception e) {
			System.out.println(
				"�ж��Ƿ��пɽ�����־�쳣!"
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











