package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends
	HttpServlet{

	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()");
		//分析请求路径，依据分析结果调用不同的
		//分支来处理
		//http://ip:port/ajax-day01/check.do
		//uri=ajax-day01/...
		String uri = 
			request.getRequestURI();
		System.out.println("uri :"+uri);
		//为了方便分析，截取请求资源路径的一部分
		//包含前面，不包含后面
		String action = 
			uri.substring(
					uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		System.out.println("action: "+action);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if("/check".equals(action)){
			String adminCode = 
				request.getParameter("adminCode");
			System.out.println("adminCode:"+adminCode);
			if("king".equals(adminCode)){
				out.println("账号已经存在");
			}else {
				out.println("账号可以使用");
			}
		}
		else if("/random".equals(action)){
			Random ran = new Random();
			int num = ran.nextInt(100);
			System.out.println(num);
			out.println(num);
		}
	}

}
