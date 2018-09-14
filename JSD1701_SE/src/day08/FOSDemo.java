package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 流
 * 流是用来读写数据的
 * 流根据方向分为输入流和输出流
 * 输入流是从外面读取数据
 * 输出流是写数据到外界
 * java.io.FileOutputStream
 * 文件输出流，继承自OutoutStream,用来向文件中写入
 * 数据的流，是一个低级流
 * 
 * java.io.InputStream
 * 所有字节输入流的父类，是一个抽象类，定义了相关的
 * 读取方法。
 * 
 * java.io.OutputStream
 * 所有字节输出流，是一个抽象类，定义了相关的写出方法
 * 
 * 流又分为:
 * 节点流(低级流):读写一定基于节点流，节点流是真实负责
 * 读写数据的流。数据源明确。
 * 
 * 处理流(高级流):不能独立存在，需要处理其他流，作用是
 * 使用它们可以简化读写数据时的复杂处理
 * 
 * 
 * @author dell
 *
 */
public class FOSDemo {
	/*
	 * 1.创建一个FileOutputStream对象,选择构造模式
	 * 2.开始写内容,转字节，指定字符集
	 */
	public static void main(String[] args) throws IOException {
		FileOutputStream fos 
		= new FileOutputStream("fos.txt",true);
		String s = "我在二环路里面，想着你.";
		byte[] data =s.getBytes();
		/*
		 * 默认创建的文件流是覆盖写模式，即:
		 * 若文件流发现该文件已经存在，那么会先将文件
		 * 中所有数据清除。
		 * 
		 * FileOutputStream提供了另一个构造方法，
		 * 该方法要求传入第二个参数，是一个boolean值，若该值
		 * 为true则是追加写模式，即:
		 * 若该文件存在，则文件数据全部保留，本次通过
		 * 流写入的数据都会被追加到文件末尾。
		 */
		fos.write(data);
		fos.close();
		System.out.println("写出完毕");
	}
}




















