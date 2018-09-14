package day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * �����ṩ��ͳһ�ı�������Ԫ�صķ���:
 * Iteartor iterator()
 * ����һ�����Ա�����ǰ���ϵĵ�����ʵ����
 * java.util.Iterator
 * ��һ���ӿڣ��涨�����е�����ʵ����������ϵ�
 * ͨ�÷���
 * ��ͬ�ļ��϶��ṩ��һ��ʵ���࣬�����ס��Щʵ����
 * �����֣�ֻ��Ҫ�����ǵ���Iterator�������ɣ�
 * ������Ӧ�ķ�����ȡ����Ԫ�ء�
 * ʹ�õ���������������ѭ:�ʣ�ȡ��ɾ  ����ɾ������
 * �������
 * @author dell
 *
 */
public class Collection_iterator {
	public static void main(String[] args) {
		/*
		 * Ϊʲô���������removeɾ������Ԫ��
		 */
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("three");
		System.out.println(c.toString());
		Iterator<String> it = c.iterator();
		/*
		 * boolean hasNext()
		 * �������ĸ÷��������ж�������ļ����Ƿ���
		 * Ԫ�ص���һ������ȡ��
		 */
		while (it.hasNext()) {
			/*
			 * E next()
			 * ͨ����������ȡ���ϵ���һ��Ԫ��
			 */
			String s = (String)it.next();
			
			if ("#".equals(s)) {
				/*
				 * ��ʹ�õ������������ϵĹ�������
				 * ����ͨ�����ϵķ�����ɾԪ�صġ�����
				 * ���������׳��쳣
				 * c.remove();
				 */
				it.remove();
				/*
				 * �����������ṩ��һ����ɾ������Ԫ��
				 * �ķ���remove,�÷�������Ҫ���������
				 * ɾ������ʹ�õ�������ȡ����Ԫ��
				 */
			}
				
		}
		
		System.out.println(c);
	}
}















