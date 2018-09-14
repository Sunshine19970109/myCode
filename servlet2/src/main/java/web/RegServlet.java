package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//���÷���3���POST������������
		req.setCharacterEncoding("utf-8");
		
		//���������һ������
		//1 ���ղ���
		String name = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String[] interests =
				req.getParameterValues("interest");
		//���÷���1�����������
//		byte[] bs = name.getBytes("iso8859-1");
//		name = new String(bs, "UTF-8");
		
		//2 ����ҵ��
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests!=null){
			for (String interest : interests) {
				System.out.println(interest);
			}
		}
		//3 ������Ӧ
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<p>ok,"+name+"</P>");
		pw.close();
	}
}














