package Review;
/**
 * 包装类提供了一个非常使用的功能:
 * 可以将字符串解析为对应的基本类型数据，
 * 但是前提是该字符串必须正确描述该基本类型可保存
 * 的值。
 * @author dell
 *
 */
public class Integer_parseInt {
	public static void main(String[] args) {
		String s = "123";
		int a = Integer.parseInt(s);
		System.out.println(a);
	}
}












