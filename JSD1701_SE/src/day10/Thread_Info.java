package day10;
/**
 * ��ȡ�߳���Ϣ����ط���
 * @author dell
 **long getId():���ظ��̵߳�Ψһ��ʶ��
 *String getName():���ظ��̵߳�����
 *int getPriority():�����̵߳����ȼ�
 *Thread.state getState():��ȡ�̵߳�״̬
 *boolean isAlive():�����߳��Ƿ��ڻ״̬
 *boolean isDaemon():�����߳��Ƿ�Ϊ�ػ��߳�
 *boolean isInterrupted():�����߳��Ƿ��Ѿ��ж�
 */
public class Thread_Info {
	public static void main(String[] args) {
		//��ȡ��ǰ�߳�
		Thread t= Thread.currentThread();
		System.out.println("��ǰ�߳���:"+t);
		//��ȡ��ǰ�̵߳�ID
		long l = t.getId();
		System.out.println("��ǰ�̵߳�ID��:"+l);
		//��ȡ���̵߳�����
		System.out.println("��ǰ�̵߳�������:"+t.getName());
		//��ȡ��ǰ�̵߳����ȼ�
		int i = t.getPriority();
		System.out.println("��ǰ�̵߳����ȼ�Ϊ:"+i);
		//��ȡ��ǰ�̵߳�״̬
		Thread.State t1 = t.getState();
		System.out.println("��ǰ�̵߳�״̬Ϊ:"+t1);
		//��ȡ��ǰ�߳��Ƿ��ڻ״̬
		boolean b = t.isAlive();
		System.out.println("��ǰ�߳��Ƿ��ڻ״̬��"+b);
		//��ȡ��ǰ�߳��Ƿ�Ϊ�ػ��̣߳���̨�߳�
		boolean b1 = t.isDaemon();
		System.out.println("��ǰ�߳��Ƿ�Ϊ�ػ��߳�:"+b1);
		//�����߳��Ƿ��Ѿ��ж�
		boolean b2 = t.isInterrupted();
		System.out.println("��ǰ�߳��Ƿ��Ѿ��ж�"+b2);
	}
}





















