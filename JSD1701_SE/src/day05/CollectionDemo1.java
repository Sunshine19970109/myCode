package day05;
/**
 * 
 * @author dell
 *
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
//		c.add(123);//±àÒë²»Í¨¹ý
		System.out.println(c);
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.println(string);
		}
		for(String s:c){
			System.out.println(s);
		}
	}
}












