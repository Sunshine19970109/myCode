package service;
/**
 * ���ͽӿ�
 * @author dell
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public interface PushService {
	
	/**
	 * �����̳߳�
	 */
	public final ExecutorService pushExcutor = Executors.newFixedThreadPool(10);
	
	/**
	 * ���ͷ���
	 */
	public void push(Object info);
}