<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		1.method=post
		${pageContext.request.contextPath} }
	 -->
	<form  action="${pageContext.request.contextPath}/upload/uploadFile.do" method="post" enctype="multipart/form-data">
		请选中文件:
		<input type="file" name="file" id="file"><br/>
		<input type="submit" value="上传">
	</form>
</body>
</html>