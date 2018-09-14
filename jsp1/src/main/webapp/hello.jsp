<%@page import="java.util.Random"%>
<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
 <head>
 	<meta charset="utf-8"/>
 	<title>第1个JSP</title>
 </head>
 <body>
 	<!-- 3 jsp声明 -->
 	<%!
		//定义函数 
		public int getNum(){
 			Random r = new Random();
 			return r.nextInt(100);
 		}
 	%>
 	<ul>
 	  <!-- 1 jsp脚本 -->
 	  <!-- jsp脚本之间可以加标签 
 	  相当于两个java代码之间加的东西-->
 	  
 	  	<!-- 2 jsp表达式 -->
 	  	<!-- jsp表达式可以用来为标签的变量赋值
 	  	生成10个随机数标签 -->
 	  	<%for(int i=0;i<10;i++){ %>
 	  	<li>num+i=<%=getNum() %></li>
 	 	<%} %>
 	</ul>
 	<%@include file="time.jsp" %>
 </body>
</html>
























