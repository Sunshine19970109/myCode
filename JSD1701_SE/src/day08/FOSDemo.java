package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ��
 * ����������д���ݵ�
 * �����ݷ����Ϊ�������������
 * �������Ǵ������ȡ����
 * �������д���ݵ����
 * java.io.FileOutputStream
 * �ļ���������̳���OutoutStream,�������ļ���д��
 * ���ݵ�������һ���ͼ���
 * 
 * java.io.InputStream
 * �����ֽ��������ĸ��࣬��һ�������࣬��������ص�
 * ��ȡ������
 * 
 * java.io.OutputStream
 * �����ֽ����������һ�������࣬��������ص�д������
 * 
 * ���ַ�Ϊ:
 * �ڵ���(�ͼ���):��дһ�����ڽڵ������ڵ�������ʵ����
 * ��д���ݵ���������Դ��ȷ��
 * 
 * ������(�߼���):���ܶ������ڣ���Ҫ������������������
 * ʹ�����ǿ��Լ򻯶�д����ʱ�ĸ��Ӵ���
 * 
 * 
 * @author dell
 *
 */
public class FOSDemo {
	/*
	 * 1.����һ��FileOutputStream����,ѡ����ģʽ
	 * 2.��ʼд����,ת�ֽڣ�ָ���ַ���
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fos 
		= new FileOutputStream("fos.txt",true);
		String s = "���ڶ���·���棬������.";
		byte[] data =s.getBytes();
		/*
		 * Ĭ�ϴ������ļ����Ǹ���дģʽ����:
		 * ���ļ������ָ��ļ��Ѿ����ڣ���ô���Ƚ��ļ�
		 * ���������������
		 * 
		 * FileOutputStream�ṩ����һ�����췽����
		 * �÷���Ҫ����ڶ�����������һ��booleanֵ������ֵ
		 * Ϊtrue����׷��дģʽ����:
		 * �����ļ����ڣ����ļ�����ȫ������������ͨ��
		 * ��д������ݶ��ᱻ׷�ӵ��ļ�ĩβ��
		 */
		fos.write(data);
		fos.close();
		System.out.println("д�����");
	}
}




















