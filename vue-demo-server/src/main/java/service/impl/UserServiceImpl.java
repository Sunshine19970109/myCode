package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserDAO;
import entity.User;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDAOImpl;
	public User login(String name,String password) {
		if(password==null||"".equals(password)){
			return null;
		}else if(name==null||"".equals(name)){
			return null;
		}else {
			User user = userDAOImpl.selectByName(name);
			if(user!=null&&password.equals(user.getPassword())){
				return user;
			}else {
				return null;
			}
		}
	}
	public List<User> findAll() {
		return userDAOImpl.selectAll();
	}

}
