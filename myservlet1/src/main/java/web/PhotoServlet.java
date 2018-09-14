package web;


import java.io.IOException;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class PhotoServlet extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Random r = new Random();
		int num = r.nextInt(100);
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<p><img src='resources/images/01.jpg'/></p>");
		pw.close();		
	}
	
}
