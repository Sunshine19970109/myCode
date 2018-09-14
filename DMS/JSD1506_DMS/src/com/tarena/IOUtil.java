package com.tarena;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.tarena.bo.LogData;

/**
 * 该类提供若干读写方法为客户端使用
 * @author Administrator
 *
 */
public class IOUtil {
	/**
	 * 从给定的文件中读取每一行字符串并存入
	 * 一个集合后返回，该字符串应当是一条配对
	 * 日志
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static List<String> readLogRec(File file)throws Exception{
		BufferedReader br = null;
		try {
			br = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						file	
					)	
				)	
			);
			List<String> list 
				= new ArrayList<String>();
			
			String line = null;
			while((line=br.readLine())!=null){
				list.add(line);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(br != null){
				br.close();
			}
		}
	}
	
	/**
	 * 从给定的文件中读取每一行日志，并转换为
	 * 若干LogData实例然后将它们存入List集合
	 * 后返回
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static List<LogData> readLogData(File file)
									throws Exception{
		BufferedReader br = null;
		try {
			br = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						file	
					)	
				)	
			);
			List<LogData> list 
				= new ArrayList<LogData>();
			
			String line = null;
			while((line=br.readLine())!=null){
				LogData logData 
					= new LogData(line);
				list.add(logData);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(br != null){
				br.close();
			}
		}
	}
	
	/**
	 * 将给定的long值以字符串的形式写入到文件
	 * 的第一行
	 * @param l
	 * @param file
	 * @throws Exception
	 */
	public static void saveLong(
						long l,File file)
						throws Exception{
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			pw.println(l);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	/**
	 * 将给定的集合中的每个元素的toString返回的字符
	 * 串以行位单位写入到给定的文件中
	 * @param c
	 * @param file
	 * @throws Exception
	 */
	public static void saveCollection(
					Collection c,File file)
						  throws Exception{
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			for(Object obj : c){
				pw.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	/**
	 * 从给定的RandomAccessFile的当前位置开始
	 * 连续读取给定长度的字节，并转换为字符串后返回
	 * @param raf
	 * @param length
	 * @return
	 * @throws Exception 
	 */
	public static String readString(
			RandomAccessFile raf,int length)
						   throws Exception{
		try {
			byte[] data = new byte[length];
			raf.read(data);
			return new String(data,"ISO8859-1");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/**
	 * 从给定的文件中读取一行字符换然后将其转换
	 * 为一个long值返回。
	 * 需要注意，该文件的第一行的字符串内容必须是
	 * 一个整数。
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	public static long readLong(File file) 
						   throws Exception{
		BufferedReader br = null;
		try {
			br = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						file	
					)	
				)	
			);
			String line = br.readLine().trim();
			return Long.parseLong(line);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(br != null){
				br.close();
			}
		}
	}
}


