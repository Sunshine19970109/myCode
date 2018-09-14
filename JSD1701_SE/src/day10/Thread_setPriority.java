package day10;
/**
 * 线程优先级
 * 
 * 线程对线程调度的工作是不可控制的，即
 * 线程只能被动被分配CPU时间，而不能主动获取到。
 * 
 * 线程调度会尽可能的将CPU时间分配的几率做到均匀。
 * 但是多个线程并发运行，并不保证一个线程一次这样交替运行  
 * 
 *   
 *可以通过调整线程优先级改善分配CPU的时间吧
 * @author dell
 *
 */
public class Thread_setPriority {
	public static void main(String[] args) {
		Thread max = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("max = "+i);
				}
				
			}
		};
		Thread min = new Thread(){
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("min = "+i);
				}
			}
		};
		Thread nor = new Thread(){
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("nor = "+i);
				}
			}
		};
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		nor.setPriority(Thread.NORM_PRIORITY);
		max.start();
		min.start();
		nor.start();
	}
}

















