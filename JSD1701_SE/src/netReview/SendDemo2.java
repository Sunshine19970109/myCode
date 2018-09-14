package netReview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 1.����br���󣬷�װ����
 * 2.����line������
 * 3.������������ֱ��886
 * @author dell
 *
 */
public class SendDemo2 {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line=br.readLine())!=null) {
			if ("886".equals(line)) {
				System.out.println("�������");
				break;
			}
			DatagramPacket dp 
			= new DatagramPacket(line.getBytes(), line.getBytes().length, 
					InetAddress.getLocalHost(), 1234);
			ds.send(dp);
			
		}
		ds.close();
	}
}
















