package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet{

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//1 ʹ��request������������
		//1 ������(3)
		System.out.println(
				"Э������:"+req.getProtocol());
		System.out.println(
				"����·��:"+req.getServletPath());
		System.out.println(
				"����ʽ:"+req.getMethod());
		//2 ��Ϣͷ	
		//�������ǰ��ռ�ֵ�Եķ�ʽ�洢��
		//Enumeration��һ�����ϵĵ�������
		//���÷���Iterator����
		Enumeration<String> e =
				req.getHeaderNames();
		while(e.hasMoreElements()){
			String key = e.nextElement();
			String value = req.getHeader(key);
			System.out.println(
					key+" : "+value);
		}
		
		//3 ʵ������
		//�����������û����������������������ݣ����永����ʾ
		
		//2 ʹ��response������Ӧ����
		//1)״̬��--������ͨ���ɷ�������д
		//��ȡ��������ʱ��
		Date date = new Date();
		SimpleDateFormat sdf = 
				new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		//2)��Ϣͷ
		//�󲿷ֵ���Ϣͷ�����ɷ������Զ���д
		//ֻ��contentType������������д
		//��ʱ��ƴ��һ����ҳ������������
		//����������������͵���ʲô���͵�����
		res.setContentType("text/html");
		//��ȡ�����������ָ���Ŀ���������
		PrintWriter w = res.getWriter();
		
		//3)��������
		//����������������͵ľ������ݣ�
		//�������������ҳ����ʵ������
		//�˴�͵����ƴһ���򻯰���ҳ
		w.println("<p>"+now+"</p>");
		//�ر���
		w.close();
	}

}















