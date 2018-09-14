package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转集合
 * 使用数组的工具类Arrays的方法asList
 * 需要注意，只能转换为List
 * @author dell
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] s = {"one","two","three","four","five"};
		List<String> s1 =Arrays.asList(s);
		System.out.println(s1.size());
		System.out.println(s1);
		s1.set(1, "2");
		System.out.println(s1);
		/*
		 * 对集合操作就是对原来的数组操作，所以不能添加元素
		 */
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		/*
		 * 从数组转换过来的集合是不能添加新元素的
		 * 否则会抛出不受支持的操作异常
		 * 因为对集合元素操作就是对于原数组操作，添加
		 * 元素会导致数组扩容，从而表示不了原数组
		 */
		List<String> l = new ArrayList<>(s1);
		System.out.println(l);
		l.add("six");
		System.out.println(l);
	}	
	
}
















