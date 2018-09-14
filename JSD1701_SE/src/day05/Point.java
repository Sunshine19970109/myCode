package day05;
/**
 * 泛型，又称为参数化类型
 * JDK1.5之后推出的一个新特性
 * 泛型可以表示属性的类型，方法参数的类型一级返回类型
 * @author dell
 *
 */
public class Point<T> {
	private T x;
	private T y;
	public Point(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+x+","+y+")";
	}
}


















