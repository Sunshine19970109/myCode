package day01;
/**
 * 1设计这个类的目的是什么
 * 2为什么设计这个类
 * 当前类是用来测试文档注释使用的
 * 
 * 文档注释只在三个地方定义:
 * 类，常量，方法(静态方法、成员方法、构造方法)
 * @author SunShine
 * @version 1.0
 * @see	java.lang.String
 * @since	JDK1.0
 *
 */
public class APIDocDemo {
	/**
	 * sayHello 中的问候语
	 */
	public static final String INFO = "你好！";
	/**
	 * 为给定用户添加一个问候语
	 * @param name 给定的用户的名字
	 * @return	含有问候语的字符串
	 */
	public static String sayHello(String name){
		return INFO+name;
	}
}












