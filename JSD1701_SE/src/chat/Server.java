package chat;
/**
 * 聊天室服务端
 * @author dell
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	/**
	 * java.net.ServerSocket 运行在服务端的ServerSocket主要有两个作用 1:申请服务端口
	 * 2:监听服务端口，一旦一个客户端通过该端口建立 连接，则创建一个Socket用于与客户端通讯
	 */
	private ServerSocket server;
	/*
	 * 该集合用来存放所有客户端的输出流，用于将消息 广播给所有客户端,对集合的认识千万不要狭窄， 单个对象可以做的，集合可以多个一起做
	 */
	private List<PrintWriter> addOut;

	public Server() throws IOException {
		/*
		 * 初始化ServerSocket的同时需要指定服务端口 该端口号不能与系统其它应用程序已申请的端口号重复，否则 会抛出异常。
		 */
		server = new ServerSocket(8088);

		addOut = new ArrayList<PrintWriter>();
	}

	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 将给定的消息广播给所有的客户端
	 * 
	 * @param message
	 */
	private void sendMessage(String message) {
		synchronized (addOut) {
			// 转发给所有人
			for (PrintWriter o : addOut) {
				o.println(message);
			}
		}

	}

	public void start() {
		try {
			/*
			 * ServerSocket提供方法: Socket accept() 该方法会监听ServerSocket申请的服务端口。
			 * 这是一个阻塞方法，直到一个客户端通过该端口连接 才会返回一个Socket.这个返回的Socket是用于与 连接的客户端进行通讯的。
			 */
			while (true) {
				System.out.println("等待客户端连接...");
				/*
				 * 调用一次accept只能接受一个客户端 同时完成多段代码只能用线程
				 */
				Socket socket = server.accept();
				System.out.println("客户端连接了");
				/*
				 * 启动一个线程与该客户端交互
				 */
				/*
				 * 实现接口不能直接跑起来，必去作为线程的参数再能跑起来 多线程是主线程启动其他线程
				 */

				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 创建一个内部类，我分派任务给他做
	 */
	private class ClientHandler implements Runnable {
		/*
		 * 当前线程通过这个Socket与指定客户端交互
		 */
		private Socket socket;
		// 客户端地址
		private String host;

		public ClientHandler(Socket socket) {
			this.socket = socket;
			InetAddress address = socket.getInetAddress();
			this.host = address.getHostAddress();
		}

		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				/*
				 * 1 获取输入流 2 输出获取的信息
				 */
				/*
				 * 当message不等于null时停止循环
				 */
				InputStream is = this.socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "GBK");
				BufferedReader br = new BufferedReader(isr);
				sendMessage(host + "上线了，一共" + addOut.size() + "人");
				/*
				 * 通过Socket获取输出流，用于将数据发送给客户端
				 */
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, "GBK");
				pw = new PrintWriter(osw, true);
				/*
				 * 将输出流放到共享集合中 由于多个线程会调用该集合的add方法向其中添加输出流，所以
				 * 为了保证线程安全，可以将该集合加锁加同步锁
				 * 
				 */
				synchronized (addOut) {
					addOut.add(pw);
				}

				String message = null;
				while ((message = br.readLine()) != null) {
					// message = br.readLine();
					// pw.println(host+"说:"+message);
					//
					// System.out.println(host+"说:"+message);
					// 转发给所有客户端
					/*
					 * 为了防止遍历的时候别的客户端向里面添加元素， 所以遍历也应该加上锁，而且锁对象为集合
					 */
					synchronized (addOut) {
						for (PrintWriter o : addOut) {
							sendMessage(host + "说:" + message);
						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 处理客户端断开以后的工作
				/*
				 * 当客户端断开以后，将该客户端的输出流从共享集合里面删除 同样加锁
				 */
				synchronized (addOut) {

					addOut.remove(pw);
				}

				sendMessage(host + "下线了");
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

	}

}
