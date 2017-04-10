<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
	body{
			background-image: url("imgs/wall.jpg");
			margin-left: 0px;
			margin-top: 0px;
		}
		.table{
			background-color:#e0e0e0;
			margin: 0 auto;
			width:1024px;
			font-family:"黑体"; 
			border-collapse: collapse;
		}
		.table th{
			color:#ffffff;
			background-color: #328DE7;
			border:0;
		}
		.table td,table th{
			padding:5px 4px;
			text-align:center;
			vertical-align: top;
			border-bottom: 1px solid #e0e0e0;
		}
		.btn{
			margin:18px 8px;
			padding:8px;
			width:30%;
			border:0;
			background-color:#1976DD;
			font-size: 15pt;
			letter-spacing:10px;
			color:#ffffff;
			cursor:pointer;
		}
		.btn:HOVER{
			background-color: #46A1EF;
		}
		#top{
			width:1024px;
			height:160px;
			background-image: url("imgs/top.jpg");
			margin: 0 auto;
		}
		#middle{
			width:1024px;
			heigth:200px;
			margin:0 auto;
			text-align:center;
		}
		tr.item:HOVER{
			background-color: #808080;
		}
		.main{
			width:1024px;
			background-color: #e0e0e0;
			margin:0 auto;
		}
		#num{
			font-size: 15pt;
		}
	</style>
  </head>
  <body>
	<div id="top"></div>
	<div id="middle">每组人数:<select id="num">
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
					 </select>人<input type="button" class="btn" value="开始分组"></div>
	<div id="data">
		<table class="table">
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>专业</th>
			</tr>
		</table>
	</div>
  </body>
  <script>
  $(function(){
	  //加载数据
	  $.get("query?type=list",function(data){
		  var stus = eval("("+data+")");
		  var xhtml = "";
		  $.each(stus,function(index,obj){
			  xhtml += "<tr>";
			  	xhtml += "<td>"+obj.sid+"</td>";
			  	xhtml += "<td>"+obj.name+"</td>";
			  	xhtml += "<td>"+obj.sex+"</td>";
			  	xhtml += "<td>"+obj.major+"</td>";
			  xhtml += "</tr>";
		  });
		  $(".table tr:first").after(xhtml);
	  });
	  //分组显示
	  $("input[type=button]").click(function(){
		  $("#middle").hide();
		  $("#data").empty();
		  $.get("query?type=group&num="+$("#num").val(),function(data){
				var groups = eval("("+data+")");
				var main = $("<div></div>");
				main.addClass("main");
				var index = 1;
				$.each(groups,function(i,obj){
					var tab = $("<div></div>").css({
						width:"339px",
						border:"1px solid #ffffff",
						float:"left"
					});
					
					var s = obj.stus;
					var item_tab = $("<table></table>").css({
						width:"100%",
						backgroundColor:"#f0f0f0",
						padding:"5px"
					});
					item_tab.hover(function(){
						$(this).css("background-color","#e0e0e0");
					},function(){
						$(this).css("background-color","#f0f0f0");
					});
					item_tab.append("<tr bgcolor='#60CDE7'><th colspan='3' style='color:#ffffff'>第<font size='7px'>"+index+"</font>组</th><tr>");
					for(var i = 0;i<s.length;i++){
						var tr = "<tr><td width='40%' style='font-weight:bold;'>"+s[i].name+"</td><td align='center' width='20%'>"+s[i].sex+"</td><td align='right' width='40%'>"+s[i].major+"</td></tr>";
						item_tab.append(tr);
						tab.append(item_tab);
					}
					if(index % 3 != 0){
						tab.css("float","block");
					}
					main.append(tab);
					index++;
				});
				$("#data").append(main);
		  });
	  });
  })
  </script>