package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ת����
 * ʹ������Ĺ�����Arrays�ķ���asList
 * ��Ҫע�⣬ֻ��ת��ΪList
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
		 * �Լ��ϲ������Ƕ�ԭ����������������Բ������Ԫ��
		 */
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		/*
		 * ������ת�������ļ����ǲ��������Ԫ�ص�
		 * ������׳�����֧�ֵĲ����쳣
		 * ��Ϊ�Լ���Ԫ�ز������Ƕ���ԭ������������
		 * Ԫ�ػᵼ���������ݣ��Ӷ���ʾ����ԭ����
		 */
		List<String> l = new ArrayList<>(s1);
		System.out.println(l);
		l.add("six");
		System.out.println(l);
	}	
	
}
















