package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ջ
 * ջҲ���Դ���һ��Ԫ�أ����Ǵ�ȡԪ�ر�����ѭ
 * �Ƚ������ԭ��
 * ջ����ͨ��˫�˶�����ʵ�֣�ֻ����һ�˽����ӵķ�����
 * ʵ����ջ�ṹ��
 * ͨ��ʹ��ջ��������硰�˺󡱹���ʱʹ��
 * @author dell
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		System.out.println(stack);
		
		String s = stack.pop();
		System.out.println(s);
		System.out.println(stack);
		String s1 = stack.peek();
		System.out.println(s1);
		System.out.println(stack);
	}
}





















