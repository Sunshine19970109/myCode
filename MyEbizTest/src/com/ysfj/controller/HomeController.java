package com.ysfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView login(String username,String password){
		if(this.checkParams(new String[]{username,password})){
			//指定要返回的页面为succ.jsp
			ModelAndView view = new ModelAndView("succ");
			//将参数存入view,返回给jsp页面
			view.addObject("username", username);
			view.addObject("password", password);
			return view;
		}
		//参数为空返回home页
		return new ModelAndView("home");
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
