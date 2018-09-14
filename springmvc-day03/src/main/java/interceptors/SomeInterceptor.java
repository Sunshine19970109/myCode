package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor {
	/**
	 * ���ִ�еķ���
	 * arg3��Controller���׳����쳣
	 */
	public void afterCompletion(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");

	}
	/**
	 * Controller�ķ����Ѿ�ִ�����
	 * ��׼����ModelAndView���ظ�DispatcherServlet
	 * ֮ǰ��ִ��postHandler�����������ڸ÷������棬
	 * �޸Ĵ�����(ModelAndView)
	 */
	public void postHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle()");
		
	}
	/**
	 * DispatcherServlet���յ�����֮��
	 * ���ȵ���preHandler����������÷����ķ���ֵ
	 * ��true,�����������ã�
	 * �������ֵ��false,���ж�����
	 * ע:
	 * 	DispatcherServlet,�������Լ�
	 * Controller�Ṳ��ͬһ��request,response
	 * arg2��Controller�ķ�������
	 */
	public boolean preHandle(
			HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}

}
