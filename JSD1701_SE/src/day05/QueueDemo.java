package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列
 * 队列用于存放一组元素，但是存取元素必须遵循先进先出原则
 * @author dell
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue =new LinkedList<String>();
		/*
		 * boolean offer (E e)
		 * 向队列末尾添加指定元素
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		/*
		 * E poll()
		 * 从队首获取元素
		 * 获取后钙元素即从列表移除
		 */
		String s = queue.poll();
		System.out.println(s);
		System.out.println(queue);
		/*
		 * E peek()
		 * 引用队首元素
		 * 获取后该元素还在队列中
		 */
		String s1 = queue.peek();
		System.out.println(s1);
		System.out.println(queue);
		for (String string : queue) {
			System.out.println(string);
		}
	}
}


















