package netReview;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 1.通过电脑名获取InetAddress对象
 * 2.获取两个东西：主机名，IP地址
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		String name  = address.getHostName();
		String ip = address.getHostAddress();
		System.out.println(name+"-----------"+ip);
	}
}
