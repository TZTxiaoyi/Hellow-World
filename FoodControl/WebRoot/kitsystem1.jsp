<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Jsp.jsp' starting page</title>
    
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
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

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
			#bigwidth{ width:100%;}
		</style>
	<!----------------------------------------------------------------------------------------------------->
  </head>
  <body>
    <!--白色，浅蓝色，深蓝色，绿色，黄色，红色，黑色，对应的class为btn,btn btn-primary,btn btn-info,btn btn-success,btn btn-warning,btn btn-danger,btn btn-inverse-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
					<div class="container-fluid"id="bigwidth">
						<div class="col-md-12"><!------------准备制作菜品模块-------------->
						<div class="col-md-12">正在制作</div><!--模块标题-->
					</div>
					<div class="col-md-12">
						<div class="col-md-2">顺序</div><!--模块标题-->
						<div class="col-md-4">菜品</div>
						<div class="col-md-2">优先级</div>
						<div class="col-md-2">状态</div>
						<div class="col-md-2">选择</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">99</div>
						<div class="col-md-4">鱼香如丝</div>
						<div class="col-md-2">0.1</div>
						<div class="col-md-2">催</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">2</div>
						<div class="col-md-4">水煮鱼</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">3</div>
						<div class="col-md-4">青椒肉丝</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">4</div>
						<div class="col-md-4">水煮肉片</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">5</div>
						<div class="col-md-4">辣子鸡</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">6</div>
						<div class="col-md-4">水煮鱼</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">7</div>
						<div class="col-md-4">粉蒸肉</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
							<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">8</div>
						<div class="col-md-4">口水鸡</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">9</div>
						<div class="col-md-4">麻婆豆腐</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">10</div>
						<div class="col-md-4">口水鸡</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">11</div>
						<div class="col-md-4">酸菜鱼</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">12</div>
						<div class="col-md-4">宫保鸡丁</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
					</div>
					<div class="col-md-12"><!--制作菜品具体数据-->
						<div class="col-md-2">13</div>
						<div class="col-md-4">干锅香辣虾</div>
						<div class="col-md-2">0.5</div>
						<div class="col-md-2">未作</div>
						<div class="col-md-2">
							<input type="checkbox"name="check"/>
						</div>
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
