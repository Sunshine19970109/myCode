package Demo;

public class ThreadState {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		t1.start();
		System.out.println();
		t2.start();
		Thread.currentThread().sleep(1000);
		System.out.println("T1----spleep...");
		//t1.sleep(1000);
		System.out.println("T1------join start()");
		t1.join(10000);
		System.out.println("T2------join  end()");
	}
}
class T1 extends Thread{
	@Override
	public void run() {
		while (true) {
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("T1����");
		}
		
	}
}
class T2 extends Thread{

	@Override
	public void run() {
		while(true){
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("����T2");
		}
		
	}
	
}