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

	width: 48%;
	margin-right: 1%;
	float: left;
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
			<div class= ""id="top"></div>
			<div class="btn-group btn-group-lg" role="group">	
				<button  class="btn btn-info btn-group-lg" id="default">默认</button>
				<button class="btn btn-info btn-group-lg" id = "priority">优先级</button>
				<button class="btn btn-info btn-group-lg" id ="desksort">桌位轮转</button>
			 </div>
		
		</div>
		<!-------------------------------------------------------------------------->
		<div class="column" id="cbody">
			<div class="column" id="col1">
		
				<!-- 左边窗口 -->
				<table class="row pre-scrollable" id="titlemading">
					
				
				</table>
				
			</div>

			<div class="row" id="col2">
				<!------------右边窗口-------------->
				<table class=" pre-scrollable"id="titlemade">
					
				</table>
				
				<div >
					<table >
			
					</table>
				</div>
			</div>
			
	
		</div>
			<!-- 最下面窗口 -->
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
 			alert(method);
 		});
 		$("#priority").click(function(){
 			method=2;
 			queryMading();
			queryMade();
 			alert(method);
 		});
 		$("#desksort").click(function(){
 			method=1;
 			queryMading();
			queryMade();
 			alert(method);
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
 					var tr="<tr><td>菜名</td><td>数量</td><td>操作</td><td><input class=\"btn btn-info\" id=\"querymading\" type=\"button\" value=\"刷新\" /></td></tr>";
					$("#titlemading").append(tr);
					$.each(data,function(index,value){				
					var dd="<tr>"+"<td name =\""+value[0]+ "\">"+value[1]+"</td>"+"<td name =\""+value[0]+ "\">"+value[2] +"</td>"+"<td><button class=\"btn btn-success\" id=\"madingbutton\" name =\""+value[0]+ "\">制作完成</button></td>"
					+"<td><button class=\"btn btn-danger\" id=\"removebutton\" name =\""+value[0]+ "\">取消制作</button></td>"+"</tr>";
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
						table=table+value[0]+value[1]+"份"
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
 					var tr="<tr><td>菜名</td><td>数量</td><td>操作</td><td><input  class=\"btn btn-info\" \"id=\"querymade\" type=\"button\" value=\"刷新\" /></td></tr>";
					$("#titlemade").append(tr);
					$.each(data,function(index,value){
					var dd="<tr>"+"<td   name =\""+value[0]+ "\">"+value[1]+"</td>"+"<td  name =\""+value[0]+ "\">"+value[2] +"</td>"+"<td ><button class=\"btn btn-danger\" id=\"makebutton\" name =\""+value[0]+ "\">制作</button></td>"+"</tr>";
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
