<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		#lefttop-subject{
			background:#ffffcc;
			height:80%;
		}
		#righttop-subject{
			background:#ffffcc;
			height:80%;
		}
		#right-subject{
			position:relative;
			height:85%;
		}
		#menu-height{
			height:500px;
			
		}
		#menu-within-height{
			height:100px;
			width:300px;
			
		}
		
		#classify{
			height:100px;
			font-size:15px;
			background-color:#ff9999;
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
			background-color: #ff9999;
			font-size:20px;
			line-height:50px;
		}
		#torder td{
			
			font-size:20px;
			width:100px;
			text-align:center;
			border-bottom:1px solid #ff9999;
					
		}
		#subject-style td{
			width:100px;
			text-align:center;
		}
		#torder a{
			width:70px;
			text-align:left;
			font-size:20px;
		}
		#money{
			height:100px;
			position:absolute;
			bottom:0px;
		}
		#money a{
			
			margin-bottom:5%;
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
		#btm{
			margin-top:5%;
		}
		#vagenum{
			position:relative;
			left:60%;
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
					菜品数量：<span id="pnum"></span>
			</div>
			<div class="col-md-3">
					桌位名字：<span id="dname"><%String dna=request.getParameter("dname");dna=new String(dna.getBytes("iso8859-1"),"utf-8");out.print(dna);%></span>
			</div>
			<div class="col-md-3">
					单号：<span id="order"><%String oid=request.getParameter("ord");out.print(oid);%></span>
			</div>
			<div class="col-md-3">
					开台时间：
					<span id="retime">
					
					</span>
			</div>
		</div>

	
		<div class="row"> <!--主体 -->
			<div class="col-md-4" id="left-subject"><!--左部主体内容-->
				<div id="lefttop-subject">
					<h3>已订菜<a id="vagenum" href=""
						role="button">总计：<span class="tred"></span></a></h3>
					<div >
						<div id="subject-style">
							
						</div>
						<div id="torder">
							
						</div>
						
					</div>
				
				</div>
				<div class="pagelist">
						<a name="minus" class="page btn-lg glyphicon glyphicon-triangle-left" href="#"></a>
						<a name="add" class="page btn-lg glyphicon glyphicon-triangle-right" href="#"></a>
							
				</div>
				<div id="money">
					
						
						<br/>
						<a class="btn btn-danger btn-lg" href=""
						role="button" id="paymoney">结账：<span class="tred"></span></a>
						<br/>
						<a class="btn btn-success btn-lg" href=""
						role="button" id="clear">清扫结束</a> 
				
				</div>
			</div>
			
			<div class="col-md-8" id="right-subject"><!--右部主体内容-->
				<div id="righttop-subject">
					<h3>菜品类别</h3>
					<div class="container-fluid" id="classify"><!--菜品分类-->
						<div class="row">
							<div class="col-md-4" id="classify-css">
								热菜
							</div>
							<div class="col-md-4" id="classify-css">
								凉菜
							</div>
							<div class="col-md-4" id="classify-css">
								主食
							</div>
							<div class="col-md-4" id="classify-css">
								饮品
							</div>
							<div class="col-md-4" id="classify-css">
								汤类
							</div>
							
						</div>
					</div>	
					
		
					<div class="container-fluid" ><!-- 菜单-->
						<div class="row " id="menu-height" >
							<c:forEach var="next"  items="${dish}" varStatus="statu">
								<div class="col-md-4" id="menu-within-height">
									<span name="name${statu.index}">${next[1]}</span>:  <span name="name${statu.index}">${next[2]}</span>元 / 份<br/>
									<div class="row" >
										<div class=" center-block"  id="food-btn">
											<input type="button" name="name${statu.index}" value="-1" class="remove btn btn-default">
											<input type="text" value="0" class="number-cl btn btn-default" size="3" name="name${statu.index}">
											<input type="button" name="name${statu.index}" value="+1" class="add btn btn-default">
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div id="btm"><!--底部功能模块-->
					<button type="button" class="btn btn-danger btn-lg" >整单取消</button>
	
					<button type="button" class="btn btn-primary btn-lg col-md-offset-1" data-toggle="modal" data-target="#myMenu">催菜</button>
	
					<button type="button" class="btn btn-warning btn-lg col-md-offset-1"  >查询</button>
					
					<button type="button" class="btn btn-success btn-lg col-md-offset-1" >传菜</button>

					<button type="button" class="btn btn-info btn-lg col-md-offset-1" >备注</button>
					<a class="btn close btn-lg" data-dismiss="modal"aria-label="Close" style="color:#ff00ff" href="service.jsp">退出系统</a>
			
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
   			//outtime();
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
		$(function(){
			if($("#order").html()!=""){
				outfood();
				outtime();
			}
		})
		/*
			动态添加菜单；页面顶部；
		*/
		function outfood(){
			var ord=$("#order").html();
			$.ajax({
				url:"addfood_orderDish.action",
				type:"post",
				data:{"addorder.ordersId":ord},
				success:function(data){
					var json=JSON.parse(data);
					var dname=null;//桌子名字
					var fnum=null;//菜品数量
					var allnum=0;//单个菜的总价格
					var onenum=0;//菜品单价
					var dnum=0;//菜品数量
					var num=0;
					var th="<tr><td>菜品</td><td>数量</td><td>单价</td><td>金额</td><td></td></tr>";
					$("#subject-style").append(th);
					var foodnum=1;
					$.each(json,function(index,value){
					//alert(json2TimeStamp(value[2].time));
						dname=value[0];
						fnum=value[4];
						onenum=value[5];
						dnum=value[6];
						allnum=dnum*onenum;
						var odertext="<tr><td>"+value[3]+"</td><td>"+value[6]+"</td><td>"+value[5]+"</td><td>"+allnum+
						"</td><td><a class=\"btn btn-danger\" href=\"\"role=\"button\">取消</a></td></tr>";
						$("#torder").append(odertext);
						num=num+allnum;
						
						
					});
					
					$("#dname").html(dname);
					$("#pnum").html(fnum);
					$(".tred").html(num);	
				 
					
						
				}
			});
		};
		/*
			开台时间；
		*/
		function outtime(){
			var ord=$("#order").html();
			$.ajax({
				url:"addfood_orderDish.action",
				type:"post",
				data:{"addorder.ordersId":ord},
				success:function(data){	
				}
			});
			$("#retime").html('${retime}');
		};
		/*
			结账
		*/
		$("#paymoney").click(function(){
			var ord=$("#order").html();
			var dname=$("#dname").html();
			$.ajax({
				url:"addfood_updateOrder.action",
				type:"post",
				data:{"st.deskName":dname,"addorder.ordersId":ord},
				success:function(data){		
					alert("dsd");
				}
			});
			
		})
		//清台
		$("#clear").click(function(){
			var dname=$("#dname").html();
			alert("dname:"+dname);
			$.ajax({
				url:"addfood_clearDesk.action",
				type:"post",
				data:{"st.deskName":dname},
				success:function(data){
					alert("55");
				}
			});
		});
		
		
		
	</script>
  </body>
</html>
