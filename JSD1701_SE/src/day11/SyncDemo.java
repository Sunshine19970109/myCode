package day11;
/**
 * ���̲߳�����ȫ����
 * ������߳�ͬʱ����ͬһ��Դʱ�������"��"�������
 * ���ڶ��߳��л�ʱ�����������ܵ��´���ִ��˳�����
 * ���ң�����ڳ�����Ƶ�ִ��˳��������߼���������
 * ʱ���ܵ���ϵͳ̱��
 * @author dell
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table t = new Table();
		Thread t1 = new Thread(){
			
			@Override
			public void run() {
				while(true){
				int b = t.getBeans();
				//ģ���߳��л�
//				Thread.yield();
				System.out.println(getName()+"---"+b);
				}
			}
		};
		Thread t2 =new Thread(){
			@Override
			public void run() {
				while(true){
				int b = t.getBeans();
//				Thread.yield();
				System.out.println(getName()+"---"+b);
				}
			}
		};
		t1.start();
		t2.start();
		
	}
}

class Table{
	private int beans = 20;
	//Ϊ����ʹ��sychronized��ʹ���߳��첽���ͬ��
	/*
	 * �ڷ�����ʹ��synchronized,��ô���ϵĶ������
	 * �÷����������󣬼�:this
	 */
	public synchronized int getBeans() {
		if (beans==0) {
			throw new RuntimeException("û�ж�����");
		}
		//ģ���߳��л�
//		Thread.yield();
		return beans--;
	}
}

























