package day10;
/**
 * �߳����첽���е�
 * �첽����ִ�и��ģ����಻����
 * ͬ��:���Ⱥ�˳���ִ�С�
 * 
 * ��Щҵ����Ҫ�ö���̼߳�ͬ�����У����ʱ�����
 * �����̵߳�join��������ɡ�
 * 
 * join��������һ���߳̽�������״̬��ֱ����ȴ�����һ��
 * �̹߳����������ټ�������
 * @author dell
 *
 */
public class Thread_join {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinish = false;
	/*
	 * д�����̣߳�����ͼƬ����ʾͼƬ
	 */
	public static void main(String[] args) {
		Thread down = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("��������"+i+"%");
				}
				System.out.println("�������");
				Thread_join.isFinish = true;
			}
		};
		Thread show = new Thread(){
			@Override
			public void run() {
				try {
					down.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (isFinish!=true) {
					throw new RuntimeException("δ�������");
				}
				System.out.println("ͼƬ��ʾ�ɹ�");
			}
		};
		down.start();
		show.start();
	}
}




















