package ioc;

public class A {
	private IB ib;
	
	public void setIb(IB ib) {
		System.out.println("setIB()");
		this.ib = ib;
	}
	public A() {
		System.out.println("A()");
	}
	public void execute(){
		System.out.println("execute()");
		//调用B的f1()方法
		ib.f1();
	}
}
