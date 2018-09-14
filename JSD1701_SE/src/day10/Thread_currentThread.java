package day10;
/**
 * 线程提供了一个静态方法:
 * static Thread currentThread()
 * 该方法可以获取运行当前方法的线程
 * @author dell
 *
 *long getId():返回该线程的唯一标识符
 *String getName():返回该线程的名称
 *int getPriority():返回线程的优先级
 *Thread.state getState():获取线程的状态
 *boolean isAlive():测试线程是否处于活动状态
 *boolean isDaemon():测试线程是否为守护线程
 *boolean isInterrupted():测试线程是否已经中断
 */
public class Thread_currentThread {
	//定义dosome方法，获取线程
	//自建线程
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("main---"+t);
		dosome();
		Thread t2 = new Thread(){
			@Override
			public void run() {
				Thread t3 =Thread.currentThread();
				System.out.println("自建线程是: "+t3);
				dosome();
			}
		};
		t2.start();
	}

	private static void dosome() {
		Thread t1 = Thread.currentThread();
		System.out.println("dosome的线程是"+t1);
	}
	
}


















