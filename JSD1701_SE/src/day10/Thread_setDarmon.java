package day10;
/**
 * �ػ��߳��ֳ�Ϊ:��̨�߳�
 * ʹ����
 * 
 * main�߳���ǰ̨�̣߳�����ִ�������main�߳�
 * ֻ������ǰ̨�߳̽��������̲��ܽ���
 * yield ---�����ó�ʱ��Ƭ�ص�runnable״̬
 * @author dell
 *
 */
public class Thread_setDarmon {
	public static void main(String[] args) {
		/*
		 * rose:ǰ̨�߳�
		 */
		Thread rose = new Thread(){
			@Override
			public void run() {
				
				for (int i = 0; i < 5; i++) {
					System.out.println("let me go");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("������");
				System.out.println("��ͨ��ˮ����");
			}
		};
		Thread jack = new Thread(){
			@Override
			public void run() {
				while (true) {
					System.out.println("you jump i jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		rose.start();
		//�����ػ��̱߳����ڿ�ʼ֮ǰ
		jack.setDaemon(true);
		jack.start();
	}
}



















