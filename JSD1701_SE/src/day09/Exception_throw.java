package day09;
/**
 * �����쳣���׳�
 * @author dell
 *
 */
public class Exception_throw {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		try {
			p.setAge(10000);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
		}
		 
		System.out.println(p.getAge());
	}
}





















