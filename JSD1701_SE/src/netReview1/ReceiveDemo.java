package netReview1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/*
 * UDpЭ���������:
 * A:�������ն�socket����
 * B:����һ�����ݰ�(��������)
 * C:����Socket����Ľ��շ�����������
 * D:�������ݰ�������ʾ�ڿ���̨
 * E:�ͷ���Դ
 */
public class ReceiveDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 1 ����һ��Socket����DatagramSocket(int port)
			 * 2 ����һ�����ݰ�������������
			 * 3 ����Socket����Ľ��շ�����������
			 */
			InetAddress address = InetAddress.getLocalHost();
			
			DatagramSocket ds = new DatagramSocket(8088, address);
			byte[] buf = new byte[100];
			DatagramPacket dp = new DatagramPacket(buf, 0, buf.length);
			ds.receive(dp);
			/*
			 * 1 �������ݰ�������ʾ�ڿ���̨
			 * 2 ��ȡ�Է�id
			 */
			InetAddress a = dp.getAddress();
			String ip = a.getHostAddress();
			//��ȡ���ݻ�����
			byte[] data = dp.getData();
			int len = data.length;
			String s = new String(data, 0, len);
			System.out.println(ip+"----"+s);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}





















