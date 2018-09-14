package chat;
/**
 * �����ҷ����
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
	 * java.net.ServerSocket �����ڷ���˵�ServerSocket��Ҫ���������� 1:�������˿�
	 * 2:��������˿ڣ�һ��һ���ͻ���ͨ���ö˿ڽ��� ���ӣ��򴴽�һ��Socket������ͻ���ͨѶ
	 */
	private ServerSocket server;
	/*
	 * �ü�������������пͻ��˵�����������ڽ���Ϣ �㲥�����пͻ���,�Լ��ϵ���ʶǧ��Ҫ��խ�� ��������������ģ����Ͽ��Զ��һ����
	 */
	private List<PrintWriter> addOut;

	public Server() throws IOException {
		/*
		 * ��ʼ��ServerSocket��ͬʱ��Ҫָ������˿� �ö˿ںŲ�����ϵͳ����Ӧ�ó���������Ķ˿ں��ظ������� ���׳��쳣��
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
	 * ����������Ϣ�㲥�����еĿͻ���
	 * 
	 * @param message
	 */
	private void sendMessage(String message) {
		synchronized (addOut) {
			// ת����������
			for (PrintWriter o : addOut) {
				o.println(message);
			}
		}

	}

	public void start() {
		try {
			/*
			 * ServerSocket�ṩ����: Socket accept() �÷��������ServerSocket����ķ���˿ڡ�
			 * ����һ������������ֱ��һ���ͻ���ͨ���ö˿����� �Ż᷵��һ��Socket.������ص�Socket�������� ���ӵĿͻ��˽���ͨѶ�ġ�
			 */
			while (true) {
				System.out.println("�ȴ��ͻ�������...");
				/*
				 * ����һ��acceptֻ�ܽ���һ���ͻ��� ͬʱ��ɶ�δ���ֻ�����߳�
				 */
				Socket socket = server.accept();
				System.out.println("�ͻ���������");
				/*
				 * ����һ���߳���ÿͻ��˽���
				 */
				/*
				 * ʵ�ֽӿڲ���ֱ������������ȥ��Ϊ�̵߳Ĳ������������� ���߳������߳����������߳�
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
	 * ����һ���ڲ��࣬�ҷ������������
	 */
	private class ClientHandler implements Runnable {
		/*
		 * ��ǰ�߳�ͨ�����Socket��ָ���ͻ��˽���
		 */
		private Socket socket;
		// �ͻ��˵�ַ
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
				 * 1 ��ȡ������ 2 �����ȡ����Ϣ
				 */
				/*
				 * ��message������nullʱֹͣѭ��
				 */
				InputStream is = this.socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "GBK");
				BufferedReader br = new BufferedReader(isr);
				sendMessage(host + "�����ˣ�һ��" + addOut.size() + "��");
				/*
				 * ͨ��Socket��ȡ����������ڽ����ݷ��͸��ͻ���
				 */
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, "GBK");
				pw = new PrintWriter(osw, true);
				/*
				 * ��������ŵ��������� ���ڶ���̻߳���øü��ϵ�add������������������������
				 * Ϊ�˱�֤�̰߳�ȫ�����Խ��ü��ϼ�����ͬ����
				 * 
				 */
				synchronized (addOut) {
					addOut.add(pw);
				}

				String message = null;
				while ((message = br.readLine()) != null) {
					// message = br.readLine();
					// pw.println(host+"˵:"+message);
					//
					// System.out.println(host+"˵:"+message);
					// ת�������пͻ���
					/*
					 * Ϊ�˷�ֹ������ʱ���Ŀͻ������������Ԫ�أ� ���Ա���ҲӦ�ü�����������������Ϊ����
					 */
					synchronized (addOut) {
						for (PrintWriter o : addOut) {
							sendMessage(host + "˵:" + message);
						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// ����ͻ��˶Ͽ��Ժ�Ĺ���
				/*
				 * ���ͻ��˶Ͽ��Ժ󣬽��ÿͻ��˵�������ӹ���������ɾ�� ͬ������
				 */
				synchronized (addOut) {

					addOut.remove(pw);
				}

				sendMessage(host + "������");
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
