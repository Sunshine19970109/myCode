package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  *Vector和HashTable是同步的，安全的
 *ArrayList和HashMap是不同步的，是不安全的
 *
 *获取线程安全的集合方式
 *Collects工具类可以转换
 * @author dell
 *
 */
public class SyncAPI {
	public static void main(String[] args) {
		/*
		 * 创建ArrayList集合，并用Collections
		 * 工具类返回一个线程安全的List集合
		 */
		List<String> l = new ArrayList<>();
		l.add("one");
		l.add("two");
		l.add("three");
		l.add("four");
		System.out.println(l);
		l = Collections.synchronizedList(l);
		System.out.println(l);
		
		/*
		 * 将给定的set集合，转换成线程安全的集合
		 */
		Set<String> s = new HashSet<>(l);
		System.out.println(s);
		s = Collections.synchronizedSet(s);
		System.out.println(s);
		//map
		Map<String, Integer> m = new HashMap<>();
		m.put("语文", 90	);
		m.put("数学", 100);
		m.put("听雨", 120);
		System.out.println(m);
		m =  Collections.synchronizedMap(m);
		System.out.println(m);
		/*
		 * 迭代器是线程安全的
		 * 即使是线程安全的集合，在用迭代器遍历的时候，
		 * 互斥关系也是不互斥的所以应该自行维护互斥关系
		 * 比如在查询集合长度的时候被添加了元素。
		 */
	}
}
























