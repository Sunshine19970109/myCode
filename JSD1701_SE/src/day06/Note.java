package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 记事本程序
 * 
 * 程序启动后，要求用户输入文件名，然后创建并对该文件进行
 * 读写操作
 * 之后用户在控制台输入的每一行字符串都要写入到
 * 该文件中。
 * 当用户输入exit时，程序退出。
 * @author dell
 *
 */
public class Note {
	public static void main(String[] args) throws IOException {
		System.out.println("记事本程序已经打开,写文件请按1，"
				+ "读文件请按2，退出请写exit");
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
		System.out.println("请输入你要读取的文件名称");
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
		System.out.println("读取完毕！");
	}
	private static void myDelete() {
		System.out.println("请输入你要删除的文件名\\d\\r");
		Scanner sc  =  new Scanner(System.in);
		String s = sc.nextLine();
		byte[] data = new byte[1024];
		
	}
	private static void myWrite() throws IOException {
		System.out.println("请输入你要写的文件名\\d\\r");
		Scanner sc = new Scanner(System.in);
		String name  = sc.nextLine();
		RandomAccessFile raf 
		= new RandomAccessFile(name+".txt", "rw");
		System.out.println("文件"+name+".txt创建成功,请输入内容！\\d\\r");
		String s = sc.next();
		byte[] data = s.getBytes("GBK");
		int len  = -1;
		while ((len=raf.read(data))!=-1) {
			raf.write(data, 0, len);
		}
		System.out.println("写入完毕/d/r");
		raf.close();

	}
}

















