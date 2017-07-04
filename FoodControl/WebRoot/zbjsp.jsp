<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>BootStrap欢迎你</title>
    <!-- <link rel='stylesheet' href='/stylesheets/bootstrap-responsive.min.css' /> -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"></link>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-datetimepicker.css" type="text/css"></link>
   <style>
       body{
        position: relative;
        padding-top:40px;
      } 
      #ddd{
      	margin-left:200px;
      }
   </style>
  </head>
  <body>  
    <div id="ddd" class="input-append date form_datetime">
      <input size="16" type="text" value="" readonly>
      <span class="add-on"><i class="icon-th"></i></span>
     </div>
    <script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js"></script>
     <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
   <script type="text/javascript">
    $(".form_datetime").datetimepicker({
      format: "yyyy-mm-dd hh:ii",
      autoclose: true,
      todayBtn: true,
      language:'zh-CN',
      pickerPosition:"bottom-left"
    });
  </script>
  </body>
</html>