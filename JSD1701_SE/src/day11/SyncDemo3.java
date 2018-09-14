package day11;
/**
 * ��̬��������synchronizedһ����ͬ��Ч��
 * ��ʹ�������֮�䱻����߳�ִ��Ҳֻ��һ��ִ��������һ����ʼ��
 * �ͺ���ֻ��һ���찲��һ��
 * �൱����ס�������Class����ÿ��������ֻ��һ�������
 * JVM�ڼ���ÿһ�����ʱ�򣬶���ʵ����һ��Class��ʵ��
 * ���ڱ�ʾ����ࡣ����ÿ��������ֻ��һ��Class��ʵ����
 * ��̬�������ľ������ʵ����
 * @author dell
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		//dosome����
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				f1.dosome();
				Foo.dosome();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				f2.dosome();
				Foo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}
class  Foo{
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":��������dosome����");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+"dosome�����������");
	}
}



















