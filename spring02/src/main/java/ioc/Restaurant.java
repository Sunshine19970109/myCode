package ioc;

public class Restaurant {
	private Waiter w;
	public void setW(Waiter w) {
		this.w = w;
	}
	public Restaurant() {
		
	}
	public void execute(){
		System.out.println("execute()");
		w.wf1();
	}
}
