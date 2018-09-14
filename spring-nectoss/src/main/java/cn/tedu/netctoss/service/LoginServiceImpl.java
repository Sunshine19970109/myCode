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
			//账号不存在，抛一个应用异常
			/*
			 * 注:应用异常，指的是因为用户不正确的
			 * 操作引起的异常，比如账号、密码填写错误。
			 * 需要明确提示用户采取正确的操作。
			 */
			throw new ApplicationException(
					"账号错误");
		}
		if(!admin.getPassword().equals(pwd)){
			//密码错误
			throw new ApplicationException
			("密码错误");
		}
		//登录成功
		return admin;
	}

}
