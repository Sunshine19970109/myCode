package day06;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class NoteDemo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ļ���:");
		String fileName = sc.nextLine();
		RandomAccessFile raf 
		= new RandomAccessFile(fileName, "rw");
		System.out.println("�뿪ʼ����!");
		while (true) {
			String message = sc.nextLine();
			if ("exit".equals(message)) {
				break;
			}
			raf.write(message.getBytes("GBK"));
		}
		System.out.println("�ټ�");
		raf.close();
	}
}


























