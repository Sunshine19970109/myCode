package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Area;
import bean.City;
import bean.Street;

public class CityServlet extends HttpServlet {
	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1 ��������ַ���
		 * 2 ��ȡuri�ü�����ȡ��������
		 * 		Ҫǰ��Ҫ��
		 * 		�뿪��һ�������--����1
		 * 		�뿪�ڶ��������--����2
		 * 3 ����Servlet
		 */
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String uri  = request.getRequestURI();
		String action = uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		PrintWriter out = response.getWriter();
		if("/city".equals(action)){
			System.err.println(action);
			/*
			 * ��ô����JSON����
			 * 1 �������󼯺�
			 * 2 ����ObjectMapper
			 */
			City c1 = new City("tj","���");
			City c2 = new City("bj","����");
			List<City> cs = new ArrayList<City>();
			cs.add(c1);cs.add(c2);
			Area a1 = new Area("xq", "������");
			Area a2 = new Area("nk", "�Ͽ���");
			Area a3 = new Area("hd", "������");
			Area a4 = new Area("hd", "������");
			List<Area> as = new ArrayList<Area>();
			List<Area> as2 = new ArrayList<Area>();
			as.add(a1);as.add(a2);as2.add(a3);as2.add(a4);
			String city = request.getParameter("city");
			ObjectMapper om = new ObjectMapper();
			if("bj".equals(city)){
				String bj = om.writeValueAsString(as2);
				System.out.println(bj);
				out.println(bj);
			}else if("tj".equals(city)){
				String tj = om.writeValueAsString(as);
				System.out.println(tj);
				out.println(tj);
			}
		}else if("/street".equals(action)){
			System.out.println(action);
			Street s1 = new Street("bjd", "������");
			Street s2 = new Street("jj", "�򾲹�·");
			List<Street> ss = new ArrayList<Street>();
			ss.add(s1);ss.add(s2);
			Street s3 = new Street("rm", "����·");
			Street s4 = new Street("gam", "�㰲�Ŵ��");
			List<Street> ss1 = new ArrayList<Street>();
			ss1.add(s3);ss1.add(s4);
			String area  = request.getParameter("area");
			ObjectMapper om = new ObjectMapper();
			if("xq".equals(area)){
				String s = om.writeValueAsString(ss);
				out.println(s);
			}else if("hd".equals(area)){
				String s = om.writeValueAsString(ss1);
				out.println(s);
			}
		}
	}
}
