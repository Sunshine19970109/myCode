package Demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new T5());
		service.shutdown();
	}
}

class T5 implements Runnable{

	@Override
	public void run() {
		System.out.println("Œ“ «T5");
	}
	
}
