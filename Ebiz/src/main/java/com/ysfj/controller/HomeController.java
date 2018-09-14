package com.ysfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HomeController {
	/**
	 * �û���¼
	 * ��������
	 * method=RequestMethod.POST
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login.html")
	public ModelAndView login(){
		System.out.println("login.html");
//		if(this.checkParams(new String[]{username,password})){
//			//ָ��Ҫ���ص�ҳ��Ϊsucc.jsp
//			ModelAndView view = new ModelAndView("succ");
//			//����������view,���ظ�jspҳ��
//			view.addObject("username", username);
//			view.addObject("password", password);
//			return view;
//		}
//		//����Ϊ�շ���homeҳ
		return new ModelAndView("succ");
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
