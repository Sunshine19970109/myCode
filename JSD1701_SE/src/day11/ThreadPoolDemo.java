package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池通常用于:
 * 1.控制线程数量
 * 2.重用线程
 * Executors.newCachedThreadPool()---可重用
 * Executors.newFixedThreadPool(int nThread)
 * --可重用、也可控制数量
 * Executors.newScheduledThreadPool(int corePoolSize)
 * 创建一个线程池，它可延迟创建
 * Executors.newScheduledThreadPool(int corePoolSize)
 * 创建一个使用单个worker线程的Executor--单线程
 * @author dell
 * 
 */
public class ThreadPoolDemo {
	/*
	 * 1 创建线程池
	 * 2 创建执行任务
	 * 3 执行任务
	 * 4 停止线程池---两种
	 */
	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable run = new Runnable() {
				@Override
				public void run() {
					Thread t = Thread.currentThread();
					System.out.println(t.getName()+":正在执行");
					try {
						Thread.sleep(2000);
						System.out.println(t.getName()+":执行完毕");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			e.execute(run);
		}
		e.shutdown();
//		e.shutdownNow();
		System.out.println("当前线程池已经停止");
	}
}





















