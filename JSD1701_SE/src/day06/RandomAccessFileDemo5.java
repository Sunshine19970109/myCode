package day06;


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ʹ��RAF��д�������������Լ�Raf����ָ��Ķ�д
 * @author dell
 *
 */
public class RandomAccessFileDemo5 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf 
		= new RandomAccessFile("r.dat", "rw");
		//���ļ���д��int���ֵ
		int imax = Integer.MAX_VALUE;
		raf.write(imax>>>24);
		raf.write(imax>>>16);
		raf.write(imax>>>8);
		raf.write(imax);
		raf.writeLong(123L);
		raf.writeDouble(123.123);
		System.out.println("д�����");
		
		raf.seek(0);
		System.out.println(raf.getFilePointer());
		int d = raf.readInt();
		System.err.println(d);
		raf.close();
	}
}
















