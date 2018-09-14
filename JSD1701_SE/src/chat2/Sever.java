package chat2;
/**
 * 服务器类
 * 1. 连接客户端接收客户端的消息
 * 2。 接收多个客户端消息
 * 3. 回复多个客户端消息
 * 		1 所以必须设置流类获取的线程实现多线程回复
 * 		2 这个线程类只供sever端使用所以可以写一个private 内部类
 * 4 这样只能把一个人的自己发的消息发给他自己，
 * 	要将别人说的话都发送给每个人，所以将别人的消息发给每个人所以就需要拿到所有人的流，
 * 	所以可以新建一个流集合，将你上面发送流消息的代码放到流集合遍历的循环中。
 * 5 怎么知道别人上线了，连接线程的时候说一次，怎么发送给所有人呢，需要些三遍发送流给每个集合元素
 * 		所以需要做一个方法发送给所有人消息的方法，私聊可能也需要一个给谁发消息的方法
 * 6 如果要改私聊就肯定需要改集合为map，不然就是遍历全局线程找到要私聊的线程
 * 
 * @author dell
 *
 */

import java.io.BufferedReader;
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

import chat.Server;

public class Sever {
	/*
	 * 你现在为什么一到写项目就会感觉有点难，因为你没有思路，你做出来
	 * 1 你对这个项目构思的思路还很少，等你做够10个项目的时候，一提项目就有思路的时候就ok了
	 */
	/**
	 * 服务器端不能用Socket,这个是要获取的，用SeverSocket
	 */
	private ServerSocket server ;
	/*
	 * 为什么不能用BufferedWriter,会出错
	 */
	private List<PrintWriter> addOut;
	
	/**
	 * 构造方法
	 * @param sever
	 */
	public Sever(ServerSocket sever) {
		this.server = sever;
		this.addOut = new ArrayList<>(); 
	}
	
	public static void main(String[] args) {
		try {
			ServerSocket severSocket = new ServerSocket(8088);
			Sever server = new Sever(severSocket);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 开始服务器的start方法
	 */
	private void start() {
		try {
			while (true) {
				System.out.println("等待连接中");
				Socket socket = server.accept();
				ClientHandler client = new ClientHandler(socket);
				Thread t = new Thread(client);
				t.start();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 多线程内部类
	 * @author dell
	 *
	 */
	private class ClientHandler implements Runnable{
		private Socket socket;
		public ClientHandler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		/**
		 * 多线程重写run方法
		 */
		public void run() {
			try {
				
				/*
				 * 读取客户端消息
				 */
				InetAddress address = socket.getInetAddress();
				String name = address.getHostName();
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				System.out.println(name+"已连接");
				String line = null;
				
				/*
				 * 发出客户端消息
				 */
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
				PrintWriter pw = new PrintWriter(osw,true);
				
				synchronized (addOut) {
					addOut.add(pw);
					for (PrintWriter printWriter : addOut) {
						while ((line = br.readLine())!=null) {
							line = br.readLine();
							System.out.println(name+"说: "+line);
							printWriter.println("服务器说:"+name+"说 :  "+line);
						}
					}
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
}






















