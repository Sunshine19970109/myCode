package day12;

import java.io.FileInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用XPATH解析XML文档数据
 * @author TeduJAVA
 *
 */
/*
 * 三天写一个项目:
 * 	至少每天写两个部分，每个人都一样，刚开始都没有思路
 * 思路都是写的多了才会有思路，你可能会有很多地方忘记了
 * 正常，都是翻笔记，新功能没见过没做过怎么办，先写个测试，
 * 不断更新迭代
 * 
 * 思路就是过往的经验
 * 反复敲不是指机械的敲代码--不是抄代码
 */
public class XpathDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 创建 SAXReader reader
			 * 2 创建doc
			 */
			SAXReader reader = new SAXReader();
			Document doc = reader.read(
					new FileInputStream("myemp.xml"));
			String xpath = "/list/emp[salary>3000 and gender='男']/name";
			
			List<Element> list = doc.selectNodes(xpath);
			for (Element element : list) {
				System.out.println(element.getText());
			}
		} catch (Exception e) {
			
		}
	}
}
