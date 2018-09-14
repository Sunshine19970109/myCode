package day05;

import java.util.ArrayList;
import java.util.List;

/**
 * 常用实现类:
 * java.util.ArrayList:数组实现，查询更快
 * java.util.LinkedList:链表实现，增删更快，尤其是在首尾增删快
 * @author dell
 *
 */
public class List_get_set {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		System.out.println(list);
		/*
		 * E get(int index)
		 * 获取指定下标处的元素
		 */
		String string = list.get(1);
		System.out.println(string);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		/*
		 * E set(int index,E e)
		 * 将指定的元素设置到指定的位置上，返回值
		 * 为原位置上的元素，所以set方法也是替换
		 * 元素操作
		 */
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println(old);
	}
}















