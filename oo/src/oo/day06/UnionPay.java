package oo.day06;
/*
 * 银联接口，用于描述银联统一制定的规则，
 * 该接口提供检测密码方法、取钱方法以及查询余额方法
 * */
public interface UnionPay {
	boolean Checkpwd(String password);
	void drowMoney(double num);
	void getBalance();
}
/*
 * 课上案例“银行卡系统（实现银联接口）”的基础上，
 * 编写建设银行接口CCB。建设银行接口，
 * 用于描述中国建设银行发行的卡片功能，
 * 在满足银联接口的规则基础上，增加了支付燃气费的功能。
 * */
interface CCB extends UnionPay{
	void gasPay(int num);

}


/*
 * 工商银行接口，用于描述工商银行发行的卡片功能，
 * 在满足银联接口的规则基础上，增加了在线支付功能。
 */
interface ICBC extends UnionPay{
	void OnlinePay(double money);
}
/*
 * 农业银行接口，用于描述中国农业银行发行的卡片功能，
 * 在满足银联接口的规则基础上，增加了支付电话费的功能。另外，农行的卡的卡内余额，允许最多透支2000
 * */
interface ABC extends UnionPay{
	void payTelBill(double num);
}