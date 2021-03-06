package controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.ResponseResult;
import entity.User;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userServiceImpl;
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<User> login(HttpServletRequest request){
		System.out.println("login.do");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("name: "+name+"  password: "+password);
		userServiceImpl.login(name, password);
		ResponseResult<User> result = null;
		User user = userServiceImpl.login(name, password);
		System.out.println(user);
		if(user!=null){
			result = new ResponseResult<User>(1, "��¼�ɹ�");
			result.setData(user);
		}else{
			result = new ResponseResult<User>(0, "��¼ʧ��");
		}
		System.out.println(result);
		return result;
	}
	@RequestMapping("/findAll.do")
	@ResponseBody
	public ResponseResult<List<User>> findAll(){
		ResponseResult<List<User>> result = 
			new ResponseResult<List<User>>(1, "�ɹ�");
		result.setData(userServiceImpl.findAll());
		return result;
	}
}
