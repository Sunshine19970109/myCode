package day02;
/**
 * �ַ���֧��������ʽ����ط���֮һ:
 * boolean matches(String regex)
 * �÷������ø�����������ʽ��֤��ǰ�ַ����Ƿ������
 * ��ʽҪ�������򷵻�true
 * ������Ҫע�⣬������ʽ���㲻��ӱ߽�ƥ���(^...$)
 * Ҳ����ȫƥ����֤
 * @author dell
 *
 */
public class String_matches {
	public static void main(String[] args) {
		/*
		 * email��������ʽ
		 * \w+@\w(\\.[a-zA-Z]+)+
		 */
		String email = "fancq@tedu.cn";
		String regex = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean tf = email.matches(regex);
		System.out.println(tf+"---"+regex);
	}
}













