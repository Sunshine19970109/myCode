package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

public class ActionServlet extends HttpServlet {
	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String action = 
			uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		System.out.println("action: "+action);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = 
			response.getWriter();
		if("/quoto".equals(action)){
			//模拟生成几只股票的信息
			//(会以json字符串的形式返回)
			
			List<Stock> stocks = 
					new ArrayList<Stock>();
			Random r = new Random();
			for(int i=0;i<3;i++){
				Stock s = new Stock();
				s.setCode("600877"+r.nextInt(10));
				s.setName("中国嘉陵"+r.nextInt(100));
				s.setPrice(r.nextInt(1000));
				stocks.add(s);
				System.out.println(s.getCode());
			}
			ObjectMapper om = 
				new ObjectMapper();
			String jsonStr= 
				om.writeValueAsString(stocks);
			System.out.println(jsonStr);
			out.println(jsonStr);
		}else if("/check".equals(action)){
			String name = request.getParameter("name");
			if("高宏".equals(name)){
				System.out.println(name);
				out.println("该昵称不可用");
			}else {
				System.out.println("可以使用");
				out.println("可以使用");
			}
		}else if("/random".equals(action)){
			Random ran = new Random();
			int num = ran.nextInt(100);
			System.out.println(num);
			out.println(num);
		}else if("/getPrice".equals(action)){
			//读航班号
			String flight= 
				request.getParameter("flight");
			//依据航班号返回对应各航班的价格
			if("CA2201".equals(flight)){
				out.println(
					"头等舱:￥2400<br/>商务舱:￥2200");
			}else {
				out.println(
					"头等舱:￥1800<br/>商务舱:￥1600");
			}
			
		}
	}
}
