package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 若希望提高读写效率，应当提高每次读写的数据量减少短些
 * 次数来达到
 * @author dell
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
		= new RandomAccessFile("movie.mp4", "r");
		RandomAccessFile desc
		= new RandomAccessFile("movie.mp4", "rw");
	/*
	 * int read(byte[] data)
	 * 尝试连续读取给定的字节数组总长度的字节数
	 * 并将这些字节存入到该数字上，返回值为实际
	 * 读取到的字节量。若返回值为-1，则表示
	 * 本次没有读到任何字节(文件末尾)
	 */
		byte[] data = new byte[1024*10];//10k
		int len = -1;
		while ((len=src.read())!=-1) {
			desc.write(data, 0, len);
		}
		src.close();
		desc.close();
	}
}


















