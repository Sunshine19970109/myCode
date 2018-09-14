package oo.day06;

public class MultiTypeDemo {
	public static void main(String[] args) {
		Aooo o1 = new Boo();
		Boo o2 = (Boo)o1;
		Inter1 o3 = (Inter1)o1;
//		Coo o4 = (Coo)o1;ClassCastException
		if (o2 instanceof Boo) {
			Coo o5 = (Coo)o1;
			System.out.println("over");
		}
		System.out.println("over");
	}
}
interface Inter1{
	
}
class Aooo{
	
}
class Boo extends Aooo implements Inter1{
	
}
class Coo extends Aooo{
	
}