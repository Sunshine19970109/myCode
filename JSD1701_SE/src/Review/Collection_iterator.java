package Review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合提供了统一的遍历集合元素的方法:
 * Iteartor iterator()
 * 返回一个可以遍历当前集合的迭代器类
 * 
 * @author dell
 *
 */
public class Collection_iterator {
	public static void main(String[] args) {
		/*
		 * 为什么迭代器里的remove删除不了元素
		 */
		Collection<String> c = new ArrayList<>();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("three");
		System.out.println(c.toString());
		Iterator<String> it =c.iterator();
		/*
		 * boolean hasNext()
		 * 迭代器的该方法用来判断其遍历的集合是否还有
		 * 元素的下一个可以取出
		 */
		while (it.hasNext()) {
			String string = (String) it.next();
			if ("#".equals(string)) {
				it.remove();
			}
		}
		System.out.println(c.toString());
	}
}

















