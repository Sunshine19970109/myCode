package controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * ��������
 * 1 ����ʵ��Controller
 * 2 ����������Ҫ�󣬷���ֵ������
 * ModelAndView,Ҳ������String
 * 3 ������Ӷ��������
 * 4 ʹ��@Controller
 * 5 �����ڷ���ǰ������ǰ���
 * 		@RequestMapping(�൱��HandlerMapping)
 * 	http://ip:port/springmvc-day02/demo/hello.do
 * @author dell
 *
 */
@Controller
//@RequestMapping("/demo")
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		//������ͼ��
		return	"hello";
	}
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "toLogin";
	}
	@RequestMapping("/Login.do")
	/*
	 * DispatcherServlet�ڵ��ô������ķ���֮ǰ��
	 * ������java������Ʒ��������Ľ�������������
	 * ͨ���������Ὣrequest���󴫹���(�˽�)��
	 */
	public String login(
			HttpServletRequest req,
			HttpServletResponse res){
		String user = req.getParameter("adminCode");
		String pwd = req.getParameter("pwd");
		System.out.println(user+" :"+pwd);
		System.out.println("login()");
		return "index";
	}
	
	@RequestMapping("/Login2.do")
	/*
	 * DispatcherServlet���ô���������֮ǰ��
	 * ������ṹ������������request����ķ�����
	 * �Ȼ�ò���ֵ��Ȼ�󸳸���Ӧ���βΡ�(�˽�)
	 * �����һ�£�Ҫ@RequestParamע�⡣
	 */
	public String login2(
			@RequestParam("adminCode")
			String adminCode,
			@RequestParam("pwd")
			String pwds){
		System.out.println("adminCode :"+adminCode);
		System.out.println("pwd :"+pwds);
		System.out.println("login2()");
		return "index";
	}
	@RequestMapping("/Login3.do")
	/*
	 * DispatcherServlet�ὫAdminParam
	 * ���󴴽���(�Ὣ��Ӧ�����������ֵ���������
	 * ����set���������һ��Զ����л������͵�ת��)
	 * �п�������ת��ʧ��
	 */
	public String login3(AdminParam ap){
		System.out.println("login3()");
		String adminCode = ap.getAdminCode();
		System.out.println("adminCode: "+adminCode);
		return "index";
	}
	
	@RequestMapping("/Login4.do")
	/*
	 * ��ҳ�洫ֵ�ķ���һ
	 */
	public String login4(AdminParam ap,
			HttpServletRequest request){
		System.out.println("login4()");
		String adminCode = ap.getAdminCode();
		request.setAttribute("adminCode", adminCode);
		//Ĭ������£�DispatcherServlet
		//��ʹ��ת����
		return "index";
	}
	
	@RequestMapping("/Login5.do")
	public ModelAndView login5(AdminParam ap){
		System.out.println("login5()");
		String adminCode = ap.getAdminCode();
		//step1.��������ӵ�Map��������
		Map<String,Object> data=
				new HashMap<String,Object>();
		//�൱��ִ����request.setAttribute
		data.put("adminCode", adminCode);
		//step2.��Map������ӵ�ModelAndView
		ModelAndView mav = 
				new ModelAndView("index", data);
		return mav;
	}
	@RequestMapping("/Login6.do")
	/*
	 * �����ݷ���ModelMap
	 * Ĭ��ת��
	 */
	public String login6(AdminParam ap,
			ModelMap mm){
		System.out.println("login6()");
		String adminCode = ap.getAdminCode();
		//�൱��ִ����request.setAttribute
		mm.addAttribute("adminCode",adminCode);
		return "index";
	}
	@RequestMapping("/Login7.do")
	/*
	 * DispatcherServlet�������������Ľṹ
	 */
	public String login7(AdminParam ap,
			HttpSession session){
		System.out.println("login7()");
		String adminCode = ap.getAdminCode();
		session.setAttribute("adminCode", adminCode);
		return "index";
	}
	@RequestMapping("/Login8.do")
	public String login8(){
		System.out.println("login8()");
		return "redirect:toIndex.do";
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	@RequestMapping("/Login9.do")
	public ModelAndView login9(){
		System.out.println("login9()");
		RedirectView rv = 
				new RedirectView("toIndex.do");
		ModelAndView mav = new ModelAndView(rv);
		return mav;
	}
}




















