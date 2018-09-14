package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * UDPЭ��������ݣ�
 * A:�������ն�DatagramSocket����--recieve����
 * B:����һ�����ݰ�(��������)DatagramPacket--getData()--getLength()
 * C:����DatagramSocket����Ľ��շ�����������
 * D:�������ݰ�������ʾ�ڿ���̨
 * E:�ͷ���Դ
 */
public class RecieveDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(10087);
		InetAddress address = InetAddress.getLocalHost();
		byte[] buf = new byte[1024];
		int length = buf.length;
		DatagramPacket dp = new DatagramPacket(buf, length);
		ds.receive(dp);
		buf = dp.getData();
		length =dp.getLength();
		String s = new String(buf, 0, length);
		String ip = address.getHostName();
		System.out.println(ip+"����: "+s);
	}
}



















