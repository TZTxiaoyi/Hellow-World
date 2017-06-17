<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 后厨已下单的菜品查询页面 --> 
<html>
<head>

<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.js"></script>
<script type="text/javascript"
	src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
</head>

<body>
	<input id="query" type="button" value="查询" />
	<div >
		<table id="title">
			
		</table>
	</div>
	<script type="text/javascript">
 		$(function(){
 			$("#query").click(function(){
 				$.ajax({
 					url:"TztQueryDish_query.action",
 					type:"post",
 					data:{"aaa":"aa"},
 					dataType:"json",
 					success:function(data){
 					$("#title").html("<tr><td>菜名</td><td>数量</td></tr>");
					$.each(data,function(index,value){				
					var dd="<tr>"+"<td>"+value[0]+"</td>"+"<td>"+value[1] +"</td>"+"<td><button class=\"btn btn-danger\" id=\"dynamicbtn\">制作</button></td>"+"</tr>";
					$("#title").append(dd);
					});
					
					
 					}

 				});
 			});
 		});
 	</script>
</body>
</html>