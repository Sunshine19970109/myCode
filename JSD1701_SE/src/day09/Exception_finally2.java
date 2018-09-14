package day09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �쳣���������IO�����еĴ���
 * @author dell
 *
 */
public class Exception_finally2 {
	/*
	 * ��Դ�����������̨
	 * 1.����br,try catch
	 * 2.�ر���
	 * 
	 * Ҫ�����ֲ�������������ȫ�ֱ������壬�ֲ���ʼ��
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(new FileInputStream(
							"src"+File.separator+
							"day09"+File.separator+"Exception_finally2.java")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = null;
		try {
			while ((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}


















