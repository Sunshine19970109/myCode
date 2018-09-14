package day12;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * XML�ļ�ֻ����һ�Σ���Ϊ�����ļ�����
 */
/**
 * ʹ��DOM4J����XML�ĵ�
 * @author TeduJAVA
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		/*
		 * ��ȡemplist�ļ�������xml�ĵ��е�����Ա��
		 * ��Ϣ������������������Empʵ�����棬Ȼ��
		 * ����ЩԱ����Ϣ���뵽һ��List�����С�
		 */
	/*
	 * ʹ��DOM����XML�Ĵ�������:
	 * 1:����SAXReader
	 * 2:ʹ��SAXReader��ȡҪ������XML�ĵ�
	 * 	�ò������DOM��ʱ����Դ�ĵط�����Ϊ�Ὣ
	 * �ĵ��������ݽ�����ϲ����뵽�ڴ��С�
	 * ��ȡ�����᷵��һ��Document���󣬸ö���
	 * �ͱ�ʾ���������ĸ�XML�ĵ�����
	 * 3:ͨ��Document�����ȡ��Ԫ��(����ǩ)
	 * 4:�����ĵ��ṹ���Ӹ�Ԫ�ؿ�ʼ�𼶻�ȡ��Ԫ��
	 * �Դﵽ����XML�ĵ����ݵ�Ŀ��
	 */
		try {
			//1����SAXReader����
			SAXReader reader = new SAXReader();
			//2��ȡDocument���󣬲����Լ��رգ��Զ���ر�
			Document doc =reader.read(
					new FileInputStream("emplist.xml"));
			//3��ȡ����ǩ
			/*
			 * Element��ÿ��ʵ�����ڱ�ʾXML�ĵ��е�
			 * һ��Ԫ��(һ�Ա�ǩ)
			 * ���ṩ�˺ܶ����ڲ�����ǰ��ǩ�ķ���������
			 * ���õ����ڻ�ȡ��ǩ��Ϣ�ķ�����:
			 * 
			 * String getName()
			 * ��ȡ��ǩ��
			 * 
			 * Element element(String name)
			 * ���ݸ��������ֻ�ȡ��ǰ��ǩ�е��ӱ�ǩ
			 * 
			 * List elements()
			 * ��ȡ��ǰ��ǩ�������ӱ�ǩ�����صļ�����
			 * �����ɵ�Elementʵ����ÿ��Ϊһ����Ԫ��
			 * 
			 * List elements(String name)
			 * ��ȡ��ǰ��ǩ������ͬ����Ԫ��
			 * 
			 * String getText()
			 * ��ȡ��ǰ��ǩ�м���ı�
			 * 
			 * Attribute  attribute(String name)
			 * ��ȡ��ǰ��ǩ��ָ�����ֵ�����
			 */
			Element root = doc.getRootElement();
			/*
			 * �ü��������������н���������Ա����Ϣ
			 */
			List<Emp> empList = new ArrayList<Emp>();
			/*
			 * ��ȡ<list>��ǩ�е�����<emp>��ǩ
			 */
			List<Element>  list = root.elements();
			/*
			 * ��ÿ��<emp>��ǩ�е�����ȡ��������һ��Empʵ������
			 * Ȼ�󽫸ö�����뼯��
			 */
			for (Element element : list) {
//				System.out.println(element.getName());
				//��ȡname
				Element nameEle = element.element("name");
				String name = nameEle.getText();
//				Attribute idAtt = element.attribute("id");
//				int id = Integer.valueOf(idAtt.getText());
				int id = Integer.parseInt(element.attributeValue("id"));
				
				int age = Integer.parseInt(element.elementText("age"));
//				Element ageEle = element.element("age");
//				int age = Integer.valueOf(ageEle.getText());
				Element genderEle = element.element("gender");
				String gender = genderEle.getText();
				Element salaryEle = element.element("salary");
				int salary = Integer.valueOf(salaryEle.getText());
				Emp e = new Emp(id, name, age, gender, salary);
				empList.add(e);
			}
			System.out.println(empList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}




















