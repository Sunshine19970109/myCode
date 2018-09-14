package day06.practice;

import java.io.File;
import java.io.FileFilter;

/**
 * 过滤器要求必须重写accept方法，而该方法的作用
 * 是定义过滤器过滤File对象的规则，若认为给定的File
 * 满足过滤器要求，则方法返回true	
 */
/*
 * 1 创建file，创建内部过滤器类，得到文件数组
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
