package netReview;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 1.ͨ����������ȡInetAddress����
 * 2.��ȡ������������������IP��ַ
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		String name  = address.getHostName();
		String ip = address.getHostAddress();
		System.out.println(name+"-----------"+ip);
	}
}
