package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EmpDao;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {
	@Override
	protected void service(
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
		e.setSal(Double.parseDouble(sal));
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
		res.sendRedirect("findEmp");
	}
}



















