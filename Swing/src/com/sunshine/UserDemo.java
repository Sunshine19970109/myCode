package com.sunshine;
/*问题  
 * 	接口方法多，实现类麻烦
 * 解决
 * 	接口-----------适配器类(实现接口，仅仅空实现)
 * 
 * */
public class UserDemo {
public static void main(String[] args) {
	UserDao ud = new UserDemoIml();
	ud.add();
	//我没有说我要实现四个
	UserDao ud2 = new UserDemoIml2();
	ud2.add();
}
}
