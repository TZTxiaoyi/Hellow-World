<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


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
		
		* div{
			border: 1px solid #cacaca;
		}
		td{
			width:150px;
		}
		
		#top {
			height: 9%;
		}
		
		#cbody {
			height: 75%;
		}
		
		#col1 {
		
			width: 49%;
			margin-right: 1%;
			float: left;
		}
		
		
		#col2 {
			
			width: 49%;
			margin-left:1%;
			float: left;
		}
		#time{
			font-size:150%;
		}
		.top1{
			float:left;
			width:50%;
			
		}
		.bottom{
			height:15%;
		}
	</style>
</head>

<body>

	<!--主体内容-->
	<!----------------------------------------------------------------------------------------------------->
	<div class="container-fluid"  >
		<!-------------------------------页面头部------------------------------------------->
		<div class="row" >
			<div class= "top1"id="top"></div>
			<div class="top1">	<button id="default">默认</button><button id="ttme">时间</button> </div>
		
		</div>
		<!-------------------------------------------------------------------------->
		<div class="row" id="cbody">
			<div class="column" id="col1">
		
				<!-- 左边窗口 -->
				<table>
					<tr><td>菜名</td><td>数量</td><td>操作</td><td><input class="btn btn-info" id="querymading" type="button" value="刷新" /></td></tr>
				</table>
				
				<div >
				<table id="titlemading">
						
					</table>
				</div>
			</div>

 				<!------------右边窗口--------------> 
				<table>
					<tr><td>菜名</td><td>数量</td><td>操作</td><td><input  class="btn btn-info" "id="querymade" type="button" value="刷新" /></td></tr>
				</table>
				
				<div >
					<table id="titlemade">
			
					</table>
				</div>
			</div>
			
	
		</div>
			<!-- 最下面窗口 -->
			<div class="bottom" id="bottom">
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
 			//alert(method);
 		});
 	
 		$("#ttme").click(function(){
 			 method=1;
 			//alert(method);
 		});
 			
 			$("#querymading").click(function(){
 				queryMading();
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
					var dd="<tr>"+"<td name =\""+value[0]+ "\">"+value[1]+"</td>"+"<td name =\""+value[0]+ "\">"+value[2] +"</td>"+"<td><button class=\"btn btn-danger\" id=\"madingbutton\" name =\""+value[0]+ "\">制作完成</button></td>"+"</tr>";
					$("#titlemading").prepend(dd);		
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
						table=table+value[0]+",";
					});
 					var dd="<div>"+time+"已完成菜品："+foodname+"共"+foodnum+"份 桌名为："+table+"</div>";
					$("#bottom"). prepend(dd);		
 						queryMading();
						queryMade();
						
 						
 					}
 				});
 			});
 		});
 		
 		
 		
 			$("#querymade").click( function(){
 				queryMade();
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
					var dd="<tr>"+"<td >"+value[1]+"</td>"+"<td>"+value[2] +"</td>"+"<td ><button class=\"btn btn-danger\" id=\"makebutton\" name =\""+value[0]+ "\">制作</button></td>"+"</tr>";
					$("#titlemade").prepend(dd);
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
 					dataType:"text",
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
