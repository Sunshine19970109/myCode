package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author dell
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 将原文件中的每个字节顺序读取出来并写入
		 * 到另一个文件中即达到复制文件的目的
		 */
		RandomAccessFile src = new RandomAccessFile("music.mp3", "r");
		RandomAccessFile desc = 
				new RandomAccessFile("musicCopy.mp3", "rw");
		//临时保存每次读取到的一个字节
		int d = -1;
		long s = System.currentTimeMillis();
		while ((d=src.read())!=-1) {
			desc.write(d);
		}
		long e = System.currentTimeMillis();
		long r = e-s;
		System.out.println("复制完毕");
		System.out.println("用时:"+r);
		src.close();
		desc.close();
	}
}















