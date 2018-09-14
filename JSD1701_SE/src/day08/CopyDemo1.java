package day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成文件复制操作
 * @author dell
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 使用文件输入读取原文件
		 * 使用文件输出流向目标文件中写入
		 * 1.创建输入输出流对象
		 * 2.读取数据，写入要复制的文件
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
		System.out.println("复制完毕");
	}
}


















