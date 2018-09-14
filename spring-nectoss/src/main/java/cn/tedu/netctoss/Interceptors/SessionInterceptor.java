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
		//��session������ȡ�ض�������
		Object obj = 
				session.getAttribute("admin");
		if(obj==null){
			//��ȡ�������ݣ�˵��û�е�¼
			//�ض��򵽵�½
			response.sendRedirect("toLogin.do");
			return false;
		}
		//�ܹ���ȡ����
		return true;
	}

}
