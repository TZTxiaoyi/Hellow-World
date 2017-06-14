<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
  
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
   
    <style>
		#div{
			background:url("image/Service-background.png") no-repeat;
			background-size:100% 100%;
		}
		
		.row1{
			padding:10px;
			
		}
		#table-set{
			font-size:20px;
		}
		.table-set-margin{
			margin-top:30px;
		}
		#static{
			
			padding-top:20px;
			height:800px;
		}
		#static1{
			height:800px;
			
		}
		#table{
			padding:15px;
			padding-left:80px;
			
		}
		#all-home{
			position:relative;
			max-height:680px;
			background:white;
		}
		
		#all-home div{
			margin-left:40px;
			margin-top:15px;
			border:1px solid #6600FF;
			height:150px;
		}
		
		#all{
			border:1px solid #CC33CC;
			height:735px;
			
		}
		
		#all-home1 div{
			margin-right:25px;
		}
		#danger{
			background:red;
		}
		#success{
			background:green;
		}
		#warning{
			background:#FF9900;
		}
		
	</style>

  </head>
  
  <body>
  
  
 
    
	<div class="container-fluid" id="div">

		<!--功能区-->
		<div class="row1 row">
			<!-- 模态框 -->
			<button type="button" class="btn btn-primary btn-lg"
				data-toggle="modal" data-target="#myModal">转台</button>

			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">请输入更改桌号：</h4>

						</div>
						<input type="text" class="form-control" placeholder="Search for...">
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
				</div>
			</div>
			 <a class="btn btn-info btn-lg col-sm-offset-1"
				href="#" role="button">交班</a> <a
				class="btn btn-info btn-lg col-sm-offset-1" href="#" role="button">刷新</a>
			<a class="btn btn-success btn-lg col-sm-offset-1" href="#"
				role="button">清扫结束</a> <a
				class="btn btn-danger btn-lg col-sm-offset-1" href="#" role="button">退出系统</a>
		</div>
		<!--桌台区-->
		<div class="row" id="row-table">
			<!--显示桌台状态-->
			<div class="pull-left col-xs-2" id="static">
				<div>
					<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
					<span id="table-set">桌台状态</span>
				</div>
				<div class="table-set-margin">
					<a class="btn btn-success btn-lg" href="#" role="button">当前可供：17</a>
				</div>
				<div class="table-set-margin">
					<a class="btn btn-danger btn-lg col-md-offset-1" href="#" role="button">当前占用：10</a>
				</div>
				<div class="table-set-margin">
					<a class="btn btn-warning btn-lg col-md-offset-2" href="#" role="button">当前脏台：2</a>
				</div>

			</div>
			 
			<div class="pull-left col-xs-10 container-fluid" id="static1">
				<div>
					<!--快速查找桌台-->
					<div id="table">
						<div class="input-group col-sm-6" >
							<span class="input-group-btn">
								<button class="btn btn-info" type="button">快速查找桌号：</button>
							</span>
							<input type="text" class="form-control" placeholder="Search for...">
							<span class="input-group-btn">
								<button class="btn btn-default glyphicon glyphicon-search" type="button">
								</button>
							</span>
						</div>
					</div>
					<div id="all">

						<!--显示桌台-->
						<div  id="all-home"class="pre-scrollable">
							<div class="pull-left col-sm-2" >1占</div>
							<div class="pull-left col-sm-2" >2空</div>
							<div class="pull-left col-sm-2">2脏</div>
							<div class="pull-left col-sm-2">4占</div>
							<div class="pull-left col-sm-2">5空</div>
						
							<div class="pull-left col-sm-2" >占</div>
							<div class="pull-left col-sm-2" >空</div>
							<div class="pull-left col-sm-2">脏</div>
							<div class="pull-left col-sm-2">占</div>
							<div class="pull-left col-sm-2">空</div>
							
							<div class="pull-left col-sm-2" >占</div>
							<div class="pull-left col-sm-2" >空</div>
							<div class="pull-left col-sm-2">脏</div>
							<div class="pull-left col-sm-2">占</div>
							<div class="pull-left col-sm-2">空</div>
							
							<div class="pull-left col-sm-2" >占</div>
							<div class="pull-left col-sm-2" >空</div>
							<div class="pull-left col-sm-2">脏</div>
							<div class="pull-left col-sm-2">占</div>
							<div class="pull-left col-sm-2">空</div>
							
							<div class="pull-left col-sm-2" >占</div>
							<div class="pull-left col-sm-2" >空</div>
							<div class="pull-left col-sm-2">脏</div>
							<div class="pull-left col-sm-2">占</div>
							<div class="pull-left col-sm-2">空</div>
							
							<div class="pull-left col-sm-2" >占</div>
							<div class="pull-left col-sm-2" >空</div>
							<div class="pull-left col-sm-2">脏</div>
							<div class="pull-left col-sm-2">占</div>
							<div class="pull-left col-sm-2">空</div>
						</div>
						 <!--结单情况-->
						<div id="all-home1">
							
							<div class="pull-right"><h4 class="text-success">已结单:8</h4></div>
							<div class="pull-right"><h4 class="text-danger">未结单:12</h4></div>
							<div class="pull-right"><h4 class="text-primary">总单数:20</h4></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
