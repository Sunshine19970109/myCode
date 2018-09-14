package day11;
/**
 * ��Ч��Сͬ����Χ�����ڱ�֤������ȫ��ǰ�������
 * ����Ч��
 * ʹ��ͬ������Ը���׼ȷ��������Ҫͬ���Ĵ���Ƭ�Σ������ǽ�һ������
 * �������������������Ч����Сͬ����Χ��
 * @author dell
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		Shop s = new Shop();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				s.buy();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				s.buy();
			}
		};
		t1.start();
		t2.start();
	}
}
class Shop{
	public void buy(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":������ѡ�·�");
		try {
			Thread.sleep(5000);
			/*
			 * ͬ��������
			 * synchronized(��Ҫ���ӵĶ���){
			 * 	��Ҫͬ���Ĵ���
			 * }
			 * �������ֱ�Ӵ���this
			 * ������������ͬһ��shop���󣬶�����Equals��ȵĶ���
			 * ��ͬ��shop������Ҫͬ��
			 * �������������Ҫһ�����������ͬ���ģ�����ǵ������ģʽ
			 */
			synchronized (this) {
				System.out.println(t.getName()+":�������·�");
				Thread.sleep(5000);
			}
			
			System.out.println(t.getName()+"�����뿪");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


















