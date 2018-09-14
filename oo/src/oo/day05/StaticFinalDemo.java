package oo.day05;

public class StaticFinalDemo {
	public static void main(String[] args) {
		System.out.println(Hoo.PI);
		System.out.println(Ioo.count);
		
		System.out.println(Ioo.NUM);
	}
}

class Ioo{
	public static final int NUM=5;
	public static int count = 6;
}

class Hoo{
	public static final double PI =3.1415926;
//	public static final double P ;
}


















