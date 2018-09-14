package day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合提供了统一的遍历集合元素的方法:
 * Iteartor iterator()
 * 返回一个可以遍历当前集合的迭代器实现类
 * java.util.Iterator
 * 是一个接口，规定了所有迭代器实现类遍历集合的
 * 通用方法
 * 不同的集合都提供了一个实现类，无需记住那些实现类
 * 的名字，只需要将他们当做Iterator看待即可，
 * 调用相应的方法获取集合元素。
 * 使用迭代器遍历集合遵循:问，取，删  其中删除不是
 * 必须操作
 * @author dell
 *
 */
public class Collection_iterator {
	public static void main(String[] args) {
		/*
		 * 为什么迭代器里的remove删除不了元素
		 */
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("three");
		System.out.println(c.toString());
		Iterator<String> it = c.iterator();
		/*
		 * boolean hasNext()
		 * 迭代器的该方法用来判断其遍历的集合是否还有
		 * 元素的下一个可以取出
		 */
		while (it.hasNext()) {
			/*
			 * E next()
			 * 通过迭代器获取集合的下一个元素
			 */
			String s = (String)it.next();
			
			if ("#".equals(s)) {
				/*
				 * 在使用迭代器遍历集合的过程中是
				 * 不能通过集合的方法增删元素的。否则
				 * 迭代器会抛出异常
				 * c.remove();
				 */
				it.remove();
				/*
				 * 迭代器自身提供了一个供删除集合元素
				 * 的方法remove,该方法不需要传入参数，
				 * 删除的是使用迭代器刚取出的元素
				 */
			}
				
		}
		
		System.out.println(c);
	}
}















