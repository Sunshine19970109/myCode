package oo.day06;
//�����ڲ�����ʾ
public class NstInnerClassDemo {

	public static void main(String[] args) {
		// ������Inter2��һ�����࣬��û������
		// Ϊ�����ഴ����һ�������o1
		Inter2 o1 = new Inter2() {
		};
		final int num = 5;
		Inter3 o3 = new Inter3() {
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("show");
				System.out.println(num);
			}
		};
		o3.show();
	}

}
interface Inter2{
	
}
interface Inter3{
	void show();
}

 









