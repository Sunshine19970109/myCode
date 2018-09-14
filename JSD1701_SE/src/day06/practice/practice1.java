package day06.practice;

import java.io.File;
/*
 * 第四题
 * 	输出:NETWYORK
 * 简述节点流和处理流的区别，以及Java流式输入输出的架构特点
 * 	1)按照流是否直接与特定的地方(如磁盘、内存、设备)相连，分为节点流和处理流两类，
 * 	  节点流可以从向一个特定的地方(节点)读写数据；处理流是对一个已存在的流的连接和
 *   封装，通过所封装的流的功能调用实现数据读写。
 *  2)处理流的构造方法总是以一个其他的流对象做参数。一个流对象经过其他流的多次包装，
 *    称为流的链接。
 * 简述RandomAccessFile类的read方法和write方法使用int类型存储byte数据的方式和原因
 * 简述RandomAccessFile和FileInputStream及FileOutputStream在使用中的区别
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











