//package oo.day05;
////��һ��ͼ���е�������
//public class ShapeTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Shape[] shapes = new Shape[4];
//		shapes[0]= new Circle(1);
//		shapes[1]= new Circle(2);
//		shapes[2]= new Square(1);
//		shapes[3]= new Square(1);
//		MaxArea(shapes);
//	}
//	public static void MaxArea(Shape[] shapes){
//		double max = shapes[0].area();
//		int maxIndex = 0;
//		for (Shape shape : shapes) {
//			double area = shape.area();
//			if(area>max){
//				max =area;
//				maxIndex++;
//			}
//		}
//		System.out.println("������:"+max);
//		System.out.println("�±�:"+maxIndex);
//	}
//
//}
//abstract class Shape{
//	protected double c;//�ܳ�
//	public abstract double area();
//}
//class Square extends Shape{
//	public Square(double c) {
//		// TODO Auto-generated constructor stub
//		this.c = c;
//	}
//	@Override
//	public double area() {
//		// TODO Auto-generated method stub
//		return 0.0625*c*c;
//	}
//	
//}
//class Circle extends Shape{
//	 public Circle(double c) {
//		// TODO Auto-generated constructor stub
//		 this.c =c;
//	}
//	@Override
//	public double area() {
//		// TODO Auto-generated method stub
//		return 0.0796*c*c;
//	}
//	
//}