package controller;

import java.io.Serializable;
/**
 * ���ڷ�װ�������ֵ
 * 	�����������������һ��
 * 	�ṩ��Ӧ��get/set����
 * 	ע:
 * 		����Ҫһ��������Ҫƥ��
 * 		(�������������ת�������罫Stringת����int
* 		�ṩ��Ӧ��get/set����)
 * @author dell
 *
 */
public class AdminParam implements Serializable {
	private String adminCode;
	private String pwd;
	
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
