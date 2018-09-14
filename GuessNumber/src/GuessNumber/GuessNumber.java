package GuessNumber;

import java.util.Random;
import java.util.Scanner;

/**
 * 猜数字游戏
 * @author dell
 *
 */
public class GuessNumber {
	public static void main(String[] args) {
		System.out.println("欢迎进入猜数字小游戏,退出请输入886");
		System.out.println("请您输入数字:");
		Scanner sc= new Scanner(System.in);
		Random r = new Random();
		int r1 = r.nextInt(101);
		int index = 1;
		while(true){
			int num = sc.nextInt();
			if(num==886){
				break;
			}
			if(num>r1){
				System.out.println("第"+index+"次猜大了，减油啊!");
				System.out.println("请您输入数字:");
			}else if(num<r1){
				System.out.println("第"+index+"次猜小了，加油啊!");
				System.out.println("请您输入数字:");
			}else if(num==r1){
				System.out.println("好厉害，才"+index+"次就猜中啦");
				break;
			}
			index++;
		}
		System.out.println("再见，下次再来玩啊!!!");
	}
}














