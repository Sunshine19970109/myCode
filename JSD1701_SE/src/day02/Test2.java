package day02;

public class Test2 {
	public static void main(String[] args) {
		String regex ="(wqnmlgb|nc|cnm|mdzz|djb|sb|nmlgb)";
		String message= "wqnmlgb!ÄãÕâ¸ösb!";
		message = message.replaceAll(regex, "****");
		System.out.println(message);
	}
}
