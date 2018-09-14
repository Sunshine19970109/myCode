package day02;
/**
 * 使用Point来测试作为Object子类时重写Object
 * 相关方法的准则
 * @author dell
 *
 */
public class Point {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "X="+this.x+",Y="+this.y;
	}
	/**
	 * 重写Object提供的equals方法
	 * 原则:按照实际设计需求而定，比较所有要求比较的
	 * 属性，但不是必须所有属性值都一样才算作true
	 */
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj==null) {
			return false;
		}
		if (obj==this) {
			return true;
		}
		if (obj instanceof Point) {
			Point p = (Point)obj;
			return this.x==p.x&&this.y==p.y;
		}
		return false;
	}
}
















