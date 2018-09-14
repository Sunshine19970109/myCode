package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Student;

public class FindStudentServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//ģ���ѯѧ��
		Student s = new Student();
		s.setName("zhangsan");
		s.setSex("M");
		s.setAge(25);
		s.setInterests(
				new String[]{"����","����","����"});
		Course c = new Course();
		c.setId(1);
		c.setName("java");
		c.setDays(85);
		s.setCourse(c);
		//�����ݰ󶨵�request��,ǰ�������֣���������Object
		//���գ��������еĶ��󶼿��Դ�����
		req.setAttribute("stu", s);
		req.getRequestDispatcher(
				"student.jsp").forward(req, res);
	}
}





















