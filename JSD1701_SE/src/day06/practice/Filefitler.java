package day06.practice;

import java.io.File;
import java.io.FileFilter;

/**
 * ������Ҫ�������дaccept���������÷���������
 * �Ƕ������������File����Ĺ�������Ϊ������File
 * ���������Ҫ���򷽷�����true	
 */
/*
 * 1 ����file�������ڲ��������࣬�õ��ļ�����
 * 
 */
public class Filefitler {
	public static void main(String[] args) {
		File f = new File(".");
		File[] f1 = f.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.isFile();
			}
		});
		for (File file : f1) {
			System.out.println(file.getName() );
		}
	}
}
