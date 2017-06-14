<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css"></link>
  <script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  <style type ="text/css">
  	
  </style>
  </head>
  
  <body>
  	    
    <input type=button value="-1" id="remove" onclick="remove()">
  	<input type=text value="0" id="number" size="3"  id ="z1">
  	<input type=button value="+1" id="add" onclick="add()">
  	
    <script>
        function add() {
            var obj = document.getElementById("number");
 
            obj.value = parseInt(obj.value) + 1;
        }
 
        function remove() {
            var obj = document.getElementById("number");
 
            if(obj.value == 0) {
                return;
            }
 
            obj.value = parseInt(obj.value) - 1;
        }
    </script>
  </body>
</html>
