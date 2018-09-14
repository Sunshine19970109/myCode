package com.dms.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**
 * 测试用例1
 * 测试loadConfig方法。该方法是DMSClient中的
 * 方法。
 * @author Xiloer
 *
 */
public class Part1 {
	/**
	 * 构造方法初始化第一步，解析配置文件
	 * 读取并解析项目根目录中的配置文件config.xml，将
	 * 根标签<config>中的所有子标签解析出来，并将每一个子
	 * 标签的名字作为key,标签中间的文本作为value,存入到
	 * Map后返回。
	 * @return 返回的Map中保存的是配置文件中的
	 *         每一条内容，其中key:标签的名字，
	 *         value为标签中间的文本
	 * @throws Exception 
	 */
	
	
	
	
	private Map<String,String> loadConfig() throws Exception{
		/*
		 * 1. 导入dom4j的jar包，导入xml-apis的jar包
		 * 解析XMl文件
		 * 1 SAXReader对象创建
		 * 2 获取doc对象
		 * 3 获取root根标签
		 * 4 获取元素集合list
		 * 5 遍历集合获取子标签的值
		 * 6 存入map集合
		 */
		try {
			Map<String,String> config = new HashMap<String,String>();
			SAXReader reader = new SAXReader();
			InputStream in = new FileInputStream("config.xml");
			Document doc = reader.read(in);
			Element root = doc.getRootElement();
			List<Element> configEle = root.elements();
			
			//unix系统日志文件名
			
			String logfile = root.elementTextTrim("logfile");
			
			
			
			//保存解析后日志的文件名
			String textlogfile = root.elementTextTrim("textlogfile");
			//书签文件名
			String lastpositionfile = root.elementTextTrim("lastpositionfile");
			//每次解析日志的条目数
			String batch = root.elementTextTrim("batch");
			//配对日志文件名
			String logrecfile = root.elementTextTrim("logrecfile");
			//未配对日志文件名
			String loginlogfile = root.elementTextTrim("loginlogfile");
			//服务端地址
			String serverhost = root.elementTextTrim("serverhost");
			//服务端端口
			String serverport = root.elementTextTrim("serverport");
			//存入map集合
			
			config.put("textlogfile", textlogfile);
			config.put("lastpositionfile", lastpositionfile);
			config.put("batch", batch);
			config.put("logrecfile", logrecfile);
			config.put("loginlogfile", loginlogfile);
			config.put("serverhost", serverhost);
			config.put("serverport", serverport);
			config.put("logfile", logfile);
			
			return config;
		} catch (Exception e) {
			System.out.println("解析配置文件异常!");
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			Part1 p = new Part1();
			Map<String,String> config = p.loadConfig();
			/*
			 * 输出后的效果应当为:
			 * {serverport=8088, logfile=wtmpx, lastpositionfile=last-position.txt, loginlogfile=login.txt, batch=10, serverhost=localhost, logrecfile=logrec.txt, textlogfile=log.txt}
			 */
			System.out.println(config);
		} catch (Exception e) {
			System.out.println("失败!");
		}
	}
}
