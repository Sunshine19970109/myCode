package day06.practice;

public class test {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("412453.jar");
		int a =sb.lastIndexOf(".");
		String s =sb.substring(a);
		System.out.println(s);
	}
}
