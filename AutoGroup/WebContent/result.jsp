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
			border-radius:0 0 5px 5px;
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
			background-color:#e0e0e0;
			width:1024px;
			heigth:200px;
			margin:0 auto;
			padding:10px 0;
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
	<div id="middle"></div>
	<div id="data">
	</div>
  </body>
  <script>
  $(function(){
	  //分组显示
	  $.get("query?type=stuPage&num="+$("#num").val(),function(data){
			var main = $("<div></div>");
			if(data != ""){
				var groups = eval("("+data+")");
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
				$("#middle").append("<a href='query?type=download' title='点击下载'>湖北第二师范学院java分组名单</a>");
			}else{
				main.css({
					margin:"0 auto",
					width:"1024px",
					height:"160px",
					lineHeight:"160px",
					textAlign:"center",
					border:"1px solid #ff0000",
					fontSize:"14pt",
					fontWeight:"900",
					color:"#ff0000"
				});
				main.html("请等待老师分组完成后再查看!");
			}
			$("#data").append(main);
		});
  })
  </script>