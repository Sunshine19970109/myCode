package day09.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 1.���ʽ���:ISO8859-1,GBK,UTF-8
 * ISO8859-1:���ı������ASCII,һ��Ӣ����ĸһ���ֽ�
 * GBK:���ı�����GB2312�ĳ�����1-2�䳤���룬
 * Ӣ����ASCIIһ�£�����2���ֽڣ����Զ�20000���
 * ���ֽ��б��롣
 * UTF-8:1��4�ֽڵı䳤���룬Ӣ����ascllһ�£�
 * ����3���ֽڡ�
 * 2.�ֱ����ISR��OSW�Ĺ���ԭ��
 * InputStreamReader�ַ���������ʹ�ø�������
 * �����ַ�����������ָ�����ַ������ֽ����а���ָ��
 * ���뽫�ֽ�����ת��Ϊ�ַ����ݲ���ȡ��
 * OutputStreamWriter�ַ��������ʹ�ø�������
 * �����ַ�����������ָ�����ַ������ַ�ת��Ϊ��Ӧ��
 * �ֽں�ͨ������д��
 * 
 *  ����Error��Exception������
 *  Error�����޸ĵĴ���Exception�����޸ĵ��쳣
 * @author dell
 *5.---D
 */
public class Pratice1 {
	/*
	 *  ��ȡ�ı��ļ��е�ÿһ��������Ϣ��������ٴ������һ��
	 *  1.����br����
	 *  2.��ȡ�У�ƴ�ӻ�����ַ���
	 *  3.����pw����д���ַ���,����fos����ʱע��ѡ��ƴ��
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br 
		= new BufferedReader(
				new InputStreamReader(
						new FileInputStream("fos.txt")));
		
//		BufferedWriter bw 
//		= new BufferedWriter(
//				new OutputStreamWriter(
//						new FileOutputStream("2.txt")));
//		bw.write("��Һ�!");
//		bw.write("    hello!");
//		bw.write("    bye!");
		String line = "";
		String s = "";
		while ((line = br.readLine())!=null) {
			s = (s+line).trim();
//			pw.write(line);
			System.out.println(line);
		}
		PrintWriter pw = new PrintWriter(new FileOutputStream("fos.txt",true), true);
		pw.println();
		pw.println(s);
//		if (s!=null) {
//			pw.write(s);
//		}
		System.out.println(s);
		br.close();
		pw.close();
		System.out.println("����");	
	}
}






















