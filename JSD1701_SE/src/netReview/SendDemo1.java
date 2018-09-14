package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 1.创建ds对象，创建数据，dp对象
 * 2.发送数据
 * 3.关闭ds对象
 * @author dell
 *
 */
public class SendDemo1 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		byte[] data = "我好爱编程".getBytes();
		DatagramPacket dp = new DatagramPacket(
				data, data.length, InetAddress.getLocalHost(),1234);
		ds.send(dp);
		ds.close();
	}
}



















