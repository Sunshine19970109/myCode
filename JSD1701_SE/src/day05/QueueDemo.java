package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * ����
 * �������ڴ��һ��Ԫ�أ����Ǵ�ȡԪ�ر�����ѭ�Ƚ��ȳ�ԭ��
 * @author dell
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue =new LinkedList<String>();
		/*
		 * boolean offer (E e)
		 * �����ĩβ���ָ��Ԫ��
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		/*
		 * E poll()
		 * �Ӷ��׻�ȡԪ��
		 * ��ȡ���Ԫ�ؼ����б��Ƴ�
		 */
		String s = queue.poll();
		System.out.println(s);
		System.out.println(queue);
		/*
		 * E peek()
		 * ���ö���Ԫ��
		 * ��ȡ���Ԫ�ػ��ڶ�����
		 */
		String s1 = queue.peek();
		System.out.println(s1);
		System.out.println(queue);
		for (String string : queue) {
			System.out.println(string);
		}
	}
}


















