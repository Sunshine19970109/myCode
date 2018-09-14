package web;

import java.io.IOException;
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
		//��ѯ����Ա��
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//�����ݰ󶨵�request��
		req.setAttribute("emps", list);
		//������ת����emp_list.jsp
		//��ǰ:/jsp2/findEmp
		//Ŀ��:/jsp2/emp_list.jsp2
		req.getRequestDispatcher(
				"emp_list.jsp")
		.forward(req, res);
	}
}
















