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
		//���������ַ���
		request.setCharacterEncoding("utf-8");
		//����response�ı���ʽ���ַ���
		response.setContentType("text/html;charset=utf-8");
		//��ȡ��ӡ���
		PrintWriter out = response.getWriter();
		//��ȡ����
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
							//ƥ��������ʽ--ƴ��json��
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
