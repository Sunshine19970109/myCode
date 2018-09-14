package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

@Controller
@RequestMapping("/User")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;
	/**
	 * 显示注册视图
	 * @return 注册页面
	 */
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/checkUsername")
	@ResponseBody
	/**
	 * 用户名验证
	 * @param username
	 * @return
	 */
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> res = null;
		boolean b = userService.checkUsername(username);
		if(b) {
			res = new ResponseResult<Void>(0, "用户名不可以使用",null);
		}else {
			res = new ResponseResult<Void>(1, "用户名可以使用",null);
		}
		return res;
	}
	@RequestMapping("/checkEmail")
	@ResponseBody
	/**
	 * 邮箱验证
	 * @param email
	 * @return
	 */
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr = null;
		boolean b = userService.checkEmail(email);
		//b==true--已经有email地址了
		if(b) {
			rr = new ResponseResult<Void>(0, "邮箱已存在");
		}else {
			rr = new ResponseResult<Void>(1, "邮箱可以使用");
		}
		return rr;
	}
	
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		 ResponseResult<Void> rr = null;
		 boolean b = userService.checkPhone(phone);
		 //b==true--电话号码已经存在
		 //b==false---电话号码不存在
		 if(b) {
			 rr = new ResponseResult<Void>(0, "电话号码已存在");
		 }else {
			 rr = new ResponseResult<Void>(1, "电话号码可以使用");
		 }
		 return rr;
	}
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname")String username,@RequestParam("upwd")String password,
			@RequestParam("email")String email,@RequestParam("phone")String phone
			){
		ResponseResult<Void> rr = null;
		try {
			User user = new User(username, password, email, phone);
			userService.addUser(user);
			rr = new ResponseResult<Void>(1, "添加数据成功");
			System.out.println(user);
		}catch(RuntimeException ex) {
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		System.out.println("显示登录");
		return "login";
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,

			String password,
			HttpSession session){
		ResponseResult<Void> rr =null;
		try {
			User user = userService.login(username, password);
			rr = new ResponseResult<Void>(1, "登陆成功");
			session.setAttribute("user", user);
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		session.invalidate();//session失效
		//重定向到index.jsp
		return "redirect:../Main/showIndex.do";
	}
	//显示梗概密码的请求
	@RequestMapping("/showPassword.do")
	public String  showPassword(){
		return "personal_password";
	}
	
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(
			HttpSession session,String oldPwd,String newPwd){
		ResponseResult<Void> rr = null;
		try {
			Integer id = super.getId(session);
			userService.changePassword(id, oldPwd, newPwd);
			rr = new ResponseResult<Void>(1, "修改密码成功");  
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/showPersonpage.do")
	public String showPersonpage() {
		return "personpage";
	}
	
	@RequestMapping("/updateUser.do")
	@ResponseBody
	/**
	 * 修改个人信息
	 * @param session
	 * @param username
	 * @param gender
	 * @param email
	 * @param phone
	 * @return
	 */
	public ResponseResult<Void> updateUser(HttpSession session,
			String
			username,Integer gender,String email,String phone){
		ResponseResult<Void> rr = null;
		try {
			userService.updateUser(getId(session), username, gender, email, phone);
			rr = new ResponseResult<Void>(1, "修改成功");
			//当修改成功的时候更新session
			session.setAttribute("user",userService.getUserById(getId(session)));
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(MultipartFile file,HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>(1, "上传成功");
		//1.创建rr对象 state:
		//1.上传图片
		try {
			//获取当前你应用的真实路径
			String path = session.getServletContext().getRealPath("/");
			System.out.println(path);
			file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		}catch (IOException e) {
			e.printStackTrace();
		}
		//2.修改image字段的值
		userService.updImage(this.getId(session), "/upload/"+file.getOriginalFilename());
		return rr;
	}
}












