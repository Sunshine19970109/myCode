package day06.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 1 新建一个相对路径的文件
 * 2 输出文件名，文件路径，文件长度，是否可写，是否可读，是否隐藏，
 * 最后一次被操作的时间
 * 3 转毫秒时间为字符串格式输出
 * 		新建date,新建sdf,long转date转sdf
 * 	
 */
public class FileDemo1 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy月MM月dd日 HH:mm:ss");
		System.out.println(sdf.format(date));
	}
}

















