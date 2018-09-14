package ArithmeticDay01;

import java.util.Arrays;
import java.util.Random;

/*
 * 题目:
 * 现有0~99,共计100个整数，各不相同,将这100个整数存放入一个数组中.
 * 然后，在这个数组中添加一个0~99之间的随机数(唯一重复的数字),把这101个数据随机排列.
 * 问题:
 * 将这个重复的数字找出来
 * */
public class Demo02 {
	public static void main(String[] args) {
		//定义一个长度为101的int型的数组
		int[] arr = new int[101];
		//为数组赋值
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = i;
		}
//		arr[100] = (int)(Math.random()*100);
		arr[100] = 88;
		//遍历数组
		printArray(arr);
		
		//随机排列
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int j = r.nextInt(101);
			int k = r.nextInt(101);
			int temp = arr[j];
			arr[j] = arr[k];
			arr[k] = temp;	
		}
		printArray(arr);
		//初学者的想法
//		itcast: for (int i = 0; i < arr.length; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				if(arr[i] ==arr[j]){
//					System.out.println("这个重复的元素是:"+arr[i]);
//					break itcast;
//				}
//			}
//		}
		//方式2
		
//		Arrays.sort(arr);
//		printArray(arr);
	}
	//遍历数组中的方法,每10个换行
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
