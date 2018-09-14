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
 * 1 ����dom4j��Ӧ��jar��
 * 2 ������������Sever��
 * @author TeduJAVA
 *
 */
public class Server {
	/*
	 * 1 ����ServerSocket���󣬼����ͻ��˵������Լ�����
	 * ����������
	 * 2 ���������Socket
	 * 3 �����ͻ�������
	 * 4 ��ȡ���뷨
	 */
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(8088);
			System.out.println("�ȴ��ͻ�������");
			Socket server = ss.accept();
			System.out.println("�ͻ������ӳɹ�");
			InputStream in = server.getInputStream();
			/*
			 * 1 ����SAXReader������ʵ�ֶ�ȡXML�ĵ�
			 * 2 ��ȡDocument����
			 * 3 ��ȡ����ǩ����
			 * 4 ��ȡ����ǩ�е�����Ԫ�صļ���
			 * 5 ��������Ԫ�صļ��ϲ������µļ���
			 * 6 ����ڿ���̨�����رշ������׽���
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
			System.out.println("�������");
			System.out.println(empList);
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 1 ��ȡ��Ԫ��
		 * 2 ��ȡ��Ԫ�ؼ����е���Ԫ��
		 * 3 ��װEmp���󣬴��뼯��
		 */
		
	}
}





















