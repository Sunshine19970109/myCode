package oo.day05;

public class ShapeTest1 {
public static void main(String[] args) {
	Shape[] shapes = new Shape[6];
	shapes[0] = new Square(1);
	shapes[1] = new Square(2);
	shapes[2] = new Circle(1);
	shapes[3] = new Circle(2);
	shapes[4] = new six(1);
	shapes[5] = new six(2);
	MaxArea(shapes);
	
}
	//比面积大小方法
	public static void MaxArea(Shape[] shapes){
		int i = 0;
		double max = shapes[0].area();
		for (Shape shape : shapes) {
			i++;
			if (shape.area()>max) {
				max = shape.area();
			}
		}
		System.out.println("第"+i+"个图形面积最大，最大面积是:"+max);
	}

}
abstract class Shape{
	int c;
	abstract double area() ;
}
class six extends Shape{
	public six(int perimeter) {
		// TODO Auto-generated constructor stub
		this.c = perimeter;
	}
	@Override
	double area() {
		// TODO Auto-generated method stub
		return 0.0721 * c * c;
	}
	
}
class Square extends Shape{
	public Square(int perimeter) {
		// TODO Auto-generated constructor stub
		this.c = perimeter;
	}
	@Override
	public  double area() {
		// TODO Auto-generated method stub
		
		return 0.0625*c*c;
	}
	
}
class Circle extends Shape{
	public Circle(int perimeter) {
		// TODO Auto-generated constructor stub
		this.c = perimeter;
	}
	@Override
	public double area( ) {
		// TODO Auto-generated method stub
		
		return 0.0796*c*c;
	}
	
}