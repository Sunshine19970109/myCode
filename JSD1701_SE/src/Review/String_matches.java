package Review;
/**
 * �ַ���֧��������ʽ����ط���֮һ:
 * boolean matches(String regex)
 * �÷������ø�����������ʽ��֤��ǰ�ַ����Ƿ������
 * ��ʽҪ�������򷵻�true
 * ������Ҫע�⣬������ʽ���㲻��ӱ߽��(^����$)
 * Ҳ����ȫƥ����֤
 * @author dell
 *
 */
public class String_matches {
	public static void main(String[] args) {
		/*
		 * email��������ʽ
		 * \w+@\w(\\.[z-zA-Z]+)+
		 */
		String email = "fancq@tedu.cn";
		String regex = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean tf = email.matches(regex);
		System.out.println(tf+"---------"+regex);
	}
}















