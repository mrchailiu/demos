<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/myframe.js"></script>
	<style type="text/css">
	body{
		background-image: url("imgs/wall.jpg");
	}
	
		.input_data{
			border:1px solid #808080;
			width: 380px;
			height:30px;
			font-size: 15pt;
			font-family: "Times New Roman";
			letter-spacing: 1px;
		}
		table{
			background-color:#e0e0e0;
			margin: 0 auto;
			width:700px;
			border:1px solid #808080;
			border-radius:5px;
		}
		table td,table th{
			padding:10px 8px;
			text-align: center;
			vertical-align: top;
		}
		h1{
			margin-bottom: 20px;
			font-size: 25pt;
			font-family: "楷体";
		}
		.btn{
			margin:18px 8px;
			padding:8px;
			width:40%;
			font-size: 15pt;
			cursor:pointer;
		}
		label{
			font-size: 10pt;
			line-height: 30px;
			font-family: "Times New Roman";
			font-weight: bold;
		}
		#msg_box{
			width:450px;
			height:30px;
			line-height: 30px;
			text-align: center;
			margin: 0 auto;
			background-color:#ff0000; 
			color:#ffffff;
			font-family: 黑体;
			display: none;
		}
		.title{
			text-align: right;
			width:20%;
		}
	</style>
  </head>
  <body>
    	<center><h1>Java1516一期项目进度报告-日报</h1></center>
    	<div id="msg_box"></div>
  	<form>
    <table>
    	<tr>
    		<td colspan="2"></td>
    	</tr>
    	<tr>
    		<td class="title"><label>高姓大名:</label></td>
    		<td><input type="text" name="stuName"  class="input_data"/></td>
    	</tr>
    	<tr>
    		<td class="title"><label>项目名称:</label></td>
    		<td><input type="text" name="proName"  class="input_data"/></td>
    	</tr>
    	<tr>
    		<td class="title"><label>完成进度:</label></td>
    		<td><select name="progress"  class="input_data">
    				<c:forEach var="progress" begin="0" end="100" step="5">
	    				<option value="${progress}">${progress}%</option>
    				</c:forEach>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td class="title"><label>今日完成:</label></td>
    		<td>
    			<textarea name="detail" class="input_data" style="height:180px;resize:none;"></textarea>
    		</td>
    	</tr>
    	<tr>
    	
    		<th colspan="2">
    			<input type="button" class="btn" value="提交" onclick="check()"/>
    		</th>
    	</tr>
    	<tr>
    		<th colspan="2" style="font-family: 黑体;color: #91A6C4"><i>Power By MRChai &copy;softeem 2016</i></th>
    	</tr>
    </table>
    </form>
  </body>
  <script>
  	function showBox(msg,t){
		$('msg_box').style.display = 'block';
		$('msg_box').innerHTML= msg;
		if(showBox.arguments.length == 2){
			t.style.borderColor="#ff0000";
		}
  	}
  	function hidBox(){
  		$('msg_box').style.display = 'none';
  	}
  	//表单提交校验
  	function check(){
		//获取第一个表单
  	  	var f = document.forms[0];
  	  	
		var name = f.stuName.value.trim();
		var proName = f.proName.value.trim();
		var progress = f.progress.value;
		var detail = f.detail.value.trim();
		console.info(name+"--"+detail+"--"+progress)
		//中文姓名正则表达式（2-4位中文）
		var china = /^[\u4e00-\u9fa5]{2,4}$/;
		//验证姓名
		if(name.length < 1){
			showBox('请输入学员姓名',f.stuName);
			return false;
		}else{
			if(!china.test(name)){
				showBox('整啥假洋鬼子范?请输正确的名字!',f.stuName);
				return false;
			}else{
				hidBox();
			}
		}
		//验证项目名
		if(proName.length < 1){
			showBox('请填写项目名称',f.proName);
			return false;
		}
		
		//验证进度
		if(progress == 0){
			if(window.confirm('你确定到今天为止啥也没做？？？')){
				showBox('在今日完成填写原因',f.progress);
			}else{
				hidBox();
			}
		}
		//验证详情
		if(detail.length < 20){
			showBox('你的日报是不是忒简单了点?亲!咱认真点可好?',f.detail);
			return false;
		}
		var data = 'flag=send&stuName='+name+'&proName='+proName+'&progress='+progress+'&detail='+detail;
		ajax('post', 'DailyServlet?r='+new Date(),data,function(msg){
				var model = jsonToObject(msg);
				if(model.code == 1){
					window.location.href='ok.jsp';
				}else if(model.code == -1){
					showBox('数据库异常,检查提交数据是否不正确!');
				}else{
					showBox('今日已提交日报,不可重复提交!');
				}
		});
  	}
  </script>
</html>
