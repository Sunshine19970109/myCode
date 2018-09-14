package day12;

import java.io.File;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 1 创建Socket去连接服务器端
 * 2 获取网络输出流
 * 3 读取XML文档，创建SAXReader对象，来读取XML文档，
 * 并获取Document对象
 * 4 创建XML输出流XMLWriter类对象
 * @author TeduJAVA
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			InetAddress in = InetAddress.getLocalHost(); 
			Socket client = new Socket(in,8088);
			OutputStream os = client.getOutputStream();
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("emplist.xml"));
			XMLWriter writer = new XMLWriter(os, OutputFormat.createPrettyPrint());
			writer.write(doc);
			client.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}




















