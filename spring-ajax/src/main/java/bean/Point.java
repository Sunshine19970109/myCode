package bean;

import java.io.Serializable;

public class Point implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private Double x;
	private Double y;
	@Override
	public String toString() {
		return "Point [name=" + name + ", x=" + x + ", y=" + y + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Point() {
	}
	public Point(String name, Double x, Double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
}
