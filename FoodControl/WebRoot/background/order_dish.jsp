<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<后厨已下单的菜品查询页面>
<html>
  <head>

  <script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.js"></script>
  <script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
  </head>
 
  <body>
 	<input id="query"type="button" value="查询"/>
 	<script type="text/javascript" >
 		$(function(){
 			$("#query").click(function(){
 				$.ajax({
 					url:"TztQueryDish_query.action",
 					type:"post",
 					data:{"user":"aa"},
 					dataType:"json",
 					success:function(data){
 						alter(1);
 					}
 				});
 			});
 		});
 	</script>
  </body>
</html>
