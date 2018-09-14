$(function(){
	
	//显示页面的时候，显示所有用户
	$.ajax({
		url  : "findAll.do",
		type : 'post',
		dataType : 'json',
		success:function(users){
			for(var i=0;i<users.length;i++){
				$("#usersTable>tbody").append(
					'<tr>'+
					'<td><input id='+users[i].id+' type="radio" onclick="changeState(this)" /></td>'+
					'<td class="userId">'+users[i].id+'</td>'+
					'<td>'+users[i].name+'</td>'+
					'<td>'+users[i].realName+'</td>'+
					'<td>'+users[i].email+'</td>'+
					'<td>'+users[i].address+'</td>'+
					'<td>'+users[i].createTime+'</td>'+
					'<td><a onclick="deleteUser(this)">删除</a></td>'+
					'</tr>'
				);
			}
			
		},
		error:function(){
			console.log("错误");
		}
	});
	//批量删除
	$("#deleteMany").click(function(){
		console.log("批量删除按钮点击");
		deleteUsers();
	});
	//点击全选
	$("#selectAll").click(function(){
		console.log("selectAll");
		selectAll();
	});
	//使用用户名进行模糊查询
	$("#select").click(function(){
		//console.log("select");
		findByName();
	});
	//点击切换按钮的选中状态
	
});

function findByName(){
	var name = $("#username").val();
	console.log(name);
	$.get(
		"findByName.do",
		"name="+name,
		function(obj){
			//var users = obj.data;
			$("#usersTable>tbody").html(obj);
			
			//JSON方式
//			for(var i=0;i<users.length;i++){
//				$("#usersTable>tbody").append(
//					'<tr>'+
//					'<td><input id='+users[i].id+' type="radio" c="0" /></td>'+
//					'<td class="userId">'+users[i].id+'</td>'+
//					'<td>'+users[i].name+'</td>'+
//					'<td>'+users[i].realName+'</td>'+
//					'<td>'+users[i].email+'</td>'+
//					'<td>'+users[i].address+'</td>'+
//					'<td>'+users[i].createTime+'</td>'+
//					'<td><a onclick="deleteUser(this)">删除</a></td>'+
//					'</tr>'
//				);
//			}
		},
		'HTML'
	);
}
//修改radio状态，点一次变化一次
function changeState(obj){
	console.log(obj.checked);
	if(obj.c==1){
		console.log("1");
		obj.checked=false;
		obj.c=0;
		console.log(obj.checked);
	}else{
		obj.c=1;
	}
}
//点击全选
function selectAll(){
	if($("#select")[0].checked){
		console.log("checked");
		$("#select").attr("checked", false);
		console.log($("#select")[0].checked);
		var radios = $("input:radio");
		for(var i=0;i<radios.length;i++){
			console.log("radios1");
			radios[i].checked=false;
		}
	}else{
		var radios = $("input:radio");
		for(var i=0;i<radios.length;i++){
			console.log("radios2");
			radios[i].checked=true;
		}
		$("#select")[0].checked=true;
		console.log($("#select")[0].checked);
	}
	
}

//批量删除http://localhost:8089/ibatisAndLog4j
// /web/deleteUsers.do?ids=19,20
function deleteUsers(){
	console.log("批量删除");
	/*
	 * 1.拿到所有的tbody中的tr数组,遍历tr数组，记录下
	 * tr里面第一个td的状态为checked的条件下的下一个td的值。
	 * $(tr).first("td").html()---这个是给tr加条件的，返回tr
	 */
	var childs = $("#usersTable>tbody").children();
	var s="";
	for(var i=0;i<childs.length;i++){
		var tr = childs[i];
		var firstTd = $(tr).children()[0];
		if($(firstTd).children("input:checked").attr('id')){
			var id = $(firstTd).children("input:checked").attr('id');
			s = s.concat(id+",");
		}
	}
	console.log(s);
	$.ajax({
		url:'deleteUsers.do',
		type:'post',
		data:'ids='+s,
		success:function(obj){
			//{"state":1,"message":"删除成功","data":null}
			var res = JSON.parse(obj);
			location.href='selectUser.html';
		},
		error:function(obj){
			console.log(obj);
		}
	});
}
//点击删除的时候
function deleteUser(obj){
	console.log("删除");
	console.log($(obj).parent().parent().children('.userId').html());
	var id = $(obj).parent().parent().children('.userId').html();
	alert(id);
	$.ajax({
		url:'deleteUser.do?id='+id,
		type:'get',
		success:function(){
			location.href='selectUser.html';
			console.log('成功');
		},
		error:function(data){
			console.log(data);
		}
	});
	
}













