package Review;
/**
 * 字符串支持正则表达式方法二:
 * String[] split(String regex);
 * 将当前字符串中满足给定正则表达式的部分拆分，将
 * 剩下的所有部分以一个数组的形式返回。
 * @author dell
 *
 */
public class String_split {
	public static void main(String[] args) {
		String s = "abc123def456ghj789jkl";
		/*
		 * 根据数字拆分，保留所有字母部分
		 */
		String[] data = s.split("\\d+");
		System.out.println("拆分出"+data.length+"项");
		for (String string : data) {
			System.out.println(string);
		}
	}
}


















