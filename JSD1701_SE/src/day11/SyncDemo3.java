package day11;
/**
 * 静态方法加上synchronized一定有同步效果
 * 即使多个对象之间被多个线程执行也只能一个执行完了另一个开始，
 * 就好像只有一个天安门一样
 * 相当于锁住了类对象，Class对象，每个类有且只有一个类对象
 * JVM在加载每一个类的时候，都会实例化一个Class的实例
 * 用于表示这个类。而且每个都有且只有一个Class的实例。
 * 静态方法锁的就是这个实例。
 * @author dell
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		//dosome方法
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				f1.dosome();
				Foo.dosome();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				f2.dosome();
				Foo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}
class  Foo{
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在运行dosome方法");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+"dosome方法运行完成");
	}
}



















