package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
	
	}

	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		//������ת��
		HttpServletRequest req = 
				(HttpServletRequest)request;
		HttpServletResponse res =
				(HttpServletResponse)response;
		//�м���������Ҫ���ˣ�������Ҫ�ų�
		String[] paths =new String[]{
			"/toLogin.do",
			"/login.do",
			"/createImg.do"
		};
		String current = req.getServletPath();
		for (int i = 0; i < paths.length; i++) {
			if(paths[i].equals(current)){
		//�����ǰ·�����ڲ���Ҫ���˵�·��������
				chain.doFilter(req, res);
				return;
			}
		}
		//��session�л�ȡ�˺�
		HttpSession session = 
				req.getSession();
		Object user = session.getAttribute("user");
		//�ж��û��Ƿ�Ϊ��
		if(user==null){
			//û��¼����ת����½ҳ��
			res.sendRedirect(
					req.getContextPath()+"/toLogin.do");
		}else{
			//�Ѿ���½�������ִ��
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
