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
		System.out.println("���๹�췽��");
	}
}
class Boo extends Aoo{
	Boo(){
		super();//Ĭ�ϵ�----������ڵ�һ�У����и�������������
		System.out.println("���๹�췽��");
	}
}
