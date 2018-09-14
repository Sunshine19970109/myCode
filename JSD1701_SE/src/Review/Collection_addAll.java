package Review;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合操作
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
		 * 将给定集合中的所有元素添加到当前集合中
		 * 添加后当前集合元素发生改变返回true
		 */
		c1.addAll(c2);
		System.out.println(c1);
		
		Collection<String> c3 = new ArrayList<>();
		c3.add(".net");
		c3.add("android");
		boolean containsAll = c2.containsAll(c3);
		System.out.println("全包含:"+containsAll);
		/*
		 * 删除当前集合中与指定集合公共的元素
		 */
		boolean a = c2.removeAll(c3);
		System.out.println(a);
	}
}

















