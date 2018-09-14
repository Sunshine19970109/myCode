package day10;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 电子表功能
 * 
 * 每秒钟在控制台输出当前系统时间
 * 格式如:17:18:22
 * @author dell
 *
 */
public class Test {
	public static void main(String[] args) {
		Thread time = new Thread(){
			
			@Override
			public void run() {
				
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					long date = System.currentTimeMillis();
					Date d = new Date(date);
					SimpleDateFormat sdf = new SimpleDateFormat("当前时间是:HH:mm:ss");
					String s = sdf.format(date);
					System.out.println(s);
				}
			}
		};
		time.start();
	}
}






















