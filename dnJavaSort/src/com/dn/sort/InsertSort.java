package com.dn.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] a = {25,64,35,21,36,9,89,2,1,0,-4};
		System.out.println(Arrays.toString(a));
		//ֱ�Ӳ�������ʼ
		for (int i = 1; i < a.length; i++) {
			//�õ�û�в������
			int temp = a[i];
			int index = i;
			//����ǰ���ź�������飬�Ӻ���ǰЧ�ʸ�
			for (int j = i-1; j >=0; j--) {
				//�������������ǰ�������������
				if(temp<a[j]){
					//����ƶ�һλ
					a[j+1] = a[j];
					index = j;
				}else{
					//��һ��С�ڵ���,���Բ����ˣ��õ��±�
					index = j+1;
					break;
				}
			}
			//����
			a[index] = temp;
		}
		System.out.println(Arrays.toString(a));
	}
}
