package day05;

import java.util.ArrayList;
import java.util.List;

/**
 * List重载了一对add,remove方法
 * 支持使用下标
 * @author dell
 *
 */
public class List_add_remove {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("one");
		l.add("two");
		l.add("three");
		l.add("four");
		l.add("five");
		System.out.println(l);
		/*
		 * void add(int index,E e)
		 * 向指定位置插入指定元素
		 */
		l.add(1, "2");
		System.out.println(l);
		String s = l.remove(2);
		System.out.println(s);
		System.out.println(l);
	}
}
