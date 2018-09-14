package Review;

public class RegExUtils {
	public static void main(String[] args) {
		String id = "610124199701094814";
		String regex = "\\d{18}";
		boolean a = id.matches(regex);
		System.out.println(a);
	}
}
