package com.dn.sort;

import java.util.Arrays;

public class BinaryInsertSort {
	public static void main(String[] args) {
		int[] a = {25,64,35,21,36,9,89,2,1,0,-4};
		System.out.println(Arrays.toString(a));
		BinaryInsertSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
	/**
	 * 不断判断等待插入的值和mid对应得到数组的值的大小
	 * 然后移动left/right两个指针的的值
	 * 直到left和right重合的时候就是这个位置
	 * 然后把要插入的位置后面的值都向后移动一位，插入temp
	 * @param a
	 */
	private static void sort(int[] a){
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];//将要插入的数先保存下来
			int left = 0;//左边的下标
			int right = i-1;//右边的下标
			int mid = 0;//初始化中间下标
			//找到要插入的位置
			while(left<=right){
				//获取中间位置
				mid = (left+right)/2;
				//判断temp与a[mid]的关系确定怎么引用left和right
				if(temp<a[mid]){
					//如果值比中间值小，让right左移到mid-1
					right = mid-1;
				}else {
					//如果值比中间的值大或者相等让left移动到mid+1
					left = mid+1;
				}
			}
			//移动位置,从后向前
			for(int j=i-1;j>=left;j--){
				a[j+1] = a[j];
			}
			//是i就可以不用动了,不可能大于i
			if(left!=i){
				a[left] = temp;
			}
		}
		
	}
}
