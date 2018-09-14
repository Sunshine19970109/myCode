package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@ExceptionHandler
	/**
	 * 这是一个异常处理的方法
	 * @param e：处理器方法所抛的异常
	 * @return
	 */
	public String handlerEx(Exception e,
			HttpServletRequest request){
		System.out.println("handleEx");
		if(e instanceof NumberFormatException){
			e.printStackTrace();
			request.setAttribute("msg",
					"亲，请输入正确数字");
			return "error3";
		}else if(e instanceof 
				StringIndexOutOfBoundsException){
			e.printStackTrace();
			request.setAttribute("msg",
					"下标越界啦");
			return "error3";
		}
		
		return "error";
	}
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		Integer.parseInt("123a");
		return "hello";
	}
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2()");
		String str = "abcd";
		str.charAt(10);
		return "hello";
	}
}
