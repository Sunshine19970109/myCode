package chat;
/**
 * �����ҿͻ���
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
 * 1 �ѵ�ַ�����ǳ�
 * 2 ˽�Ĺ���
 * 
 * 1 ������
 * 2 ����ͻ�������
 * 3 ���ܲ��ܻظ�
 * 4 
 */
public class Client {
	/**
	 * java.net.Socket ��װ��TCPЭ��
	 */
	private Socket socket;

	/**
	 * ���췽����������ʼ���ͻ���
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public Client() throws UnknownHostException, IOException {
		/*
		 * ʵ����Socket����Ҫ������������ 1:�����ip��ַ 2:����˶˿ں� ͨ��IP��ַ�����ҵ������ϵķ�������ڵļ����
		 * ͨ���˿ڿ������ӵ��ü�����ϵķ����Ӧ�ó���
		 * 
		 * ʵ����Socket�Ĺ��̾��ǽ������ӵĹ��̣������� ���ӷ����ʧ�ܣ�������׳��쳣
		 */
		socket = new Socket("localhost", 8088);
		System.out.println("���� ����˳ɹ�");

	}

	public static void main(String[] args) {

		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ͻ��������쳣");
		}
	}

	/*
	 * �ͻ��˵����������������￪ʼִ���߼�
	 */
	public void start() {
		/*
		 * 1 ��ȡ�������д�߼���printWriter�򻯲��� 2 ����OutputStream,ָ���ַ���
		 */
		try {
			/*
			 * ���������˵��
			 */
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "GBK");
			PrintWriter pw = new PrintWriter(osw, true);
			Scanner sc = new Scanner(System.in);

			String line = null;
			/*
			 * ������������ȡ�������ظ��Ļ�
			 */
			ServerHandler sever = new ServerHandler();
			Thread t = new Thread(sever);
			t.start();
			System.out.println("��ʼ�����");
			while (!("886".equals(line = sc.nextLine()))) {

				pw.println("��ã������");

				// line = sc.nextLine();
				pw.println(line);
				System.out.println("666");
			}
			System.out.println("�ټ���������");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ͻ���������쳣");
		}
	}

	/**
	 * ���߳�����ѭ�����շ���˷��͹�������Ϣ������� �ͻ����Լ��Ŀ���̨��
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
					System.out.println("������˵:" + read);
				}
				System.out.println(read);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
