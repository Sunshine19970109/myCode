package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * UDP协议接收数据：
 * A:创建接收端DatagramSocket对象--recieve方法
 * B:创建一个数据包(接收容器)DatagramPacket--getData()--getLength()
 * C:调用DatagramSocket对象的接收方法接收数据
 * D:解析数据包，并显示在控制台
 * E:释放资源
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
		System.out.println(ip+"传来: "+s);
	}
}



















