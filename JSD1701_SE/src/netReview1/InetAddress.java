package netReview1;

import java.net.UnknownHostException;

/**
 * ���һ����û�й��췽��:
 * A:��Աȫ���Ǿ�̬����(Math,Arrays,Collections)
 * b:�������ģʽ
 * c:�����о�̬�������ظ���Ķ���(InetAddress)
 * 
 * @author dell
 *
 */
public class InetAddress {
	public static void main(String[] args) {
		// ��ȡ������������������IP��ַ
		try {
			java.net.InetAddress address = java.net.InetAddress.getLocalHost();
			String name = address.getHostName();
			System.out.println("��������:"+name);
			String ip = address.getHostAddress();
			System.out.println("ip:"+ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





















