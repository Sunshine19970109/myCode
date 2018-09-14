package netReview1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/*
 * UDp协议接收数据:
 * A:创建接收端socket对象
 * B:创建一个数据包(接收容器)
 * C:调用Socket对象的接收方法接收数据
 * D:解析数据包，并显示在控制台
 * E:释放资源
 */
public class ReceiveDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 1 创建一个Socket对象DatagramSocket(int port)
			 * 2 创建一个数据包（接收容器）
			 * 3 调用Socket对象的接收方法接收数据
			 */
			InetAddress address = InetAddress.getLocalHost();
			
			DatagramSocket ds = new DatagramSocket(8088, address);
			byte[] buf = new byte[100];
			DatagramPacket dp = new DatagramPacket(buf, 0, buf.length);
			ds.receive(dp);
			/*
			 * 1 解析数据包，并显示在控制台
			 * 2 获取对方id
			 */
			InetAddress a = dp.getAddress();
			String ip = a.getHostAddress();
			//获取数据缓冲区
			byte[] data = dp.getData();
			int len = data.length;
			String s = new String(data, 0, len);
			System.out.println(ip+"----"+s);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}





















