package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		//�״ε���sessionʱ���������Զ���
		//��ǰ���ʵ����������һ��session
		//��session��jsp����������֮һ
		//getSession(true);Ĭ��Ϊtrue,û�лᴴ����
		HttpSession session = req.getSession();
		//session�п��Դ��������͵�����
		session.setAttribute("user", user);
		//��������Ӧʱ���������´���:
//		Cookie c = new Cookie(
//				"JSESSIONID", session.getId());
	//	c.setPath(request.getContextPath());
	//	response.addCookie(c);
		session.getId();
	}
}













