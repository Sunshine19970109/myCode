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
		System.out.println("销毁LogFilter");
	}
	/**
	 * 公共的业务在此处实现
	 */
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("在前面记日志");
		//让请求继续执行，放行，继续执行
		//filter就像一个管家一样拦截
		chain.doFilter(request, response);
		System.out.println("在后面记日志");
	}
	
	/**
	 * 和servlet一样可以为filter提供初始化数据
	 * 初始化数据在web.xml的配置文件中
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始LogFilter");
	}

}
