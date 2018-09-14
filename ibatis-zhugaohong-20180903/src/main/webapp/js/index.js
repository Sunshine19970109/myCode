$(document).ready(function(){
	$.ajax({
		url:'findAll.user',
		type:'get',
		dataType:'json',
		success:function(obj){
			var data=obj.data;
			for(var i=0;i<data.length;i++){
				var user = data[i];
				$("tbody").append(
					'<tr>'+
						'<th><input id='+user.id+' type="radio"/></th>'+
						'<th>'+user.id+'</th>'+
						'<th>'+user.name+'</th>'+
						'<th>'+user.realName+'</th>'+
						'<th>'+user.email+'</th>'+
						'<th>'+user.address+'</th>'+
						'<th>'+user.createTime+'</th>'+
						'<th><a onclick="deleteUser(this)">删除</a></th>'+
					'</tr>'
				);
			}
		},
		error:function(){
			console.log('error');
		}
	});
});
function deleteUser(obj){
	console.log("delete");
	var id=$($(obj).parent().parent().children()[1]).html();
	$.ajax({
		url:'deleteUser.user?id='+id,
		type:'get',
		dataType:'json',
		success:function(obj){
			location.href='index.html';
		},
		error:function(){
			console.log('error');
		}
	});
}