package com.ysfj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysfj.entity.ResponseResult;
import com.ysfj.entity.User;
import com.ysfj.service.IUserService;
import com.ysfj.service.Impl.UserService;

public class UserServlet extends HttpServlet {
	private static Logger log = null;
	@Override
	public void init() throws ServletException {
		log = Logger.getLogger(UserServlet.class);
		String prefix = this.getServletContext().getRealPath("/");
		String file = this.getInitParameter("log4jLocationConfig");
		System.out.println(prefix+file);
		PropertyConfigurator.configure(prefix+file);
	}
	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 这一句相当于两句
		 * response.setCharacterEncoding("utf-8");  
			response.setHeader("content-type", "text/html;charset=utf-8");  
		 */
		response.setContentType("text/html;charset=utf-8");
		IUserService service = new UserService();
		ObjectMapper mapper = new ObjectMapper();
		String url = request.getRequestURI();
		String[] s = url.split("/");
		String action = s[s.length-1];
		log.debug(action);
		if("findAll.user".equals(action)){
			findAll(request,response,mapper,log,service);
		}else if("deleteUser.user".equals(action)){
			deleteUser(request,response,mapper,log,service);
		}
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response, ObjectMapper mapper, Logger log2,
			IUserService service) {
		ResponseResult<Void> result = null;
		String id = request.getParameter("id");
		try {
			service.deleteUser(Integer.parseInt(id));
			PrintWriter writer = response.getWriter();
			result = new ResponseResult<Void>(1, "删除成功");
			String json = mapper.writeValueAsString(result);
			writer.println(json);
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
		} catch (SQLException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response, ObjectMapper mapper, Logger log2,IUserService service) {
		ResponseResult<List<User>> result = null;
		try {
			PrintWriter writer = response.getWriter();
			List<User> users = service.findAll();
			result = new ResponseResult<List<User>>(1, "查询成功");
			result.setData(users);
			String json = mapper.writeValueAsString(result);
			writer.println(json);
		} catch (IOException e) {
			result = new ResponseResult<List<User>>(0, "查询失败");
			log.error(e.getMessage());
		} catch (SQLException e) {
			result = new ResponseResult<List<User>>(0, "查询失败");
			log.error(e.getMessage());
		}
		
	}
}
