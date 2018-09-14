package com.dms.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.dms.IOUtil;
import com.dms.bo.LogData;
import com.dms.bo.LogRec;

/**
 * 该测试用例是用于测试DMSClient的
 * 第二步配对日志的方法
 * 当前测试用例中的属性都可以在DMSClient中找到
 * @author Xiloer
 *
 */
public class Part1 {
	//属性定义
	//保存解析后日志的文件
	private File textLogFile = new File("src/test/java/com/dms/test/log.txt");
	//第二步:配对日志所需要属性
	//保存配对日志的文件
	private File logRecFile = new File("src/test/java/com/dms/test/logrec.txt");
	//保存未配对日志的文件
	private File loginLogFile = new File("src/test/java/com/dms/test/login.txt");
	
	/**
	 * 第二步:配对日志
	 * @return true:配对成功
	 *         false:配对失败
	 */
	private boolean matchLogs(){
		try {
			/*
			 * 实现要求:
			 * 将第一步解析的新日志(textLogFile中记录)，与上次为配对成功
			 * 的登入日志(loginLogFile中记录)全部读取出来，然后再按照user,
			 * pid相同，type一个是7，一个是8进行配对。
			 * 注:只要能找到类型为8的，一定可以找到一个
			 *    能与之配对的登入日志。
			 * 将配对成功的日志存入logRecFile表示的文件中
			 * 将未配对的日志存入loginLogFile表的文件中   
			 * 成功配对后，需要将第一步生成的textLogFile文件
			 * 删除，以表示第二步成功。   
			 * 
			 * 实现步骤:
			 * 1:必要的判断
			 *   1.1:logRecFile是否存在，存在则不再
			 *       进行新的配对工作，避免覆盖。
			 *   1.2:textLogFile文件必须存在。    
			 * 2:读取textLogFile将日志读取出来，并
			 *   存入到集合中。(若干LogData实例)
			 *   注:使用IOUtil.loadLogData方法。
			 * 3:若loginLogFile文件若存在，则说明
			 *   有上次未配对成功的日志，也将其读取
			 *   出来存入步骤2的集合等待一起配对
			 *   注:使用IOUtil.loadLogData方法。
			 * 4:配对工作
			 *   4.1:创建一个集合，用于保存所有配对日志
			 *   4.2:创建两个Map分别保存登入日志与登出日志
			 *   4.3:遍历所有待配对的日志，按照登入与登出
			 *       分别存入两个Map中，
			 *       其中key:user,pid
			 *           value:LogData实例
			 *   4.4:遍历登出Map,并根据每条登出日志的key
			 *       去登入Map中找到对应的登入日志，并
			 *       以一个LogRec实例保存该配对日志，然后
			 *       存入配对日志的集合中。并将该配对日志
			 *       中的登入日志从登入Map中删除。这样一来
			 *       登入Map中应当只剩下没有配对的了。
			 *  5:将配对日志写入到logRecFile中
			 *    注:使用IOUtil.saveCollection方法
			 *  6:将所有未配对日志写入到loginLogFile中
			 *    注:使用IOUtil.saveCollection方法
			 *  7:将textLogFile文件删除
			 *  8:返回true,表示配对完毕
			 * 
			 */
			/*
			 * 1 读取两个文件的日志，并存入不同的map集合(为了读取到内存中开始计算这样速度快)，
			 * 	循环进行键值对匹配
			 * 2 匹配成功存入logRecFile,并删除，将两个map存入loginLogFile
			 * 3 删除textLogFile文件
			 * 
			 */
			if (!logRecFile.exists()) {
				boolean flag  = true;
				if (!loginLogFile.exists()) {
					 flag = false;
				}
				List<LogData> text = IOUtil.loadLogData(textLogFile);
				List<LogData> login = null;
				if (flag) {
					 login = IOUtil.loadLogData(loginLogFile);
				}
				
				Map<String, LogData> textMap = new HashMap<String, LogData>();
				Map<String, LogData> loginMap = new HashMap<String, LogData>();
				
				
				//配对成功存入集合
				List<String> suc = new ArrayList<String>();
				
				//初始化textMap
				for(LogData log :text){
					String key  = log.getUser()+","+log.getPid();
					textMap.put(key, log);
				}
				//初始化loginMap
				if (flag) {
					for(LogData log : login){
						String key = log.getUser()+","+log.getPid();
						loginMap.put(key, log);
					}
				}
				
				/*
				 * 1 遍历textMap,将里面的7，放入loginMap,并删除
				 * 2 所以现在只有8
				 */
				Iterator<Map.Entry<String, LogData>> it = textMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<java.lang.String, com.dms.bo.LogData> en = (Map.Entry<java.lang.String, com.dms.bo.LogData>) it
							.next();
					String textKey = en.getKey();
					LogData log = en.getValue();
					short type = log.getType();
					if (type==7) {
						loginMap.put(textKey, log);
						it.remove();
					}
				}
				
				/*
				 * 遍历textMap，开始用里面所有的8找7，并匹配
				 * 2 存入suc
				 */
				for(Map.Entry<String,LogData> en : textMap.entrySet()){
					String key = en.getKey();
					String s = textMap.get(key)+"|"+en.getValue();
					suc.add(s);
				}
				
				//将配对过后的textMap里面的存入loginMap
				//将loginMap剩下的元素转为list
				for(Map.Entry<String , LogData> entry : loginMap.entrySet()){
					LogData l = entry.getValue();
					login.add(l);
				}
				IOUtil.saveCollection(login, loginLogFile);
				IOUtil.saveCollection(suc, logRecFile);
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println("配对日志失败!");
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		try {
			Part1 p = new Part1();
			System.out.println(p.matchLogs());
			System.out.println("执行完毕");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
