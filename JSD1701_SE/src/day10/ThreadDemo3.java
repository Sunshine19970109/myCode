package day10;
/**
 * ʹ�������ڲ�����������ַ�ʽ���̴߳���
 * @author dell
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("����˭��"+i);
				}
			}
		};
		Thread t2 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 1100; i++) {
					System.out.println("������ˮ�ܵ�"+i);
				}
				
			}
		});
		t1.start();
		t2.start();
	}
}
class MyThread4 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("����˭��"+i);
		}	
	}
}
class MyThread5 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("���ǲ�ˮ���"+i);
		}
	}
}



















