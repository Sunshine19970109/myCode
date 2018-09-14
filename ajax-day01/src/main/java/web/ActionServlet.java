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
		//��������·�������ݷ���������ò�ͬ��
		//��֧������
		//http://ip:port/ajax-day01/check.do
		//uri=ajax-day01/...
		String uri = 
			request.getRequestURI();
		System.out.println("uri :"+uri);
		//Ϊ�˷����������ȡ������Դ·����һ����
		//����ǰ�棬����������
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
				out.println("�˺��Ѿ�����");
			}else {
				out.println("�˺ſ���ʹ��");
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
