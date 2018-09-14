package oo.day06;
//匿名内部类演示
public class NstInnerClassDemo {

	public static void main(String[] args) {
		// 创建了Inter2的一个子类，但没有名字
		// 为该子类创建了一个对象叫o1
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

 









