package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 1.����ds���󣬴������ݣ�dp����
 * 2.��������
 * 3.�ر�ds����
 * @author dell
 *
 */
public class SendDemo1 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		byte[] data = "�Һð����".getBytes();
		DatagramPacket dp = new DatagramPacket(
				data, data.length, InetAddress.getLocalHost(),1234);
		ds.send(dp);
		ds.close();
	}
}



















