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
	<style>
		.box_main{
			width:50%;
			min-width: 400px;
			border:1px solid #808080;
			margin:0 auto;
			border-radius:5px;
		}
		.title{
			width:100%;
			height:50px;
			background-color: #38B0FF;
			color:#ffffff;
			text-align: center;
			line-height: 50px;
			font-size: 25px;
			font-family: 微软雅黑;
		}
		.tab_data{
			width:100%;
		}
		a{
			text-decoration: none;
			color:#000000;
		}
		a:HOVER {
			text-decoration: underline;
			color:#ff0000;
		}
		.tab_data table{
			width:100%;
			border-collapse: collapse;
			background-color: #4B4B4B;
		}
		.tab_data table th{
			border:1px solid #808080;
			padding:10px;
			color:#ffffff;
			opacity:0.8;
			font-family: 微软雅黑;
		}
	</style>
  </head>
  
  <body>
    <div class="box_main">
    	<div class="title">SOFTEEM实时天气</div>
    	<div class="tab_data">
    		<table>
    			<tr>
    				<th><a href="javascript:history.back()"><img src="wopc_arrow.png" width="20px" height="20px" title="返回"/>返回</a></th>
    			</tr>
    			<tr>
    				<th style="font-size:20pt">${city.cityName}</th>
    			</tr>
    			<tr>
    				<th style="color:#ff0000;font-size:20pt">
    					<img src="${imgPath}a${city.state1}.gif"><br>
    					<c:if test="${city.temNow != - 10000}">
	    					${city.temNow}℃
    					</c:if>
    				</th>
    			</tr>
    			<tr>
    				<th style="color:#ff0000;font-size:20pt">${city.stateDetailed}</th>
    			</tr>
    			<tr>
    				<th>${city.tem2}℃~${city.tem1}℃</th>
    			</tr>
    			<tr>
    				<th>${city.windState}</th>
    			</tr>
    			<tr>
    				<th>风向:<c:out value="${city.windDir}"></c:out></th>
    			</tr>
    			<tr>
    				<th>风力:<c:out value="${city.windPower}"></c:out></th>
    			</tr>
    			<tr>
    				<th>湿度:<c:out value="${city.humidity}"></c:out></th>
    			</tr>
    			<tr>
    				<th>更新时间:<c:out value="${city.lastTime}"></c:out></th>
    			</tr>
    		</table>
    	</div>
    </div>
  </body>
</html>
