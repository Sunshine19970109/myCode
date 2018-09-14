package day02;

public class RegExUtils {
	public static void main(String[] args) {
//		String id = "610124199701094814";
//		String regex = "\\d{18}";
//		boolean a =id.matches(regex);
//		System.out.println(a);
		System.out.println(id("610124199701094814"));
		System.out.println(yzbm("710400"));
		System.out.println(phoneNumber("13132105223"));
	}
	private static boolean id(String id) {
		// TODO Auto-generated method stub
		return id.matches("\\d{18}"); 
	}
	private static boolean yzbm(String yb) {
		// TODO Auto-generated method stub
		return yb.matches("\\d{6}");
	}
	private static boolean phoneNumber(String phoneNum) {
		// TODO Auto-generated method stub
		return phoneNum.matches("\\d{6,11}");
	}
}














