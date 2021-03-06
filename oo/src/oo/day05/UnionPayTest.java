package oo.day05;

import java.util.Scanner;

//银行卡系统
public class UnionPayTest {

	public static void main(String[] args) {
		ICBCImpl icbc = new ICBCImpl("123456",2000);//工行卡
		UnionPay abc = new ABCImpl("1234567",2000);//银联卡---农行卡
		icbcDemo(icbc);
		
	}
	public static void icbcDemo(ICBCImpl icbc) {
		// TODO Auto-generated method stub
		System.out.println("欢迎进入工行银行卡系统，请输入您的密码:");
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
		if (icbc.checkPwd(password)) {
			System.out.println("查询余额请按1");
			System.out.println("取款请按2");
			System.out.println("在线支付请按3");
			System.out.println("退出请按4");
			int number1=0;
			int number2=0;
			int num = sc.nextInt();
			if (num==3) {
				System.out.println("请输入您要支付的金额:");
				number2 = sc.nextInt();
			}
			if (num==2) {
				System.out.println("请输入您要取款的金额:");
				number1 = sc.nextInt();
			}
			switch (num) {
			case 1:
				double money = icbc.getBalance();
				System.out.println("您的余额为:"+money);
				break;
			case 2:
				icbc.drawMoney(number1);
				break;
			case 3:
				icbc.payOnline(number2);;
				break;
			case 4:
				System.exit(0);
				break;
			}
		}
		
	}
}
interface UnionPay{
	public double getBalance();//查询余额
	public boolean drawMoney(double number);//取款
	public boolean checkPwd(String input);//验证密码
}
interface ICBC extends UnionPay{//工行接口
	
	public void payOnline(double number);//在线支付
	
}
interface ABC extends UnionPay{
	public boolean payTelBill(String phoneNumber,double sum);
}

class ICBCImpl implements ICBC{//工行卡
	String pwd ;
	double balance;
	public ICBCImpl(String password,double balance) {
		this.pwd = password;
		this.balance = balance;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public boolean drawMoney(double number) {
		// TODO Auto-generated method stub
		if(balance-number>=0){
			balance  = balance - number;
			System.out.println("取钱成功，卡余额为："+balance);
			return true;
			
		}else {
			System.out.println("您的余额不足");
			return false;
		}
		
	}

	@Override
	public boolean checkPwd(String input) {
		// TODO Auto-generated method stub
		if (input.equals(pwd)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void payOnline(double number) {
		// TODO Auto-generated method stub
		if (number<=balance) {
			balance = balance-number;
		}else{
			System.out.println("您的余额不足:");
		}
	}
	
}

class ABCImpl implements ABC{
	String pwd ;
	double balance;
	public ABCImpl(String password,double balance) {
		this.pwd = password;
		this.balance = balance;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public boolean drawMoney(double number) {
		// TODO Auto-generated method stub
		if(balance-number>=-2000){
			balance  = balance - number;
			System.out.println("取钱成功，卡余额为："+balance);
			return true;
			
		}else {
			System.out.println("您的余额不足");
			return false;
		}
		
	}

	@Override
	public boolean checkPwd(String input) {
		// TODO Auto-generated method stub
		if (input.equals(pwd)) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean payTelBill(String phoneNumber, double num) {
		// TODO Auto-generated method stub
		if (phoneNumber.length()==11&&balance-num>=-2000) {
			balance = balance-num;
			System.out.println("您的电话"+phoneNumber+"费"+num+"缴纳成功,您的余额为:"+balance);
		}
		return false;
	}
	
}













