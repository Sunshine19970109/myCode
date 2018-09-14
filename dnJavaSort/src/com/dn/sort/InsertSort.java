package com.dn.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] a = {25,64,35,21,36,9,89,2,1,0,-4};
		System.out.println(Arrays.toString(a));
		//直接插入排序开始
		for (int i = 1; i < a.length; i++) {
			//拿到没有插入的数
			int temp = a[i];
			int index = i;
			//遍历前面排好序的数组，从后向前效率高
			for (int j = i-1; j >=0; j--) {
				//待插入的数大于前面遍历到的数字
				if(temp<a[j]){
					//向后移动一位
					a[j+1] = a[j];
					index = j;
				}else{
					//第一个小于的数,可以插入了，拿到下标
					index = j+1;
					break;
				}
			}
			//插入
			a[index] = temp;
		}
		System.out.println(Arrays.toString(a));
	}
}
