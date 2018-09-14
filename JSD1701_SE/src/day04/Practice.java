package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Practice {
/*
 * contains�жϼ��������Ƿ�������ж�֮ǰ��equals�ж��Ƿ���ͬ������ͬ�Ű���
 */
	public static void main(String[] args) {
//		testSizeAndClearAndIsEmpty();
//		testAddAllAndContainsAll();
		testSubList();
		List<String> l = new ArrayList<>();
		 String[] s = new String[]{};
		 Arrays.asList(s);
		 l.toArray(s);
	}
	public static void testSizeAndClearAndIsEmpty() {
        Collection<String> c = new ArrayList<String>();
        System.out.println("isEmpty:"+c.isEmpty()); 
        c.add("terry");
        c.add("allen");
        c.add("jerry");
        c.add("smith");
        System.out.println("isEmpty:" + c.isEmpty() + ",size: " + c.size());
        c.clear();
        System.out.println("isEmpty:" + c.isEmpty() + ", size: " + c.size());
    }
	 public static void testAddAllAndContainsAll() {
	        Collection<String> c1 = new ArrayList<String>();
	        c1.add("terry");
	        c1.add("allen");
	        System.out.println(c1);
	        Collection<String> c2 = new HashSet<String>();
	        c2.addAll(c1);
	        System.out.println(c2); 
	        Collection<String> c3 = new ArrayList<String>();
	        c3.add("terry");
	        System.out.println(c1.containsAll(c3));
	    }
	 /*
	  * ����ArrayList��LinkedList�Ĳ�ͬ
	  * ArrayList�ײ������飬��ѯ����ɾ��
	  * LinkedList�ײ���������ѯ����ɾ��
	  */
	 public static void testSubList() {
	        List<Integer> list = new ArrayList<Integer>();
	        for (int i = 0; i < 10; i++) {
	            list.add(i);
	        }
	        List<Integer> subList = list.subList(2, 5);
	        for (int i = 0; i < subList.size(); i++) {
	            subList.set(i, subList.get(i) * 10);
	        }
	        System.out.println(subList); 
	        System.out.println(list);
	    }
	 /*
	  * ����List������ֱ���໥ת���ķ���
	  */
	 
	 
}
