//package oo.day05;
//
//public interface UnionPay{//银联接口
//	void 存款();
//	void 取款();
//	void 转账();
//	void 查询余额();
//}
//
//interface CCB extends UnionPay{
//	void 支付燃气费();
//}
//
//interface ICBC extends UnionPay{//工行接口
//	void 在线支付();
//}
//class ICBCImpl implements ICBC{//农行接口
//	public void 存款(){};
//	public void 取款(){};
//	public void 转账(){};
//	public void 查询余额(){};
//	public void 在线支付(){};
//}
//
//interface ABC extends UnionPay{
//	void 支付电话费();
//}
//class ABCImpl implements ABC{
//	public void 存款(){};
//	public void 取款(){};
//	public void 转账(){};
//	public void 查询余额(){};
//	public void 支付电话费(){};
//}