package day11;
/**
 * ����
 * @author dell
 * �ڶ��߳��޸��ַ�����ʱ������Ҫ��StringBuffer,������StringBuider
 * ��ΪStringBuffer���߳�ͬ���ģ�synchronized  append()
 * StringBuider���̲߳�ͬ����
 *
 *Vector��Hashtable��ͬ����
 *ArrayList ��HashMap����ͬ����
 *
 *��ȡ�̰߳�ȫ�ļ��Ϸ�ʽ
 *Collects���������ת��
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		Boo b = new Boo();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				b.A();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				b.B();
			}
		};
		t1.start();
		t2.start();
	}
}
class Boo{
	public synchronized void B(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":��ִ��B����");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getName()+":B����ִ�����");
	}
	public synchronized void A(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":����ִ��A����");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getName()+":A����ִ�����");
	}
}
























