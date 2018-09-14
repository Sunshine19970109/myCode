package com.dms.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.dms.bo.LogData;

/**
 * 该测试用来测试IOUtil类中的方法:
 * public static List<LogData> loadLogData(File file) throws Exception
 */
public class Part1 {
	/**
	 * 从给定的文件中读取每一条配对日志,并以若干LogData实例保存然后存入
	 * 一个集合中后返回。
	 * 注:LogData有一个构造方法，可以将log.txt文件中:
	 *    lidz,441232,7,1375334515,192.168.1.61
	 *    格式的字符串直接传入，然后就生成了LogData对象。
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	public static List<LogData> loadLogData(File file) throws Exception{
		List<LogData>  logData = new ArrayList<LogData>();
//		String[] s = new String[5];
		InputStream is = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine())!=null) {
//			s = line.split("[,]{1}");
			LogData l = new LogData(line);
			
			logData.add(l);
		}
		br.close();
		return logData;
	}
	
	public static void main(String[] args) {
		try {
			File file = new File("src/test/resources/log.txt");
			List<LogData> list = loadLogData(file);
			/*
			 * 测试输出结果：
			 * 应与当前目录中log.txt文件内容一致:
			 * lidz,441232,7,1375334515,192.168.1.61
			 * ....
			 */
			for(LogData log : list){
				System.out.println(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
