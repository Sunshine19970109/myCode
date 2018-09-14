package netReview1;

import java.net.UnknownHostException;

/**
 * 如果一个类没有构造方法:
 * A:成员全部是静态方法(Math,Arrays,Collections)
 * b:单例设计模式
 * c:类中有静态方法返回该类的对象(InetAddress)
 * 
 * @author dell
 *
 */
public class InetAddress {
	public static void main(String[] args) {
		// 获取两个东西：主机名，IP地址
		try {
			java.net.InetAddress address = java.net.InetAddress.getLocalHost();
			String name = address.getHostName();
			System.out.println("本机名是:"+name);
			String ip = address.getHostAddress();
			System.out.println("ip:"+ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





















