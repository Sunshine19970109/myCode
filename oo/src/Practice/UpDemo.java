package Practice;

public class UpDemo {
public static void main(String[] args) {
	a a1 = new b(10);
	a1.show();//���಻�ܷ�������ķ���
	b b1 = new b();
	b1.s = "�����Ұ���";//������Է������и���ķ�������
	b1.see();
	
}
}
class a{
	String s;
	a(){
		System.out.println("����a����޲ι���");
	}
	a(int age){
		s = "����a��Ĵ��ι���";
		System.out.println(s);
	}
	void show(){
		System.out.println("����a���show����");
	}
}

class b extends a{
	int age;
	b(){
		
		System.out.println("����b����޲ι���");
	}
	b(int age){
		super(age);
		age = age;
		System.out.println("�ҵ�������"+age);
	}
	void see(){
		super.s="����һ���ý��";
		System.out.println(s);
		System.out.println("֪��Ϊʲô������Ⱥ��һ�ۿ�������ô");
		super.show();
	}
	
}