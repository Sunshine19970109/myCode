package Review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * �����ṩ��ͳһ�ı�������Ԫ�صķ���:
 * Iteartor iterator()
 * ����һ�����Ա�����ǰ���ϵĵ�������
 * 
 * @author dell
 *
 */
public class Collection_iterator {
	public static void main(String[] args) {
		/*
		 * Ϊʲô���������removeɾ������Ԫ��
		 */
		Collection<String> c = new ArrayList<>();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("three");
		System.out.println(c.toString());
		Iterator<String> it =c.iterator();
		/*
		 * boolean hasNext()
		 * �������ĸ÷��������ж�������ļ����Ƿ���
		 * Ԫ�ص���һ������ȡ��
		 */
		while (it.hasNext()) {
			String string = (String) it.next();
			if ("#".equals(string)) {
				it.remove();
			}
		}
		System.out.println(c.toString());
	}
}

















