package ArithmeticDay01;

import java.util.Arrays;
import java.util.Random;

/*
 * ��Ŀ:
 * ����0~99,����100��������������ͬ,����100�����������һ��������.
 * Ȼ����������������һ��0~99֮��������(Ψһ�ظ�������),����101�������������.
 * ����:
 * ������ظ��������ҳ���
 * */
public class Demo02 {
	public static void main(String[] args) {
		//����һ������Ϊ101��int�͵�����
		int[] arr = new int[101];
		//Ϊ���鸳ֵ
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = i;
		}
//		arr[100] = (int)(Math.random()*100);
		arr[100] = 88;
		//��������
		printArray(arr);
		
		//�������
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int j = r.nextInt(101);
			int k = r.nextInt(101);
			int temp = arr[j];
			arr[j] = arr[k];
			arr[k] = temp;	
		}
		printArray(arr);
		//��ѧ�ߵ��뷨
//		itcast: for (int i = 0; i < arr.length; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				if(arr[i] ==arr[j]){
//					System.out.println("����ظ���Ԫ����:"+arr[i]);
//					break itcast;
//				}
//			}
//		}
		//��ʽ2
		
//		Arrays.sort(arr);
//		printArray(arr);
	}
	//���������еķ���,ÿ10������
	private static void printArray(int[] arr) {
		int count = 0;
		for (int i : arr) {
			System.out.print(arr[i]+"\t");
			count++;
			if(count%10==0){
				System.out.println();
			}
		}
		System.out.println();
	}
}
