package day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * ���ϲ���
 * @author dell
 *
 */
public class Collection_addAll {
	public static void main(String[] args) {
		Collection c1 = new ArrayList<>();
		c1.add("java");
		c1.add("c");
		c1.add(".net");
		
		Collection c2 = new ArrayList<>();
		c2.add("php");
		c2.add("android");
		c2.add("oc");//Objective C
		c2.add("java");
		/*
		 * boolean addAll(Collection c)
		 * �����������е�����Ԫ����ӵ���ǰ������
		 * ��Ӻ�ǰ����Ԫ�ط����ı䷵��true.
		 */
		c1.addAll(c2);
		System.out.println(c1);
		
		Collection c3 = new ArrayList();
		c3.add(".net");
		c3.add("android");
		/*
		 * boolean containAll(Collection c)
		 * �жϵ�ǰ�����Ƿ�������������е�����Ԫ��
		 */
		boolean containsAll = c2.containsAll(c3);
		System.out.println("ȫ����:"+containsAll);
		/*
		 * ɾ����ǰ��������ָ�����Ϲ��е�Ԫ��
		 */
		boolean a =c2.removeAll(c3);
		System.out.println(a);
	}
}

















