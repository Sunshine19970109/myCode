package day02;
/**
 * ��װ��
 * 8�������������ڲ���ֱ�Ӳ���������󿪷�(��Ϊ��������
 * û�������������:��װ���̳У���̬)
 * Ϊ��javaΪ8�����������ṩ�˰�װ��
 * 
 * ����6���������͵İ�װ�඼�̳���:java.lang.Number
 * Number��һ�������࣬�ṩ�˿ɹ���������֮�以��ת������ط���
 * @author dell
 *
 */
public class IntegerDemo1 {
	public static void main(String[] args) {
		int a = 1;
		Integer i1 = Integer.valueOf(a);
		Integer i2 = Integer.valueOf(a);
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		int ii = i1.intValue();
		System.out.println(ii);
		System.out.println(i1);
	}
}















