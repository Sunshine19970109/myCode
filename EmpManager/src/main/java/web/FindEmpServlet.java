package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class FindEmpServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1 接收参数
		//2 业务处理
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//3 发送响应
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		//当前:/EmpManager/findEmp
		//目标:/EmpManager/add_emp.html
		pw.println("<a href='add_emp.html'>增加</a>");
		pw.println("<table border='1' cellspacing='0' width='30%'>");
		pw.println(" <tr>");
		pw.println(" 	<td>编号</td>");
		pw.println(" 	<td>姓名</td>");
		pw.println(" 	<td>职位</td>");
		pw.println(" 	<td>薪资</td>");
		if(list!=null){
			for (Emp e : list) {
				pw.println(" <tr>");
				pw.println(" 	<td>"+e.getEmpno()+"</td>");
				pw.println(" 	<td>"+e.getEname()+"</td>");
				pw.println(" 	<td>"+e.getJob()+"</td>");
				pw.println(" 	<td>"+e.getSal()+"</td>");
				pw.println(" </tr>");
			}
		}
		pw.println(" </tr>");
		pw.println("</table>");
		pw.close();
	}
}

















