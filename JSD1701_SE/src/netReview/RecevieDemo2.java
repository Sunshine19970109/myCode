package netReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ��������˿�java.net.BindExceotion
 * 1.�������ն�(���ô�ʽ)
 * @author dell
 *
 */
public class RecevieDemo2 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(1234);
		
		while (true) {
			//�������ݰ�
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			String ip  = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());
//			if ("886".equals(data)) {
//				System.out.println("���ݽ������");
//				
//				break;
//			}
			System.out.println(ip+"���� : "+data);
		}
//		ds.close();
	}
}


























