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
		//将参数转型
		HttpServletRequest req = 
				(HttpServletRequest)request;
		HttpServletResponse res =
				(HttpServletResponse)response;
		//有几个请求不需要过滤，这里需要排除
		String[] paths =new String[]{
			"/toLogin.do",
			"/login.do",
			"/createImg.do"
		};
		String current = req.getServletPath();
		for (int i = 0; i < paths.length; i++) {
			if(paths[i].equals(current)){
		//如果当前路径等于不许要过滤的路径，放行
				chain.doFilter(req, res);
				return;
			}
		}
		//从session中获取账号
		HttpSession session = 
				req.getSession();
		Object user = session.getAttribute("user");
		//判断用户是否为空
		if(user==null){
			//没登录，跳转到登陆页面
			res.sendRedirect(
					req.getContextPath()+"/toLogin.do");
		}else{
			//已经登陆请求继续执行
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
