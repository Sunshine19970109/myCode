package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Reataurant {
	//�ײ����÷��似��ֱ�ӷ�������
	//�ȼ��ڼ���setǰ
	//��������ǰ�൱�ڼ򵥵ĸ�ֵthis.wt=wt;
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
	
//	@Autowired//�Զ�װ��
//	public void setWt(
//			//Qualifierָ����ע���bean��id
//			@Qualifier("wt") Waiter wt) {
//		System.out.println("setWt()");
//		this.wt = wt;
//	}
	public Reataurant() {
		System.out.println("Restaurant()");
	}

}
