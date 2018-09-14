package day11.prctice;

/**
 * 1 简述RuntimeException为非检测异常和 
 * 非RuntimeException为可检测异常的区别 运行时异常，在运行的时候一定条件时抛出 
 * 2线程和进程的区别 一个进程中有多个线程，
 * 任务管理器就是进程， 一个进程中最少有一个前台线程，否则进程结束
 *  3 简述线程的状态及其转换 new
 * Runnable Running Block Dead 
 * 4 简述线程的两种创建方式以及它们的区别 
 * 1. 继承Thead 存在只能单继承的问题
 * 2. 实现Runnable接口，不存在单继承的问题
 * 5--A、B C Thread类的getPriority()方法用于返回线程的优先级
 *  6--C
 * 
 * @author dell
 *
 */
public class day09 implements Runnable{
	/*
	 * InputStream是抽象类不是接口
	 * 通过 String bStr = aStr;这句代码使 bStr 和 aStr 指向同一个地址空间，
	 * 所以最后 aStr 和 bStr 的结 果应该是一样，
	 * String类是一个定长字符串，调用String 的方法后会形成新的字符串
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

















