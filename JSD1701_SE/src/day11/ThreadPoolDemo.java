package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳�
 * �̳߳�ͨ������:
 * 1.�����߳�����
 * 2.�����߳�
 * Executors.newCachedThreadPool()---������
 * Executors.newFixedThreadPool(int nThread)
 * --�����á�Ҳ�ɿ�������
 * Executors.newScheduledThreadPool(int corePoolSize)
 * ����һ���̳߳أ������ӳٴ���
 * Executors.newScheduledThreadPool(int corePoolSize)
 * ����һ��ʹ�õ���worker�̵߳�Executor--���߳�
 * @author dell
 * 
 */
public class ThreadPoolDemo {
	/*
	 * 1 �����̳߳�
	 * 2 ����ִ������
	 * 3 ִ������
	 * 4 ֹͣ�̳߳�---����
	 */
	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable run = new Runnable() {
				@Override
				public void run() {
					Thread t = Thread.currentThread();
					System.out.println(t.getName()+":����ִ��");
					try {
						Thread.sleep(2000);
						System.out.println(t.getName()+":ִ�����");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			e.execute(run);
		}
		e.shutdown();
//		e.shutdownNow();
		System.out.println("��ǰ�̳߳��Ѿ�ֹͣ");
	}
}





















