package Review;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
	public static void main(String[] args) {
		//Date----String
		Date d = new Date();
		//创建格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
		//public final String format(Date date)
		String s = sd.format(d);
		System.out.println(s);
	}
}
















