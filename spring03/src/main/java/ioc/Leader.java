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
	
	//ֻ����setter����ע��,nameָע���bean��id
	//@ResourceҲ����ֱ�Ӽ�������ǰ
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
