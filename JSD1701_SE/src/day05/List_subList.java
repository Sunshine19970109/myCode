package day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List subList(int start ,int end)
 * 取子集
 * @author dell
 *
 */
public class List_subList {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l.add(i);
		}
		System.out.println(l);
		List<Integer> sub =l.subList(3, 8);
		System.out.println(sub);
		/*
		 * 将子集中每个元素扩大10倍
		 */
//		int index = 0;
//		Iterator<Integer> it = sub.iterator();
//		while (it.hasNext()) {
//			Integer integer = (Integer) it.next();
//			integer *=10;
//			sub.set(index, integer);
//		}
//		System.out.println(sub);
		for (int i = 0; i < sub.size(); i++) {
			int a = sub.get(i)*10;
			sub.set(i, a);
		}
		System.out.println(sub);
		/*
		 * 对子集的修改就是对源集合的修改
		 */
		System.out.println(l);
		/*
		 * 将集合中2-8的元素删除
		 */
		l.subList(2, 8).clear();
		System.out.println(l);
	}
}












