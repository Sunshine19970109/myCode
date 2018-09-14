<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示城市</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" width="60%">
		<caption>
			城市信息列表
		</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>	
		<c:forEach items="${allCity }" var="i">
		<tr>
			<td>
				<c:out value="${i.getId() }"/>
			</td>
			<td>
				<c:out value="${i.getName() }"/>
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>