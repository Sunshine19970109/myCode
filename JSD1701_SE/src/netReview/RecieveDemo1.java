package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 1.�������ն�ds���˿ں�
 * 2.����һ������dp(�ȷ��Ͷ˵ļ�)
 * 3.��������
 * 4.��������
 * 		����ip�������ַ���---getAddress().getLocalAddress
 * 				---getdata() ,dp.getLength()
 * 		����ڿ���̨
 * 5.�ر��׽��ֶ���
 * @author dell
 *
 */
public class RecieveDemo1 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(1234);
		byte[] data = new byte[1024];
		DatagramPacket dp = new DatagramPacket(data, data.length);
		ds.receive(dp);
		//��������
		String ip = dp.getAddress().getHostAddress();
		String s = new String(dp.getData(),0,dp.getLength());
		System.out.println(ip+"��������"+s);
		ds.close();
	}
}


























