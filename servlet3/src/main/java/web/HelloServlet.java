package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//获取访问路径
		System.out.println(
				req.getContextPath());///servlet3
		System.out.println(
				req.getServletPath());///hello
		System.out.println(
				req.getRequestURI());///servlet3/hello
		System.out.println(
				req.getRequestURL());
		//http://localhost:8089/servlet3/hello
		//本案例主要演示获取访问路径的方式
		//就不向浏览器输出内容了，但服务器会自动向浏览器做出
		//响应，只是内容为空而已，浏览器看到一片空白
	}
}
















