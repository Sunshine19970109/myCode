package day11.prctice;

/**
 * 1 ����RuntimeExceptionΪ�Ǽ���쳣�� 
 * ��RuntimeExceptionΪ�ɼ���쳣������ ����ʱ�쳣�������е�ʱ��һ������ʱ�׳� 
 * 2�̺߳ͽ��̵����� һ���������ж���̣߳�
 * ������������ǽ��̣� һ��������������һ��ǰ̨�̣߳�������̽���
 *  3 �����̵߳�״̬����ת�� new
 * Runnable Running Block Dead 
 * 4 �����̵߳����ִ�����ʽ�Լ����ǵ����� 
 * 1. �̳�Thead ����ֻ�ܵ��̳е�����
 * 2. ʵ��Runnable�ӿڣ������ڵ��̳е�����
 * 5--A��B C Thread���getPriority()�������ڷ����̵߳����ȼ�
 *  6--C
 * 
 * @author dell
 *
 */
public class day09 implements Runnable{
	/*
	 * InputStream�ǳ����಻�ǽӿ�
	 * ͨ�� String bStr = aStr;������ʹ bStr �� aStr ָ��ͬһ����ַ�ռ䣬
	 * ������� aStr �� bStr �Ľ� ��Ӧ����һ����
	 * String����һ�������ַ���������String �ķ�������γ��µ��ַ���
	 */
	
	public static void main(String[] args) {
		String s = "HelloWorld";
		s.toUpperCase();
		System.out.println(s);// HelloWorld
		s = s.toUpperCase();
		System.out.println(s);
		Thread t = new Thread(new day09());
		t.run();
		t.run();
		t.start();
	}

	public void run() {
		System.out.print("running");
	}
}

















