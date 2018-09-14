package ioc;

public class Manager {
	private CP cp;
	public Manager(CP cp) {
		System.out.println("Manager(cp)");
		this.cp = cp;
	}
	public void setCp(Computer cp) {
		this.cp = cp;
	}
	public Manager() {
		System.out.println("Manager()");
	}
	@Override
	public String toString() {
		return "Manager [cp=" + cp +  "]";
	}
	

}
