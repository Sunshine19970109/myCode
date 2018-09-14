package cn.itcast.action;

public class HelloAction {
	/*
	 * 访问servlet时候，执行service方法
	 * 	-写类继承HttpServlet,重写类里面的方法
	 * 	-在web.xml中配置servlet访问路径
	 * 访问action,每次访问action时候，默认执行名称execute方法
	 * 	-配置action类的访问路径
	 * */
	public String execute(){
		return "ok";
	}
}
















