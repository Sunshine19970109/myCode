package day12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * д��XML�ĵ�
 * @author TeduJAVA
 *
 */
public class WriteXMLDemo {
	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp(1, "����", 34, "��", 3000));
		empList.add(new Emp(2, "����", 21, "Ů", 4000));
		empList.add(new Emp(3, "����", 46, "Ů", 6500));
		empList.add(new Emp(4, "����	", 28, "��", 4400));
		empList.add(new Emp(5, "Ǯ��", 53, "��", 12000));
		
		/*
		 * д��XML�ĵ��Ĵ��²���:
		 * 1: �����հ��ĵ�����Document
		 * 2������ĵ���������Ӹ�Ԫ��
		 * 3:����Ԥ����XML�ĵ��ṹ�Ӹ�Ԫ�ؿ�ʼ�������
		 * ��Ԫ�أ�����ɸýṹ
		 * 4:����XMLWriter
		 * 5:��Document����д����XML�ĵ�
		 * 6:��XMLWriter�ر�
		 */
		//����Document����
		Document doc =DocumentHelper.createDocument();
		//��ӱ�ǩ
		/*
		 * Element addElement(String name)
		 * Document�ṩ�÷�����������ǰ�ĵ���
		 * ��Ӹ������ֵĸ�Ԫ�أ���������һ��Element
		 * ʵ�������Ա�����Ը�Ԫ�ؽ��в�����
		 * ��Ҫע�⣬�÷���ֻ�ܵ���һ�Σ���Ϊһ���ĵ�
		 * ��ֻ����һ����Ԫ��
		 */
		Element root = doc.addElement("list");
		//������Ա����Ϣ����Լ�������<Emp>��ǩ��ӵ�<list>����
		for (Emp emp : empList) {
			/*
			 * Element�ṩ������������ӱ�ǩ�ķ���:
			 * Element addElement(String name)
			 */
			Element empEle = root.addElement("emp");
			empEle.addAttribute("id", emp.getId()+"");
			//���<name>��ǩ
			Element nameEle = empEle.addElement("name");
			nameEle.addText(emp.getName());
			//���<age>
			empEle.addElement("age").addText(emp.getAge()+"");
			empEle.addElement("gender").addText(emp.getGender());
			empEle.addElement("salary").addText(emp.getSalary()+"");
		}
		
		try {
			
			FileOutputStream fos  =new FileOutputStream("myemp.xml");
			XMLWriter writer = new XMLWriter(fos,OutputFormat.createPrettyPrint());
			
			writer.write(doc);
			System.out.println("д�����");
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}























