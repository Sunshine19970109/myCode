package day10;
/**
 * �߳��ṩ��һ����̬����:
 * static Thread currentThread()
 * �÷������Ի�ȡ���е�ǰ�������߳�
 * @author dell
 *
 *long getId():���ظ��̵߳�Ψһ��ʶ��
 *String getName():���ظ��̵߳�����
 *int getPriority():�����̵߳����ȼ�
 *Thread.state getState():��ȡ�̵߳�״̬
 *boolean isAlive():�����߳��Ƿ��ڻ״̬
 *boolean isDaemon():�����߳��Ƿ�Ϊ�ػ��߳�
 *boolean isInterrupted():�����߳��Ƿ��Ѿ��ж�
 */
public class Thread_currentThread {
	//����dosome��������ȡ�߳�
	//�Խ��߳�
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("main---"+t);
		dosome();
		Thread t2 = new Thread(){
			@Override
			public void run() {
				Thread t3 =Thread.currentThread();
				System.out.println("�Խ��߳���: "+t3);
				dosome();
			}
		};
		t2.start();
	}

	private static void dosome() {
		Thread t1 = Thread.currentThread();
		System.out.println("dosome���߳���"+t1);
	}
	
}


















