package day11;
/**
 * StringBuffer��StringBuilderʹ��
 * @author dell
 *
 */
public class SyncDemo5 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("buffer");
		StringBuilder sbl = new StringBuilder("builder");
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
		//public synchronized StringBuffer append(String str) {
					sb.append("Thread-0dosome�����������");
					System.out.println(sbl);
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
			//public StringBuilder append(String str) {
					sbl.append("Thread-1:��������dosome����");
					System.out.println(sbl);
				}
				
			}
		});
		t1.start();
		t2.start();
	}
}
