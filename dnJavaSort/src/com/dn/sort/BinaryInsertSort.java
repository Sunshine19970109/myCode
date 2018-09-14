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
	 * �����жϵȴ������ֵ��mid��Ӧ�õ������ֵ�Ĵ�С
	 * Ȼ���ƶ�left/right����ָ��ĵ�ֵ
	 * ֱ��left��right�غϵ�ʱ��������λ��
	 * Ȼ���Ҫ�����λ�ú����ֵ������ƶ�һλ������temp
	 * @param a
	 */
	private static void sort(int[] a){
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];//��Ҫ��������ȱ�������
			int left = 0;//��ߵ��±�
			int right = i-1;//�ұߵ��±�
			int mid = 0;//��ʼ���м��±�
			//�ҵ�Ҫ�����λ��
			while(left<=right){
				//��ȡ�м�λ��
				mid = (left+right)/2;
				//�ж�temp��a[mid]�Ĺ�ϵȷ����ô����left��right
				if(temp<a[mid]){
					//���ֵ���м�ֵС����right���Ƶ�mid-1
					right = mid-1;
				}else {
					//���ֵ���м��ֵ����������left�ƶ���mid+1
					left = mid+1;
				}
			}
			//�ƶ�λ��,�Ӻ���ǰ
			for(int j=i-1;j>=left;j--){
				a[j+1] = a[j];
			}
			//��i�Ϳ��Բ��ö���,�����ܴ���i
			if(left!=i){
				a[left] = temp;
			}
		}
		
	}
}
