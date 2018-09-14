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
 * �����ṩ���ɶ�д����Ϊ�ͻ���ʹ��
 * @author Administrator
 *
 */
public class IOUtil {
	/**
	 * �Ӹ������ļ��ж�ȡÿһ���ַ���������
	 * һ�����Ϻ󷵻أ����ַ���Ӧ����һ�����
	 * ��־
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
	 * �Ӹ������ļ��ж�ȡÿһ����־����ת��Ϊ
	 * ����LogDataʵ��Ȼ�����Ǵ���List����
	 * �󷵻�
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
	 * ��������longֵ���ַ�������ʽд�뵽�ļ�
	 * �ĵ�һ��
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
	 * �������ļ����е�ÿ��Ԫ�ص�toString���ص��ַ�
	 * ������λ��λд�뵽�������ļ���
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
	 * �Ӹ�����RandomAccessFile�ĵ�ǰλ�ÿ�ʼ
	 * ������ȡ�������ȵ��ֽڣ���ת��Ϊ�ַ����󷵻�
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
	 * �Ӹ������ļ��ж�ȡһ���ַ���Ȼ����ת��
	 * Ϊһ��longֵ���ء�
	 * ��Ҫע�⣬���ļ��ĵ�һ�е��ַ������ݱ�����
	 * һ��������
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


