package Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String>{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//第一种方式Future + ExcecutorService
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<String> future = service.submit(new CallableDemo());
		//获取返回值
		System.out.println(future.get());
		service.shutdown();
		System.out.println("-----------------");
		System.out.println("第二种方式:FutureTask+ ExecutorService");
		
		ExecutorService service1 = Executors.newCachedThreadPool();
		FutureTask<String> futureTask = new FutureTask<>(new CallableDemo());
		service1.submit(futureTask);
		System.out.println("返回值为:"+futureTask.get());
		service1.shutdown();
		
		System.out.println("第三种方式:FutureTask + Thread");
		System.out.println("------------------------");
		FutureTask<String> futureTask2 = new FutureTask<>(new CallableDemo());
		Thread t1 = new Thread(futureTask2);
		t1.setName("Task thread");
		t1.start();
		
	}
	@Override
	public String call() throws Exception {
		for (int i = 1; i < 100; i++) {
			System.out.println("开始数数"+i);
		}
		return "数数完毕";
	}

}
