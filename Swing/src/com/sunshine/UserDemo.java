package com.sunshine;
/*����  
 * 	�ӿڷ����࣬ʵ�����鷳
 * ���
 * 	�ӿ�-----------��������(ʵ�ֽӿڣ�������ʵ��)
 * 
 * */
public class UserDemo {
public static void main(String[] args) {
	UserDao ud = new UserDemoIml();
	ud.add();
	//��û��˵��Ҫʵ���ĸ�
	UserDao ud2 = new UserDemoIml2();
	ud2.add();
}
}
