package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	//在响应之后
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	//在控制器方法执行之后，单是在响应页面之前
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	//在执行控制器方法之前
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object obj) throws Exception {
		Object object = request.getSession().getAttribute("user");
		if(object==null) {
			//没有用户登陆的session重定向
			String path = request.getContextPath()+"/User"+"/showLogin.do";
			response.sendRedirect(path);
			return false;
		}
		//放行
		return true;
	}
	
}
