package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	public void destroy() {
		System.out.println("����LogFilter");
	}
	/**
	 * ������ҵ���ڴ˴�ʵ��
	 */
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("��ǰ�����־");
		//���������ִ�У����У�����ִ��
		//filter����һ���ܼ�һ������
		chain.doFilter(request, response);
		System.out.println("�ں������־");
	}
	
	/**
	 * ��servletһ������Ϊfilter�ṩ��ʼ������
	 * ��ʼ��������web.xml�������ļ���
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼLogFilter");
	}

}
