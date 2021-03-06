﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>后厨系统</title>

<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">


<!--自定义CSS样式-->
	<style>
		body{
			margin:0;
			padding:0;
			
		}
		
		td{
			width:230px;
			padding-right:30px;
			margin-top:10px;
			margin-bottom:10px;
			border-bottom:1px solid #ff6600;
		}
		table td{
			width:120px;
			font-size:18px;
		}
		 .firsthead{
			background:#6666ff;
			width: 100%;
		}
		
		#top {
			height: 9%;
			font-size:20px;
			margin-left:20px;
		}
		#cbody {
			height: 60%;
			border-bottom:1px solid #ff6666;
		}
		
		#col1 {
			height: 100%;
			width: 48%;
			float: left;
			border-right:1px solid #99ff99;
		}
		
		
		#col2 {
			width: 48%;
			margin-left:1%;
			float: left;
		}
		#time{
			font-size:150%;
		}
		#top{
			float:left;
			width:50%;
		}
		#bottom{
			height:20%;
			background-color:#ffcc99;
			font-size:25px;
		}
		#titlemading{
			max-height:400px;
			margin-left:10px;
			margin-right:10px;
			background-color:#ffcc99;
		}
		#titlemade{
			background-color:#ff99cc;
			max-height:350px;
		}
		#bhead{
			padding-top:15px;
			border-bottom:1px solid #ff6666;
			background-color:#ffffcc;
		}
		.pre-scrollable{
			overflow:auto;
		}
		
		
		
	</style>
</head>

