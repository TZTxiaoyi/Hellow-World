<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript"src="bootstrap/jquery/jquery-2.1.3.min.js"></script>	
  </head>
  
  <body>
   	员工管理<input type="checkbox" name="check1" value="10" class="parent_one"><br>  				
          添加员工<input type="checkbox" name="check11" aria-label="..." class="children1">
 	修改员工信息<input type="checkbox" name="check12" aria-label="..." class="children1">
	删除员工<input type="checkbox" name="check13" aria-label="..." class="children1"><br>  
	 
  </body>  

 <script type="text/javascript">
	 	$(function(){
	 		$(".children1").bind('click',function(){
	 		//alert("0000");	 		
	 			if($(this).prop("checked",true)){
	 				$(".parent_one").prop("checked",true);
	 			}
	 			$(this).unbind('click');
	 		});
	 		
	 	});
	 	$(function(){
	 		$(".parent_one").bind('click',function(){
	 		//alert("0001");
	 			if($(this).prop("checked",false)){
	 				$(".children1").prop("checked",false);
	 			}
	 			$(this).unbind('click');
	 		});
	 	});
	 </script>
</html>
