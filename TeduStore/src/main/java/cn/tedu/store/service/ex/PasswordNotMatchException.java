package cn.tedu.store.service.ex;
/**
 * 密码不匹配异常
 * @author soft01
 *
 */
public class PasswordNotMatchException extends RuntimeException {
	public PasswordNotMatchException() {
	}
	public PasswordNotMatchException(String msg) {
		super(msg);
	}
}
