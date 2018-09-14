package ioc;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Leader {
	@Resource(name="wt")
	private Waiter wt;
	public Waiter getWt() {
		return wt;
	}
	
	//只能用setter方法注入,name指注入的bean的id
	//@Resource也可以直接加在属性前
	@Resource(name="wt")
	public void setWt(Waiter wt) {
		this.wt = wt;
	}
	public Leader() {
		System.out.println("Leader()");
	}
	@Override
	public String toString() {
		return "Leader [wt=" + wt + "]";
	}

}
