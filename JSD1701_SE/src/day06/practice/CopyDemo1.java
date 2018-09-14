package day06.practice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 1 创建两个读写对象，创建记录读到字节变量，直到读到-1
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile r = new RandomAccessFile("music.mp3", "r");
		RandomAccessFile w = new RandomAccessFile("musicCopy1.mp3", "rw");
		int d = -1;
		byte[] b = new byte[1000];
		while ((d=r.read(b))!=-1) {
			w.write(b);
		}
		r.close();
		w.close();
	}
}

























