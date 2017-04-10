<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>武汉工业学院校企合作java班随机抽取器</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style>
  
  	body{
  		font-family:华文行楷;
  		font-size:xx-large;
  		background-color: #800080;
  		color: white;
  	}
  	#tab{
  		position: absolute;
  		left: 30%;
  		top: 30%;
  	}
  	#tab table{
  		width: 600px;
  	
  	}
  	.btn{
  		cursor:hand;
  		width: 80px;
  		height: 35px;
  		color: red;
  		font-family: 华文行楷;
  		font-size: +18;
  	
  	}
  </style>
  <body>
  <%
  	List<String> list = (List<String>)request.getAttribute("list");
  	String str = (String)request.getAttribute("msg");
  %>
   <form action="ExtractServlet">
   <div id="tab">
   <table border="1px" cellpadding="10" cellspacing="0" bordercolor="#6495ED" style="font-size:30px">
  
   <caption>
   随机抽取&nbsp;&nbsp;&nbsp;&nbsp;第
   <%!int i=1;%>
   <%=i%>
   <%i++;
   	if(i>3){
   		i=0;
   	}
   %>次
   </caption>
   
   	<tr align="center">
   		<td colspan="4" >恭喜以下同学中标!<%=str%></td>
   	</tr>
   	<tr align="center">
   	<%for(String s:list){%>
   		<td width="150"><%=s%></td>
   		<%}%>
   	</tr>
   	<tr align="center">
   		<td colspan="4"><input type="submit" value="再次抽取" class="btn"></td>
   	</tr>
   </table>
   </div>
   </form>
  </body>
</html>
