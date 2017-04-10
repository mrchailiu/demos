/*
 	ajax��װ
 	method ����ʽ
 	url �������Դ·��
 	data ʹ��post�ύʱ��Ҫ���ݵ�����
 	callback �ص�����
 */
var xhr;			//name=XXX&pass=XXX
function ajax(method, url, data, callback) {
	//�ж�������Ƿ�֧��XMLHttpRequestͬʱ����
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		//IE5��IE6
		xhr = new ActiveXObject("microsoft.xmlhttp");
	}
	//������
	xhr.open(method, url);
	//��׼��״̬�����ı�ʱ�����ص�����
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//��ȡ�������Ӧ���� 
			var resp = xhr.responseText;
			callback(resp);
		}
	}
	//�����post�ύ�����ö��������ͷ
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

//��װtrim����
String.prototype.trim=function(){
	return this.replace(/(^\s*)|(\s*$)/g,"");
};