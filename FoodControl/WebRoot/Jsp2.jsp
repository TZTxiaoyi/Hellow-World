<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Jsp2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
				
											<!--自定义CSS样式-->
	<!----------------------------------------------------------------------------------------------------->
		<style>
			*{border:1px solid #cacaca;}
			#bigwidth{ width:60%;}
		</style>
	<!----------------------------------------------------------------------------------------------------->
  </head>
  <body>
    
					<div class="container-fluid"id="bigwidth">
				<div class="row">
					<div class="col-md-6">
						<div class="col-md-3">编号</div>
						<div class="col-md-6">菜品名</div>
						<div class="col-md-3">选择</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">编号</div>
						<div class="col-md-6">菜品名</div>
						<div class="col-md-3">选择</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="col-md-3">1</div>
						<div class="col-md-6">鱼香肉丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">2</div>
						<div class="col-md-6">鱼香肉丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">3</div>
						<div class="col-md-6">辣子鸡</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">4</div>
						<div class="col-md-6">宫保鸡丁</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-6">
						<div class="col-md-3">5</div>
						<div class="col-md-6">水煮鱼</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="col-md-3">6</div>
						<div class="col-md-6">麻辣鸡丝</div>
						<div class="col-md-3">
							<input type="checkbox"name="check"/>
						</div>
					</div>
				</div>
		
		



				


		
	  <!--白色，浅蓝色，深蓝色，绿色，黄色，红色，黑色，对应的class为btn,btn btn-primary,btn btn-info,btn btn-success,btn btn-warning,btn btn-danger,btn btn-inverse-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
