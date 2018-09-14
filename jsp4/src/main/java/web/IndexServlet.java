package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	//ģ��MainServlet.toIndex()
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//��������ʷ�����ʱ�����Զ�����
		//֮ǰ�����cookie 
		Cookie[] cookies = req.getCookies();
		if(cookies !=null){
			res.setContentType(
					"text/html;charset=utf-8");
			PrintWriter printWriter = res.getWriter();
			for (Cookie cookie : cookies) {
				String value = URLDecoder.decode(cookie.getValue(),"utf-8");
				printWriter.println(
						cookie.getName()+":"+value);
			}
			printWriter.close();
		}
	}
}














