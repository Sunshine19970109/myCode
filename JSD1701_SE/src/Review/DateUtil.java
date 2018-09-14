package Review;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	private DateUtil(){
		
	}
	/*
	 * ������������þ��ǰ�����ת��һ���ַ���
	 */
	private String dateToString(Date d,String format) {
		// TODO Auto-generated method stub
		return new SimpleDateFormat(format).format(d);
	}
	/*
	 * �ַ���ת����
	 */
	private java.util.Date stringToDate(String s,String format) throws ParseException {
		return new SimpleDateFormat(format).parse(s);

	}
}


















