package cn.tedu.netctoss.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.net.ssl.SSLSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.service.ApplicationException;
import cn.tedu.netctoss.service.LoginService;
import cn.tedu.netctoss.util.ImageUtil;
	
@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request,
			HttpSession session){
		System.out.println("login()");
		//读取验证码
		String code = request.getParameter("code");
		String sCode = (String)session.getAttribute("code");
		if(code==null||!sCode.equalsIgnoreCase(code)){
			request.setAttribute("codeError", "验证码错误");
			System.out.println("验证码错误");
			return "login";
		}
		//读取账号密码
		String adminCode = 
				request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		
		System.err.println("adminCode : "+adminCode);
		System.out.println("login()");
//		//调用业务层提供的服务
//		try {
			Admin admin = loginService.checkLogin(adminCode, pwd);
			//登录成功，将一些数据绑定到session对象上
			session.setAttribute("admin", admin);
//		} catch (Exception e) {
//			e.printStackTrace();
//			if(e instanceof ApplicationException){
//				//应用异常，明确提示用户
//				/*
//				 * getMessage方法继承自
//				 * RuntimeException,作用是
//				 * 获得异常的描述信息。
//				 */
//				request.setAttribute(
//						"login_failed",
//						e.getMessage());
//				return "login";
//			}
//			//系统异常，提示用户稍后重试
//			return "error";
//		}
//		
		return "redirect:toIndex.do";
	}
	@ExceptionHandler
	/**
	 * 异常处理
	 * @param e
	 * @param request
	 * @return
	 */
	public String handlerEx(Exception e,
			HttpServletRequest request){
		System.out.println("handlerEx()");
		if(e instanceof ApplicationException){
			e.printStackTrace();
			request.setAttribute(
					"login_failed",
					e.getMessage());
			return "login";
		}
		return "error";
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	
	@RequestMapping("/checkcode.do")
	/**
	 * 返回验证码图片
	 * 请求处理中如果返回不是String或者ModelAndView
	 * 控制器就不会转发，也不会重定向，怎么做由我们
	 * 自己控制
	 * @param response
	 * @throws IOException
	 */
	public void checkcode(
			HttpServletResponse response,
			HttpSession session) throws IOException{
		Object[] img = ImageUtil.createImage();
		session.setAttribute("code", img[0]);
		BufferedImage image = 
				(BufferedImage)img[1];
		OutputStream output = 
				response.getOutputStream();
		//将验证码图片发送给浏览器
		//jpeg 图灵奖
		ImageIO.write(image, "jpeg", output);
		output.close();
	}
}



























