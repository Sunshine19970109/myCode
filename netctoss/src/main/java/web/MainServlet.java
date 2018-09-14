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
		//获取访问路径
		String path = req.getServletPath();
		//根据规范(图)处理路径
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
			throw new RuntimeException("没有这个页面");
		}
	}
	//生成验证码
	protected void createImg(
			HttpServletRequest req, 
			HttpServletResponse res) throws IOException {
		//生成验证码及图片
		Object[] objs = ImageUtil.createImage();
		//将验证码存入session
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", objs[0]);
		//将图片发送给浏览器
		res.setContentType("image/png");
		//获取字节输出流，该流由服务器创建，
		//其目标就是当前访问的那个浏览器。
		BufferedImage img = (BufferedImage)objs[1];
		OutputStream os = res.getOutputStream();
		ImageIO.write(img, "png", os);
		os.close();	
	}
	protected void login(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//接收参数
		String adminCode = 
				req.getParameter("adminCode");
		String password = 
				req.getParameter("password");
		String code = 
				req.getParameter("code");
		//检查验证码
		HttpSession session= req.getSession();
		
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode(adminCode);
		String imgcode=(String)session.
				getAttribute("imgcode");
		if(code==null||!code.equalsIgnoreCase(imgcode)){
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher(
					"WEB-INF/main/login.jsp")
			.forward(req, res);
		}else{
		//读取所有的表单参数,返回一个枚举
		Enumeration paramNames = req.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String s = (String) paramNames.nextElement();
			String[] paramValues = req.getParameterValues(s);
			System.out.println("参数名: "+s);
			System.out.println("参数值: "+paramValues[0]);
		}
		
		if(a.getAdminCode()==null){
			//账号错误
			req.setAttribute("error", "账号错误");
			req.getRequestDispatcher(
					"WEB-INF/main/login.jsp")
			.forward(req, res);
		}else if(!a.getPassword().equals(password)){
			//密码错误
			req.setAttribute("error", "密码错误");
			req.getRequestDispatcher(
					"WEB-INF/main/login.jsp")
			.forward(req, res);
			
		}else {
			//将账号存入cookie
			Cookie cookie = new Cookie("user",
					adminCode);
			res.addCookie(cookie);
			//将账号存入session
			
			session.setAttribute("user", adminCode);
			
			//验证通过
			res.sendRedirect("toIndex.do");
		}
		}
	}
	
	
	//打开登陆页面
	protected void toLogin(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		req.getRequestDispatcher(
				"WEB-INF/main/login.jsp")
		.forward(req, res);
	}
	
	//打开主页
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
				req.getParameter("costType");//资费类型
		String  baseDuration = 
				req.getParameter("baseDuration");//基本时长
		String baseCost = req.getParameter("baseCost");//基本费用
		String unitCost = req.getParameter("unitCost");//单位费用
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
	 * 查询资费
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//查询所有的资费
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		//将请求转发到jsp
		req.setAttribute("costs", list);
		//当前:/netctoss/findCost.do
		//目标:/netctoss/WEB-INF/cost/find.jsp
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
		//接收传入的参数
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String type = 
				req.getParameter("costType");//资费类型
		String  duration = 
				req.getParameter("baseDuration");//基本时长
		String bcost = req.getParameter("baseCost");//基本费用
		String unit = req.getParameter("unitCost");//单位费用
		String descr  = req.getParameter("descr");
		
		//保存该数据
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
		//重定向到查询
		//当前:/netctoss/addCost.do
		//目标:/netctoss/findCost.do
		res.sendRedirect("findCost.do");
	}
	protected void deleteCost(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		//接收参数获取id
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		System.out.println(id);
//		CostDao dao = new CostDao();
//		dao.delete(Integer.parseInt(id));
//		//删除对应的数据
//		//重定向到findCost.do
//		res.sendRedirect("findCost.do");
	}
	
}
