package Review;
/**
 * �ַ���֧��������ʽ������:
 * String replaceAll(String regex ,String str)
 * ����ǰ�ַ���������������ʽ�Ĳ����滻Ϊ����������
 * @author dell
 *
 */
public class String_replaceAll {
	public static void main(String[] args) {
		String s = "abc123bcd456789jkl";
		s = s.replaceAll("\\d+", "#NUMBER#");
		System.out.println(s);
	}
}


















