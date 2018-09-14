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
 * 写出XML文档
 * @author TeduJAVA
 *
 */
public class WriteXMLDemo {
	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp(1, "张三", 34, "男", 3000));
		empList.add(new Emp(2, "李四", 21, "女", 4000));
		empList.add(new Emp(3, "王五", 46, "女", 6500));
		empList.add(new Emp(4, "赵六	", 28, "男", 4400));
		empList.add(new Emp(5, "钱七", 53, "男", 12000));
		
		/*
		 * 写出XML文档的大致步骤:
		 * 1: 创建空白文档对象Document
		 * 2：向该文档对象中添加根元素
		 * 3:按照预定的XML文档结构从根元素开始，逐级添加
		 * 子元素，已完成该结构
		 * 4:创建XMLWriter
		 * 5:将Document对象写出成XML文档
		 * 6:将XMLWriter关闭
		 */
		//创建Document对象
		Document doc =DocumentHelper.createDocument();
		//添加标签
		/*
		 * Element addElement(String name)
		 * Document提供该方法是用来向当前文档中
		 * 添加给定名字的根元素，并将其以一个Element
		 * 实例返回以便继续对该元素进行操作。
		 * 需要注意，该方法只能调用一次，因为一个文档
		 * 中只能有一个根元素
		 */
		Element root = doc.addElement("list");
		//将所有员工信息添加自己的若干<Emp>标签添加到<list>当中
		for (Emp emp : empList) {
			/*
			 * Element提供了向其中添加子标签的方法:
			 * Element addElement(String name)
			 */
			Element empEle = root.addElement("emp");
			empEle.addAttribute("id", emp.getId()+"");
			//添加<name>标签
			Element nameEle = empEle.addElement("name");
			nameEle.addText(emp.getName());
			//添加<age>
			empEle.addElement("age").addText(emp.getAge()+"");
			empEle.addElement("gender").addText(emp.getGender());
			empEle.addElement("salary").addText(emp.getSalary()+"");
		}
		
		try {
			
			FileOutputStream fos  =new FileOutputStream("myemp.xml");
			XMLWriter writer = new XMLWriter(fos,OutputFormat.createPrettyPrint());
			
			writer.write(doc);
			System.out.println("写出完毕");
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}























