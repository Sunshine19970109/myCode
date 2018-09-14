package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取文件中的数据
 * @author dell
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile r 
		= new RandomAccessFile("raf.txt", "r");
		byte[] data = new byte[200];
		int len = r.read(data);
		String s = new String(data,0,len,"UTF-8");
		s.trim();
		System.out.println(s);
		r.close();
	}
}















