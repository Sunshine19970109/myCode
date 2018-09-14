package day09.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 1.名词解释:ISO8859-1,GBK,UTF-8
 * ISO8859-1:西文编码就是ASCII,一个英文字母一个字节
 * GBK:中文编码是GB2312的超集，1-2变长编码，
 * 英文与ASCII一致，中文2个字节，可以对20000多个
 * 汉字进行编码。
 * UTF-8:1到4字节的变长编码，英文与ascll一致，
 * 中文3个字节。
 * 2.分别简述ISR和OSW的工作原理
 * InputStreamReader字符输入流。使用该流可以
 * 设置字符集，并按照指定的字符集从字节流中按照指定
 * 编码将字节数据转换为字符数据并读取。
 * OutputStreamWriter字符输出流。使用该流可以
 * 设置字符集，并按照指定的字符集将字符转换为对应的
 * 字节后通过该流写出
 * 
 *  简述Error和Exception的区别
 *  Error不可修改的错误，Exception可以修改的异常
 * @author dell
 *5.---D
 */
public class Pratice1 {
	/*
	 *  读取文本文件中的每一行数据信息，求其和再存入最后一行
	 *  1.创建br对象
	 *  2.读取行，拼接或添加字符串
	 *  3.创建pw对象写入字符串,创建fos对象时注意选择拼接
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br 
		= new BufferedReader(
				new InputStreamReader(
						new FileInputStream("fos.txt")));
		
//		BufferedWriter bw 
//		= new BufferedWriter(
//				new OutputStreamWriter(
//						new FileOutputStream("2.txt")));
//		bw.write("大家好!");
//		bw.write("    hello!");
//		bw.write("    bye!");
		String line = "";
		String s = "";
		while ((line = br.readLine())!=null) {
			s = (s+line).trim();
//			pw.write(line);
			System.out.println(line);
		}
		PrintWriter pw = new PrintWriter(new FileOutputStream("fos.txt",true), true);
		pw.println();
		pw.println(s);
//		if (s!=null) {
//			pw.write(s);
//		}
		System.out.println(s);
		br.close();
		pw.close();
		System.out.println("结束");	
	}
}






















