package day06;


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RAF读写基本类型数据以及Raf基于指针的读写
 * @author dell
 *
 */
public class RandomAccessFileDemo5 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf 
		= new RandomAccessFile("r.dat", "rw");
		//向文件中写入int最大值
		int imax = Integer.MAX_VALUE;
		raf.write(imax>>>24);
		raf.write(imax>>>16);
		raf.write(imax>>>8);
		raf.write(imax);
		raf.writeLong(123L);
		raf.writeDouble(123.123);
		System.out.println("写出完毕");
		
		raf.seek(0);
		System.out.println(raf.getFilePointer());
		int d = raf.readInt();
		System.err.println(d);
		raf.close();
	}
}
















