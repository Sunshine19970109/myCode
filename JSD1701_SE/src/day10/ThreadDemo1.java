package day10;
/**
 * �߳�
 * �߳���������ִ�ж�δ��룬�й�����"ͬʱִ��"��
 * ʵ�������е��̶߳�������ͣͣ�ģ�����ִ�������Ϊ������
 * 
 * �߳������ִ�����ʽ��
 * ��ʽһ:
 * �̳�Thread����дrun������run�������������嵱ǰ
 * �߳�Ҫִ�е�������롣(���׳��ֵ��̳�����)
 * ��ʽ��:
 * ʵ��Runnable�ӿ�
 * ʵ��
 * @author dell
 *
 */
public class ThreadDemo1 extends Thread{
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * �����߳�Ҫ����start����������run������
		 * ��start����������Ϻ�run������ܿ�
		 * �ı��Զ�ִ�С�
		 */
		t1.start();
		t2.start();
	}
}
/**
 * �̳��߳���дrun������������������������:
 * 1 ����java�ǵ��̳У���͵��¼̳���Thread�Ͳ���
 * �̳������ࡣ
 * 2 ������дrun�������̵߳������������̵߳��У����
 * �����̵߳������Ա�úܲ�߳�������Ӧ�б�Ȼ�����
 * ��ϵ��
 * @author dell
 *
 */
class MyThread1 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("���Ǹ�ʲô��"+i);
		}
	}
}
class MyThread2 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("���ǲ�ˮ���"+i);
		}
	}
}






















