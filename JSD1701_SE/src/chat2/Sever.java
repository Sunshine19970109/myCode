package chat2;
/**
 * ��������
 * 1. ���ӿͻ��˽��տͻ��˵���Ϣ
 * 2�� ���ն���ͻ�����Ϣ
 * 3. �ظ�����ͻ�����Ϣ
 * 		1 ���Ա������������ȡ���߳�ʵ�ֶ��̻߳ظ�
 * 		2 ����߳���ֻ��sever��ʹ�����Կ���дһ��private �ڲ���
 * 4 ����ֻ�ܰ�һ���˵��Լ�������Ϣ�������Լ���
 * 	Ҫ������˵�Ļ������͸�ÿ���ˣ����Խ����˵���Ϣ����ÿ�������Ծ���Ҫ�õ������˵�����
 * 	���Կ����½�һ�������ϣ��������淢������Ϣ�Ĵ���ŵ������ϱ�����ѭ���С�
 * 5 ��ô֪�����������ˣ������̵߳�ʱ��˵һ�Σ���ô���͸��������أ���ҪЩ���鷢������ÿ������Ԫ��
 * 		������Ҫ��һ���������͸���������Ϣ�ķ�����˽�Ŀ���Ҳ��Ҫһ����˭����Ϣ�ķ���
 * 6 ���Ҫ��˽�ľͿ϶���Ҫ�ļ���Ϊmap����Ȼ���Ǳ���ȫ���߳��ҵ�Ҫ˽�ĵ��߳�
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
	 * ������Ϊʲôһ��д��Ŀ�ͻ�о��е��ѣ���Ϊ��û��˼·����������
	 * 1 ��������Ŀ��˼��˼·�����٣���������10����Ŀ��ʱ��һ����Ŀ����˼·��ʱ���ok��
	 */
	/**
	 * �������˲�����Socket,�����Ҫ��ȡ�ģ���SeverSocket
	 */
	private ServerSocket server ;
	/*
	 * Ϊʲô������BufferedWriter,�����
	 */
	private List<PrintWriter> addOut;
	
	/**
	 * ���췽��
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
	 * ��ʼ��������start����
	 */
	private void start() {
		try {
			while (true) {
				System.out.println("�ȴ�������");
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
	 * ���߳��ڲ���
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
		 * ���߳���дrun����
		 */
		public void run() {
			try {
				
				/*
				 * ��ȡ�ͻ�����Ϣ
				 */
				InetAddress address = socket.getInetAddress();
				String name = address.getHostName();
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				System.out.println(name+"������");
				String line = null;
				
				/*
				 * �����ͻ�����Ϣ
				 */
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
				PrintWriter pw = new PrintWriter(osw,true);
				
				synchronized (addOut) {
					addOut.add(pw);
					for (PrintWriter printWriter : addOut) {
						while ((line = br.readLine())!=null) {
							line = br.readLine();
							System.out.println(name+"˵: "+line);
							printWriter.println("������˵:"+name+"˵ :  "+line);
						}
					}
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
}






















