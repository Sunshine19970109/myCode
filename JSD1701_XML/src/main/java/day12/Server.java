package day12;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 1 导入dom4j对应的jar包
 * 2 创建服务器端Sever类
 * @author TeduJAVA
 *
 */
public class Server {
	/*
	 * 1 创建ServerSocket对象，监听客户端的连接以及网络
	 * 输入流对象
	 * 2 创建服务端Socket
	 * 3 监听客户端连接
	 * 4 获取输入法
	 */
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(8088);
			System.out.println("等待客户端连接");
			Socket server = ss.accept();
			System.out.println("客户端连接成功");
			InputStream in = server.getInputStream();
			/*
			 * 1 创建SAXReader对象来实现读取XML文档
			 * 2 获取Document对象
			 * 3 获取根标签对象
			 * 4 获取根标签中的所有元素的集合
			 * 5 遍历所有元素的集合并存入新的集合
			 * 6 输出在控制台，并关闭服务器套接字
			 */
			SAXReader reader = new SAXReader();
			Document doc = reader.read(in);
			Element root = doc.getRootElement();
			List<Element> elements = root.elements();
			List<Emp> empList = new ArrayList<Emp>();
			for (Element element : elements) {
				int id = Integer.parseInt(element.attribute("id").getValue());
				int age = Integer.parseInt(element.elementText("age"));
				String name = element.elementText("name");
				String gender = element.elementText("gender");
				int salary = Integer.parseInt(element.elementTextTrim("salary"));
				Emp emp = new Emp(id, name, age, gender, salary);
				empList.add(emp);
			}
			System.out.println("解析完毕");
			System.out.println(empList);
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 1 获取根元素
		 * 2 获取根元素集合中的子元素
		 * 3 封装Emp对象，存入集合
		 */
		
	}
}





















