package day10;

public class Test1 extends Thread implements Runnable{
	public static void main(String[] args) {
		Thread t1 = new Thread(new Test1());
		t1.start();
	}
	
	@Override
	public void run() {
		System.out.println("run");
	}
}
