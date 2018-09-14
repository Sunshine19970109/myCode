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
 * 测试loadConfig方法。该方法是DMSServer中的
 * 方法。
 * @author Xiloer
 *
 */
public class Part1 {
	/**
	 * 构造方法初始化第一步，解析配置文件
	 * 读取并解析项目根目录中的配置文件server-config.xml，将
	 * 根标签<config>中的所有子标签解析出来，并将每一个子
	 * 标签的名字作为key,标签中间的文本作为value,存入到
	 * Map后返回。
	 * @return 返回的Map中保存的是配置文件中的
	 *         每一条内容，其中key:标签的名字，
	 *         value为标签中间的文本
	 * @throws Exception 
	 */
	private Map<String,String> loadConfig() throws Exception{
		try {
			Map<String,String> config
				= new HashMap<String,String>();
			/*
			 * 1 创建SAX类，获取document对象，获取root对象
			 * 2 获取其他标签的内容和标签名
			 */
			SAXReader reader = new SAXReader();
			InputStream is = new FileInputStream("config.xml");
			Document doc =  reader.read(is);
			Element root = doc.getRootElement();
			
			List<Element> l = root.elements();
			for (Element element : l) {
				String name =element.getName();
			
				String text = root.elementTextTrim(name);
				
				config.put(name, text);
			}
			
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
			 * {threadsum=30, serverport=8088, logrecfile=server-logs.txt}
			 */
			System.out.println(config);
		} catch (Exception e) {
			System.out.println("失败!");
		}
	}
}
