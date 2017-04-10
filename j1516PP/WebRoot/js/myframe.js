/*
 	ajax封装
 	method 请求方式
 	url 请求的资源路径
 	data 使用post提交时需要传递的数据
 	callback 回调函数
 */
var xhr;			//name=XXX&pass=XXX
function ajax(method, url, data, callback) {
	//判断浏览器是否支持XMLHttpRequest同时创建
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		//IE5，IE6
		xhr = new ActiveXObject("microsoft.xmlhttp");
	}
	//打开连接
	xhr.open(method, url);
	//当准备状态发生改变时触发回调函数
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//获取服务端响应数据 
			var resp = xhr.responseText;
			callback(resp);
		}
	}
	//如果是post提交则设置额外的请求头
	if (method.toLowerCase() == "post") {
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
	}
	xhr.send(data);
}

function $(id) {
	return document.getElementById(id);
}

function createEle(tag) {
	return document.createElement(tag);
}

function jsonToObject(json){
	return eval("("+json+")");
}

//封装trim函数
String.prototype.trim=function(){
	return this.replace(/(^\s*)|(\s*$)/g,"");
};