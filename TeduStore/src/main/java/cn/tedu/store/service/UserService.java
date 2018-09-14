package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
@Service
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;
	@Value("#{config.salt}")
	private String salt;
	public void addUser(User user) {
		User user1 = userMapper.selectByUsername(user.getUsername());
		if(user1==null) {
			//获取密码加盐
			String pwd = user.getPassword()+salt;
			//加密处理
			String Md5Pwd = DigestUtils.md5Hex(pwd);
			user.setPassword(Md5Pwd);
			//把设置密码
			userMapper.insertUser(user);
		}else {
			throw new UsernameAlreadyExistException("用户已存在");
		}
	}
	public boolean checkEmail(String email) {
		int num = userMapper.selectByEmail(email);
		if(num==0) {
			return false;
		}else {
			return true;
		}
	}
	public boolean checkPhone(String phone) {
		return userMapper.selectByPhone(phone)>0;
	}
	public boolean checkUsername(String username) {
		return userMapper.selectByUsername(username)!=null;
	}
	public User login(String username, String password) {
		User user = userMapper.selectByUsername(username);
		if(user==null) {
			throw new UserNotFoundException("帐号不存在");
		}else {
			//判断密码是否正确
			password = DigestUtils.md5Hex(password+salt);
			if(user.getPassword().equals(password)) {
				return user;
			}else {
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}
	public void changePassword(Integer id, String oldPassword, String newPassword) {
		User user = userMapper.selectUserById(id);
		if(user!=null) {
			String pwd = user.getPassword();
			oldPassword = DigestUtils.md5Hex(oldPassword+salt);
			//旧的密码正确
			if(pwd.equals(oldPassword)) {
				user.setPassword(DigestUtils.md5Hex(newPassword+salt));
				userMapper.updateUser(user);
			}else {
				throw new PasswordNotMatchException("密码不正确");
			}
		}else {
			throw new UserNotFoundException("用户不存在");
		}
	}
	public void updateUser(Integer id, String username, Integer gender, String email, String phone) {
		User user1 = userMapper.selectUserById(id);
		if(user1!=null) {
			//有用户
			User user2 = userMapper.selectByUsername(username);
			//能否修改名字
			//user1是登陆对象的名字
			//user2是重复名字的对象
			if(user2!=null&&!username.equals(user1.getUsername())) {
				//用户名已存在
				throw new UsernameAlreadyExistException("用户名已存在");
			}else {
				//用户名不存在
				//问题其他的信息会丢失
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setGender(gender);
				user.setEmail(email);
				user.setPhone(phone);
				userMapper.updateUser(user);
			}
		}else {
			//没有用户
			throw new UserNotFoundException("用户不存在");
		}
	}
	public User getUserById(Integer id) {
		return userMapper.selectUserById(id);
	}
	public void updImage(Integer id, String image) {
		userMapper.updateImage(id, image);
	}

}
