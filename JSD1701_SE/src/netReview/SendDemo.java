package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/*
 * UDPЭ�鷢�����ݣ�
 * A:�������Ͷ�DatagramSocket����
 * B:�������ݣ��������ݴ��ΪDatagramPacket����
 * C:����DatagramSocket����ķ��ͷ����������ݰ�
 * D:�ͷ���Դ
 */
public class SendDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		InetAddress address = InetAddress.getLocalHost();
		byte[] data = "�ҵ����ֽ���С΢".getBytes();
		DatagramPacket dp = new DatagramPacket(data, data.length, address, 10087);
		ds.send(dp);
		ds.close();
	}
}































