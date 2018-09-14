package com.ysfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HomeController {
	/**
	 * 用户登录
	 * 可以增加
	 * method=RequestMethod.POST
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login.html")
	public ModelAndView login(){
		System.out.println("login.html");
//		if(this.checkParams(new String[]{username,password})){
//			//指定要返回的页面为succ.jsp
//			ModelAndView view = new ModelAndView("succ");
//			//将参数存入view,返回给jsp页面
//			view.addObject("username", username);
//			view.addObject("password", password);
//			return view;
//		}
//		//参数为空返回home页
		return new ModelAndView("succ");
	}
	/***
	 * 验证参数是否为空
	 * @param params
	 * @return
	 */
	private boolean checkParams(String[] params){
		for(String param:params){
			if(param==""||param==null||param.isEmpty()){
				return false;
			}
		}
		return true;
	}
}
