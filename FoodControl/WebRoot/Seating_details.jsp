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
			margin-left:5%;
		}
		#lefttop-subject{
			background:#ffffcc;
			height:85%;
		}
		#righttop-subject{
			background:#ffffcc;
			height:85%;
		}
		#right-subject{
			position:relative;
			height:85%;
		}
		#menu-height{
			height:700px;
			margin-left:25px;
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
			background-color:#ff9999;
			font-size:20px;
			line-height:50px;
		}
		#subject-styler{
			padding-left:15px;
			height:50px;
			background-color: #6666ff;
			font-size:20px;
			line-height:50px;
		}
		.torder td{
			
			font-size:18px;
			width:20%;
			height:50px;
			text-align:center;
			margin-top:5px;
			border-bottom:1px solid #ff9999;
			line-height:50px;
					
		}
		#vageorder td{
			width:23%;
		}
		#vageorder{
			height:500px;
			margin-bottom:25px;
		}
		#vageadd{
		
			height:500px;
			background-color:#ffff99;
		}
		#vageitem td{
			width:22%;
		}
		#vageitem{
			height:500px;
		}
		#subject-style td{
			width:100px;
			text-align:center;
		}
		#subject-styler td{
			width:150px;
			text-align:center;
		}
		#torder a{
			width:80px;
			text-align:left;
			font-size:18px;
		}
		.pre-scrollable{
			color:#ff6600;
			overflow:auto;
		}
		
		#money a{
			
			margin-top:25px;
			margin-right:10px;
			margin-left:150px;
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
			height:80px;
			position:absolute;
			bottom:30px;
		}
		#vagenum{
			position:relative;
			left:50%;
		}
		#area{
			margin-left:15px;
			font-size:15px;
		}
		.img{
			width:120px;
			height:120px;
			position:absolute;
			top:20px;
			left:500px;
		}
		.imgdel{
			font-size:30px;
			color:red;
			-webkit-transform: rotate(-45deg);  
    		-moz-transform: rotate(-30deg);  
			position:absolute;
			top:60px;
			left:520px;
		}
		#callimg{
			display:none;
		}
		#callimgpay{
			display:none;
		}
		#lishi{
			color:#3333ff;
			
		}
		#selectmoney{
			margin-top:25px;
			margin-right:-50px;
			margin-left:100px;
			background-color:#ff99ff;
		}

	</style>
  
  <script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript">

  /* 		$(document).ready(function(){

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
		});*/
  </script>

  
  </head>
  
  <body>

    <div class="container-fluid" id="div"><!--最外层 -->
		<div class="row" id="head"><!-- 头部-->
			<div class="col-md-2">
					菜品数量：<span id="pnum"></span>
			</div>
			<div class="col-md-2">
					桌位名字：<span id="dname"><%String dna=request.getParameter("dname");dna=new String(dna.getBytes("iso8859-1"),"utf-8");out.print(dna);%></span>
			</div>
			<div class="col-md-2">
					单号：<span id="order"><%String oid=request.getParameter("ord");out.print(oid);%></span>
			</div>
			<div class="col-md-2">
					开台时间：
					<span id="retime">
					
					</span>
			</div>
			<div class="col-md-3">
				<a class="btn btn-lg" style="color:#66ccff" href="" id="shuxin">刷新</a>
				<a class="btn close btn-lg" data-dismiss="modal"aria-label="Close" style="color:#ff00ff" href="service.jsp">返回</a>
			</div>
		</div>

	
		<div class="row" id="rowsubject"> <!--主体 -->
			<div class="col-md-4" id="left-subject"><!--左部主体内容-->
				<div id="lefttop-subject">
					<h3>临时加菜<a id="vagenum" href=""
						role="button">总计：<span class="tred"></span></a></h3>
					<div id="vageadd" >
						<div id="subject-style">
							
						</div>
						<div  id="vageitem" class="pre-scrollable torder">
						
						</div>
					</div>
					
				</div>
				
				
			</div>
			
			<div class="col-md-6" id="right-subject"><!--右部主体内容-->
				<div id="righttop-subject">
					<h3>已订菜</h3>
					<div id="callimg"><img  src="images/del.jpg" alt="已取消" class="img-circle img"><span class="imgdel">已取消</span></div>
					<div id="callimgpay"><img  src="images/del.jpg" alt="已结账" class="img-circle img"><span class="imgdel">已结账</span></div>
					<div id="subject-styler">
							
					</div>
					<div id="vageorder" class="pre-scrollable torder">
							
					</div>	
				</div>
				
				
			</div>
			<div id="btm"><!--底部功能模块-->
					<span id="money">
						<select  id ="selectmoney" class="btn btn-lg dropdown-toggle" name="selectvalue"> 
							<option value="21">结账方式</option>
							<option value="9">现金支付</option>
							<option value="11">微信支付</option>
							<option value="10">支付宝支付</option>
						</select>
						<a class="btn btn-danger btn-lg" href=""
						role="button" id="paymoney">确认结账</a>
						<a class="btn btn-success btn-lg "
						role="button" id="clear">清扫结束</a>
						

						<a role="button" class="btn btn-danger btn-lg" id="alldel">整单取消</a>
					
						<a role="button" class="btn btn-primary btn-lg" id="anxious">催菜</a>
					</span>
					
				
			</div>
				<div id="times">
			</div>
		</div>
		
		
		
  </div>
	<!-- 备注模态框 -->
	、<!-- Modal -->
			<div class="modal fade  bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog  modal-sm" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h3 class="modal-title">取消原因</h3>

						</div>
						<textarea cols="30" rows="5" placeholder="请输入取消原因..." id="area"></textarea>
						<div class="modal-footer">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" id="alldel">保存
							</button>
						</div>
					</div>
				</div>
			</div>	
	<script>
	
		/*
			系统加载自动运行;
		*/
	/*	$(function() {
			setInterval("getTime()",1000);
			if($("#order").html()!="undefined"){
				setInterval("outtime()",1000);
			}
		});*/
		/*
			获取系统时间;
		*/
		/*function getTime(){
			var time = new Date();
   			$("#times").html(time.toLocaleString());
   			
		};
		/*
			开台时间；
		*/
		function outtime(){
			
			var ord=$("#order").html();
			$.ajax({
				url:"addfood_ordertime.action",
				type:"post",
				data:{"addorder.ordersId":ord},
				success:function(data){	
				$("#retime").html(data);
				}
			});
			
		};
		
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
			
		});*/
		$(function(){
			//$("#vageadd").hide();
			if($("#order").html()!=""){
				outfood();
			}
		});
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
					var num=0;//订单总金额
					$("#subject-style").html("");
					$("#subject-styler").html("");
					var th="<tr><td>菜品</td><td>数量</td><td>单价</td><td>金额</td><td></td></tr>";
					$("#subject-style").append(th);
					$("#subject-styler").append(th);
					var foodnum=1;
					$("#torder").html("");
					$("#vageorder").html("");
					$("#vageitem").html("");
					$.each(json,function(index,value){
						dname=value[0];
						fnum=value[4];
						onenum=value[5];
						dnum=value[6];
						ordersnum=value[11];
						allnum=dnum*onenum;
						var aa="";
						var timefood=format(value[10].time);
						if(value[8]==12){
							aa="<a class=\"btn btn-danger del\" foodprice=\""+allnum+"\" name=\""+timefood+"\" id=\"xiao"+value[7]+"\" href=\"\"role=\"button\">取消</a>";
						}
						if(value[8]==13){
							aa="<a class=\"btn btn-info disabled del\" href=\"\"role=\"button\">在做</a>";
						}
						if(value[8]==14){
							aa="<a class=\"btn btn-success disabled del\" href=\"\"role=\"button\">已完成</a>";
						}
						if(value[8]==17){
							aa="<a class=\"btn btn-danger disabled del\" href=\"\"role=\"button\">已取消</a>";
						}
						var odertext="<tr><td id=\"quxiao"+value[7]+"\">"+value[3]+"</td><td>"+value[6]+"</td><td>"+value[5]+"</td><td  id=\"monxiao"+value[7]+"\">"+allnum+
						"</td><td>"+aa+"</td></tr>";
						if(value[9]==0){
							$("#vageorder").append(odertext);
						}
						if(value[9]==1){
							//$("#vageadd").show();
							$("#vageitem").append(odertext);
						}
						num=num+allnum;
						if(value[12]!=21){
							$("#callimgpay").show();
							$("#clear").attr("disabled",false); 
						}
					});
					
					
					$("#dname").html(dname);
					$("#pnum").html(fnum);
					$(".tred").html(ordersnum);	
				 	$("#clear").attr("disabled",true); 
					
						
				}
			});
		};
	
		/*
			结账
		*/
		
		$("#paymoney").click(function(){
			var ord=$("#order").html();
			var dname=$("#dname").html();
			var svalue=$("#selectmoney option:selected").val();
			if(svalue!=21){
				$.ajax({
					async:false,
					url:"addfood_updateOrder.action",
					type:"post",
					data:{"st.deskName":dname,"addorder.ordersId":ord,"svalue":svalue},
					success:function(data){	

					}
				});
			}else{
				alert("请选择结账方式");
			}
			
		});

	
		/*
			整单取消；
		*/
		$("#alldel").click(function(){
			var dname=$("#dname").html();
			var ord=$("#order").html();
			$.ajax({
				url:"addfood_alldelect.action",
				type:"post",
				data:{"addorder.ordersId":ord,"st.deskName":dname},
				success:function(data){
					if(data==1){
						$("#callimg").show();//切换元素为可见状态==$("#callimg").css("display","block");
						outfood();
					}else if(data==-1){
						alert("整单删除失败！");	
					}	
				}
			});
		});
		/*
			单个菜品取消；
		*/
		$("#rowsubject").on('click',".del", function(){
			var delid=$(this).attr("id");
			var vagename=$("#qu"+delid).html();
			var num=$("#mon"+delid).html();//取消金额
			var ord=$("#order").html();
			var name=$(this).attr("name");
			var foodprice=$(this).attr("foodprice");
			$.ajax({
				async:false,
				url:"addfood_onedelect.action",
				type:"post",
				data:{"addfood.foodname":vagename,"addorder.ordersId":ord,"foodtime":name,"foodprice":foodprice},
				success:function(data){
					//$(".tred").html(pay);
					if(data!=-1){
						outfood();
					}
				}
			});
		});
		function add0(m){return m<10?'0'+m:m }
		function format(shijianchuo){
		//shijianchuo是整数，否则要parseInt转换
			var time = new Date(shijianchuo);
			var y = time.getFullYear();
			var m = time.getMonth()+1;
			var d = time.getDate();
			var h = time.getHours();
			var mm = time.getMinutes();
			var s = time.getSeconds();
			return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
		} 
		/*
			催菜
		*/
		$("#anxious").click(function(){
		var orderid=$("#order").html();
		$.ajax({
			url:"addfood_anxious.action",
			type:"post",
			data:{"addorder.ordersId":orderid},
			success:function(data){
				if(data!=-1){
					alert("催菜成功！");
				}
				
			}
		});
	})
	/*
		刷新
	*/
	$("#shuxin").click(function(){
		outfood();
	})

		/*
			清台
		*/
		$("#clear").click(function(){
			var dname=$("#dname").html();
			var orderid=$("#order").html();
			$.ajax({
				async:false,
				url:"addfood_clearDesk.action",
				type:"post",
				data:{"st.deskName":dname,"addorder.ordersId":orderid},
				success:function(data){
					if(data!=-1){
						window.location.href="http://localhost:8080/FoodControl/service.jsp";
					}
				}
			});
		});
	

	</script>
  </body>
</html>
