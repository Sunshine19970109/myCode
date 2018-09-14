package ooDay04;

public class StaticDemo {
	public static void main(String[] args) {
		Loo o1 = new Loo();
		o1.show();
		
		Loo o2 = new Loo();
		o2.show();
		System.out.println(Loo.b);
		//静态成员变量可以通过对象访问，不建议
		System.out.println(o2.b);
		Moo.test();
		Noo o3 = new Noo();
		Noo o4 = new Noo();
	}
}

class Noo{
	static{
		System.out.println("静态块");
	}
	Noo(){
		System.out.println("构造方法");
	}
}
class Moo{
	int a;//实例变量
	static int b;//静态变量
	void show(){//实例方法,有this
		System.out.println(this.a);
		System.out.println(b);
	}
	static void test(){//没有this
//		System.out.println(a);//编译错误
		System.out.println(Moo.b);
		System.out.println(b);
	}
}

class Loo{
	int a;//实例变量
	static int b;//静态变量
	Loo(){
		a++;
		b++;
	}
	
	void show() {
		// TODO Auto-generated method stub
		System.out.println(a);
		System.out.println(b);
	}
}