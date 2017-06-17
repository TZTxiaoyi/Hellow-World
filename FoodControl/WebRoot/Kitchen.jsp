<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<meta name="viewport" content="width=device-width, initial-scale=1">
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

* {
	border: 1px solid #cacaca;
}

#Bigbody {
	height: 100%;
	border: 3px solid red;
} /*整体*/
#TOP {
	height: 9%;
}

#Cbody {
	height: 75%;
}

#col1 {
	height: 100%;
	width: 49.5%;
	margin-right: 0.5%;
	float: left;
}

#col1c01 {
	width: 85%;
	height: 100%;
	float: left;
}

#col1c01 .col-md-12 div {
	height: 6%;
	text-align: left;
}

#col1c02 {
	width: 15%;
	height: 100%;
	float: left;
}

#col1c02 .column {
	height: 15%;
	margin-top: 20%;
}

#col2 {
	height: 100%;
	width: 49%;
	margin-left: 0.5%;
	float: left;
}

#Bbotton {
	height: 15%;
}

</style>
</head>

<body>

	<!--主体内容-->
	<!----------------------------------------------------------------------------------------------------->
	<div class="container-fluid" id="Bigbody">
		<!-------------------------------页面头部------------------------------------------->
		<div class="row" id="TOP"></div>
		<!-------------------------------------------------------------------------->
		<div class="row" id="Cbody">
			<div class="column" id="col1">
				<div class="column" id="col1c01">
				<!-- 左边窗口 -->
					<iframe scrolling="auto" rameborder="0" src="kitsystem.jsp"
						name="left" width="100%" height="100%"></iframe>
				</div>
			</div>
			<div class="row" id="col2">
				<!------------右边窗口-------------->
				<div><iframe scrolling="auto" rameborder="0" src="background/order_dish.jsp"
					name="left" width="100%" height="100%"></iframe></div>
				
			</div>
			<div class="row" id="Bbotton">
			
			</div>
		</div>



		<!--白色，浅蓝色，深蓝色，绿色，黄色，红色，黑色，对应的class为btn,btn btn-primary,btn btn-info,btn btn-success,btn btn-warning,btn btn-danger,btn btn-inverse-->
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
