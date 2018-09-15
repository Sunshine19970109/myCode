<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">

姓名：<input type="text" name="name" id="name"><br>
电话：<input type="text" name="phone" id="phone"><br>
地址：<input type="text" name="address" id="address"><br>
<input type="button" value="显示数据" onclick="showData()">
</body>
<script type="text/javascript">
	//显示数据到文本框中
	function showData(){
		//1.创建xhr对象
		var xhr = new XMLHttpRequest();
		//2.监听事件处理
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				//json格式的字符串
				var values = xhr.responseText;
				//把json字符串转换为json对象
				var obj = JSON.parse(values);
				//以下3个方法，分别给文本框赋值
				document.getElementById("name").value=
					obj.data.name;
				document.getElementById("phone").value=
					obj.data.phone;
				document.getElementById("address").value=
					obj.data.address;
				
				
			}
		}
		//3.open
		xhr.open("get",
		"${pageContext.request.contextPath}/showData.do",true);
		//4.send
		xhr.send();
	}
</script>
</html>












