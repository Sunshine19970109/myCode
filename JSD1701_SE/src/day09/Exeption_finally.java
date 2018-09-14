package day09;
/**
 * finally块
 * 在异常捕获机制中，finally块是最后一部分。它只能
 * 跟在try块之后，或者最后一个catch之后。
 * finally可以保证该块其中的代码(必定执行)，无论try
 * 中的代码是否出现异常。
 * 通常会将无论如何都要运行的代码放在里面，比如流操作
 * 中的关闭流这个工作
 * @author dell
 *
 */
public class Exeption_finally {
	public static void main(String[] args) {
		/*
		 * 不管你的代码有没有错finally中的代码一定是
		 * 执行的，就算return,finally依然执行
		 */
	}
}

















