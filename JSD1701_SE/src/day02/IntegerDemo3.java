package day02;
/**
 * JDK1.5之后推出了一个新的特性
 * 自动拆装箱
 * 自动拆装箱特性是编译器认可，而非虚拟机。
 * @author dell
 *
 */
public class IntegerDemo3 {
	public static void main(String[] args) {
		/*
		 * 下面代码会触发编译器的自动装箱特性：
		 * 编译器会在编译后的class文件中添加代码，将
		 * 包装类转换为基本类型:
		 * int in = i.intValue();
		 */
		Integer i = 123;
		int in = i;
	}
}













