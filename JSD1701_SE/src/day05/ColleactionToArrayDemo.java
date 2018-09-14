package day05;

import java.util.ArrayList;
import java.util.Collection;

public class ColleactionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		System.out.println(c);
		
		Object[] o = c.toArray();
		System.out.println(o);
		for (Object object : o) {
			System.out.println(object);
		}
		String[] s =c.toArray(new String[c.size()]);
		for (String string : s) {
			System.out.println(string);
		}
	}
}















