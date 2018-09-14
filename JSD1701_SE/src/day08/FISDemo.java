package day08;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * java.io.InputStream
 * 文件输入流
 * 用于从文件中读取数据
 * @author dell
 *
 */
public class FISDemo {
	/*
	 * 1.创建FileInputStream
	 * 2.定义byte[] 和 int len
	 * 3.读数据
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




















