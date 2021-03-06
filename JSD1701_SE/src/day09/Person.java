package day09;
/**
 * 使用这个类来测试throw,throws的作用
 * @author dell
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	/*
	 * 1.抛出创建的年龄不合法异常
	 * throw关键字用于抛出异常:
	 * 通常两种情况会抛出异常: 
	 * 1:当满足语法要求，但是不满足实际业务逻辑时，可以
	 * 当成一个异常抛出去
	 * 2:在当前方法中出现了一个实际的异常，但是不应当在
	 * 当前方法中处理该异常时，可以将其抛出
	 */
	/*
	 * 1.只有runtimeException 及其子类可以不用
	 * 在方法名的后面throws 抛出异常，其他的异常都是
	 * 必须抛出的
	 */
	public void setAge(int age) throws IllegalAgeException {
		if (age<0||age>100) {
			throw new IllegalAgeException("年龄不合法");
		}
		this.age = age;
	}
	
}






















