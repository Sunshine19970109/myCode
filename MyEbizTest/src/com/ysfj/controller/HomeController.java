package com.ysfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView login(String username,String password){
		if(this.checkParams(new String[]{username,password})){
			//ָ��Ҫ���ص�ҳ��Ϊsucc.jsp
			ModelAndView view = new ModelAndView("succ");
			//����������view,���ظ�jspҳ��
			view.addObject("username", username);
			view.addObject("password", password);
			return view;
		}
		//����Ϊ�շ���homeҳ
		return new ModelAndView("home");
	}
	/***
	 * ��֤�����Ƿ�Ϊ��
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
