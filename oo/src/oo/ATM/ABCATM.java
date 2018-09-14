package oo.ATM;

import oo.day06.UnionPay;
import oo.day06.TestUnionPay;

public class ABCATM {
	private UnionPay card;
	private String cardPassword;
	public void insertCard(UnionPay card,String cardPassword) {
		// TODO Auto-generated method stub
		if (card!=null) {
			this.card = card;
			this.cardPassword = cardPassword;
		}
	}
	public void outCard() {
		// TODO Auto-generated method stub
		this.card = null;
	}
	public void showBalance() {
		// TODO Auto-generated method stub
		card.Checkpwd(cardPassword);
		card.getBalance();
	}
	public void takeMoney(double num) {
		// TODO Auto-generated method stub
		card.Checkpwd(cardPassword);
		card.drowMoney(num);
	}
//	public void payTelBill(String phoneNum,double num) {
//		// TODO Auto-generated method stub
//		card.Checkpwd(cardPassword);
//		if (card instanceof ABC) {
//			
//		} else {
//
//		}
//	}
	public void allMenu() {
		// TODO Auto-generated method stub

	}
}
