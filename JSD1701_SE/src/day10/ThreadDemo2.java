package day10;
/**
 * ��ʽ��:
 * ʵ��Runnable�ӿ�
 * @author dell
 *
 */
public class ThreadDemo2 implements Runnable{
	public static void main(String[] args) {
		MyThread3 run1 =new MyThread3();
		ThreadDemo2 run2 = new ThreadDemo2();
		
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("������ˮ�ܵ�"+i);
		}
		
	}

}
class MyThread3 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("����˭��"+i);
		}
		
	}
	
}



























