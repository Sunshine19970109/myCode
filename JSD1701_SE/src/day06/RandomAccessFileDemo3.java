package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 写出字符串
 * @author dell
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
		= new RandomAccessFile("456.txt", "rw");
		/*
		 * 字符串提供了可以将当前字符串转换为一组字节的方法:
		 * 
		 * byte[] getBytes()
		 * 将当前字符串按照系统默认的字符集转换为字节数组
		 * 字符串提供了一个重载的getVytes方法，可以按照
		 * 指定的字符集写出字符串:
		 * byte[] getBytes(String csn)
		 * 传入的字符串为指定的字符集名称，不区分大小写
		 */
		String s = "不完美的学习资料其实是最好的状态";
		byte[] data = s.getBytes("UTF-8");
		raf.write(data);
		raf.close();
	}
}




















