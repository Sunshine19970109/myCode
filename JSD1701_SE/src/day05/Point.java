package day05;
/**
 * ���ͣ��ֳ�Ϊ����������
 * JDK1.5֮���Ƴ���һ��������
 * ���Ϳ��Ա�ʾ���Ե����ͣ���������������һ����������
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


















