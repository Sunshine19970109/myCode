package day10;
/**
 * 获取线程信息的相关方法
 * @author dell
 **long getId():返回该线程的唯一标识符
 *String getName():返回该线程的名称
 *int getPriority():返回线程的优先级
 *Thread.state getState():获取线程的状态
 *boolean isAlive():测试线程是否处于活动状态
 *boolean isDaemon():测试线程是否为守护线程
 *boolean isInterrupted():测试线程是否已经中断
 */
public class Thread_Info {
	public static void main(String[] args) {
		//获取当前线程
		Thread t= Thread.currentThread();
		System.out.println("当前线程是:"+t);
		//获取当前线程的ID
		long l = t.getId();
		System.out.println("当前线程的ID是:"+l);
		//获取该线程的名称
		System.out.println("当前线程的名称是:"+t.getName());
		//获取当前线程的优先级
		int i = t.getPriority();
		System.out.println("当前线程的优先级为:"+i);
		//获取当前线程的状态
		Thread.State t1 = t.getState();
		System.out.println("当前线程的状态为:"+t1);
		//获取当前线程是否处于活动状态
		boolean b = t.isAlive();
		System.out.println("当前线程是否处于活动状态："+b);
		//获取当前线程是否为守护线程，后台线程
		boolean b1 = t.isDaemon();
		System.out.println("当前线程是否为守护线程:"+b1);
		//测试线程是否已经中断
		boolean b2 = t.isInterrupted();
		System.out.println("当前线程是否已经中断"+b2);
	}
}





















