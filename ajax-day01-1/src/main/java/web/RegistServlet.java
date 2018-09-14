package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet{

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("uri: "+uri);
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		System.out.println("action: "+action);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		if("/check".equals(action)){
			String admin = request.getParameter("adminCode");
			System.out.println("adminCode: "+admin);
			if("king".equals(admin)){
				writer.println("账号已存在");
			}else {
				writer.println("账号可以使用");
			}
		}
		writer.close();
	}
	
}
