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
		//模拟查询学生
		Student s = new Student();
		s.setName("zhangsan");
		s.setSex("M");
		s.setAge(25);
		s.setInterests(
				new String[]{"篮球","足球","排球"});
		Course c = new Course();
		c.setId(1);
		c.setName("java");
		c.setDays(85);
		s.setCourse(c);
		//将数据绑定到request上,前面是名字，后面是用Object
		//接收，所以所有的对象都可以传进来
		req.setAttribute("stu", s);
		req.getRequestDispatcher(
				"student.jsp").forward(req, res);
	}
}





















