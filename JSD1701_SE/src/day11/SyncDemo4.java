package day11;
/**
 * 互斥
 * @author dell
 * 在多线程修改字符串的时候是需要用StringBuffer,不能用StringBuider
 * 因为StringBuffer是线程同步的，synchronized  append()
 * StringBuider是线程不同步的
 *
 *Vector和Hashtable是同步的
 *ArrayList 和HashMap不是同步的
 *
 *获取线程安全的集合方式
 *Collects工具类可以转换
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		Boo b = new Boo();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				b.A();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				b.B();
			}
		};
		t1.start();
		t2.start();
	}
}
class Boo{
	public synchronized void B(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":在执行B方法");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getName()+":B方法执行完毕");
	}
	public synchronized void A(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在执行A方法");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getName()+":A方法执行完毕");
	}
}
























