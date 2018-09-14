package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GuolvFilter implements Filter {

	public void destroy() {
		System.out.println("����Guolvfilter");
	}

	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
			System.err.println("�������д�ǰ");
			chain.doFilter(request, response);
			System.out.println("�������дʺ�");
	}

	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("��ʼ��GuolvFilter");
		String city = cfg.getInitParameter("city");
		System.out.println("city: "+city);
	}

}
