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
			//ģ�����ɼ�ֻ��Ʊ����Ϣ
			//(����json�ַ�������ʽ����)
			
			List<Stock> stocks = 
					new ArrayList<Stock>();
			Random r = new Random();
			for(int i=0;i<3;i++){
				Stock s = new Stock();
				s.setCode("600877"+r.nextInt(10));
				s.setName("�й�����"+r.nextInt(100));
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
			if("�ߺ�".equals(name)){
				System.out.println(name);
				out.println("���ǳƲ�����");
			}else {
				System.out.println("����ʹ��");
				out.println("����ʹ��");
			}
		}else if("/random".equals(action)){
			Random ran = new Random();
			int num = ran.nextInt(100);
			System.out.println(num);
			out.println(num);
		}else if("/getPrice".equals(action)){
			//�������
			String flight= 
				request.getParameter("flight");
			//���ݺ���ŷ��ض�Ӧ������ļ۸�
			if("CA2201".equals(flight)){
				out.println(
					"ͷ�Ȳ�:��2400<br/>�����:��2200");
			}else {
				out.println(
					"ͷ�Ȳ�:��1800<br/>�����:��1600");
			}
			
		}
	}
}
