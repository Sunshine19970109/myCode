package com.tarena.bo;
/**
 * 该类用于表示一组配对日志
 * 其中包含两条日志信息，一个登入，一个登出
 * @author Administrator
 *
 */
public class LogRec {
	//登入日志
	private LogData login;
	//登出日志
	private LogData logout;
	
	public LogRec(){
		
	}

	public LogRec(LogData login, LogData logout) {
		super();
		this.login = login;
		this.logout = logout;
	}

	public LogData getLogin() {
		return login;
	}

	public void setLogin(LogData login) {
		this.login = login;
	}

	public LogData getLogout() {
		return logout;
	}

	public void setLogout(LogData logout) {
		this.logout = logout;
	}
	
	public String toString(){
		return login+"|"+logout;
	}
}








