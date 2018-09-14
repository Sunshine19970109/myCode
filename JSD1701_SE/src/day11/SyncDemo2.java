package day11;
/**
 * 有效缩小同步范围可以在保证并发安全的前提下提高
 * 并发效率
 * 使用同步块可以更加准确的锁定需要同步的代码片段，而不是将一个方法
 * 整体加锁。这样可以有效的缩小同步范围。
 * @author dell
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		Shop s = new Shop();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				s.buy();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				s.buy();
			}
		};
		t1.start();
		t2.start();
	}
}
class Shop{
	public void buy(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在挑选衣服");
		try {
			Thread.sleep(5000);
			/*
			 * 同步监视器
			 * synchronized(需要监视的对象){
			 * 	需要同步的代码
			 * }
			 * 对象最好直接传入this
			 * 这个对象必须是同一个shop对象，而不是Equals相等的对象
			 * 不同的shop对象不需要同步
			 * 所以如果这里需要一个对象而且是同步的，最好是单例设计模式
			 */
			synchronized (this) {
				System.out.println(t.getName()+":正在试衣服");
				Thread.sleep(5000);
			}
			
			System.out.println(t.getName()+"结账离开");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


















