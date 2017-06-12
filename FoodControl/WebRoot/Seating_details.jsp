<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Seating_details.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<script type="text/javascript" src="jquery/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<style>
		#head{
			height:50px;
			line-height:50px;
			font-size:20px;
			background-color: #FFFFCC;
		}
		#left-subject{
			max-height:700px;
			background-color: #66ffcc;
		}
		#right-subject{
			height:700px;
			background-color: #66ccff;
		}
		#menu-height{
			height:500px;
			
		}
		#menu-within-height{
			height:100px;
			width:150px;
			
		}
		#classify{
			height:100px;
			font-size:15px;
			background-color: #FFCC00;
		}
		#classify-css{
			border:2px;
			height:40px;
			line-height:50px;
			font-size:20px;
		}

	</style>
  </head>
  
  <body>
    <div class="container-fluid"><!--最外层 -->
	<div class="row" id="head"><!-- 头部-->
		<div class="col-md-3">
				菜品数量：
		</div>
		<div class="col-md-3">
				桌位：
		</div>
		<div class="col-md-3">
				单号：
		</div>
	</div>
	
	
	<div class="row"> <!--主体 -->
		<div class="col-md-6" id="left-subject"><!--左部主体内容-->
			已订菜
			<div class="pre-scrollable">
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>
				<p>dfdf</p>

			</div>

		</div>

		<div class="col-md-6" id="right-subject"><!--右部主体内容-->
			菜品类别
			
			<div class="container-fluid" id="classify"><!--菜品分类-->
				<div class="row">
					<div class="col-md-3" id="classify-css">
						热菜
					</div>
					<div class="col-md-3" id="classify-css">
						凉菜
					</div>
					<div class="col-md-3" id="classify-css">
						主食
					</div>
					<div class="col-md-3" id="classify-css">
						饮品
					</div>
					<div class="col-md-3" id="classify-css">
						汤类
					</div>
					
				</div>
			</div>	
			

			<div class="container-fluid" ><!-- 菜单-->
				<div class="row " id="menu-height" >
					<div class="col-md-3" id="menu-within-height">
							菜名
					</div>
					<div class="col-md-3" id="menu-within-height">
								菜名
					</div>
					<div class="col-md-3" id="menu-within-height">
								菜名
					</div>
					<div class="col-md-3" id="menu-within-height">
							菜名
					</div>
					<div class="col-md-3" id="menu-within-height">
								菜名
					</div>
					<div class="col-md-3" id="menu-within-height">
							菜名
					</div>
					<div class="col-md-3"id="menu-within-height">
							菜名
					</div>
					<div class="col-md-3" id="menu-within-height">
							菜名
					</div>
				</div>
			</div>
			<div><!--底部功能模块-->
				<button type="button" class="btn btn-danger">整单取消</button>

				<button type="button" class="btn btn-primary">取消菜品</button>

				<button type="button" class="btn btn-info">备注</button>

				<button type="button" class="btn btn-success">传菜</button>

				<button type="button" class="btn btn-warning">查询</button>

				<button type="button" class="btn btn-success">查看</button>
			</div>

		</div>

	</div>
  </div>
  </body>
</html>
