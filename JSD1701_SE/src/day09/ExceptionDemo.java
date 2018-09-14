package day09;
/**
 * java异常处理机制中的try--catch
 * 
 * @author dell
 *
 */
public class ExceptionDemo {
	/*
	 * 1.try--catch捕获异常
	 * 2.怎么处理的代码,catch可以写多次
	 * catch可以写多个，针对不同异常就不同解决手段
	 * 时可以分别捕获这些异常并处理
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
			String s = "abc";
			System.out.println(s.length());
			char ch = s.charAt(1);
			System.out.println(Integer.valueOf(s));
			/*
			 * try中出错的代码以下的所有代码都不会运行
			 * 不会输出
			 */
			System.out.println("!!!!!!!!!");
		}catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("出现空指针异常");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("出现字符串越界");
		}catch (NumberFormatException e) {
			System.out.println("数字格式异常");
		/*
		 * 应该养成一个好习惯，在最后一个catch中捕捉
		 * Exception,这样不会因为一个未捕获的异常
		 * 程序中断。
		 * 当异常之间存在父子类继承关系时，一定子类异常
		 * 在上先行捕获，父类异常在下后捕获。
		 */
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("出错了");
		}
		System.out.println("程序结束了");
	}
}




















