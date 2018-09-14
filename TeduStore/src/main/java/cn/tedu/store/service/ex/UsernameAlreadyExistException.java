package cn.tedu.store.service.ex;

public class UsernameAlreadyExistException extends RuntimeException {
	public UsernameAlreadyExistException() {}
	public UsernameAlreadyExistException(String msg) {
		super(msg);
	}
}
