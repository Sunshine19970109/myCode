package day06.practice;

import java.io.File;

/*
 * 查看当前目录所有子项
 * 		创建目录，判断是不是文件夹
 * 		拿到文件数组	
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























