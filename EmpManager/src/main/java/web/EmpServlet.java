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
 * �����淶:
 * ��ѯԱ��:/find.emp
 * ����Ա��:/add.emp
 * getServletPath()
 * @author dell
 *
 */
public class EmpServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//��ȡ�������
		//����ҵ��
		//��Ӧ�ظ�
		
		//�жϷ���·������������
		String path = req.getServletPath();
		if("/find.emp".equals(path)){
			findEmp(req,res);
		}else if("/add.emp".equals(path)){
			addEmp(req,res);
		}else {
			throw new RuntimeException("���޴�ҳ");
		}
		
	}
	private void findEmp(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1 ���ղ���
		//2 ҵ����
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//3 ������Ӧ
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		//��ǰ:/EmpManager/findEmp
		//Ŀ��:/EmpManager/add_emp.html
		pw.println("<a href='add_emp.html'>����</a>");
		pw.println("<table border='1' cellspacing='0' width='30%'>");
		pw.println(" <tr>");
		pw.println(" 	<td>���</td>");
		pw.println(" 	<td>����</td>");
		pw.println(" 	<td>ְλ</td>");
		pw.println(" 	<td>н��</td>");
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
		//����post��ʽ���յ����ݸ�ʽ
		req.setCharacterEncoding("utf-8");
		//���ղ���
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//2 ����Ա������
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		e.setSal(Double.valueOf(sal));
		new EmpDao().save(e);
		//������Ӧ
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter p = res.getWriter();
//		p.println("<p>����ɹ�</p>");
//		p.close();
		//�ض��򵽲�ѯҳ�棬��
		//����������Լ�ȥ���ʲ�ѯҳ�档
		//��ǰ:/EmpManager/addEmp
		//Ŀ��:/EmpManager/findEmp
		res.sendRedirect("find.emp");
		
	}
}
















