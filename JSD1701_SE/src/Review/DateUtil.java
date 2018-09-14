package Review;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	private DateUtil(){
		
	}
	/*
	 * 这个方法的作用就是把日期转成一个字符串
	 */
	private String dateToString(Date d,String format) {
		// TODO Auto-generated method stub
		return new SimpleDateFormat(format).format(d);
	}
	/*
	 * 字符串转日期
	 */
	private java.util.Date stringToDate(String s,String format) throws ParseException {
		return new SimpleDateFormat(format).parse(s);

	}
}


















