package day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List subList(int start ,int end)
 * ȡ�Ӽ�
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
		 * ���Ӽ���ÿ��Ԫ������10��
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
		 * ���Ӽ����޸ľ��Ƕ�Դ���ϵ��޸�
		 */
		System.out.println(l);
		/*
		 * ��������2-8��Ԫ��ɾ��
		 */
		l.subList(2, 8).clear();
		System.out.println(l);
	}
}












