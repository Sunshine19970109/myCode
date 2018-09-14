package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Reataurant {
	//底层利用反射技术直接访问属性
	//等价于加载set前
	//加载属性前相当于简单的赋值this.wt=wt;
	@Autowired
	@Qualifier("wt")
	private Waiter wt;
	
	@Override
	public String toString() {
		return "Reataurant [wt=" + wt + "]";
	}
	public Waiter getWt() {
		return wt;
	}
	
//	@Autowired//自动装配
//	public void setWt(
//			//Qualifier指定被注入的bean的id
//			@Qualifier("wt") Waiter wt) {
//		System.out.println("setWt()");
//		this.wt = wt;
//	}
	public Reataurant() {
		System.out.println("Restaurant()");
	}

}
