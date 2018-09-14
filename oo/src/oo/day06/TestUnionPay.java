package oo.day06;

import java.util.Scanner;
//农行ATM
public class TestUnionPay {
	public static void main(String[] args) {
//		UnionPay icbc = new ICBCImpl("123456", 2000);
//		UnionPay abc = new ABCImpl("123456", 2000);
//		System.out.println("请输入密码:");
//		Scanner sc = new Scanner(System.in);
//		String password = sc.next();
//		icbc.Checkpwd(password);
//		System.out.println("请输入取款金额:");
//		double money = sc.nextDouble();
//		icbc.drowMoney(money);
		ABCATM atm = new ABCATM();
		UnionPay card = new ABCImpl("123456", 2000);
		atm.insertCard(card);
		atm.payTelBill();//相当于一个按钮
	}
}

class ABCATM{
	private UnionPay card;
	public void insertCard(UnionPay card){
		this.card = card;
	}
	public void payTelBill() {
		// TODO Auto-generated method stub
		if(card instanceof ABC){
			ABC abcCard = (ABC)card;
			abcCard.payTelBill(100);
		}else{
			System.out.println("不是农行卡，不能支付电话费");
		}
	}
}





























class CCBImpl implements CCB{
	String pwd;
	double balance;
	public CCBImpl(String password,double num) {
		// TODO Auto-generated constructor stub
		this.pwd = password;
		this.balance = num;
	}
	@Override
	public boolean Checkpwd(String password) {
		// TODO Auto-generated method stub
		if (this.pwd.equals(password)) {
			return true;
		}else{
		return false;
		}
	}

	@Override
	public void drowMoney(double num) {
		// TODO Auto-generated method stub
		if (balance-num>=0) {
			balance = balance-num;
			System.out.println("您成功取款"+num);
			System.out.println("您的余额为:"+balance);
		} 
	}

	@Override
	public void getBalance() {
		// TODO Auto-generated method stub
		System.out.println("您的余额为:"+balance);
	}

	@Override
	public void gasPay(int num) {
		// TODO Auto-generated method stub
		if (balance-num>=0) {
			balance = balance-num;
			System.out.println("您成功取款"+num);
			System.out.println("您的余额为:"+balance);
		} 
	}
}	
class ABCImpl implements ABC{
	double balance;
	String password;
	public ABCImpl(String password,double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
		this.password = password;
	}
	@Override
	public boolean Checkpwd(String password) {
		if (this.password.equals(password)) {
			return true;
		}else {
			return false;	
		}
	}

	@Override
	public void drowMoney(double num) {
		if (balance-num>=0) {
			balance = balance-num;
			System.out.println("成功取款:"+num);
			System.out.println("您的余额为:"+balance);
		}
	}

	@Override
	public void getBalance() {
		// TODO Auto-generated method stub
		System.out.println(balance);
	}

	@Override
	public void payTelBill(double num) {
		// TODO Auto-generated method stub
		if (balance-num>=0) {
			System.out.println("电话费缴纳:"+num+"成功");
		}
		
	}
	
}
class ICBCImpl implements ICBC{
	double balance;
	String password;
	public ICBCImpl(String password,double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
		this.password = password;
	}
	@Override
	public boolean Checkpwd(String password) {
		if (this.password.equals(password)) {
			return true;
		}else {
			return false;	
		}
		
	}

	@Override
	public void drowMoney(double num) {
		if (balance-num>=0) {
			balance = balance-num;
			System.out.println("成功取款:"+num);
			System.out.println("您的余额为:"+balance);
		}
		
	}

	@Override
	public void getBalance() {
		System.out.println(balance);
	}

	@Override
	public void OnlinePay(double money) {
		if (balance-money>=0) {
			System.out.println("支付成功:"+money);
		}
		
	}
	
}