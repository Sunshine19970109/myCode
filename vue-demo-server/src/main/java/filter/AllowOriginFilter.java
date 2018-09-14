package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllowOriginFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		response.setContentType("text/html;charset=utf-8");
		HttpServletResponse response2 = (HttpServletResponse)response;
		HttpServletRequest request2 = (HttpServletRequest)request;
		boolean b =request2.authenticate(response2);
		System.out.println("Boolean--"+b);
		response2.setHeader("Access-Control-Allow-Origin","*");
		response2.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
		response2.setHeader("Access-Control-Max-Age", "3600");
		response2.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
		response2.setHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(request2, response2);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}