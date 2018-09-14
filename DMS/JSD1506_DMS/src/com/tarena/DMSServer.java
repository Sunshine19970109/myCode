package com.tarena;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * DMS服务端
 * 负责接收所有客户端发送过来的配对日志，并存入
 * 一个文件保存。
 * @author Administrator
 *
 */
public class DMSServer {
	/*
	 * 属性定义
	 */
	private ServerSocket server;
	
	//线程池，用来管理与客户端交互的线程
	private ExecutorService threadPool;
	
	//用于保存所有客户端发送过来的配对日志的文件
	private File serverLogFile;
	
	//用于保存客户端接收的待保存的日志的消息队列
	private BlockingQueue<String> messageQueue;
	
	/**
	 * 构造方法，用来初始化服务端
	 * @throws Exception
	 */
	public DMSServer() throws Exception{
		try {
			/*
			 * 这里初始化还是应当使用一个配置文件
			 * 我们可以定义一个server_config.xml
			 * 然后将服务端需要的内容进行配置，再
			 * 使用这些配置项初始化服务端属性,参考
			 * 客户端的写法。
			 */
			
			server = new ServerSocket(8088);
			
			threadPool = Executors.newFixedThreadPool(30);
			
			serverLogFile = new File("server-logs.txt");
			
			messageQueue = new LinkedBlockingQueue<String>();
			
		} catch (Exception e) {
			System.out.println("服务端初始化失败!");
			throw e;
		}
	}
	/**
	 * 服务端开始工作的方法
	 * @throws Exception
	 */
	public void start() throws Exception{
		try {
			/*
			 * 将保存日志的线程启动起来
			 */
			SaveLogHandler saveHandler
				= new SaveLogHandler();
			Thread t = new Thread(saveHandler);
			t.start();
			
			
			while(true){
				Socket socket = server.accept();
				/*
				 * 当一个客户端连接后，将与该客户端交互的
				 * 任务指派给线程池，使其分配空线程完成该
				 * 任务。
				 */
				ClientHandler handler
					= new ClientHandler(socket);
				threadPool.execute(handler);
				
			}
		} catch (Exception e) {
			System.out.println("服务端运行失败!");
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			DMSServer server = new DMSServer();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 该线程任务用于周期性的从消息队列中取出每一条
	 * 配对日志并保存到serverLogFile中
	 * @author Administrator
	 *
	 */
	private class SaveLogHandler 
					 implements Runnable{
		public void run(){
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(
					serverLogFile
				);
				/*
				 * 从消息队列获取每一条日志
				 * 并写入文件，当队列中暂时
				 * 没有元素时，休息。
				 */
				while(true){
					if(messageQueue.size()>0){
						String log = messageQueue.poll();
						pw.println(log);
					}else{
						pw.flush();
						Thread.sleep(500);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(pw != null){
					pw.close();
				}
			}
		}
	}
	
	
	/**
	 * 该线程的主要任务是接收一个客户端发送过来的
	 * 所有配对日志并保存，然后回应客户端服务端的
	 * 处理结果
	 * @author Administrator
	 *
	 */
	private class ClientHandler 
					implements Runnable{
		//与客户端通讯的Socket
		private Socket socket;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			//用于回复客户端的输出流
			PrintWriter pw = null;
			try {
				//3 这个是步骤3的内容
				pw = new PrintWriter(
					new OutputStreamWriter(
						socket.getOutputStream(),
						"UTF-8"
					)	
				);
				
				/*
				 * 步骤:
				 * 1:通过Socket获取输入流，并
				 *   包装为BufferedReader，
				 *   用于读取客户端发送过来的配对
				 *   日志
				 * 2:循环读取每一条日志并将日志
				 *   写入本地文件保存。
				 *   当读取到"OVER"时停止读取
				 * 3:当全部接收完毕后，通过Socket
				 *   获取输出流，并转换为PrintWriter
				 *   用于给客户端发送响应
				 * 4:回复客户端"OK"    
				 *   
				 */
				//1
				BufferedReader br
					= new BufferedReader(
					new InputStreamReader(
						socket.getInputStream(),
						"UTF-8"
					)		
				);
				
				//2
				String line = null;
				while((line=br.readLine())!=null){
					if("OVER".equals(line)){
						break;
					}
					messageQueue.offer(line);
				}
				
				//4
				pw.println("OK");
				pw.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
				pw.println("ERROR");
				pw.flush();
			} finally{
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}








