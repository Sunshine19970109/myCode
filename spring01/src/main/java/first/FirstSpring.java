package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
	
	public static void main(String[] args) {
		String config = 
				"applicationContext.xml";
		/*
		 * ApplicationContext�ǽӿ�
		 * ClassPathXmlApplicationContext��ʵ���࣬����
		 * ��������·��ȥ����spring�����ļ���Ȼ������������
		 */
		//��������
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext(config);
		//Student.class�������е�class���󣬿��Բ���ǿת
		Student stu = ac.getBean("stu1",Student.class);
		System.out.println(stu);
		Date date = ac.getBean("date",Date.class);
		System.out.println(date);
		Calendar cal1 = ac.getBean("cal1",Calendar.class);
		System.out.println(cal1);
		
		Date time1 = ac.getBean("time1",Date.class);
		System.out.println(time1);
	}
}


















