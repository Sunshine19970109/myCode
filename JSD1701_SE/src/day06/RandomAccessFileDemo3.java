package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * д���ַ���
 * @author dell
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
		= new RandomAccessFile("456.txt", "rw");
		/*
		 * �ַ����ṩ�˿��Խ���ǰ�ַ���ת��Ϊһ���ֽڵķ���:
		 * 
		 * byte[] getBytes()
		 * ����ǰ�ַ�������ϵͳĬ�ϵ��ַ���ת��Ϊ�ֽ�����
		 * �ַ����ṩ��һ�����ص�getVytes���������԰���
		 * ָ�����ַ���д���ַ���:
		 * byte[] getBytes(String csn)
		 * ������ַ���Ϊָ�����ַ������ƣ������ִ�Сд
		 */
		String s = "��������ѧϰ������ʵ����õ�״̬";
		byte[] data = s.getBytes("UTF-8");
		raf.write(data);
		raf.close();
	}
}




















