package ooDay03;

public class Test {
	public static void main(String[] args) {
		Boo b = new Boo();
	}
}

class Coo{
	Coo(int a){
		
	}
}

class Doo extends Coo{
	Doo(int a){
		super(a);
	}
}

class Aoo{
	Aoo(){
		System.out.println("父类构造方法");
	}
}
class Boo extends Aoo{
	Boo(){
		super();//默认的----必须放在第一行，现有父类对象才有子类
		System.out.println("子类构造方法");
	}
}
