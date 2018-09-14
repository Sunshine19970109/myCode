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
		//��ȡ��֤��
		String code = request.getParameter("code");
		String sCode = (String)session.getAttribute("code");
		if(code==null||!sCode.equalsIgnoreCase(code)){
			request.setAttribute("codeError", "��֤�����");
			System.out.println("��֤�����");
			return "login";
		}
		//��ȡ�˺�����
		String adminCode = 
				request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		
		System.err.println("adminCode : "+adminCode);
		System.out.println("login()");
//		//����ҵ����ṩ�ķ���
//		try {
			Admin admin = loginService.checkLogin(adminCode, pwd);
			//��¼�ɹ�����һЩ���ݰ󶨵�session������
			session.setAttribute("admin", admin);
//		} catch (Exception e) {
//			e.printStackTrace();
//			if(e instanceof ApplicationException){
//				//Ӧ���쳣����ȷ��ʾ�û�
//				/*
//				 * getMessage�����̳���
//				 * RuntimeException,������
//				 * ����쳣��������Ϣ��
//				 */
//				request.setAttribute(
//						"login_failed",
//						e.getMessage());
//				return "login";
//			}
//			//ϵͳ�쳣����ʾ�û��Ժ�����
//			return "error";
//		}
//		
		return "redirect:toIndex.do";
	}
	@ExceptionHandler
	/**
	 * �쳣����
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
	 * ������֤��ͼƬ
	 * ��������������ز���String����ModelAndView
	 * �������Ͳ���ת����Ҳ�����ض�����ô��������
	 * �Լ�����
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
		//����֤��ͼƬ���͸������
		//jpeg ͼ�齱
		ImageIO.write(image, "jpeg", output);
		output.close();
	}
}



























