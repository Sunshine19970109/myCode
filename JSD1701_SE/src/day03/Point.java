package day03;

public class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+x+","+y+")";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}if(obj==this){
			return true;
		}else if(obj instanceof Point){
			Point p = (Point)obj;
			return p.x==this.x&&p.y==this.y;
		}else{
			return false;
		}
		
	}
}











