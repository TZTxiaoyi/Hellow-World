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
* {
	padding: 0px;
	margin: 0px;
}

* div{
	border: 1px solid #cacaca;
}
td{
	width:100px;
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

</style>
</head>

<body>

	<!--主体内容-->
	<!----------------------------------------------------------------------------------------------------->
	<div class="container-fluid" >
		<!-------------------------------页面头部------------------------------------------->
		<div class="row" id="top">
			
		</div>
		<!-------------------------------------------------------------------------->
		<div class="row" id="cbody">
			<div class="column" id="col1">
		
				<!-- 左边窗口 -->
				<input class="btn btn-info" id="querymading" type="button" value="刷新" />
				<div >
				<table id="titlemading">
						
					</table>
				</div>
			</div>

			<div class="row" id="col2">
				<!------------右边窗口-------------->
				<input  class="btn btn-info" "id="querymade" type="button" value="刷新" />
				<div >
					<table id="titlemade">
			
					</table>
				</div>
			</div>
	
		</div>


		<!--白色，浅蓝色，深蓝色，绿色，黄色，红色，黑色，对应的class为btn,btn btn-primary,btn btn-info,btn btn-success,btn btn-warning,btn btn-danger,btn btn-inverse-->
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
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
 			var today=new Date();
 			var h = today.getHours();		
 			var m = today.getMinutes();
 			var s = today.getSeconds();
 			m =checkTime(m);
 			s=checkTime(s);
 			var ti=h+":"+m+":"+s;
 			$("#top").html("<span id=time>"+ti +"</span>");
 		}
 		
 		function checkTime(i){
 			if(i<10){
 				i="0"+i;
 				}
 			return i;
 		}
 			
 			$("#querymading").click(function(){
 				queryMading();
 			});
 		function queryMading(){
 				$.ajax({
 					url:"TztQueryDish_queryMading.action",
 					type:"post",
 					data:{},
 					dataType:"json",
 					success:function(data){
 					$("#titlemading").html("<tr><td>菜名</td><td>数量</td><td>操作</td></tr>");
					$.each(data,function(index,value){				
					var dd="<tr>"+"<td >"+value[1]+"</td>"+"<td>"+value[2] +"</td>"+"<td><button class=\"btn btn-danger\" id=\"madingbutton\" name =\""+value[0]+ "\">制作完成</button></td>"+"</tr>";
					$("#titlemading").prepend(dd);		
					});
					}
 					});
 				}
 		$(function(){
 			$("#titlemading").on('click',"#madingbutton",function(){
 				var aa=$(this).attr("name");
 				alert(aa);
 				$.ajax({
 					url:"TztQueryDish_makding.action",
 					type:"post",
 					data:{"dishId":aa},
 					dataType:"text",
 					complete:function(data){
 						alert(2);
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
 					data:{},
 					dataType:"json",
 					success:function(data){
 					$("#titlemade").html("<tr><td>菜名</td><td>数量</td><td>操作</td></tr>");
					$.each(data,function(index,value){				
					var dd="<tr>"+"<td >"+value[1]+"</td>"+"<td>"+value[2] +"</td>"+"<td ><button class=\"btn btn-danger\" id=\"makebutton\" name =\""+value[0]+ "\">制作</button></td>"+"</tr>";
					$("#titlemade").prepend(dd);
					});
 					}
 				});
 			}
 		$(function(){
 			$("#titlemade").on('click',"#makebutton",function(){
 				var aa=$(this).attr("name");
 				$.ajax({
 					url:"TztQueryDish_make.action",
 					type:"post",
 					data:{"dishId":aa},
 					dataType:"text",
 					complete:function(data){
 						queryMading();
						queryMade();
 						
 					}
 				});
 			});
 		});
 	
 	</script>
</body>
</html>
