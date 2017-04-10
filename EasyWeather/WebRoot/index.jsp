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
		.tab_data table{
			width:100%;
			border:1px solid #8194AA;
			border-collapse: collapse;
		}
		.tab_data table th,.tab_data table td{
			border:1px solid #8194AA;
			padding:5px;
			font-size: 10pt;
			font-family: 微软雅黑;
		}
		a{
			text-decoration: none;
			color:#000000;
		}
		a:HOVER {
			text-decoration: underline;
			color:#ff0000;
		}
		
	</style>
  </head>
  
  <body>
    <div class="box_main">
    	<div class="title">SOFTEEM实时天气</div>
    	<div class="tab_data">
    		<table>
    			<tr>
    				<td colspan="5"><a href="javascript:history.back();">&lt;&lt;返回</a></td>
    			</tr>
    			<tr>
    				<th>城市/地区</th>
    				<th>天气</th>
    				<th>温度</th>
    				<th>风力情况</th>
    				<th>下属地区天气</th>
    			</tr>
    			<c:forEach items="${cities}" var="city">
    			<tr>
    				<td><a href="weather?flag=details&pyName=${pyName}&cityName=${city.cityName}">${city.cityName}</a></td>
    				<td><img src="${imgPath}d${city.state1}.gif"/>${city.stateDetailed}</td>
    				<td>${city.tem2}℃~${city.tem1}℃</td>
    				<td>${city.windState}&nbsp;${city.windDir}&nbsp;${city.windPower}</td>
    				<td><a href="weather?pyName=${city.pyName}">详情</a></td>
    			</tr>
    			</c:forEach>
    		</table>
    	</div>
    </div>
  </body>
</html>
