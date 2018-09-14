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
		 * ApplicationContext是接口
		 * ClassPathXmlApplicationContext是实现类，该类
		 * 会依据类路径去查找spring配置文件，然后启动容器。
		 */
		//启动容器
		ApplicationContext ac= 
				new ClassPathXmlApplicationContext(config);
		//Student.class方法区中的class对象，可以不用强转
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



















