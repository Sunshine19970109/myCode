package day02;
/**
 * 	
 * @author dell
 *
 */
public class TestPoint {
public static void main(String[] args) {
	Point p = new Point();
	p.setX(1);
	p.setY(2);
	/*
	 * 当使用一个类的toString方法时，就应当重写该方法，因为
	 * Object提供的toString格式为:
	 * 类名@地址
	 * 这通常对我们了解当前类实例信息没有帮助。
	 */
	String str= p.toString();
	System.out.println(str);
	Point p1 = new Point();
	p1.setX(1);
	p1.setY(2);
	System.out.println(p1);
	System.out.println(p==p1);
	/*
	 * 当我们需要使用一个类的equals方法时，就
	 * 需要重写这个方法，因为Object提供的equals
	 * 内部是使用"=="比较的。
	 * equals设计的目的是比较两个对象内容是否一样。
	 */
	System.out.println(p.equals(p1));
}
	
}











