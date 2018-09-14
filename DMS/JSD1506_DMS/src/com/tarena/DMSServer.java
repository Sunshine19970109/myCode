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
 * DMS�����
 * ����������пͻ��˷��͹����������־��������
 * һ���ļ����档
 * @author Administrator
 *
 */
public class DMSServer {
	/*
	 * ���Զ���
	 */
	private ServerSocket server;
	
	//�̳߳أ�����������ͻ��˽������߳�
	private ExecutorService threadPool;
	
	//���ڱ������пͻ��˷��͹����������־���ļ�
	private File serverLogFile;
	
	//���ڱ���ͻ��˽��յĴ��������־����Ϣ����
	private BlockingQueue<String> messageQueue;
	
	/**
	 * ���췽����������ʼ�������
	 * @throws Exception
	 */
	public DMSServer() throws Exception{
		try {
			/*
			 * �����ʼ������Ӧ��ʹ��һ�������ļ�
			 * ���ǿ��Զ���һ��server_config.xml
			 * Ȼ�󽫷������Ҫ�����ݽ������ã���
			 * ʹ����Щ�������ʼ�����������,�ο�
			 * �ͻ��˵�д����
			 */
			
			server = new ServerSocket(8088);
			
			threadPool = Executors.newFixedThreadPool(30);
			
			serverLogFile = new File("server-logs.txt");
			
			messageQueue = new LinkedBlockingQueue<String>();
			
		} catch (Exception e) {
			System.out.println("����˳�ʼ��ʧ��!");
			throw e;
		}
	}
	/**
	 * ����˿�ʼ�����ķ���
	 * @throws Exception
	 */
	public void start() throws Exception{
		try {
			/*
			 * ��������־���߳���������
			 */
			SaveLogHandler saveHandler
				= new SaveLogHandler();
			Thread t = new Thread(saveHandler);
			t.start();
			
			
			while(true){
				Socket socket = server.accept();
				/*
				 * ��һ���ͻ������Ӻ󣬽���ÿͻ��˽�����
				 * ����ָ�ɸ��̳߳أ�ʹ�������߳���ɸ�
				 * ����
				 */
				ClientHandler handler
					= new ClientHandler(socket);
				threadPool.execute(handler);
				
			}
		} catch (Exception e) {
			System.out.println("���������ʧ��!");
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
	 * ���߳��������������ԵĴ���Ϣ������ȡ��ÿһ��
	 * �����־�����浽serverLogFile��
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
				 * ����Ϣ���л�ȡÿһ����־
				 * ��д���ļ�������������ʱ
				 * û��Ԫ��ʱ����Ϣ��
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
	 * ���̵߳���Ҫ�����ǽ���һ���ͻ��˷��͹�����
	 * ���������־�����棬Ȼ���Ӧ�ͻ��˷���˵�
	 * ������
	 * @author Administrator
	 *
	 */
	private class ClientHandler 
					implements Runnable{
		//��ͻ���ͨѶ��Socket
		private Socket socket;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			//���ڻظ��ͻ��˵������
			PrintWriter pw = null;
			try {
				//3 ����ǲ���3������
				pw = new PrintWriter(
					new OutputStreamWriter(
						socket.getOutputStream(),
						"UTF-8"
					)	
				);
				
				/*
				 * ����:
				 * 1:ͨ��Socket��ȡ����������
				 *   ��װΪBufferedReader��
				 *   ���ڶ�ȡ�ͻ��˷��͹��������
				 *   ��־
				 * 2:ѭ����ȡÿһ����־������־
				 *   д�뱾���ļ����档
				 *   ����ȡ��"OVER"ʱֹͣ��ȡ
				 * 3:��ȫ��������Ϻ�ͨ��Socket
				 *   ��ȡ���������ת��ΪPrintWriter
				 *   ���ڸ��ͻ��˷�����Ӧ
				 * 4:�ظ��ͻ���"OK"    
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








