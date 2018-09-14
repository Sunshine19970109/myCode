package cn.tedu.store.service.ex;
/**
 * 没有找到用户异常
 * @author soft01
 *
 */
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
	}
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
