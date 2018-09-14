package day10;
/**
 * 线程
 * 线程用来并发执行多段代码，感官上是"同时执行"，
 * 实际上所有的线程都是走走停停的，这种执行现象称为并发。
 * 
 * 线程有两种创建方式。
 * 方式一:
 * 继承Thread并重写run方法，run方法是用来定义当前
 * 线程要执行的任务代码。(容易出现单继承问题)
 * 方式二:
 * 实现Runnable接口
 * 实现
 * @author dell
 *
 */
public class ThreadDemo1 extends Thread{
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 启动线程要调用start方法而不是run方法。
		 * 当start方法调用完毕后，run方法会很快
		 * 的被自动执行。
		 */
		t1.start();
		t2.start();
	}
}
/**
 * 继承线程重写run方法这样的做法有两个不足:
 * 1 由于java是单继承，这就导致继承了Thread就不能
 * 继承其他类。
 * 2 由于重写run方法将线程的任务定义在了线程当中，这就
 * 导致线程的重用性变得很差。线程与任务不应有必然的耦合
 * 关系。
 * @author dell
 *
 */
class MyThread1 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("你是干什么的"+i);
		}
	}
}
class MyThread2 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我是查水表的"+i);
		}
	}
}






















