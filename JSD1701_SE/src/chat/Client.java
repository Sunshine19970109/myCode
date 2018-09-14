package chat;
/**
 * 聊天室客户端
 * @author dell
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 1 把地址换成昵称
 * 2 私聊功能
 * 
 * 1 先连上
 * 2 多个客户端连上
 * 3 看能不能回复
 * 4 
 */
public class Client {
	/**
	 * java.net.Socket 封装了TCP协议
	 */
	private Socket socket;

	/**
	 * 构造方法，用来初始化客户端
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public Client() throws UnknownHostException, IOException {
		/*
		 * 实例化Socket是需要传入两个参数 1:服务端ip地址 2:服务端端口号 通过IP地址可以找到网络上的服务端所在的计算机
		 * 通过端口可以连接到该计算机上的服务端应用程序
		 * 
		 * 实例化Socket的过程就是建立连接的过程，所以若 连接服务端失败，这里会抛出异常
		 */
		socket = new Socket("localhost", 8088);
		System.out.println("连接 服务端成功");

	}

	public static void main(String[] args) {

		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端启动异常");
		}
	}

	/*
	 * 客户端的启动方法，从这里开始执行逻辑
	 */
	public void start() {
		/*
		 * 1 获取输出流、写高级流printWriter简化操作 2 创建OutputStream,指定字符集
		 */
		try {
			/*
			 * 向服务器端说话
			 */
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "GBK");
			PrintWriter pw = new PrintWriter(osw, true);
			Scanner sc = new Scanner(System.in);

			String line = null;
			/*
			 * 创建输入流读取服务器回复的话
			 */
			ServerHandler sever = new ServerHandler();
			Thread t = new Thread(sever);
			t.start();
			System.out.println("开始聊天吧");
			while (!("886".equals(line = sc.nextLine()))) {

				pw.println("你好，服务端");

				// line = sc.nextLine();
				pw.println(line);
				System.out.println("666");
			}
			System.out.println("再见，服务器");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端输出流异常");
		}
	}

	/**
	 * 该线程用来循环接收服务端发送过来的消息并输出到 客户端自己的控制台上
	 * 
	 * @author TeduJAVA
	 *
	 */
	private class ServerHandler implements Runnable {

		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "GBK");
				BufferedReader br = new BufferedReader(isr);

				String read = null;
				while ((read = br.readLine()) != null) {
					System.out.println("服务器说:" + read);
				}
				System.out.println(read);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
