package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	//ģ��MainServlet.login()
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		//���˺Ŵ���cookie
		//�൱�ڼ�ֵ��name-value
		//cookie��ֻ�ܴ�һ�����ݣ�����ֻ�ܴ��ַ���
		Cookie c1 = new Cookie("user",user);
		//��cookie�浽Ӳ����
		c1.setMaxAge(60*30);
		//��cookie�󶨵�response֮�ϣ�
		//��������������Ӧʱ���Զ�����cookie
		res.addCookie(c1);
		//�ٴ���һ��cookie,��������
		Cookie c2 = new Cookie("city", 
				URLEncoder.encode("����","utf-8"));
		res.addCookie(c2);
		
		//�ٴ���һ��cookie,��������Ч·��
		Cookie c3 = new Cookie("status", "1");
		c3.setPath("/jsp4");
		res.addCookie(c3);
	}
}















