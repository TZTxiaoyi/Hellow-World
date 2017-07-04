<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<!-- 
		后台订单详情页面
	 -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	<title></title>
	<link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.css" type="text/css"></link>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap-datetimepicker.css" type="text/css"></link>
	<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="../bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="../bootstrap/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="../bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>

	<style>
		#modalform input {
			
			width: 250px;
			height: 40px;
			
		}
		#modalform div{
			margin-top:30;
			margin-left:20%;
		}
		#modalform span{
			font-size:20px;
		}
		#timedate{
			padding-left:100px;
		}
	
	</style>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 订单信息</strong>
		</div>
		<div>


				<div class="panel admin-panel">
					<div class="padding border-bottom">
						<ul>
							<li id="timedate">
					  			
					  			<input placeholder="起始时间" size="16" type="text" value="" readonly class="form_datetime" id="readytime">
					  			——&nbsp;<input placeholder="终止时间" size="16" type="text" value="" readonly class="form_datetime" id="lasttime">
					  			<a type="button" href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" id="searchorder"> 搜索</a>
					  		</li>	
					  	</ul>  

					</div>
				
				    <table class="table table-hover text-center" id="tableid">
				    </table>
	   
					<div class="pagelist">
							<a  class="minuspage" name="firstname">首页</a>
							<a  class="minuspage" name="minusname">上一页</a> 
							<a  class="minuspage" name="addname">下一页</a>
							<a  class="minuspage" name="lastname">尾页</a>
							共<span id="pagenum"></span>页
							<input type="text" id="someone" value="1" size ="2">
							<input type="button" value="跳转" id="commitone">
					</div>			
				</div>
		

		</div>
		<!-- 
			查询订单模态框
 		-->
		
		<!-- 
			订单详情模态框
		 -->
		<div class="media media-y margin-big-bottom"></div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close"></button>
						<div class="text-center margin-big padding-big-top">
							<h1>订单菜品信息</h1>
						</div>
					    	<table class="table table-hover text-center" id ="zbTable">
					    		
					    	</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning btn-default modal-alterbtn" data-dismiss="modal" >取消</button>

					</div>
				</div>
			</div>
		</div>


	</div>
	<script type="text/javascript">
	
	    $(".form_datetime").datetimepicker({
	      format: "yyyy-mm-dd hh:ii",
	      autoclose: true,
	      todayBtn: true,
	      language:'zh-CN',
	      pickerPosition:"bottom-left"
	    });

			/*
				总页数
			*/
			function stamp(json){			
						var th="<tr><td>订单号</td><td>订单状态</td><td>订单价格</td><td>点菜数量</td><td>支付方式</td><td>订单时间</td><td>桌台名称</td><td>操作</td></tr>";
					 	$("#tableid").html("");	
					 	$("#tableid").append(th);				 
						$.each(json,function(index,value){
						
						var oldTime = (new Date(value[5])).getTime()/1000;
						//time=value[5].getfullyear+"-"+value[5].getfullmonth+"-"+value[5].getfullday
							var timett=format(value[5].time);
							var emtable=
								"<tr><td id=\"anum"+value[0]+"\">"+value[0]+
								"</td><td id=\"bnum"+value[0]+"\">"+value[1]+"</td><td id=\"cnum"+value[0]+"\">"+value[2]+"</td><td id=\"dnum"+value[0]+"\">"+value[3]+"</td><td id=\"enum"+value[0]+"\">"+value[4]+
								"</td><td id=\"fnum"+value[0]+"\">"+timett+"</td><td id=\"gnum"+value[0]+"\">"+value[6]+"</td>"+
								"<td id=\"fnum"+value[0]+"\">"+
								"<button class=\"button border-main  orderD\" name =\""+value[0]+"\"  aria-labelledby=\"myModalLabel\"  data-target=\"#myModal\" data-toggle=\"modal\">"+
								"<span class=\"icon-edit\"></span> 订单详情</button></td></tr>";
							$("#tableid").append(emtable);																												
						});
								
			}
			//-----------------------------------------订单详情6.30--------------------------------------
			
				$("#tableid").on('click',".orderD",function(){
					var name =$(this).attr("name");
					$.ajax({
						url:"zborders_ZbOrder.action",
						type:"post",
						data:{"orderD":name},
						success:function(data){
							var json =JSON.parse(data);
							$("#zbTable").html("");
							var tab ="<tr><td>菜品名称</td><td>菜品数量</td><td>菜品价格</td><td>菜品状态</td><td>合计</td></tr>";
							$("#zbTable").append(tab);
							$.each(json,function(index,value){
								var price=value[4]*value[5];
								var orderTable=
									"<tr><td>"+value[2]+"</td><td>"+value[4]+"</td><td>"+value[5]+"</td><td>"+value[9]+"</td>"+
									"<td>"+price+"元</td></tr>";
									$("#zbTable").append(orderTable);
							});
						}
					});	
				});
			
						
			//-------------------------------------------------------------------------------
		var pageflag=0;
		$(function(){
			var a=0;
			pagetatolint();
			liyang(a);
		});
		$(function(){
			$("#searchorder").click(function(){
				var readyvalue=$("#readytime").val();
				var lastvalue=$("#lasttime").val();
				if (readyvalue==""&&lastvalue==""){
					pageflag=0;
					var a=0;
					pagetatolint();
					liyang(a);
				}else if (readyvalue!=""&&lastvalue!=""){
					pageflag=1;
					var a=0;
					pagetatolint();
					orderpage(a);
				}else{
					alert("请选择完整的时间段。");
				}
			});
			
		});
		function pagetatolint(){
			var readyvalue=$("#readytime").val();
			var lastvalue=$("#lasttime").val();
				$.ajax({
					url:"order_pageTotal.action",
					type:"post",
					data:{"pageflag":pageflag,"begintime":readyvalue,"endtime":lastvalue},
					success:function(data){						
						if(data%5==0){
							var pagesize=parseInt(data/5);
							$("#pagenum").html(pagesize);					
						}else{
							var pagesize=parseInt(data/5)+1;
							$("#pagenum").html(pagesize);
						}				
					},
				});								
		}
		$(function(){
			$(".minuspage").click(function(){			
				var somename=$(this).attr("name");
						//alert(somename);				 
				var onepage=parseInt($("#someone").val());	
							
				var pagesize=$("#pagenum").html();
				if(somename=="firstname"){
					onepage=1;					
				}else if(somename=="minusname"){
					
					if(onepage<=1){
						onepage=1;
					}else{
						onepage=onepage-1;
					}
				}else if(somename=="addname"){
					if(onepage>=pagesize){
						onepage = pagesize;
					}else{
						onepage = onepage +1;
					}
				}else{
					onepage = pagesize;
				}
				
				a=onepage-1;
				
				if (pageflag==0){
					liyang(a);
				}else if(pageflag==1){
					orderpage(a);
				}				
				$("#someone").val(onepage);
				
				//alert(inputnum);			
			});			
		});
		//时间戳转时间
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
		function liyang(a){
		//alert(a);
			$.ajax({				
					url:"order_getpage.action",
					type:"post",
					data:{"countpage":a},
					success:function(data){				
						var json=JSON.parse(data);
						stamp(json);					
					}
				});
		}
		
			function orderpage(curr){
				var readyvalue=$("#readytime").val();
				var lastvalue=$("#lasttime").val();
				//alert(readyvalue);
				$.ajax({
					url:"order_selorder.action",
					type:"post",
					data:{"begintime":readyvalue,"endtime":lastvalue,"curr":curr},
					success:function(data){
						var json=JSON.parse(data);
						stamp(json);
					}
				});
			};		
		
	</script>
</body>
</html>
