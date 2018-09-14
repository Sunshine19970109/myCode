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
		 * 1 设置输出字符集
		 * 2 获取uri裁剪，获取请求名称
		 * 		要前不要后
		 * 		离开第一个输入框--请求1
		 * 		离开第二个输入框--请求2
		 * 3 配置Servlet
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
			 * 怎么返回JSON对象
			 * 1 创建对象集合
			 * 2 创建ObjectMapper
			 */
			City c1 = new City("tj","天津");
			City c2 = new City("bj","北京");
			List<City> cs = new ArrayList<City>();
			cs.add(c1);cs.add(c2);
			Area a1 = new Area("xq", "西青区");
			Area a2 = new Area("nk", "南开区");
			Area a3 = new Area("hd", "海淀区");
			Area a4 = new Area("hd", "西城区");
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
			Street s1 = new Street("bjd", "滨江道");
			Street s2 = new Street("jj", "津静公路");
			List<Street> ss = new ArrayList<Street>();
			ss.add(s1);ss.add(s2);
			Street s3 = new Street("rm", "人民路");
			Street s4 = new Street("gam", "广安门大街");
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
