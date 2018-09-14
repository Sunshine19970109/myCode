package day05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Comparator {
	public static void main(String[] args) {
		Collection<Emp> c = new ArrayList<>();
		c.add(new Emp("Terry", 25, 'm', 6000));
		c.add(new Emp("Allen", 21, 'f', 4000));
		c.add(new Emp("Smith", 23, 'm', 3000));
		System.out.println(c);
		Collections.sort((List<Emp>) c);
		System.out.println(c);
		
	}
}















