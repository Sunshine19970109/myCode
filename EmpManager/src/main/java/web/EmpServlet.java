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
/**
 * 开发规范:
 * 查询员工:/find.emp
 * 增加员工:/add.emp
 * getServletPath()
 * @author dell
 *
 */
public class EmpServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//读取请求参数
		//处理业务
		//响应回复
		
		//判断访问路径并处理请求
		String path = req.getServletPath();
		if("/find.emp".equals(path)){
			findEmp(req,res);
		}else if("/add.emp".equals(path)){
			addEmp(req,res);
		}else {
			throw new RuntimeException("查无此页");
		}
		
	}
	private void findEmp(
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
	private void addEmp(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//设置post方式接收的数据格式
		req.setCharacterEncoding("utf-8");
		//接收参数
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//2 保存员工数据
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		e.setSal(Double.valueOf(sal));
		new EmpDao().save(e);
		//发送响应
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter p = res.getWriter();
//		p.println("<p>保存成功</p>");
//		p.close();
		//重定向到查询页面，即
		//建议浏览器自己去访问查询页面。
		//当前:/EmpManager/addEmp
		//目标:/EmpManager/findEmp
		res.sendRedirect("find.emp");
		
	}
}
















