package day02;
/**
 * �ַ���֧��������ʽ������:
 * String[] split(String regex)
 * ����ǰ�ַ������������������ʽ�Ĳ��ֲ�֣���
 * ʣ�µ����в�����һ���������ʽ���ء�
 * @author dell
 *
 */
public class String_split {
public static void main(String[] args) {
	String str = "abc123def456ghi789jkl";
	/*
	 * �������ֲ�֣�����������ĸ����
	 */
	String[] data = str.split("\\d+");
	System.out.println("��ֳ�"+data.length+"��");
	for (String string : data) {
		System.out.println(string);
	}
}
}














