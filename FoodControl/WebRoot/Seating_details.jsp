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
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"></link>
    
   	
	<style>
		#head{
			height:50px;
			line-height:50px;
			font-size:20px;
			background-color: #FFFFCC;
		}
		#left-subject{
			max-height:700px;
			
		}
		#right-subject{
			height:700px;
			background-color: #FFFFCC;
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
		#left-scrollable{
			max-height:530px;
		}
		#subject-style{
			padding-left:20px;
			height:50px;
			background-color: #66ccff;
			font-size:20px;
			line-height:50px;
		}
		#money{
			height:150px;
			background-color: #FFFFCC;
		}
		#money span{
			float:right;
			background-color: #66ccff;
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
  
  <body><button id="eeed">anniu1</button>
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
				<div class="pre-scrollable" id="left-scrollable">
					<div id="subject-style"></div>
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
				<div id="money">
					<div>
						小计：<span class="col-md-offset-2">0</span><br/>
						已付金额：<span class="col-md-offset-2">0</span><br/>
						应付：<span class="col-md-offset-2">0</span><br/>
					</div>
					
					
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
	
	<script>
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
