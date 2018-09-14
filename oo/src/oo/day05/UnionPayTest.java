package oo.day05;

import java.util.Scanner;

//���п�ϵͳ
public class UnionPayTest {

	public static void main(String[] args) {
		ICBCImpl icbc = new ICBCImpl("123456",2000);//���п�
		UnionPay abc = new ABCImpl("1234567",2000);//������---ũ�п�
		icbcDemo(icbc);
		
	}
	public static void icbcDemo(ICBCImpl icbc) {
		// TODO Auto-generated method stub
		System.out.println("��ӭ���빤�����п�ϵͳ����������������:");
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
		if (icbc.checkPwd(password)) {
			System.out.println("��ѯ����밴1");
			System.out.println("ȡ���밴2");
			System.out.println("����֧���밴3");
			System.out.println("�˳��밴4");
			int number1=0;
			int number2=0;
			int num = sc.nextInt();
			if (num==3) {
				System.out.println("��������Ҫ֧���Ľ��:");
				number2 = sc.nextInt();
			}
			if (num==2) {
				System.out.println("��������Ҫȡ��Ľ��:");
				number1 = sc.nextInt();
			}
			switch (num) {
			case 1:
				double money = icbc.getBalance();
				System.out.println("�������Ϊ:"+money);
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
	public double getBalance();//��ѯ���
	public boolean drawMoney(double number);//ȡ��
	public boolean checkPwd(String input);//��֤����
}
interface ICBC extends UnionPay{//���нӿ�
	
	public void payOnline(double number);//����֧��
	
}
interface ABC extends UnionPay{
	public boolean payTelBill(String phoneNumber,double sum);
}

class ICBCImpl implements ICBC{//���п�
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
			System.out.println("ȡǮ�ɹ��������Ϊ��"+balance);
			return true;
			
		}else {
			System.out.println("��������");
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
			System.out.println("��������:");
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
			System.out.println("ȡǮ�ɹ��������Ϊ��"+balance);
			return true;
			
		}else {
			System.out.println("��������");
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
			System.out.println("���ĵ绰"+phoneNumber+"��"+num+"���ɳɹ�,�������Ϊ:"+balance);
		}
		return false;
	}
	
}












