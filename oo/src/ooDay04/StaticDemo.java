package ooDay04;

public class StaticDemo {
	public static void main(String[] args) {
		Loo o1 = new Loo();
		o1.show();
		
		Loo o2 = new Loo();
		o2.show();
		System.out.println(Loo.b);
		//��̬��Ա��������ͨ��������ʣ�������
		System.out.println(o2.b);
		Moo.test();
		Noo o3 = new Noo();
		Noo o4 = new Noo();
	}
}

class Noo{
	static{
		System.out.println("��̬��");
	}
	Noo(){
		System.out.println("���췽��");
	}
}
class Moo{
	int a;//ʵ������
	static int b;//��̬����
	void show(){//ʵ������,��this
		System.out.println(this.a);
		System.out.println(b);
	}
	static void test(){//û��this
//		System.out.println(a);//�������
		System.out.println(Moo.b);
		System.out.println(b);
	}
}

class Loo{
	int a;//ʵ������
	static int b;//��̬����
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