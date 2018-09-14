package day06;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class NoteDemo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入文件名:");
		String fileName = sc.nextLine();
		RandomAccessFile raf 
		= new RandomAccessFile(fileName, "rw");
		System.out.println("请开始输入!");
		while (true) {
			String message = sc.nextLine();
			if ("exit".equals(message)) {
				break;
			}
			raf.write(message.getBytes("GBK"));
		}
		System.out.println("再见");
		raf.close();
	}
}


























