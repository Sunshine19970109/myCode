package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bar {
	private Waiter wt;
	public Bar() {
		System.out.println("Bar()");
	}
	@Autowired
	public Bar(@Qualifier("wt") Waiter wt) {
		System.out.println("Bar(wt)");
		this.wt = wt;
	}
	@Override
	public String toString() {
		return "Bar [wt=" + wt + "]";
	}
	
}
