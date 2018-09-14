package day06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/*
 * ����emp.dat�ļ�--UTF-8
 * name--32 age--4 gender--10
 * salary---4
 * hiredate--"yyyy--MM-dd" 30
 * 1.ʹ������������ص�ǰ���е�emp.dat�ļ�
 * File file = new File(Test13.class.
				getClassLoader().getResource("day06/zhu.txt").toURI());
 * 2.����raf��������ȡ����,��������
 * 3.��ȡname�����ԣ���String��ʽ������raf.parse()תΪdate
 * 4.����Emp,���뼯��
 */
public class Test13 {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File file = new File(Test13.class.
				getClassLoader().getResource("day06/zhu.txt").toURI());
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		List<Emp> emps = new ArrayList<>();
		//��ȡname
		byte[] data = new byte[32];
		raf.read(data);
		String name = new String(data,"UTF-8").trim();
		
		//��ȡ����
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










