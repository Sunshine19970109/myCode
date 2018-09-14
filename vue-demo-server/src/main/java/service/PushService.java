package service;
/**
 * 推送接口
 * @author dell
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public interface PushService {
	
	/**
	 * 定义线程池
	 */
	public final ExecutorService pushExcutor = Executors.newFixedThreadPool(10);
	
	/**
	 * 推送方法
	 */
	public void push(Object info);
}
