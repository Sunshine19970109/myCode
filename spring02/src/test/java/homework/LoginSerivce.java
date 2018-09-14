package homework;

public class LoginSerivce {
	private AdminDao dao;
	
	@Override
	public String toString() {
		return "LoginSerivce [dao=" + dao + "]";
	}

	public AdminDao getDao() {
		return dao;
	}

	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	public LoginSerivce() {
		
	}

}
