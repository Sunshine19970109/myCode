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
 * 处理器类
 * 1 不用实现Controller
 * 2 方法名不做要求，返回值可以是
 * ModelAndView,也可以是String
 * 3 可以添加多个方法。
 * 4 使用@Controller
 * 5 可以在方法前或者类前添加
 * 		@RequestMapping(相当于HandlerMapping)
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
		//返回视图名
		return	"hello";
	}
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "toLogin";
	}
	@RequestMapping("/Login.do")
	/*
	 * DispatcherServlet在调用处理器的方法之前，
	 * 会利用java反射机制分析方法的结果，比如这儿，
	 * 通过分析，会将request对象传过来(了解)。
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
	 * DispatcherServlet调用处理器方法之前，
	 * 会分析结构，这儿，会调用request对象的方法，
	 * 先获得参数值，然后赋给对应的形参。(了解)
	 * 如果不一致，要@RequestParam注解。
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
	 * DispatcherServlet会将AdminParam
	 * 对象创建好(会将对应的请求参数赋值给这个对象，
	 * 调用set方法，并且会自动进行基本类型的转换)
	 * 有可能类型转换失败
	 */
	public String login3(AdminParam ap){
		System.out.println("login3()");
		String adminCode = ap.getAdminCode();
		System.out.println("adminCode: "+adminCode);
		return "index";
	}
	
	@RequestMapping("/Login4.do")
	/*
	 * 向页面传值的方法一
	 */
	public String login4(AdminParam ap,
			HttpServletRequest request){
		System.out.println("login4()");
		String adminCode = ap.getAdminCode();
		request.setAttribute("adminCode", adminCode);
		//默认情况下，DispatcherServlet
		//会使用转发。
		return "index";
	}
	
	@RequestMapping("/Login5.do")
	public ModelAndView login5(AdminParam ap){
		System.out.println("login5()");
		String adminCode = ap.getAdminCode();
		//step1.将数据添加到Map对象里面
		Map<String,Object> data=
				new HashMap<String,Object>();
		//相当于执行了request.setAttribute
		data.put("adminCode", adminCode);
		//step2.将Map对象添加到ModelAndView
		ModelAndView mav = 
				new ModelAndView("index", data);
		return mav;
	}
	@RequestMapping("/Login6.do")
	/*
	 * 将数据放入ModelMap
	 * 默认转发
	 */
	public String login6(AdminParam ap,
			ModelMap mm){
		System.out.println("login6()");
		String adminCode = ap.getAdminCode();
		//相当于执行了request.setAttribute
		mm.addAttribute("adminCode",adminCode);
		return "index";
	}
	@RequestMapping("/Login7.do")
	/*
	 * DispatcherServlet会分析这个方法的结构
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




















