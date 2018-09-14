package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 1.创建接收端ds带端口号
 * 2.创建一个包裹dp(比发送端的简单)
 * 3.接收数据
 * 4.解析数据
 * 		解析ip，解析字符串---getAddress().getLocalAddress
 * 				---getdata() ,dp.getLength()
 * 		输出在控制台
 * 5.关闭套接字对象
 * @author dell
 *
 */
public class RecieveDemo1 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(1234);
		byte[] data = new byte[1024];
		DatagramPacket dp = new DatagramPacket(data, data.length);
		ds.receive(dp);
		//解析数据
		String ip = dp.getAddress().getHostAddress();
		String s = new String(dp.getData(),0,dp.getLength());
		System.out.println(ip+"发送来："+s);
		ds.close();
	}
}


























