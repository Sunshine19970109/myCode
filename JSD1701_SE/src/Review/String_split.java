package Review;
/**
 * �ַ���֧��������ʽ������:
 * String[] split(String regex);
 * ����ǰ�ַ������������������ʽ�Ĳ��ֲ�֣���
 * ʣ�µ����в�����һ���������ʽ���ء�
 * @author dell
 *
 */
public class String_split {
	public static void main(String[] args) {
		String s = "abc123def456ghj789jkl";
		/*
		 * �������ֲ�֣�����������ĸ����
		 */
		String[] data = s.split("\\d+");
		System.out.println("��ֳ�"+data.length+"��");
		for (String string : data) {
			System.out.println(string);
		}
	}
}


















