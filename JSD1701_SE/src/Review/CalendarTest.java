package Review;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 获取任意一年的二月有多少天
 */
public class CalendarTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份:");
		int year = sc.nextInt();
		//设置年月日
		Calendar c = Calendar.getInstance();
		c.set(year, 2, 1);
		//把时间往前推一天，就是二月的最后一天
		c.add(c.DATE, -1);
		System.out.println(c.get(Calendar.DATE));
	}
}



















