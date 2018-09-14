package cn.tedu.netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.netctoss.dao.AdminDAO;
import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.util.ImageUtil;
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name="adminDAO")
	private AdminDAO aDAO;
	public Admin checkLogin(
			String adminCode, String pwd) {
		Admin admin = aDAO.findByAdminCode(adminCode);
		if(admin==null){
			//�˺Ų����ڣ���һ��Ӧ���쳣
			/*
			 * ע:Ӧ���쳣��ָ������Ϊ�û�����ȷ��
			 * ����������쳣�������˺š�������д����
			 * ��Ҫ��ȷ��ʾ�û���ȡ��ȷ�Ĳ�����
			 */
			throw new ApplicationException(
					"�˺Ŵ���");
		}
		if(!admin.getPassword().equals(pwd)){
			//�������
			throw new ApplicationException
			("�������");
		}
		//��¼�ɹ�
		return admin;
	}

}
