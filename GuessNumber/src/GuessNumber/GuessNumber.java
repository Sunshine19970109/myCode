package GuessNumber;

import java.util.Random;
import java.util.Scanner;

/**
 * ��������Ϸ
 * @author dell
 *
 */
public class GuessNumber {
	public static void main(String[] args) {
		System.out.println("��ӭ���������С��Ϸ,�˳�������886");
		System.out.println("������������:");
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
				System.out.println("��"+index+"�β´��ˣ����Ͱ�!");
				System.out.println("������������:");
			}else if(num<r1){
				System.out.println("��"+index+"�β�С�ˣ����Ͱ�!");
				System.out.println("������������:");
			}else if(num==r1){
				System.out.println("����������"+index+"�ξͲ�����");
				break;
			}
			index++;
		}
		System.out.println("�ټ����´������氡!!!");
	}
}














