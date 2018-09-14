<!-- 
	pageEncoding:声明jsp文件的编码
	contentType:声明此jsp向浏览器输出的内容格式
 -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page pageEncoding="utf-8"
	contentType="text/html"%>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
	String s = sdf.format(date);
%>
<p>
	<%=s %>
</p>