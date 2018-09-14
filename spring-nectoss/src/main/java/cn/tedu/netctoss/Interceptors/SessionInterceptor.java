package cn.tedu.netctoss.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object arg2, ModelAndView arg3)
			throws Exception {
		

	}

	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object arg2) throws Exception {
		System.out.println("SessionIntercetor's preHandle()");
		HttpSession session=
				request.getSession();
		//从session对象中取特定的数据
		Object obj = 
				session.getAttribute("admin");
		if(obj==null){
			//收取不到数据，说明没有登录
			//重定向到登陆
			response.sendRedirect("toLogin.do");
			return false;
		}
		//能够获取数据
		return true;
	}

}
