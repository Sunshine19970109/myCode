package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 栈也可以储存一组元素，但是存取元素必须遵循
 * 先进后出的原则。
 * 栈可以通过双端队列来实现，只调用一端进出队的方法就
 * 实现了栈结构。
 * 通常使用栈来完成诸如“退后”功能时使用
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





















