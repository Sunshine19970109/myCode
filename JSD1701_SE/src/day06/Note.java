package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * ���±�����
 * 
 * ����������Ҫ���û������ļ�����Ȼ�󴴽����Ը��ļ�����
 * ��д����
 * ֮���û��ڿ���̨�����ÿһ���ַ�����Ҫд�뵽
 * ���ļ��С�
 * ���û�����exitʱ�������˳���
 * @author dell
 *
 */
public class Note {
	public static void main(String[] args) throws IOException {
		System.out.println("���±������Ѿ���,д�ļ��밴1��"
				+ "���ļ��밴2���˳���дexit");
		Scanner sc =  new Scanner(System.in);
		String s = sc.nextLine();
		while(!s.equals("exit")){
			if (s.equals("1")) {
				myWrite();
			}if(s.equals("2")){
				myRead();
			}
		}
	}
	private static void myRead() throws IOException {
		System.out.println("��������Ҫ��ȡ���ļ�����");
		Scanner sc = new Scanner(System.in);
		String name  = sc.nextLine();
		RandomAccessFile raf 
		= new RandomAccessFile(name+".txt", "r");
		byte[] date = new byte[1024];
		int len = -1;
		while ((len = raf.read(date))!=-1) {
			raf.read(date, 0, len);
		}
		raf.close();
		System.out.println("��ȡ��ϣ�");
	}
	private static void myDelete() {
		System.out.println("��������Ҫɾ�����ļ���\\d\\r");
		Scanner sc  =  new Scanner(System.in);
		String s = sc.nextLine();
		byte[] data = new byte[1024];
		
	}
	private static void myWrite() throws IOException {
		System.out.println("��������Ҫд���ļ���\\d\\r");
		Scanner sc = new Scanner(System.in);
		String name  = sc.nextLine();
		RandomAccessFile raf 
		= new RandomAccessFile(name+".txt", "rw");
		System.out.println("�ļ�"+name+".txt�����ɹ�,���������ݣ�\\d\\r");
		String s = sc.next();
		byte[] data = s.getBytes("GBK");
		int len  = -1;
		while ((len=raf.read(data))!=-1) {
			raf.write(data, 0, len);
		}
		System.out.println("д�����/d/r");
		raf.close();

	}
}

















