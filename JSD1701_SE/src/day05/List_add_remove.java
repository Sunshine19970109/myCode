package day05;

import java.util.ArrayList;
import java.util.List;

/**
 * List������һ��add,remove����
 * ֧��ʹ���±�
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
		 * ��ָ��λ�ò���ָ��Ԫ��
		 */
		l.add(1, "2");
		System.out.println(l);
		String s = l.remove(2);
		System.out.println(s);
		System.out.println(l);
	}
}
