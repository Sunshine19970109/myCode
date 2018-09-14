package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/*
 * UDP协议发送数据：
 * A:创建发送端DatagramSocket对象
 * B:创建数据，并把数据打包为DatagramPacket对象
 * C:调用DatagramSocket对象的发送方法发送数据包
 * D:释放资源
 */
public class SendDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		InetAddress address = InetAddress.getLocalHost();
		byte[] data = "我的名字叫做小微".getBytes();
		DatagramPacket dp = new DatagramPacket(data, data.length, address, 10087);
		ds.send(dp);
		ds.close();
	}
}































