package test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TestCase {
	@Test
	public void testBin1(){
		//变量i是二进制数据
		int i=50;
		System.err.println(
			Integer.toBinaryString(i));
		//输出方法调用了Integer.toString()将
		//2进制转换为10进制，然后再输出
		System.out.println(50);
	}
	@Test
	public void testBin2(){
		//输出int类型0-63全部2进制存储情况
		for(int i=0;i<=63;i++){
			System.out.println(
				StringUtils.leftPad(Integer.toBinaryString(i),32,"0"));
		}
		int num = Integer.MAX_VALUE;
		System.out.println(
		Integer.toBinaryString(num));
	}
	@Test
	public void testLeftPad(){
		//左填充函数
		//将str左面补充到指定的长度
		//leftPad("6",8,"0")->00000006
		//leftPad("123",8,"0")->00000123
		String s = 
			StringUtils.leftPad("101", 32, "0");
		System.out.println(s);
	}
	@Test
	public void testHex(){
		int i = 0xac;
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
	}
	@Test
	public void testBin5(){
		long i = -1L;
		System.out.println(Long.toBinaryString(i));
	}
	@Test
	public void testBin6(){
		//01111111 11111111 11111111 11111111
		int max = 0x7fffffff;
		System.out.println(
		Integer.toBinaryString(max));
		System.out.println(max);
	}
	@Test
	public void testBin7(){
		//10000000 00000000 00000000 00000000
		int min =0x80000000;
		System.out.println(min);
		System.out.println(
		Integer.toBinaryString(min));
	}
	@Test
	public void testBin8(){
		int n = Integer.MAX_VALUE;
		int k = Integer.MIN_VALUE;
		System.out.println(n-k);
	}
	@Test
	public void testBin10(){
		System.out.println(
			Integer.toBinaryString(~8));
		System.out.println(~8);
	}
	@Test
	public void testBin11(){
		int c = '中';
		System.out.println(Integer.toBinaryString(c));
	}
	@Test
	public void testBin12(){
		//与运算用来拆
		int n = '中';
		int m = 0x3f;
		int k= m&n;
		System.out.println(Integer.toBinaryString(k));
	}
	@Test
	public void testBin13(){
		//或运算用来合并
		int n = 0x2d;
		int m = 0x80;
		int k = m|n;
		System.out.println(
			Integer.toBinaryString(k));
	}
	public void testBin14(){
		int n = 0x227aaabb;
		int m = n>>>2;
		System.out.println(
			Integer.toBinaryString(m));
	}
}