<body>

	<!--主体内容-->
	<!----------------------------------------------------------------------------------------------------->
	<div class="container-fluid"  >
		<!-------------------------------页面头部------------------------------------------->
		<div class="row" id="bhead">
			<div class= "row"id="top"></div>
			<div class="btn-group btn-group-lg" role="group">	
				<button  class="btn btn-info btn-group-lg" id="default">默认</button>
				<button class="btn btn-info btn-group-lg" id = "priority">优先级</button>
				<button class="btn btn-info btn-group-lg" id ="desksort">桌位轮转</button>
			 </div>
			 <button class="btn btn-danger btn-group-lg" id="back">后台页面</button>
			<button class="btn btn-danger btn-group-lg" id="exit">退出登录</button>

		</div>
		<!-------------------------------------------------------------------------->
		<div class="column" id="cbody">
			<div class="column" id="col1">
		
				<!-- 左边窗口 -->
				<h2>制作中</h2>
				<div class="firsthead">
					<table>
						<tr>
							<td>菜名</td>
							<td style="width:150px">数量</td>
							<td>桌位</td>
							<td>操作
							<input class="btn btn-info" id="querymading" type="button" value="刷新" /></td>
						</tr>
					</table>
				</div>
				<div class="row pre-scrollable" id="titlemading">
				
				</div>
				
			</div>

			<div class="row" id="col2">
				<!------------右边窗口-------------->
				<h2>待做</h2>
				<div class="firsthead">
					<table>
						<tr>
							<td>菜名</td>
							<td>数量</td>
							<td style="width:190px">桌位</td>
							<td>操作
							<input class="btn btn-info\" id="querymade" type="button" value="刷新" /></td>
						</tr>
					</table>
				</div>
				<div class=" pre-scrollable"id="titlemade">
					
				</div>
			</div>
			
	
		</div>
			<!-- 最下面窗口 -->
			<h2>制作完成</h2>
			<div class="row pre-scrollable" id="bottom">
			</div>
		<!--白色，浅蓝色，深蓝色，绿色，黄色，红色，黑色，对应的class为btn,btn btn-primary,btn btn-info,btn btn-success,btn btn-warning,btn btn-danger,btn btn-inverse-->
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			var method=0;
		/*自动运行函数*/
 		$(function(){	
 		
 			startTime();
			queryMading();
			queryMade();
			var time = setInterval("startTime()",500);
			var made =  setInterval("queryMade()",5000);
			var mading = setInterval("	queryMading()",5000)
			
 		});
 		function startTime(){
 			var ti=getTime();
 			$("#top").html("<span id=time>"+ti +"</span>");
 		}
 		function getTime(){
 			var today=new Date();
 			var h = today.getHours();		
 			var m = today.getMinutes();
 			var s = today.getSeconds();
 			m =checkTime(m);
 			s=checkTime(s);
 			var ti=h+":"+m+":"+s;
 			return ti;
 		}
 		function checkTime(i){
 			if(i<10){
 				i="0"+i;
 				}
 			return i;
 		}
 		$("#default").click(function(){
 			method=0;
 			queryMading();
			queryMade();
 		});
 		$("#priority").click(function(){
 			method=2;
 			queryMading();
			queryMade();
 		});
 		$("#desksort").click(function(){
 			method=1;
 			queryMading();
			queryMade();
 		});
 		$("#exit").click(function(){
 			window.location.href="TztQueryDish_exit.action";
 		});
 		$("#back").click(function(){
 			window.location.href="TztQueryDish_back.action";
 		});
 		function queryMading(){
 				$.ajax({
 					url:"TztQueryDish_queryMading.action",
 					type:"post",
 					data:{"method":method},
 					dataType:"json",
 					success:function(data){
 			
 					$("#titlemading").html("");
					$.each(data,function(index,value){	
					var dd="<tr>"+"<td name =\""+value[0]+ "\">"+value[1]+"</td>"+"<td name =\""+value[0]+ "\">"+value[2] +"</td>"+"<td>"+value[3]+"</td>"+"<td><div class=\"btn-group\"><button class=\"btn btn-success\" id=\"madingbutton\" name =\""+value[0]+ "\">制作完成</button><br/>"
					+"<button class=\"btn btn-danger\" id=\"removebutton\" name =\""+value[0]+ "\">取消制作</button></div></td>"+"</tr>";
					$("#titlemading").append(dd);		
					});
					}
 					});
 				}
 				
 		$(function(){
 			$("#titlemading").on('click',"#madingbutton",function(){	
 				var aa=$(this).attr("name");
 				var foodname=$($("td[name=\""+aa+"\"]")[0]).html();
 				var foodnum=$($("td[name=\""+aa+"\"]")[1]).html();
 				var table="";
 				var time=getTime();
 				$.ajax({
 					url:"TztQueryDish_makding.action",
 					type:"post",
 					data:{"method":method,"dishId":aa},
 					dataType:"json",
 					success:function(data){
 					$.each(data,function(index,value){				
						table=table+value[0]+":"+value[1]+"份，"
					});
 					var dd="<div>"+time+"已完成菜品："+foodname+"共"+foodnum+"份  ，"+table+"</div>";
					$("#bottom").prepend(dd);		
 						queryMading();
						queryMade();
 					}
 				});
 			});
 		});
 		
 		$(function(){
 			$("#titlemading").on('click',"#removebutton",function(){	
 				var aa=$(this).attr("name");
 				$.ajax({
 					url:"TztQueryDish_remove.action",
 					type:"post",
 					data:{"method":method,"dishId":aa},
 					dataType:"json",
 					complete:function(data){
 						queryMading();
						queryMade();
 					},
 				});
 			});
 		});
 		
 		
 		
 		function queryMade(){
 				$.ajax({
 					url:"TztQueryDish_queryMade.action",
 					type:"post",
 					data:{"method":method},
 					dataType:"json",
 					success:function(data){
 					$("#titlemade").html("");
					$.each(data,function(index,value){
					var dd="<tr>"+"<td   name =\""+value[0]+ "\">"+value[1]+"</td>"+"<td  name =\""+value[0]+ "\">"+value[2] +"</td>"+ "</td>"+"<td>"+value[3]+"<td ><button class=\"btn btn-danger\" id=\"makebutton\" name =\""+value[0]+ "\">制作</button></td>"+"</tr>";
					$("#titlemade").append(dd);
					});
 					}
 				});
 			}
 			
 		$(function(){
 			$("#titlemade").on('click',"#makebutton",function( ){
 				var aa=$(this).attr("name");
 				$.ajax({
 					url:"TztQueryDish_make.action",
 					type:"post",
 					data:{"method":method,"dishId":aa},
 					dataType:"json",
 					complete:function(data){
 						queryMading();
						queryMade();
 					},
 				});
 			});
 		});
 	
 	</script>
</body>
</html>
