package oo.day06;
/*
 * �����ӿڣ�������������ͳһ�ƶ��Ĺ���
 * �ýӿ��ṩ������뷽����ȡǮ�����Լ���ѯ����
 * */
public interface UnionPay {
	boolean Checkpwd(String password);
	void drowMoney(double num);
	void getBalance();
}
/*
 * ���ϰ��������п�ϵͳ��ʵ�������ӿڣ����Ļ����ϣ�
 * ��д�������нӿ�CCB���������нӿڣ�
 * ���������й��������з��еĿ�Ƭ���ܣ�
 * �����������ӿڵĹ�������ϣ�������֧��ȼ���ѵĹ��ܡ�
 * */
interface CCB extends UnionPay{
	void gasPay(int num);

}


/*
 * �������нӿڣ����������������з��еĿ�Ƭ���ܣ�
 * �����������ӿڵĹ�������ϣ�����������֧�����ܡ�
 */
interface ICBC extends UnionPay{
	void OnlinePay(double money);
}
/*
 * ũҵ���нӿڣ����������й�ũҵ���з��еĿ�Ƭ���ܣ�
 * �����������ӿڵĹ�������ϣ�������֧���绰�ѵĹ��ܡ����⣬ũ�еĿ��Ŀ������������͸֧2000
 * */
interface ABC extends UnionPay{
	void payTelBill(double num);
}