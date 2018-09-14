function getXhr(){
	var xhr = null;
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}else{
		xhr = new ActiveXObject("MicroSoft.XMLHttp");
	}
	return xhr;
}

function $(id){
	/*
	 * 这里不能用变量接收
	 */
	return document.getElementById(id);
}
function $F(id){
	return $(id).value;
}
