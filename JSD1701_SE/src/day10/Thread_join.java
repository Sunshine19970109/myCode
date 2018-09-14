package day10;
/**
 * 线程是异步运行的
 * 异步：各执行各的，互相不妨碍
 * 同步:有先后顺序的执行。
 * 
 * 有些业务需要让多个线程间同步运行，这个时候可以
 * 借助线程的join方法来完成。
 * 
 * join方法允许一个线程进入阻塞状态，直到其等待的另一个
 * 线程工作结束后再继续运行
 * @author dell
 *
 */
public class Thread_join {
	//表示图片是否下载完毕
	public static boolean isFinish = false;
	/*
	 * 写两个线程：下载图片，显示图片
	 */
	public static void main(String[] args) {
		Thread down = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("正在下载"+i+"%");
				}
				System.out.println("下载完毕");
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
					throw new RuntimeException("未下载完毕");
				}
				System.out.println("图片显示成功");
			}
		};
		down.start();
		show.start();
	}
}




















