package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ļ�
 * @author dell
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ��ԭ�ļ��е�ÿ���ֽ�˳���ȡ������д��
		 * ����һ���ļ��м��ﵽ�����ļ���Ŀ��
		 */
		RandomAccessFile src = new RandomAccessFile("music.mp3", "r");
		RandomAccessFile desc = 
				new RandomAccessFile("musicCopy.mp3", "rw");
		//��ʱ����ÿ�ζ�ȡ����һ���ֽ�
		int d = -1;
		long s = System.currentTimeMillis();
		while ((d=src.read())!=-1) {
			desc.write(d);
		}
		long e = System.currentTimeMillis();
		long r = e-s;
		System.out.println("�������");
		System.out.println("��ʱ:"+r);
		src.close();
		desc.close();
	}
}















