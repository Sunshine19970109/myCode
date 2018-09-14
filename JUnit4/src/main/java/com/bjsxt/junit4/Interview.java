package com.bjsxt.junit4;

public class Interview {

	public static void main(String[] args) {
		int i = -129;
		Integer j = -129;
		j.intValue();
		System.err.println(Byte.MIN_VALUE);
		System.err.println(Byte.MAX_VALUE);
		Integer k = Integer.valueOf(i);
		System.out.println(j==k);
		System.out.println(Integer.MAX_VALUE);
	}

}
