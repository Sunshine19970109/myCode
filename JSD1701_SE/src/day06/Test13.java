package day06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/*
 * 解析emp.dat文件--UTF-8
 * name--32 age--4 gender--10
 * salary---4
 * hiredate--"yyyy--MM-dd" 30
 * 1.使用类加载器加载当前包中的emp.dat文件
 * File file = new File(Test13.class.
				getClassLoader().getResource("day06/zhu.txt").toURI());
 * 2.创建raf，创建读取方法,创建集合
 * 3.读取name等属性，将String格式日期用raf.parse()转为date
 * 4.传入Emp,存入集合
 */
public class Test13 {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File file = new File(Test13.class.
				getClassLoader().getResource("day06/zhu.txt").toURI());
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		List<Emp> emps = new ArrayList<>();
		//读取name
		byte[] data = new byte[32];
		raf.read(data);
		String name = new String(data,"UTF-8").trim();
		
		//读取年龄
		raf.readInt();
		data = new byte[10];
		raf.read(data);
		String gender = new String(data, "UTF-8");
		
		int salary = raf.readInt();
		
	}
	public static String readString(RandomAccessFile raf,int len) throws IOException{
		byte[] data = new byte[len];
		raf.read(data);
		return new String(data, "UTF-8").trim();
	}
}










