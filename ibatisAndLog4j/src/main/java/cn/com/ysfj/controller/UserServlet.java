package cn.com.ysfj.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.ysfj.entity.ResponseResult;
import cn.com.ysfj.entity.User;
import cn.com.ysfj.service.IUserService;
import cn.com.ysfj.service.Impl.UserService;


public class UserServlet extends HttpServlet {
	//初始化log4j
	private static Logger log = Logger.getLogger(UserServlet.class);
	@Override
	public void init() throws ServletException {
		//获取部署后的项目路径
		String prefix = getServletContext().getRealPath("/");
		//获取配置的相对路径
	    String file = getInitParameter("log4jConfigLocation");
	    System.out.println("prefile : "+prefix);
	    System.out.println("file : "+file);
	    if (file != null) {
	      PropertyConfigurator.configure(prefix + file);     
	    }
	}
	/**
	 * 待考虑问题:
	 * 	1.并发访问
	 *  2.各种为空的测试
	 *  3.异常的正确处理
	 *  4.日志多线程访问是否可以
	 */
	
	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		UserService service = new UserService();
		String url = request.getRequestURI();
		//创建输出json字符串的json对象
		ObjectMapper om = new ObjectMapper();
		
		int index = url.lastIndexOf('/');
		String action = url.substring(index+1,url.length());
		log.debug(action);
		if("findAll.do".equals(action)){
			findAll(request,response,service);
		}else if("deleteUser.do".equals(action)){
			deleteUser(request,response,service);
		}else if("deleteUsers.do".equals(action)){
			deleteUsers(request,response,service,om);
		}else if("findByName.do".equals(action)){
			findByName(request,response,service,om);
		}
	}
	private void findByName(HttpServletRequest request, HttpServletResponse response, UserService service,
			ObjectMapper om) {
		String name  = request.getParameter("name");
		ResponseResult<List<User>> rr = null;
		try {
			List<User> data = service.selectByName(name);
			PrintWriter pw = response.getWriter();
			
			rr = new ResponseResult<List<User>>(1, "查询成功");
			rr.setData(data);
			//html方式输出
			String html ="";
			for (User user : data) {
				html+="<tr>"+
				"<td><input id="+user.getId()+" type='radio' c='0' /></td>"+
				"<td class='userId'>"+user.getId()+"</td>"+
				"<td>"+user.getName()+"</td>"+
				"<td>"+user.getRealName()+"</td>"+
				"<td>"+user.getEmail()+"</td>"+
				"<td>"+user.getAddress()+"</td>"+
				"<td>"+user.getCreateUser()+"</td>"+
				"<td><a onclick='deleteUser(this)'>删除</a></td>"+
				"</tr>";
			}
			pw.println(html);
			//JSON方式输出
//			String dataJSON = om.writeValueAsString(rr);
//			pw.println(dataJSON);
		} catch (SQLException e) {
			log.error(e.getMessage());
			rr = new ResponseResult<List<User>>(0, "查询失败");
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
			rr = new ResponseResult<List<User>>(0, "查询失败");
		} catch (IOException e) {
			log.error(e.getMessage());
			rr = new ResponseResult<List<User>>(0, "查询失败");
		}
	}
	private void deleteUsers(HttpServletRequest request, 
			HttpServletResponse response, UserService service,
			ObjectMapper om) {
		ResponseResult<Integer> result = null;	
		String s = request.getParameter("ids");
		s = s.trim();
		String[] ss = s.split(",");
		Integer[] ids = new Integer[ss.length];
		for (int i = 0; i < ss.length; i++) {
			log.debug(ss[i]);
			ids[i] = Integer.parseInt(ss[i]);
		}
		PrintWriter pw = null;
		try {
			service.deleteUsers(ids);
			result = new ResponseResult<Integer>(1,"删除成功");
			pw = response.getWriter();
			pw.println(om.writeValueAsString(result));
		} catch (SQLException e) {
			result = new ResponseResult<Integer>(0,"删除失败");
			log.error(e.getMessage());
		} catch (IOException e) {
			result = new ResponseResult<Integer>(0,"删除失败");
			log.error(e.getMessage());
		}
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response, UserService service) {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		log.debug("删除");
		String id= request.getParameter("id");
		try {
			service.deleteById(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}
	/**
	 * 查询所有的用户
	 * @param request
	 * @param response
	 * @param service
	 */
	private void findAll(HttpServletRequest request, 
			HttpServletResponse response,IUserService service) {
		PrintWriter pw = null;
		try {
			List<User> users = service.findAll();
			ObjectMapper mapper = new ObjectMapper();
			String lists = mapper.writeValueAsString(users);
			pw = response.getWriter();
			pw.println(lists);
			log.debug(lists);
		} catch (SQLException e) {	
			log.error(e.getMessage());
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}finally {
			pw.close();
		}
	}

}
