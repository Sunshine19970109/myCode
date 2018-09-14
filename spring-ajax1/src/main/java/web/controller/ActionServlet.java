package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//设置请求字符集
		request.setCharacterEncoding("utf-8");
		//设置response文本格式，字符集
		response.setContentType("text/html;charset=utf-8");
		//获取打印输出
		PrintWriter out = response.getWriter();
		//获取请求
		String uri = request.getRequestURI();
		String action = uri.substring(
			uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/search".equals(action)){
			String key = request.getParameter("search-text");
			if(key!=null){
				if(key.length()!=0){
					String json = "[";
					String[] alls = {"bike","byebye","beat","be","bing"};
					for (int i = 0; i < alls.length; i++) {
						if(alls[i].startsWith(key)){
							//匹配正则表达式--拼接json串
							json+="\""+alls[i]+"\""+",";
						}
					}
					json=json.substring(0, json.length()-1>0?json.length()-1:1);
					System.out.println(json);
					out.println(json);
				}
			}
		}
		out.close();
	}
}
