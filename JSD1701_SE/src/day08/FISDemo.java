package day08;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * java.io.InputStream
 * �ļ�������
 * ���ڴ��ļ��ж�ȡ����
 * @author dell
 *
 */
public class FISDemo {
	/*
	 * 1.����FileInputStream
	 * 2.����byte[] �� int len
	 * 3.������
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fis 
		= new FileInputStream("fos.txt");
		byte[] data = new byte[100];
		int len = -1;
		len =fis.read(data);
		String s = new String(data, 0, len, "GBK");
		System.out.println(s);
		fis.close();
	}
}




















