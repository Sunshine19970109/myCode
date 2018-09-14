package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.CostDao;
import entity.Admin;
import entity.Cost;
import util.ImageUtil;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//��ȡ����·��
		String path = req.getServletPath();
		//���ݹ淶(ͼ)����·��
		if("/findCost.do".equals(path)){
			findCost(req,res);
		}else if("/addCost.do".equals(path)){
			addCost(req,res);
		}else if("/toAddCost.do".equals(path)){
			toAddCost(req,res);
		}else if("/toUpdateCost.do".equals(path)){
			toUpdateCost(req, res);
		}else if("/updateCost.do".equals(path)){
			UpdateCost(req, res);
		}else if("/deleteCost.do".equals(path)){
			deleteCost(req, res);
		}else if("/toLogin.do".equals(path)){
			toLogin(req,res);
		}else if("/toIndex.do".equals(path)){
			toIndex(req,res);
		}else if("/login.do".equals(path)){
			login(req,res);
		}else if("/createImg.do".equals(path)){
			createImg(req,res);
		}
		else{
			throw new RuntimeException("û�����ҳ��");
		}
	}
	//������֤��
	protected void createImg(
			HttpServletRequest req, 
			HttpServletResponse res) throws IOException {
		//������֤�뼰ͼƬ
		Object[] objs = ImageUtil.createImage();
		//����֤�����session
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", objs[0]);
		//��ͼƬ���͸������
		res.setContentType("image/png");
		//��ȡ�ֽ�������������ɷ�����������
		//��Ŀ����ǵ�ǰ���ʵ��Ǹ��������
		BufferedImage img = (BufferedImage)objs[1];
		OutputStream os = res.getOutputStream();
		ImageIO.write(img, "png", os);
		os.close();	
	}
	protected void login(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//���ղ���
		String adminCode = 
				req.getParameter("adminCode");
		String password = 
				req.getParameter("password");
		String code = 
				req.getParameter("code");
		//�����֤��
		HttpSession session= req.getSession();
		
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode(adminCode);
		String imgcode=(String)session.
				getAttribute("imgcode");
		if(code==null||!code.equalsIgnoreCase(imgcode)){
			req.setAttribute("error", "��֤�����");
			req.getRequestDispatcher(
					"WEB-INF/main/login.jsp")
			.forward(req, res);
		}else{
		//��ȡ���еı�����,����һ��ö��
		Enumeration paramNames = req.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String s = (String) paramNames.nextElement();
			String[] paramValues = req.getParameterValues(s);
			System.out.println("������: "+s);
			System.out.println("����ֵ: "+paramValues[0]);
		}
		
		if(a.getAdminCode()==null){
			//�˺Ŵ���
			req.setAttribute("error", "�˺Ŵ���");
			req.getRequestDispatcher(
					"WEB-INF/main/login.jsp")
			.forward(req, res);
		}else if(!a.getPassword().equals(password)){
			//�������
			req.setAttribute("error", "�������");
			req.getRequestDispatcher(
					"WEB-INF/main/login.jsp")
			.forward(req, res);
			
		}else {
			//���˺Ŵ���cookie
			Cookie cookie = new Cookie("user",
					adminCode);
			res.addCookie(cookie);
			//���˺Ŵ���session
			
			session.setAttribute("user", adminCode);
			
			//��֤ͨ��
			res.sendRedirect("toIndex.do");
		}
		}
	}
	
	
	//�򿪵�½ҳ��
	protected void toLogin(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		req.getRequestDispatcher(
				"WEB-INF/main/login.jsp")
		.forward(req, res);
	}
	
	//����ҳ
	protected void toIndex(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		req.getRequestDispatcher(
				"WEB-INF/main/index.jsp")
		.forward(req, res);
	}
	protected void UpdateCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("costId");
		String name = req.getParameter("name");
		String costType = 
				req.getParameter("costType");//�ʷ�����
		String  baseDuration = 
				req.getParameter("baseDuration");//����ʱ��
		String baseCost = req.getParameter("baseCost");//��������
		String unitCost = req.getParameter("unitCost");//��λ����
		String descr  = req.getParameter("descr");
		Cost c = new Cost();
		c.setCostId(Integer.parseInt(id));
		c.setName(name);
		c.setCostType(costType);
		if(baseDuration!=null&&baseDuration.length()>0){
			c.setBaseDuration(Integer.parseInt(baseDuration));
		}
		if(baseCost!=null&&baseCost.length()>0){
			c.setBaseCost(Double.valueOf(baseCost));
		}
		if(unitCost!=null&&unitCost.length()>0){
			c.setUnitCost(Double.valueOf(unitCost));
		}
		c.setDescr(descr);
		CostDao dao = new CostDao();
		dao.update(c);
		res.sendRedirect("findCost.do");
	}
	
	protected void toUpdateCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		CostDao dao = new CostDao();
		Cost c = dao.findById(Integer.parseInt(id));
		req.setAttribute("co", c);
		req.getRequestDispatcher("/WEB-INF/cost/update.jsp")
		.forward(req, res);
	}
	/**
	 * ��ѯ�ʷ�
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//��ѯ���е��ʷ�
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		//������ת����jsp
		req.setAttribute("costs", list);
		//��ǰ:/netctoss/findCost.do
		//Ŀ��:/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp")
		.forward(req, res);
	}
	protected void toAddCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/cost/add.jsp")
		.forward(req, res);
	}
	
	protected void addCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//���մ���Ĳ���
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String type = 
				req.getParameter("costType");//�ʷ�����
		String  duration = 
				req.getParameter("baseDuration");//����ʱ��
		String bcost = req.getParameter("baseCost");//��������
		String unit = req.getParameter("unitCost");//��λ����
		String descr  = req.getParameter("descr");
		
		//���������
		Cost c = new Cost();
		c.setName(name);
		if(duration!=null&&duration.length()>0){
			c.setBaseDuration(Integer.valueOf(duration));
		}
		if(bcost!=null&&bcost.length()>0){
			c.setBaseCost(Double.valueOf(bcost));
		}
		if(unit!=null&&unit.length()>0){
			c.setUnitCost(Double.valueOf(unit));
		}	
		c.setDescr(descr);
		c.setCostType(type);

		CostDao dao = new CostDao();
		dao.save(c);
		//�ض��򵽲�ѯ
		//��ǰ:/netctoss/addCost.do
		//Ŀ��:/netctoss/findCost.do
		res.sendRedirect("findCost.do");
	}
	protected void deleteCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//���ղ�����ȡid
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		System.out.println(id);
//		CostDao dao = new CostDao();
//		dao.delete(Integer.parseInt(id));
//		//ɾ����Ӧ������
//		//�ض���findCost.do
//		res.sendRedirect("findCost.do");
	}
	
}
