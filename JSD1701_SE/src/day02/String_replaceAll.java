package day02;
/**
 * 字符串支持正则表达式方法三:
 * String replaceAll(String regex,String str)
 * 将当前字符串你中满足正则表达式的部分替换为给定内容
 * @author dell
 *
 */
public class String_replaceAll {
	public static void main(String[] args) {
		String str = "abc123def456ghi789jkl";
		str = str.replaceAll("\\d+", "#NUMBER#");
		System.out.println(str);
 	}
}
















