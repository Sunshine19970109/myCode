package day10;
/**
 * �߳����ȼ�
 * 
 * �̶߳��̵߳��ȵĹ����ǲ��ɿ��Ƶģ���
 * �߳�ֻ�ܱ���������CPUʱ�䣬������������ȡ����
 * 
 * �̵߳��Ȼᾡ���ܵĽ�CPUʱ�����ļ����������ȡ�
 * ���Ƕ���̲߳������У�������֤һ���߳�һ��������������  
 * 
 *   
 *����ͨ�������߳����ȼ����Ʒ���CPU��ʱ���
 * @author dell
 *
 */
public class Thread_setPriority {
	public static void main(String[] args) {
		Thread max = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("max = "+i);
				}
				
			}
		};
		Thread min = new Thread(){
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("min = "+i);
				}
			}
		};
		Thread nor = new Thread(){
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("nor = "+i);
				}
			}
		};
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		nor.setPriority(Thread.NORM_PRIORITY);
		max.start();
		min.start();
		nor.start();
	}
}

















