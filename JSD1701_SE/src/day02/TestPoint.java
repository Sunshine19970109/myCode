package day02;
/**
 * 	
 * @author dell
 *
 */
public class TestPoint {
public static void main(String[] args) {
	Point p = new Point();
	p.setX(1);
	p.setY(2);
	/*
	 * ��ʹ��һ�����toString����ʱ����Ӧ����д�÷�������Ϊ
	 * Object�ṩ��toString��ʽΪ:
	 * ����@��ַ
	 * ��ͨ���������˽⵱ǰ��ʵ����Ϣû�а�����
	 */
	String str= p.toString();
	System.out.println(str);
	Point p1 = new Point();
	p1.setX(1);
	p1.setY(2);
	System.out.println(p1);
	System.out.println(p==p1);
	/*
	 * ��������Ҫʹ��һ�����equals����ʱ����
	 * ��Ҫ��д�����������ΪObject�ṩ��equals
	 * �ڲ���ʹ��"=="�Ƚϵġ�
	 * equals��Ƶ�Ŀ���ǱȽ��������������Ƿ�һ����
	 */
	System.out.println(p.equals(p1));
}
	
}











