<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'time.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	  <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	  <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	  <link rel="stylesheet" href="bootstrap/css/bootstrap-datetimepicker.min.css" type="text/css"></link>
	  <script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
  <script>
  	$(".form_datetime").datetimepicker({
	    minView: "month", //选择日期后，不会再跳转去选择时分秒 
	    language:  "zh-CN",
	    format: "yyyy-mm-dd",
	    todayBtn:  1,
	    autoclose: 1,
	});
	
  </script>
  </head>
  
  <body>
    <div class="form-group row">
	    <div class="left col-xs-3 text-right">
	        <label for="">*时间:</label>
	    </div>
	    <div class="right col-xs-6 text-left">
	        <div class="input-group">
	          <input type="text" class="form-control form_datetime" id="addtime" name="addtime" value="{sh:$info.addtime|default=$time|date='Y-m-d',###}" placeholder="">
	          <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
	        </div>
	    </div>
	</div>
  </body>
</html>
