<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<!-- 
		后台桌位详情页面
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
	<script type="text/javascript"
		src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
		
	<script type="text/javascript" src="../bootstrap/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<link rel="stylesheet" href="../bootstrap/css/bootstrap-datetimepicker.css" type="text/css"></link>
	
	
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"
		type="text/css"></link>
	
	
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
	
	</style>
</head>

<body>
	
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 桌台信息</strong>
		</div>
		<div>
			<form method="post" action="">
				<div class="panel admin-panel">
					<div class="padding border-bottom">
						
								<a class="button border-yellow" data-toggle="modal"
								data-target="#myModaltable" id="zbdesk">桌台销售统计</a>
									
							

					</div>
					<table class="table table-hover text-center"  id="tab">
						
						
					</table>
					<!-- <div class="pagelist">
						<a name="first" class="page" href="#">首页</a><a name="minus" class="page" href="#">上一页</a><a name="add" class="page" href="#">下一页</a><a name="last" class="page" href="#">尾页</a><input type="text" id="pageinp" value="1" size="5"/>
						<a class="page" type="button">跳转</a>共<span id="spanpage"></span>页
					</div> -->
					<div class="zbpagelist">
					<a  class="zbpage" name="zbfirst" href="#">首页</a>
					<a  class="zbpage" name="zbminus" href="#">上一页</a> 
					<a  class="zbpage" name="zbadd" href="#">下一页</a>
					<a  class="zbpage" name="zblast" href="#">尾页</a>
					共<span id="zbpagenum"></span>页
					<input type="text" id="zbsome" value="1" size ="5">
					<input type="button" value="跳转" class ="zbpage" name ="zbcommit" id="zbcommit">
			</div>
				</div>
			</form>
		</div>
		<!-- 
			添加桌台模态框
 		-->
		<div class="media media-y margin-big-bottom"></div>
		<div class="modal fade" id="myModaltable" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss=modal></button>
						<div class="text-center margin-big padding-big-top">
							<h1>桌位详细信息</h1>
						</div>
						 <div id="modalform">
						 
						 <select class="form-control" id ="desknub" name="selectvalue">
							 	  
						</select>
						 
					    	<div id="ddd" class="input-append date form_datetime">
						      起始时间：<input size="16" type="text" value="" readonly id ="inpu1">
						      <span class="add-on"><i class="icon-th"></i></span>
						     </div>
						     <div id="ddd" class="input-append date form_datetime">
						      结束时间：<input size="16" type="text" value="" readonly id ="inpu2">
						      <span class="add-on"><i class="icon-th"></i></span>
						     </div>
					    	
					    	<div>
								<button class="btn btn-warning btn-group-lg confirm-btn" data-dismiss="modal" id="zbbtn">查询</button>	
							</div>
					 </div>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
	</div>
	
	<script type="text/javascript">
	//----------------------------日历----------------------------------------------
	    $(".form_datetime").datetimepicker({
	      format: "yyyy-mm-dd hh:ii",
	      autoclose: true,
	      todayBtn: true,
	      language:'zh-CN',
	      pickerPosition:"bottom-left"
	    });
	    
	    $(function(){
	    
	    	 $("#zbdesk").click(function(){
	    	$.ajax({
				url:"zborders_orders.action",
				type:"type",
				data:{},
				success:function(data){
					$("#desknub").html("");
					var json = JSON.parse(data);
					var op="<option>选取桌号</option>";
					$("#desknub").append(op);
					$.each(json,function(index,value){
						var opt="<option value=\""+value[0]+"\">"+value[2]+"</option>";
						$("#desknub").append(opt);
					});
				}
			});
	    });
	    });
	   
	    $("#zbbtn").click(function(){
	   
	   		var va = $("#desknub").val();
	   		var va1 = $("#inpu1").val();
	   		var va2 = $("#inpu2").val();
	   		$.ajax({
	   			url:"zborders_zbDeskQu.action",
	   			type:"post",
	   			data:{"zbde.va":va,"zbde.va1":va1,"zbde.va2":va2},
	   			success:function(data){
	   				var json = JSON.parse(data);
	   				/* var zbva ="<tr><td>订单号</td><td>订单总价(元)</td><td>订单状态</td><td>支付方式</td></tr>";
	   				$("#tab").append(zbva);
	   				
	   				$.each(json,function(index,value){
	   					
	   					var va = "<tr><td>"+value[0]+"</td><td>"+value[2]+"</td><td>"+value[1]+"</td><td>"+value[4]+"</td></tr>";
	   					$("#tab").append(va);
	   				}); */
	   				
	   			}
	   		});
	   }); 
	   function refresh(json) {
				var zbva ="<tr><td>订单号</td><td>订单总价(元)</td><td>订单状态</td><td>支付方式</td></tr>";
					$("#tab").html("");
	   				$("#tab").append(zbva);
	   				
					$.each(json,function(index, value) {
						var va = "<tr><td>"+value[0]+"</td><td>"+value[2]+"</td><td>"+value[1]+"</td><td>"+value[4]+"</td></tr>";
	   					$("#tab").append(va);
					});
		
		}
    	
    	//------------------------分页（总）-------------------------
    	$(function(){
			$.ajax({
				url : "zborders_zbtotalpage.action",
				data: {},
				type: "post",
				success : function(data){
					var zbtotal = parseInt(data/3);
					if(data%3 == 0){
						$("#zbpagenum").html(zbtotal);
					}
					if(data%3 != 0){
						$("#zbpagenum").html(parseInt(zbtotal)+1);
					}
				},
			});
		});
	//++++++++++++++++++++++++分页++++++++++++++++++++++++++++++
		$(function(){
			$(".zbpage").click(function(){
				var name = $(this).attr("name");
				var zbsome1 = parseInt($("#zbsome").val());
				if(name == "zbfirst"){
					zbsome1 = 1;
				}
				if(name == "zbminus"){
					zbsome1 = zbsome1 - 1;
					if(zbsome1 <= 1){
						zbsome1 = 1;
					}
				}
				if(name=="zbadd"){
						zbsome1=zbsome1+1;
						if(zbsome1>=$("#zbpagenum").html()){
							zbsome1=$("#zbpagenum").html()
							
						}
				}
				
				if(name=="zblast"){
					zbsome1=$("#zbpagenum").html();
				}
					$("#zbsome").val(zbsome1);
					var curr=zbsome1-1;
					
					zbtabonload(curr);
			});
		});
		$(function() {
				var currpage=0;
				zbtabonload(currpage);
			});
		function zbtabonload(curr){
			$.ajax({
				url : "zborders_zbtabpage1.action",
				data : {"currpage":curr},
				type : "post",
				success : function flash(data){
					var json = JSON.parse(data);
					refresh(json);
				},
			});
		}
	
	</script>
</body>
</html>
