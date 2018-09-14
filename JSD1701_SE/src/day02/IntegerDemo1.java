package day02;
/**
 * 包装类
 * 8个基本类型由于不能直接参与面相对象开发(因为基本类型
 * 没有面相对象特性:封装，继承，多态)
 * 为此java为8个基本类型提供了包装类
 * 
 * 其中6个数字类型的包装类都继承自:java.lang.Number
 * Number是一个抽象类，提供了可供数字类型之间互相转换的相关方法
 * @author dell
 *
 */
public class IntegerDemo1 {
	public static void main(String[] args) {
		int a = 1;
		Integer i1 = Integer.valueOf(a);
		Integer i2 = Integer.valueOf(a);
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		int ii = i1.intValue();
		System.out.println(ii);
		System.out.println(i1);
	}
}















