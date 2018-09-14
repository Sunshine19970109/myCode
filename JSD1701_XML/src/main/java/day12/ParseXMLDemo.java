package day12;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * XML文件只解析一次，因为解析文件很慢
 */
/**
 * 使用DOM4J解析XML文档
 * @author TeduJAVA
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		/*
		 * 读取emplist文件，将该xml文档中的所有员工
		 * 信息解析出来，并以若干Emp实例保存，然后
		 * 将这些员工信息存入到一个List集合中。
		 */
	/*
	 * 使用DOM解析XML的大致流程:
	 * 1:创建SAXReader
	 * 2:使用SAXReader读取要解析的XML文档
	 * 	该步骤就是DOM耗时耗资源的地方，因为会将
	 * 文档所有内容解析完毕并存入到内存中。
	 * 读取方法会返回一个Document对象，该对象
	 * 就表示解析出来的该XML文档内容
	 * 3:通过Document对象获取根元素(根标签)
	 * 4:根据文档结构，从根元素开始逐级获取子元素
	 * 以达到遍历XML文档数据的目的
	 */
		try {
			//1创建SAXReader对象
			SAXReader reader = new SAXReader();
			//2获取Document对象，不用自己关闭，自动会关闭
			Document doc =reader.read(
					new FileInputStream("emplist.xml"));
			//3获取根标签
			/*
			 * Element的每个实例用于表示XML文档中的
			 * 一个元素(一对标签)
			 * 它提供了很多用于操作当前标签的方法，其中
			 * 常用的用于获取标签信息的方法有:
			 * 
			 * String getName()
			 * 获取标签名
			 * 
			 * Element element(String name)
			 * 根据给定的名字获取当前标签中的子标签
			 * 
			 * List elements()
			 * 获取当前标签中所有子标签，返回的集合中
			 * 是若干的Element实例，每个为一个子元素
			 * 
			 * List elements(String name)
			 * 获取当前标签中所有同名子元素
			 * 
			 * String getText()
			 * 获取当前标签中间的文本
			 * 
			 * Attribute  attribute(String name)
			 * 获取当前标签中指定名字的属性
			 */
			Element root = doc.getRootElement();
			/*
			 * 该集合用来保存所有解析出来的员工信息
			 */
			List<Emp> empList = new ArrayList<Emp>();
			/*
			 * 获取<list>标签中的所有<emp>标签
			 */
			List<Element>  list = root.elements();
			/*
			 * 将每个<emp>标签中的内容取到，并以一个Emp实例保存
			 * 然后将该对象存入集合
			 */
			for (Element element : list) {
//				System.out.println(element.getName());
				//获取name
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




















