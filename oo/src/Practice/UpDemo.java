package Practice;

public class UpDemo {
public static void main(String[] args) {
	a a1 = new b(10);
	a1.show();//父类不能访问子类的方法
	b b1 = new b();
	b1.s = "妈妈我爱你";//子类可以访问所有父类的方法属性
	b1.see();
	
}
}
class a{
	String s;
	a(){
		System.out.println("我是a类的无参构造");
	}
	a(int age){
		s = "我是a类的带参构造";
		System.out.println(s);
	}
	void show(){
		System.out.println("我是a类的show方法");
	}
}

class b extends a{
	int age;
	b(){
		
		System.out.println("我是b类的无参构造");
	}
	b(int age){
		super(age);
		age = age;
		System.out.println("我的年龄是"+age);
	}
	void see(){
		super.s="我有一个好姐姐";
		System.out.println(s);
		System.out.println("知道为什么我在人群中一眼看到了你么");
		super.show();
	}
	
}