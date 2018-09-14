package chat2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * �ͻ���
 * 1 �����׽��֡��˿ڣ���ȡ�����
 * 2 �������¼�빦��
 * @author dell
 *
 */
public class Client {
	private Socket socket;
	public Client(Socket socket) {
		this.socket = socket;
	}
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			Socket socket = new Socket(address, 8088);
			Client client  = new Client(socket);
			client.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private void start() {
		try {
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			PrintWriter pw = new PrintWriter(osw,true);
			System.out.println("�����ӷ��������뿪ʼ����");
			
			SeverHandler sever = new SeverHandler(socket);
			Thread t = new Thread(sever);
			t.start();
			
			Scanner sc = new Scanner(System.in);
			String line = null;
			while ((line = sc.nextLine())!=null) {
				pw.println("��÷����");
				pw.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("�Ѿ��Ͽ����������������!");
		}
	}
	private class SeverHandler implements Runnable{
		private Socket socket;
		public SeverHandler(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String line  = null;
				while ((line = br.readLine())!=null) {
					System.out.println(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
	}
}




















