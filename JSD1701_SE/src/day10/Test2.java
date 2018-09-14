package day10;

public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * Waits for this thread to die. 
			An invocation(调用) of this method behaves in exactly the 
			same way as the invocation 
			join(0) 

			Waits at most millis milliseconds for this thread to die.
			 A timeout of 0 means to wait forever. 
This implementation uses a loop(环) of this.wait calls conditioned(受制约的)
on this.isAlive. As a thread terminates(使终止) the this.notifyAll 
method is invoked(被叫唤). It is recommended that applications 
not use wait, notify, or notifyAll on Thread instances.

 A CharSequence(字符序列) is a readable sequence of char values. 
 This interface provides uniform, read-only access 
 to many different kinds of char sequences. A char
  value represents a character(字符) in the Basic 
  Multilingual(多种语言的) Plane(平面) (BMP) or a surrogate(代理). Refer 
  to Unicode Character Representation(表示法) for details.
 
    It is therefore inappropriate to use arbitrary(任意的)
    CharSequence instances(相依物体) as elements in a 
    set or as keys in a map. 

		 */
//		StringBuffer sb = new StringBuffer();
		
		//测试join方法是使所有的线程都停止，还是只使main停止
		System.out.println("main方法开始");
		Thread A = new Thread(new ThreadA());
		Thread B = new Thread(new ThreadB());
		A.start();B.start();
		A.join();
		System.out.println("main方法结束");
	}
}
class ThreadA implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("ThreadA-"+i);
		}
	}
	
}
class ThreadB implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("ThreadB-"+i);
		}
	}
	
}

