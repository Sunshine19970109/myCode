package Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String>{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//��һ�ַ�ʽFuture + ExcecutorService
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<String> future = service.submit(new CallableDemo());
		//��ȡ����ֵ
		System.out.println(future.get());
		service.shutdown();
		System.out.println("-----------------");
		System.out.println("�ڶ��ַ�ʽ:FutureTask+ ExecutorService");
		
		ExecutorService service1 = Executors.newCachedThreadPool();
		FutureTask<String> futureTask = new FutureTask<>(new CallableDemo());
		service1.submit(futureTask);
		System.out.println("����ֵΪ:"+futureTask.get());
		service1.shutdown();
		
		System.out.println("�����ַ�ʽ:FutureTask + Thread");
		System.out.println("------------------------");
		FutureTask<String> futureTask2 = new FutureTask<>(new CallableDemo());
		Thread t1 = new Thread(futureTask2);
		t1.setName("Task thread");
		t1.start();
		
	}
	@Override
	public String call() throws Exception {
		for (int i = 1; i < 100; i++) {
			System.out.println("��ʼ����"+i);
		}
		return "�������";
	}

}
