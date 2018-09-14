package oo.day05;

public class FinalDemo {
	public static void main(String[] args) {
		
	}
}
/*
 * final修饰成员变量，只有两种初始化方式:
 * 		1.声明同时初始化
 * 		2.在构造方法中初始化(有对象的用的时候，值是不能变的)
 * final修饰局部变量，只要用之前初始化即可
 * */
//演示final修饰变量
class Aoo{
	final int num = 5;
	final int count;
	Aoo(){
		count = 6;
	}
	void show(){
		final int n;
//		System.out.println(n);
//		num = 55;
	}
	
}

class Boo{
	final void show(){}
	void test(){}
}
class Coo extends Boo{
//	void show(){}
	void test(){}
}

//演示final修饰类
final class Doo{
	
}
//class Eoo extends Doo{
//	
//}
class Foo{}
final class Goo extends Foo{}



