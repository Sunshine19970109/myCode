package day12;

import java.io.FileInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��XPATH����XML�ĵ�����
 * @author TeduJAVA
 *
 */
/*
 * ����дһ����Ŀ:
 * 	����ÿ��д�������֣�ÿ���˶�һ�����տ�ʼ��û��˼·
 * ˼·����д�Ķ��˲Ż���˼·������ܻ��кܶ�ط�������
 * ���������Ƿ��ʼǣ��¹���û����û������ô�죬��д�����ԣ�
 * ���ϸ��µ���
 * 
 * ˼·���ǹ����ľ���
 * �����ò���ָ��е���ô���--���ǳ�����
 */
public class XpathDemo {
	public static void main(String[] args) {
		try {
			/*
			 * ���� SAXReader reader
			 * 2 ����doc
			 */
			SAXReader reader = new SAXReader();
			Document doc = reader.read(
					new FileInputStream("myemp.xml"));
			String xpath = "/list/emp[salary>3000 and gender='��']/name";
			
			List<Element> list = doc.selectNodes(xpath);
			for (Element element : list) {
				System.out.println(element.getText());
			}
		} catch (Exception e) {
			
		}
	}
}
