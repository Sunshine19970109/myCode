package Review;

import java.util.Scanner;

public class Change {
	public static void main(String[] args) {
		System.out.println("������һ������");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.matches("\\d+")) {
			System.out.println("������:"+Integer.valueOf(s));
		}else if(s.matches("\\d+\\.+\\d+")){
			System.out.println("��С��:"+Double.valueOf(s));
		}else {
			System.out.println("�������");
		}
		
	}
}















