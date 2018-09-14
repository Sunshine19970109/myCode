package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  *Vector��HashTable��ͬ���ģ���ȫ��
 *ArrayList��HashMap�ǲ�ͬ���ģ��ǲ���ȫ��
 *
 *��ȡ�̰߳�ȫ�ļ��Ϸ�ʽ
 *Collects���������ת��
 * @author dell
 *
 */
public class SyncAPI {
	public static void main(String[] args) {
		/*
		 * ����ArrayList���ϣ�����Collections
		 * �����෵��һ���̰߳�ȫ��List����
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
		 * ��������set���ϣ�ת�����̰߳�ȫ�ļ���
		 */
		Set<String> s = new HashSet<>(l);
		System.out.println(s);
		s = Collections.synchronizedSet(s);
		System.out.println(s);
		//map
		Map<String, Integer> m = new HashMap<>();
		m.put("����", 90	);
		m.put("��ѧ", 100);
		m.put("����", 120);
		System.out.println(m);
		m =  Collections.synchronizedMap(m);
		System.out.println(m);
		/*
		 * ���������̰߳�ȫ��
		 * ��ʹ���̰߳�ȫ�ļ��ϣ����õ�����������ʱ��
		 * �����ϵҲ�ǲ����������Ӧ������ά�������ϵ
		 * �����ڲ�ѯ���ϳ��ȵ�ʱ�������Ԫ�ء�
		 */
	}
}
























