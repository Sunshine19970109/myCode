package com.tarena.bo;
/**
 * �������ڱ�ʾһ�������־
 * ���а���������־��Ϣ��һ�����룬һ���ǳ�
 * @author Administrator
 *
 */
public class LogRec {
	//������־
	private LogData login;
	//�ǳ���־
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








