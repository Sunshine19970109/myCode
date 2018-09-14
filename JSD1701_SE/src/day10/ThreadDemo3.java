package day10;
/**
 * 使用匿名内部类来完成两种方式的线程创建
 * @author dell
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("你是谁？"+i);
				}
			}
		};
		Thread t2 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 1100; i++) {
					System.out.println("我是修水管的"+i);
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
			System.out.println("你是谁？"+i);
		}	
	}
}
class MyThread5 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是查水表的"+i);
		}
	}
}



















