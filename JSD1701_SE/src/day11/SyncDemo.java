package day11;
/**
 * 多线程并发安全问题
 * 当多个线程同时操作同一资源时，会出现"抢"的情况。
 * 由于多线程切换时机不定，可能导致代码执行顺序出现
 * 混乱，有悖于程序设计的执行顺序而出现逻辑错误，严重
 * 时可能导致系统瘫痪
 * @author dell
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table t = new Table();
		Thread t1 = new Thread(){
			
			@Override
			public void run() {
				while(true){
				int b = t.getBeans();
				//模拟线程切换
//				Thread.yield();
				System.out.println(getName()+"---"+b);
				}
			}
		};
		Thread t2 =new Thread(){
			@Override
			public void run() {
				while(true){
				int b = t.getBeans();
//				Thread.yield();
				System.out.println(getName()+"---"+b);
				}
			}
		};
		t1.start();
		t2.start();
		
	}
}

class Table{
	private int beans = 20;
	//为方法使用sychronized，使多线程异步变成同步
	/*
	 * 在方法上使用synchronized,那么锁上的对象就是
	 * 该方法所属对象，即:this
	 */
	public synchronized int getBeans() {
		if (beans==0) {
			throw new RuntimeException("没有豆子了");
		}
		//模拟线程切换
//		Thread.yield();
		return beans--;
	}
}

























