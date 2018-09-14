package com.dn.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author dell
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] a = {25,64,35,21,36,9,89,2,1,0,-4};
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, 10);
		System.out.println(Arrays.toString(a));
	}
	public static void quickSort(int[] a,int start,int end){
		if(start<end){
			int baseNum = a[start];//选基准值
			int midNum;//记录中间值
			int i = start;
			int j = end;
			do {
				while ((a[i]<baseNum)&&i<end) {
					i++;
				}
				while ((a[j]>baseNum)&&j>start) {
					j--;
				}
				if(i<=j){
					midNum = a[i];
					a[i] = a[j];
					a[j] = midNum;
					i++;
					j--;
				}
			} while (i<=j);
			if(start<j){
				quickSort(a, start, j);
			}
			if(end>j){
				quickSort(a, i, end);
			}
		}
	}
}
