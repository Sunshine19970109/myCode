package day05;
/**
 * �����Ǳ������Ͽɣ����͵�ԭ�;���Object
 * ֻ�Ǳ���������һЩ����:
 * 1:���Է��ʹ���ʵ��ʱ�������������ֵ�Ƿ����㷺��
 * 	ָ�������͡�����������벻ͨ��
 * 2:����ȡ���͵�ֵʱ���������ͻ��Զ������Ͳ���
 * @author dell
 *
 */
public class TestPoint2 {
	public static void main(String[] args) {
		/*
		 * ����������ʵ���Ƿ����㷺��Ҫ��
		 * ����ֻ��ת������
		 */
		Point<Integer> p1 = new Point<Integer>(1, 2);
		p1.setX(2);
		/*
		 * �������ڱ���ʱ���޸Ĵ�����ת��
		 * int x = ((Integer)p1.getX()).intValue();
		 */
		int x1 = p1.getX();
		System.out.println(x1);
		Point p2 = p1;
		p2.setX("��");
		System.out.println(p2);
		System.out.println(p1);
	}
}



















