package oo.day05;

public class FinalDemo {
	public static void main(String[] args) {
		
	}
}
/*
 * final���γ�Ա������ֻ�����ֳ�ʼ����ʽ:
 * 		1.����ͬʱ��ʼ��
 * 		2.�ڹ��췽���г�ʼ��(�ж�����õ�ʱ��ֵ�ǲ��ܱ��)
 * final���ξֲ�������ֻҪ��֮ǰ��ʼ������
 * */
//��ʾfinal���α���
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

//��ʾfinal������
final class Doo{
	
}
//class Eoo extends Doo{
//	
//}
class Foo{}
final class Goo extends Foo{}



