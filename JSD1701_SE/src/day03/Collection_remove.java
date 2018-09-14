package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 删除集合元素
 * @author dell
 *
 */
public class Collection_remove {
	public static void main(String[] args) {
		Collection c = new ArrayList<>();
		c.add(new Point(1, 2));
		c.add(new Point(3, 4));
		c.add(new Point(5, 6));
		c.add(new Point(1, 2));
		System.out.println(c);
		Point p = new Point(1, 2);
		/*
		 * boolean remove(E e)
		 * 从集合中删除与指定元素equals比较为true的
		 * 元素。需要注意，只会删除一个。集合会顺序进行比较，
		 * 删除第一个equals比较为true的元素后即停止删除。
		 */
		c.remove(p);
		System.out.println(c);
	}
}



















