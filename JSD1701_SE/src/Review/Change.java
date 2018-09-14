package Review;

import java.util.Scanner;

public class Change {
	public static void main(String[] args) {
		System.out.println("请输入一个数字");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.matches("\\d+")) {
			System.out.println("是整数:"+Integer.valueOf(s));
		}else if(s.matches("\\d+\\.+\\d+")){
			System.out.println("是小数:"+Double.valueOf(s));
		}else {
			System.out.println("输入错误");
		}
		
	}
}















