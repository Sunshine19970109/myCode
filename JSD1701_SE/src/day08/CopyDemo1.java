package day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ���ļ�������ļ����Ʋ���
 * @author dell
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ʹ���ļ������ȡԭ�ļ�
		 * ʹ���ļ��������Ŀ���ļ���д��
		 * 1.�����������������
		 * 2.��ȡ���ݣ�д��Ҫ���Ƶ��ļ�
		 */
		FileInputStream fis = new FileInputStream("fos.txt");
		FileOutputStream fos = new FileOutputStream("fosCopy.txt");
		byte[] data = new byte[100];
		int len = -1;
		while((len=fis.read(data))!=-1){
		fos.write(data,0,len);
		}
		fis.close();
		fos.close();
		System.out.println("�������");
	}
}


















