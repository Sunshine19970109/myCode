package day06.practice;

import java.io.File;

/*
 * �鿴��ǰĿ¼��������
 * 		����Ŀ¼���ж��ǲ����ļ���
 * 		�õ��ļ�����	
 */
public class FileDemo7 {
	public static void main(String[] args) {
		File f = new File(".");
		if (f.isDirectory()) {
			File[] f1 = f.listFiles();
			for (File file : f1) {
				System.out.println(file.getName());
			}
		}
	}
}























