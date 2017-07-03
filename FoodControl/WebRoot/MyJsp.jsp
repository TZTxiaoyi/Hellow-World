<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

  </head>
  
  <body>
  <input type="button"value="ss" id="aa"/>
   <form action="service.jsp" id="form1">
  	<input type="submit" />
  </form>
  <script>
  $("#aa").click(function(){
  	aa();
  })
  function aa(){
		alert(3);
			//window.location.href("http://localhost:8080/FoodControl/service.jsp");
			$("#form1").submit();
		}
	
  </script>
  </body>
</html>
