package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 多次启动端口java.net.BindExceotion
 * 1.创建接收端(永久打开式)
 * @author dell
 *
 */
public class RecevieDemo2 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(1234);
		
		while (true) {
			//创建数据包
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			String ip  = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());
//			if ("886".equals(data)) {
//				System.out.println("数据接收完毕");
//				
//				break;
//			}
			System.out.println(ip+"发送 : "+data);
		}
//		ds.close();
	}
}


























