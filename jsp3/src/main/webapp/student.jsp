<%@page import="java.util.Date"%>
<%@page import="javafx.scene.shape.Circle"%>
<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<%@taglib uri="/lhh-tags" prefix="s" %>
<!doctype html>
<html>
	<head >
	  <meta charset="utf-8"/>
	  <title>查询学生</title>
	</head>
<body>
for:<br/>
<%!int fontsize; %>
<%for(fontsize=1;fontsize<=3;fontsize++){ %>
	<font color="green" size="<%=fontsize %>">
		JSP教学；
	</font><br/>
<%} %>

<jsp:include page="date.jsp" flush="true"></jsp:include>
<p>把请求转到另一个页面<br/>
跟引入页面的区别是，这个跳转到另一个，引入是引进来</p>
<%-- <jsp:forward page="date.jsp" /> --%>
<p>8<br/> 以下实例动态定义了XML元素：</p>
<jsp:element name="xmlElement">
	<jsp:attribute name="xmlElementAttr">
		这个指属性值
	</jsp:attribute>
	<jsp:attribute name="id" >
		ele
	</jsp:attribute>
	<jsp:body>
		这个是什么的Html值
	</jsp:body>
</jsp:element>
<script type="text/javascript">
	var xml = document.getElementById("ele");
	alert(xml.xmlElementAttr);
</script>
<!-- 
	定义的xml标签在执行之后会生成标签
	<xmlElement name="这个指属性值">这个是什么html的值</xmlElement>
 -->
<p></p>



<p>在JSP中用Java Bean </p>
<jsp:useBean id="id" class="entity.Student"></jsp:useBean>
<jsp:setProperty property="name" name="id"
			value="Hello.jsp"
			/>
<p>得到值</p>
<jsp:getProperty property="name" name="id"/>		
<br/>			

判断语句:<br/>
	<%! int day = 3; %>
	<p>if...else..例子</p>
	<% if(day==1|day==7){ %>
		<p>今天周末</p>
	<%} else{ %>
		<p>今天不是周末</p>
	<%} %>
	<p>SWITCH...CASE 的例子</p>
	<%
	switch(day){
	case 0:
		out.println("周日");
	case 3:
		out.println("周三");
	default:
		out.println("周五");
	}
	%><br/>
	
	Hello World!<br/>
	<%
	out.println("你的IP地址是: "+request.getRemoteAddr());
	%>
	<%! int i = 10;
		int a,b,c;
	%>
	<%	Circle a = new Circle(2.0);
	%>
	<p>
		今天的日期是:<%=(new Date()).toLocaleString() %>
	</p>


	<!-- 2 JSTL标签 -->
	<!-- 2.1 if标签 -->
	<p>
	<c:if test="${stu.sex=='M' }">男</c:if>
	<c:if test="${stu.sex=='F' }">女</c:if>
	</p>
	<!-- 2.2 choose标签 -->
	<p>
	性别:
	<c:choose>
		<c:when test="${stu.sex=='M' }">男孩子</c:when>
		<c:otherwise>女孩</c:otherwise>
	</c:choose>
	</p>
	<!-- 2.3 forEach标签 -->
	<p>
		<c:forEach var="i" items="${stu.interests }">
			${i }
		</c:forEach>
	</p>
	<!-- 2.4 自定义标签 -->
	<p><s:sysdate format="yyyy-MM-dd"/></p>


	<!-- 1 EL表达式 -->
	<!-- 1.1访问Bean的属性 -->
	<!-- request.getAttribute("stu").getName() -->
	<p>${stu.name}</p>
	<p>年龄:${stu['age'] }</p>
	<!-- id对应getId() -->
	<p>课程:${stu.course.id}</p>
	<!-- EL表达式的取值范围:
	它默认从4个隐含对象内一次取值:
	page->request->session->application 
	取值方式:
		1.直接取(没有重复)
		${stu.name }
		2.指定取值
		${request.getAttribute("stu") }等价于${requestScope.stu}
		scope--范围
	-->
	<p>性别:${requestScope.stu.sex }</p>
	<!-- 1.2可以用来做计算 
		比如:加减乘除，比大小，判断是否为空，判断是否相等-->
	<p>加法:${stu.age+3 }</p>
	<p>乘法:${stu.age*10 }</p>
	<p>比大小:${stu.age>20&&stu.age<30 }</p>
	<p>判断是否为空${empty stu.interests }</p>
	
	<!-- 1.3获取请求参数 -->
	<p>参数:${param.user }</p>
</body>
</html>

















