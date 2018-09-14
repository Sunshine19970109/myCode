package oo.day05;
//½Ó¿ÚÑÝÊ¾
public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inter8 o1 = new Zoo();
		Inter7 o2 = new Zoo();
	}

}

interface Inter7{
	void show();
}
interface Inter8 extends Inter7{
	void say();
}
class Zoo implements Inter8{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		
	}
	
} 

interface Inter3{
	void show();
}
interface Inter4{
	void test();
}
abstract class Koo{
	abstract void show();
} 
class Loo extends Koo implements Inter3,Inter4{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
}
interface Inter5{
	void show();
	void say();
}
class Woo implements Inter5{
	public void show(){}
	public void say(){};
}
interface Inter6{
	public static final int NUM = 5;
	public abstract void show();
	int COUNT = 6;
	void test();
//	int NUMBER;
//	void say(){}
}
