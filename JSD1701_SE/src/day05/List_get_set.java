package day05;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ʵ����:
 * java.util.ArrayList:����ʵ�֣���ѯ����
 * java.util.LinkedList:����ʵ�֣���ɾ���죬����������β��ɾ��
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
		 * ��ȡָ���±괦��Ԫ��
		 */
		String string = list.get(1);
		System.out.println(string);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		/*
		 * E set(int index,E e)
		 * ��ָ����Ԫ�����õ�ָ����λ���ϣ�����ֵ
		 * Ϊԭλ���ϵ�Ԫ�أ�����set����Ҳ���滻
		 * Ԫ�ز���
		 */
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println(old);
	}
}















