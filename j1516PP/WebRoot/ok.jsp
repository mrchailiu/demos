<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ok.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/myframe.js"></script>
	<style>
		body{
			background-image: url("imgs/wall.jpg");
		}
		#main{
			width:750px;
			height:220px;
			background-color: #808080;
			margin: 0 auto;
			text-align: center;
			vertical-align: middle;
		}
		#msg{
			font-size:12pt;
			font-family:黑体;
			height:100%;
			line-height: 220px;
		}
		#list,#list2{
			margin: 0 auto;
			width:750px;
			display: none;
		}
		#list table,#list2 table{
			background-color:#F2F2F2;
			border-collapse:collapse;
			width:100%;
			border:1px solid #808080;
		}
		table thead th{
			color:#ffffff;
		}
		table td,table th{
			padding:5px;
			text-align: center;
		}
		#copy{
			width:750px;
			height:25px;
			text-align: center;
			margin: 0 auto;
			font-family: "黑体";
			font-style: italic;
			color:#91A6C4;
			background: #808080;
		}
	</style>
  </head>
  
  <body>
    <div id="main">
    	<img src="imgs/ok.jpg" style="float: left;"/>
    	<div id="msg">
    		今日日报提交成功!
    		<a href="javascript:proList()">查看今日进度排名</a>
    		(<a href="javascript:totalList()">查看总排名</a>)
    	</div>
    </div>
    <!-- 今日排行显示区域 -->
    <div id="list">
    	<table>
    		<thead>
	    		<tr bgcolor="#1976DD">
	    			<th>排名</th>
	    			<th>工程师</th>
	    			<th>项目名</th>
	    			<th>进度</th>
	    		</tr>
    		</thead>
    		<tbody id="tbody">
    		</tbody>
    	</table>
    </div>
    <!-- 总排行显示区域 -->
     <div id="list2">
    	<table>
    		<thead>
	    		<tr bgcolor="#1976DD">
	    			<th width="10%">排名</th>
	    			<th width="20%">工程师</th>
	    			<th>进度</th>
	    		</tr>
    		</thead>
    		<tbody id="tbody2">
    		</tbody>
    	</table>
    </div>
    <div id="copy">Power By MRChai &copy;softeem 2016</div>
  </body>
  <script>
  	//今日排行记录是否已被点击(若已被点击则不再重复执行)
  	var list1 = 0;
  	//总排行记录是否已被点击(若已被点击则不再重复执行)
  	var list2 = 0;
  	function proList(){
  	  	if(list1 == 0){
  	  	  	list2 = 0;//可以查看总排行
  	  		list1++;//防止在已显示排行榜的情况下再次显示
			ajax("get","DailyServlet?flag=proList",null,function(data){
				var obj = jsonToObject(data);
				var list = obj.data;
				if(list == null){
					$('list').style.display = 'block';
					$('list').style.display = '截止到目前暂无排名';
					$('list2').style.display = 'none';
					$('list2').style.display = 'none';
				}else{
					genTab(list,obj.info);
			  	  	$('list').style.display = 'block';
					$('list2').style.display = 'none';
				}
			});
  	  	}
  	}
	//生成表格
  	function genTab(list,info){
  	  	//显示前先移除所有子节点
  		var trs = $('tbody').getElementsByTagName('tr');
  		var arrays = new Array();//声明临时数组存储需要删除的节点
		for(var i = 0;i< trs.length;i++){
			arrays.push(trs[i]);
		}
		//删除数组中包含的节点
		for(var i = 0;i<arrays.length;i++){
			$('tbody').removeChild(arrays[i]);
		}
		//添加新的节点
		for(var i = 0;i<list.length;i++){
			var tr = createEle('tr');

			var td1 = createEle('td');
			td1.innerHTML = i+1;
			var td2 = createEle('td');
			td2.innerHTML = list[i].name;
			var td3 = createEle('td');
			td3.innerHTML = list[i].proName;
			var td4 = createEle('td');
			td4.innerHTML = list[i].progress+"%";
			td4.style.fontSize = "15pt";
			td4.style.fontFamily = "黑体"; 
			
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);

			if(i % 2 == 0){
				tr.bgColor = '#BCBCBC';
			} 
			if(list[i].ip == info){
				tr.bgColor = '#ff0000';
				tr.style.color = '#ffffff';
				tr.style.fontSize = '15pt';
				tr.style.fontFamily = "黑体"; 
			}
			$('tbody').appendChild(tr);
		}
  	}

	//总排行榜事件处理
  	function totalList(){
  		if(list2 == 0){
  	  	  	list1 = 0;//可以查看今日排行
  	  		list2++;//防止在已显示排行榜的情况下再次显示
	  		ajax("get","DailyServlet?flag=totalList",null,function(data){
				var obj = jsonToObject(data);
				genList(obj);
	  	  	});
  		}
  	}

  	function genList(obj){
		var list = obj.data;
		$('list2').style.display = 'block';
		$('list').style.display = 'none';

		//显示前先移除所有子节点
  		var trs = $('tbody2').getElementsByTagName('tr');
  		var arrays = new Array();//声明临时数组存储需要删除的节点
		for(var i = 0;i< trs.length;i++){
			arrays.push(trs[i]);
		}
		//删除数组中包含的节点
		for(var i = 0;i<arrays.length;i++){
			$('tbody2').removeChild(arrays[i]);
		}
		
		for(var i = 0;i<list.length;i++){
			var tr = createEle('tr');
			
			var td1 = createEle('td');
			td1.innerHTML = i + 1;
			var td2 = createEle('td');
			td2.innerHTML = list[i].name
			var td3 = createEle('td');
			var bar = createEle('div');//创建div作为进度条，显示项目进度
			//进度条样式控制
			bar.style.width = list[i].progress+"%";
			bar.style.height = "30px";
			bar.style.lineHeight = "30px";
			bar.style.textAlign = "right";
			bar.style.padding = "2px";
			bar.style.backgroundColor = "#1976DD";
			bar.innerHTML = list[i].progress+"%";
			bar.style.color = '#ffffff';
			
			td3.appendChild(bar);

			tr.appendChild(td1);			
			tr.appendChild(td2);			
			tr.appendChild(td3);
			//为偶数行设置背景颜色
			if(i % 2 == 0){
				tr.bgColor = '#BCBCBC';
			} 
			//为前3名设置特定样式
			var colors = ['#9370DB','#FF8C00','#7CFC00'];
			if(i < 3){
				tr.bgColor = colors[i];
				tr.style.color = '#ffffff';
				tr.style.fontSize = (12+(3-i)*3)+"pt";
				tr.style.fontFamily = "黑体"; 
			}
			$('tbody2').appendChild(tr);			
		}
  	}
  </script>
</html>
