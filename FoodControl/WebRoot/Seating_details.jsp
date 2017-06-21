<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>

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
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"></link>
   
	<link rel="stylesheet" href="css/admin.css">
   	
	<style>
		#head{
			height:50px;
			line-height:50px;
			font-size:20px;
			border-bottom:1px solid #666699;
		}
		#left-subject{
			height:85%;
			position:relative;
		
		}
		#right-subject{
			position:relative;
			background:white;
			height:85%;
		}
		#menu-height{
			height:500px;
			
		}
		#menu-within-height{
			height:100px;
			width:150px;
			
		}
		#list{
			background:white;
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
		
		#subject-style{
			padding-left:10px;
			height:50px;
			background-color: #66ccff;
			font-size:20px;
			line-height:50px;
		}
		#subject-style span{
			margin-right:15%;
		}
		#money{
			height:100px;
			position:absolute;
			bottom:0px;
		}
		#money a{
			
			margin-bottom:20px;
		}
		#times{
			position:absolute;
			bottom:20px;
			right:50px;
			font-size:20px;
			white-space:nowrap;
		}
		#div {
			background: url("image/Service-background.png") no-repeat;
			background-size: 100% 100%;
			height: 100%;
		}
		
		.pagelist a{
			background: #ffcc99;
		}
	
	</style>
  
  <script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript">
   		$(document).ready(function(){
   			$("#btn").click(
   				function(){
   					alert("确认修改吗？");
   				}
   			);
   			$("#add1").click(
   				function(){
   					
   					alert($("#price").val);
   				}
   			);
   		});
  </script>
  <script>
		$(function(){
			$("#add").click(function(){
				var price=$("#UPrice").html()*$("#Number").val();//价格*数量获得总价
				var total=parseInt($("#Total").html())+price;//先转为int类型再做加法运算
				$("#Total").html(total);//把当前菜的总价格加上当前订单的金额
			});
		});
	</script>
  
  </head>
  
  <body>
    <div class="container-fluid" id="div"><!--最外层 -->
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
			<div class="col-md-3">
					开台时间：
			</div>
		</div>

	
		<div class="row"> <!--主体 -->
			<div class="col-md-6" id="left-subject"><!--左部主体内容-->
				<div id="left-subject1">
				<h3>已订菜</h3>
				<div >
					<div id="subject-style">
						<span>菜品</span>
						<span>数量</span>
						<span>单价</span>
						<span>金额</span>
					</div>
					<div id="list">
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
				<div class="pagelist">
						<a name="minus" class="page btn-lg glyphicon glyphicon-triangle-left" href="#"></a>
						<a name="add" class="page btn-lg glyphicon glyphicon-triangle-right" href="#"></a>
							
				</div>
				</div>
				<div id="money">
					
						<a class="btn btn-info btn-lg" href="#"
						role="button">总计：<span id="tred">12</span></a>
						<br/>
						<a class="btn btn-danger btn-lg" href="#"
						role="button">结账：<span id="tred">45元</span></a>
				
				</div>
			</div>
			
			<div class="col-md-6" id="right-subject"><!--右部主体内容-->
				
				<h3>菜品类别</h3>
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
							 
						</div>
						<div class="col-md-3" id="menu-within-height">
							<span id="cm">红烧狮子头：</span><span id="UPrice">20</span>
        					<input type=button value="-1" id="remove" onclick="remove()">
  							<input type=text value="0" id="number" size="3">
  							<input type=button value="+1" id="add" onclick="add()">
        					<button id="addcc">添加</button>
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
					<button type="button" class="btn btn-danger " >整单取消</button>
	
					<button type="button" class="btn btn-primary col-md-offset-1" data-toggle="modal" data-target="#myMenu">取消菜品</button>
	
					<button type="button" class="btn btn-info col-md-offset-1" >备注</button>
	
					<button type="button" class="btn btn-success col-md-offset-1" >传菜</button>
	
					<button type="button" class="btn btn-warning col-md-offset-1"  >查询</button>
	
					<button type="button" class="btn btn-success col-md-offset-1">查看</button>
				</div>
				
			</div>
		<div id="times"></div>
		</div>
		
  </div>
			<div class="modal fade" id="myMenu"> <!-- modal把div的内容识别为模态框 fade模态框切换时内容淡入淡-->
				<div class="modal-dialog">
					<div class="modal-content"><!-- 模态框居中显示-->
						<div class="modal-header"> <!-- 模态框标题-->
							<button type="button" class="close"			data-dismiss=modal>×
							</button>
							<h4 class="modal-title" id="MyMenuLabel">		选择取消菜品
							</h4>
						</div>
						<div class="modal-body"> <!-- 模态框显示的主要内容-->
							已點的菜<br/>
							<div id="subject-style">糖醋里脊 <button class="btn btn-danger col-md-offset-6" id="btn-click">取消</button> </div>
							红烧狮子头<input type="checkbox" name="cancel"><br/>
							玉米汤<input type="checkbox" name="cancel"><br/>
							
						</div>
						
						<div class="modal-footer"> <!-- 模态框下的关闭和保存按钮--> 
							<button type="button" class="btn btn-default" data-dismiss="modal">
								关闭
							</button>
							<button type="button" class="btn btn-danger">
								取消
							</button>
							
						</div>
					</div>
				</div>
			</div>
	<script>
		
		/*
			系统加载自动运行;
		*/
		$(function() {
			setInterval("getTime()",1000);
		});
		/*
			获取系统时间;
		*/
		function getTime(){
			var time = new Date();
   			$("#times").html(time.toLocaleString());
		}
		
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
		$(function(){
			
			$("#addcc").click(function(){
				var price=$("#UPrice").html()*$("#number").val();//价格*数量获得总价
				var total=parseInt($("#Total").html())+price;//先转为int类型再做加法运算
				$("#Total").html(total);//把当前菜的总价格加上当前订单的金额
				
				$("#subject-style").html("<button type=\"button\" class=\"btn btn-danger\" id=\"cddd\">btn</button>");
			});
			
		});
	</script>
  </body>
</html>
