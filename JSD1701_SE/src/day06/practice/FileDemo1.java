package day06.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 1 �½�һ�����·�����ļ�
 * 2 ����ļ������ļ�·�����ļ����ȣ��Ƿ��д���Ƿ�ɶ����Ƿ����أ�
 * ���һ�α�������ʱ��
 * 3 ת����ʱ��Ϊ�ַ�����ʽ���
 * 		�½�date,�½�sdf,longתdateתsdf
 * 	
 */
public class FileDemo1 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		System.out.println(sdf.format(date));
	}
}

















