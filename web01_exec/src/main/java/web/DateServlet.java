package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1 ��ȡ�������
		//2 ����ҵ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String ds = sdf.format(date);
		String s = new String("<p>"+ds+"</p>");
		//3 ������Ӧ����
		res.setContentType("text/html;charset=utf-8");
		PrintWriter p = res.getWriter();
		p.println(s);
		p.close();
	}
}



















