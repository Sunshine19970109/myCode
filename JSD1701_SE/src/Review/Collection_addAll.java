package Review;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���ϲ���
 * @author dell
 *
 */
public class Collection_addAll {
	public static void main(String[] args) {
		Collection<String> c1 = new ArrayList<>();
		c1.add("java");
		c1.add("c");
		c1.add(".net");
		
		Collection<String> c2 = new ArrayList<>();
		c2.add("php");
		c2.add("android");
		c2.add("oc");
		c2.add("java");
		/*
		 * boolean addAll(Collection c)
		 * �����������е�����Ԫ����ӵ���ǰ������
		 * ��Ӻ�ǰ����Ԫ�ط����ı䷵��true
		 */
		c1.addAll(c2);
		System.out.println(c1);
		
		Collection<String> c3 = new ArrayList<>();
		c3.add(".net");
		c3.add("android");
		boolean containsAll = c2.containsAll(c3);
		System.out.println("ȫ����:"+containsAll);
		/*
		 * ɾ����ǰ��������ָ�����Ϲ�����Ԫ��
		 */
		boolean a = c2.removeAll(c3);
		System.out.println(a);
	}
}

















