package com.dn.sort;

import java.util.Arrays;

public class HeerSort {
	public static void main(String[] args) {
		int[] a = {64,35,21,36,9,89,2,1,0,-4};
		System.out.println(Arrays.toString(a));
		int d = a.length/2;//默认最大增量
		while (true) {
			//每组开头循环
			for (int i = 0; i < d; i++) {
				//每组内部交换
				for(int j=i;j+d<a.length;j+=d){
					int temp ;
					if(a[j]>a[j+d]){
						temp = a[j];
						a[j] = a[j+d];
						a[j+d] = temp;
					}
				}
			}
			if(d==1){
				break;
			}
			d--;
		}
		System.out.println(Arrays.toString(a));
	}
}
