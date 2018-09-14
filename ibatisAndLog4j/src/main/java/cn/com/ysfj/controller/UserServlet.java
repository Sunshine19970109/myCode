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
	//��ʼ��log4j
	private static Logger log = Logger.getLogger(UserServlet.class);
	@Override
	public void init() throws ServletException {
		//��ȡ��������Ŀ·��
		String prefix = getServletContext().getRealPath("/");
		//��ȡ���õ����·��
	    String file = getInitParameter("log4jConfigLocation");
	    System.out.println("prefile : "+prefix);
	    System.out.println("file : "+file);
	    if (file != null) {
	      PropertyConfigurator.configure(prefix + file);     
	    }
	}
	/**
	 * ����������:
	 * 	1.��������
	 *  2.����Ϊ�յĲ���
	 *  3.�쳣����ȷ����
	 *  4.��־���̷߳����Ƿ����
	 */
	
	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		UserService service = new UserService();
		String url = request.getRequestURI();
		//�������json�ַ�����json����
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
			
			rr = new ResponseResult<List<User>>(1, "��ѯ�ɹ�");
			rr.setData(data);
			//html��ʽ���
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
				"<td><a onclick='deleteUser(this)'>ɾ��</a></td>"+
				"</tr>";
			}
			pw.println(html);
			//JSON��ʽ���
//			String dataJSON = om.writeValueAsString(rr);
//			pw.println(dataJSON);
		} catch (SQLException e) {
			log.error(e.getMessage());
			rr = new ResponseResult<List<User>>(0, "��ѯʧ��");
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
			rr = new ResponseResult<List<User>>(0, "��ѯʧ��");
		} catch (IOException e) {
			log.error(e.getMessage());
			rr = new ResponseResult<List<User>>(0, "��ѯʧ��");
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
			result = new ResponseResult<Integer>(1,"ɾ���ɹ�");
			pw = response.getWriter();
			pw.println(om.writeValueAsString(result));
		} catch (SQLException e) {
			result = new ResponseResult<Integer>(0,"ɾ��ʧ��");
			log.error(e.getMessage());
		} catch (IOException e) {
			result = new ResponseResult<Integer>(0,"ɾ��ʧ��");
			log.error(e.getMessage());
		}
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response, UserService service) {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		log.debug("ɾ��");
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
	 * ��ѯ���е��û�
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
