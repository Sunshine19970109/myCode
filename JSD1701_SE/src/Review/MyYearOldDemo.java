package Review;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyYearOldDemo {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的出生年月日:");
		String line = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(line);
		//通过该日期得到毫秒值
		long myTime = d.getTime();
		long time = System.currentTimeMillis();
		long timeNow = time-myTime;
		//转化为天
		long day = timeNow/1000/60/60/24;
		System.out.println("你来到这个世界:"+day+"天了");
	}
}
















