package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ϣ����߶�дЧ�ʣ�Ӧ�����ÿ�ζ�д�����������ٶ�Щ
 * �������ﵽ
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
	 * ����������ȡ�������ֽ������ܳ��ȵ��ֽ���
	 * ������Щ�ֽڴ��뵽�������ϣ�����ֵΪʵ��
	 * ��ȡ�����ֽ�����������ֵΪ-1�����ʾ
	 * ����û�ж����κ��ֽ�(�ļ�ĩβ)
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


















