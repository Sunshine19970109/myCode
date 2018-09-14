package Demo;

public class DeadLock {
	public static void main(String[] args) {
		Thread t1 = new Thread(new T6(true));
		Thread t2 = new Thread(new T6(false));
		t1.start();
		t2.start();
		System.out.println("结束");
		System.out.println();
	}
}

class T6 implements Runnable{
	private Boolean flag;
	public T6(boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		if(flag){
			while (true) {
				synchronized (MyLock.obj1) {
					System.out.println(Thread.currentThread().getName()+"if----");
					//破坏条件可以把obj2改成obj3
					synchronized (MyLock.obj3) {
						System.out.println(Thread.currentThread().getName()+"if----");
					}
				}
			}
		}else{
			while (true) {
				synchronized (MyLock.obj2) {
					System.out.println(Thread.currentThread().getName()+"else----");
					synchronized (MyLock.obj1) {
						System.out.println(Thread.currentThread().getName()+"else----");
					}
				}
			}
		}
	}
	
}

class MyLock{
	public static Object obj1 = new Object();
	public static Object obj2 = new Object();
	public static Object obj3 = new Object();
}














