package day09;
/**
 * �Զ����쳣
 * ͨ����������һ���߼��Ĵ���
 * 
 * ���䲻�Ϸ�
 * @author dell
 *
 */
public class IllegalAgeException extends Exception{

	/**
	 * 1.�����쳣�࣬�̳�Exception
	 * 2.�Զ����ɹ���
	 */
	private static final long serialVersionUID = 1L;

	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
























