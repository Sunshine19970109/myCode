package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpServlet extends HttpServlet {
	private Double salary = 2000.0;
	
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		synchronized (this) {
			salary+=100.0;
		
		
		try {
			//Ä£ÄâÍøÂçÑÓ³Ù
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println(salary);
		pw.close();
		}
 	}
}





























