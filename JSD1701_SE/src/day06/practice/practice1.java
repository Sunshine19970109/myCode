package day06.practice;

import java.io.File;
/*
 * ������
 * 	���:NETWYORK
 * �����ڵ����ʹ������������Լ�Java��ʽ��������ļܹ��ص�
 * 	1)�������Ƿ�ֱ�����ض��ĵط�(����̡��ڴ桢�豸)��������Ϊ�ڵ����ʹ��������࣬
 * 	  �ڵ������Դ���һ���ض��ĵط�(�ڵ�)��д���ݣ��������Ƕ�һ���Ѵ��ڵ��������Ӻ�
 *   ��װ��ͨ������װ�����Ĺ��ܵ���ʵ�����ݶ�д��
 *  2)�������Ĺ��췽��������һ����������������������һ�������󾭹��������Ķ�ΰ�װ��
 *    ��Ϊ�������ӡ�
 * ����RandomAccessFile���read������write����ʹ��int���ʹ洢byte���ݵķ�ʽ��ԭ��
 * ����RandomAccessFile��FileInputStream��FileOutputStream��ʹ���е�����
 */

public class practice1 {
	public static void main(String[] args) {
		File f = new File(".");
		findFile(f);
	}
	private static void findFile(File f) {
		if (f.isDirectory()) {
			File[] f1= f.listFiles();
			for (File file : f1) {
				if (file.isFile()) {
					String s = file.getName();
					StringBuilder s1 = new StringBuilder(s);
					int index = s1.lastIndexOf(".");
					if("jar".equals(s1.substring(index+1))){
						System.out.println(s);
					}
				}else{
					findFile(file);
				}
				
			}
		}
	}
}











