package day10;
/**
 * 守护线程又称为:后台线程
 * 使用上
 * 
 * main线程是前台线程，最先执行完的是main线程
 * 只有所有前台线程结束，进程才能结束
 * yield ---主动让出时间片回到runnable状态
 * @author dell
 *
 */
public class Thread_setDarmon {
	public static void main(String[] args) {
		/*
		 * rose:前台线程
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
				System.out.println("啊啊啊");
				System.out.println("扑通掉水里了");
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
		//设置守护线程必须在开始之前
		jack.setDaemon(true);
		jack.start();
	}
}



















