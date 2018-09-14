package day05;
/**
 * 泛型是编译器认可，泛型的原型就是Object
 * 只是编译器会做一些工作:
 * 1:当对泛型传入实参时，编译器会检查该值是否满足泛型
 * 	指定的类型。不满足则编译不通过
 * 2:当获取泛型的值时，编译器就会自动做造型操作
 * @author dell
 *
 */
public class TestPoint2 {
	public static void main(String[] args) {
		/*
		 * 编译器会检查实参是否满足泛型要求
		 * 这里只能转入整数
		 */
		Point<Integer> p1 = new Point<Integer>(1, 2);
		p1.setX(2);
		/*
		 * 编译器在编译时会修改代码做转换
		 * int x = ((Integer)p1.getX()).intValue();
		 */
		int x1 = p1.getX();
		System.out.println(x1);
		Point p2 = p1;
		p2.setX("二");
		System.out.println(p2);
		System.out.println(p1);
	}
}



















