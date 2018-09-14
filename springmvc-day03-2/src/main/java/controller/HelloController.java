package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@ExceptionHandler
	/**
	 * ����һ���쳣����ķ���
	 * @param e���������������׵��쳣
	 * @return
	 */
	public String handlerEx(Exception e,
			HttpServletRequest request){
		System.out.println("handleEx");
		if(e instanceof NumberFormatException){
			e.printStackTrace();
			request.setAttribute("msg",
					"�ף���������ȷ����");
			return "error3";
		}else if(e instanceof 
				StringIndexOutOfBoundsException){
			e.printStackTrace();
			request.setAttribute("msg",
					"�±�Խ����");
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
