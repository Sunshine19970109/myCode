package day10;

public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * Waits for this thread to die. 
			An invocation(����) of this method behaves in exactly the 
			same way as the invocation 
			join(0) 

			Waits at most millis milliseconds for this thread to die.
			 A timeout of 0 means to wait forever. 
This implementation uses a loop(��) of this.wait calls conditioned(����Լ��)
on this.isAlive. As a thread terminates(ʹ��ֹ) the this.notifyAll 
method is invoked(���л�). It is recommended that applications 
not use wait, notify, or notifyAll on Thread instances.

 A CharSequence(�ַ�����) is a readable sequence of char values. 
 This interface provides uniform, read-only access 
 to many different kinds of char sequences. A char
  value represents a character(�ַ�) in the Basic 
  Multilingual(�������Ե�) Plane(ƽ��) (BMP) or a surrogate(����). Refer 
  to Unicode Character Representation(��ʾ��) for details.
 
    It is therefore inappropriate to use arbitrary(�����)
    CharSequence instances(��������) as elements in a 
    set or as keys in a map. 

		 */
//		StringBuffer sb = new StringBuffer();
		
		//����join������ʹ���е��̶߳�ֹͣ������ֻʹmainֹͣ
		System.out.println("main������ʼ");
		Thread A = new Thread(new ThreadA());
		Thread B = new Thread(new ThreadB());
		A.start();B.start();
		A.join();
		System.out.println("main��������");
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

