package day10;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ӱ���
 * 
 * ÿ�����ڿ���̨�����ǰϵͳʱ��
 * ��ʽ��:17:18:22
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
					SimpleDateFormat sdf = new SimpleDateFormat("��ǰʱ����:HH:mm:ss");
					String s = sdf.format(date);
					System.out.println(s);
				}
			}
		};
		time.start();
	}
}






















