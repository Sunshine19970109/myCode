package Review;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyYearOldDemo {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ĳ���������:");
		String line = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(line);
		//ͨ�������ڵõ�����ֵ
		long myTime = d.getTime();
		long time = System.currentTimeMillis();
		long timeNow = time-myTime;
		//ת��Ϊ��
		long day = timeNow/1000/60/60/24;
		System.out.println("�������������:"+day+"����");
	}
}
















