package Review;
/**
 * 字符串支持正则表达式方法三:
 * String replaceAll(String regex ,String str)
 * 将当前字符串中满足正则表达式的部分替换为给定的内容
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


















