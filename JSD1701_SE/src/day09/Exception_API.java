package day09;
/**
 * Exception���÷���
 * @author dell
 *
 */
public class Exception_API {
	public static void main(String[] args) {
		/*
		 * 1.�����ַ���תInteger
		 * 2.�õ�������Ϣ
		 */
		System.out.println("����ʼ��");
		try {
			String s = "abc";
			System.out.println(Integer.parseInt(s));
		} catch (Exception e) {
		//��������ջ��Ϣ�����ڶ�λ���������
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
		System.out.println("���������");
	}
}























