package day02;
/**
 * 字符串支持正则表达式的相关方法之一:
 * boolean matches(String regex)
 * 该方法是用给定的正则表达式验证当前字符串是否满足该
 * 格式要求，满足则返回true
 * 这里需要注意，正则表达式就算不添加边界匹配符(^...$)
 * 也是做全匹配验证
 * @author dell
 *
 */
public class String_matches {
	public static void main(String[] args) {
		/*
		 * email的正则表达式
		 * \w+@\w(\\.[a-zA-Z]+)+
		 */
		String email = "fancq@tedu.cn";
		String regex = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean tf = email.matches(regex);
		System.out.println(tf+"---"+regex);
	}
}













