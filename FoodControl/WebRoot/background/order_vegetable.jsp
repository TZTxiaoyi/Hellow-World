<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
 				$ajax({
 					url:'TztQuerVeg.action',
 					type:'get',
 					data:{},
 					dataType:'json',
 					success:function(data){
 						
 					},
 				});
 			});
 		});
 	</script>
  </body>
</html>
