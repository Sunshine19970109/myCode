package Review;

import java.util.Calendar;
import java.util.Scanner;

/*
 * ��ȡ����һ��Ķ����ж�����
 */
public class CalendarTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������:");
		int year = sc.nextInt();
		//����������
		Calendar c = Calendar.getInstance();
		c.set(year, 2, 1);
		//��ʱ����ǰ��һ�죬���Ƕ��µ����һ��
		c.add(c.DATE, -1);
		System.out.println(c.get(Calendar.DATE));
	}
}



















