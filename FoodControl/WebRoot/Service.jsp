<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"src="bootstrap/jquery/jquery-2.1.3.min.js"></script>

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	
	<style>
		#div {
			background: url("image/Service-background.png") no-repeat;
			background-size: 100% 100%;
			height: 100%;
		}
		
		.row1 {
			padding: 10px;
			border-bottom:1px solid #666699;
		}
		
		#table-set {
			font-size: 20px;
		}
		
		.table-set-margin {
			margin-top: 30px;
		}
		
		#static {
			padding-top: 20px;
		
		}
		
		
		
		#table {
			padding: 15px;
			padding-left: 80px;
		}
		
		#all-home {
			position: relative;
			max-height:500px;
			background: white;
		}
		
		#all-home div {
			
			margin-left: 40px;
			margin-top: 15px;
			margin-bottom:15px;
			border: 1px solid #6600FF;
			height: 150px;
			text-align:center;
			font-size:25px;
			color:white;
			padding-top:60px;
		}
		#all-home p {
			
			
			
			font-size:15px;
			color:white;
			padding-top:30px;
		}
	
		
		
		#all-home1 {
			position:absolute;
			margin-right:25px;
			right:300px;
			bottom:20px;
		}
		#all-home1 div{
			margin-right:40px;
		}
		#times{
			position:absolute;
			bottom:10px;
			left:100%;
			font-size:20px;
			margin-left:40px;
			white-space:nowrap;
		}
		
		#doper{
			position:absolute;
			top:10px;
			right:200px;
			font-size:20px;
		}

		#modelclear{
			text-align:center;
			color:red;
		}
		#modelclear button{
			margin-right:30px;
			color:blue;
		}
		#myModalLabel{
			color:#ff6666;
		}
		.updatetable input{
			width:50%;
		}
		.updatetable{
			margin-top:20px;
			margin-bottom:20px;
			margin-left:5px;
			margin-right:5px;
		}
		.tablefont{
			color:#ff6600;

		}
	
	.changet{
		width:300px;
		font-size:20px;
	}
	</style>

</head>

<body>
	



	<div class="container-fluid" id="div">

		<!--功能区-->
		<div class="row1 row">
			<!-- 模态框 -->
			<button type="button" class="btn btn-primary btn-lg"
				data-toggle="modal" data-target="#myModal" id="changetable">转台</button>

			
			<a class="btn btn-info btn-lg col-sm-offset-1" href="" role="button" data-toggle="modal" data-target="#myModal1">交班</a>

			<a class="btn btn-success btn-lg col-sm-offset-1" href=""role="button"
			data-toggle="modal" data-target="#myModalclear"  data-toggle="modal" data-target="#myModalclear">清扫结束</a> 

			<span id="doper">操作员：<span id="user"></span></span>
			
				<a class="btn close btn-lg" data-dismiss="modal"aria-label="Close" style="color:#ff00ff" href="background/login.jsp">退出系统</a>
			
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
					<a class="btn btn-success btn-lg" href="#" role="button">当前可供：<span id="tgreen"></span></a>
				</div>
				<div class="table-set-margin">
					<a class="btn btn-danger btn-lg col-md-offset-1" href="#"
						role="button">当前占用：<span id="tred"></span></a>
				</div>
				<div class="table-set-margin">
					<a class="btn btn-warning btn-lg col-md-offset-2" href="#"
						role="button">当前脏台：<span id="torange"></span></a>
				</div>

			</div>

			<div class="pull-left col-xs-10 container-fluid" id="static1">
				<div>
					<!--快速查找桌台-->
					<div id="table">
						<div class="input-group col-sm-6">
							<span class="input-group-btn">
								<button class="btn btn-info" type="button" >快速查找桌号：</button> 
							</span> 
								<input type="text" class="form-control" id="inpbtn" placeholder="Search for...">
							<span class="input-group-btn" id="btn">
								<button class="btn btn-default glyphicon glyphicon-search"
									type="button" ></button> 
							</span>
							
						</div>
					</div>
					<div id="all">

						<!--显示桌台-->
						<div id="all-home" class="pre-scrollable">
							
						</div>
						
					</div>
					
				</div>
			</div>
			<!--结单情况-->
			<div id="all-home1">
							
							<div class="pull-right">
								<h3 class="text-success">已结单:<span id="ordok"></span></h4>
							</div>
							<div class="pull-right">
								<h3 class="text-danger">未结单:<span id="orderr"></span></h4>
							</div>
							<div class="pull-right">
								<h3 class="text-primary">总单数:<span id="ordall"></span></h4>
							</div>
							<span id="times">
								
							</span>
			</div>
		</div>
	</div>
	<!-- 转台模态框 -->
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
							<h3 class="modal-title">更改桌号：</h3>

						</div>
						
						<div class="changet"> 当前桌号：<select  id ="before" name="selectvalue">
							 	  
						</select></div>
						<div class="changet">更改桌号： <select  id ="after" name="selectvalue">
							 	  
						</select></div>
						<div class="modal-footer">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" id="changesave">保存
							</button>
						</div>
					</div>
				</div>
			</div>
	<!-- 交班模态框 -->
	<!-- Modal -->
			<div class="modal fade bs-example-modal-sm" id="myModal1" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog modal-sm" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">努力开发中。。。</h4>
						</div>
					</div>
				</div>
			</div>
	<!-- 清扫结束模态框 -->
	<!-- Modal -->
			<div class="modal fade bs-example-modal-sm" id="myModalclear" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog modal-sm" role="document">
					<div class="modal-content">
						<div class="modal-header" id="modelclear">
							<h4 class="modal-title" id="myModalLabel">一键清除所有脏台？</h4>
							<br/>
							<button type="button" class="btn btn-default close"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-default close" data-dismiss="modal"
								 id="allclears">保存
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
			
				tabonload();
				orderonload();
				setInterval("getTime()",1000);
				$("#user").html("asd");
			});
			/*
				获取系统时间;
			*/
			function getTime()
			{
    			var time = new Date();
   				 $("#times").html(time.toLocaleString());
			}
			/*
				页面加载时自动查询数据库，显示桌台信息
			 */
			
			function tabonload() {
				$.ajax({
					async: false,
					url : "SxmTable_tableAdmin.action",
					type : "post",
					data : {map : null},
					success : function flash(data) {
						var json = JSON.parse(data);
						refresh(json);
					},
				});

			};
			/*
				动态刷新
			*/
			function refresh(json) {
						var i=0;
						var j=0;
						var k=0;
					$("#all-home").html("");	
					$.each(json,function(index, value) {
				
						var orderid=value[3];
						ordertext="订单号："+orderid;
						if(value[3]==null){
							orderid="";
							ordertext="";
						}
						if(value[0]=="6"){
							var	tdiv="tdiv1";
							i++;
						}else if(value[0]=="7"){
							var tdiv="tdiv2";	
							j++;
						}else if(value[0]=="8"){      
							var tdiv="tdiv3";	
							k++;
						}
						var dd = "<a href=\"Seating_details.jsp?ord="+orderid+"&&dname="+value[1]+"\"><div class=\"pull-left col-sm-2 tclick "+tdiv+"\" id=\"deskname"+value[5]+"\">"+ value[1]+
						"<p>"+ordertext+"</p></div></a>";
						//alert("value:"+value[5]);
						$("#all-home").append(dd);
					});
					$(".tdiv1").css("background-color","#33ff33");
					$(".tdiv2").css("background-color","#FF3333");
					$(".tdiv3").css("background-color","#ff9900");
					$("#tgreen").html(i);
					$("#tred").html(j);
					$("#torange").html(k);
			}
			
			/*
				快速搜索,搜索到的内容动态到第一个；
			*/
			$("#btn").click(function(){
				tabonload();
				var allput=$("#inpbtn").val();
				$.ajax({
					url : "SxmTable_indexTable.action",
					type : "post",
					data : {"search" :allput},
					success:function(data){
						var json = JSON.parse(data);
						$.each(json,function(index, value) {
							if(value[4]=="可用"){
								var	tdiv="tdiv1";
							}else if(value[4]=="占用"){
								var tdiv="tdiv2";	
							}else if(value[4]=="脏台"){
								var tdiv="tdiv3";	
							}
							var dd1= "<div class=\"pull-left col-sm-2 "+tdiv+"\" id=\"deskname"+value[0]+"\">"+ value[1]+"</div>";
							var tbid="deskname"+value[0];
							//alert("value0:"+value[0]);
							//alert("tbid:"+tbid);
							$("#"+tbid).remove();
							$("#all-home").prepend(dd1);
							
							$("#"+tbid).css("border","10px solid #ff0099");
						});
						$(".tdiv1").css("background-color","#33ff33");
						$(".tdiv2").css("background-color","#FF3333");
						$(".tdiv3").css("background-color","#ff9900");	
					}
				});
			});
			/*
				点击刷新按钮
			
			$("#tflash").click(function(){
				tabonload();
			})
			*/
			/*
				登陆成功后带值显示到本页面；
			*/
			$(function(){
    			var dd='${username}';
    			$("#user").html(dd);	
    			dd=null;
    		})
			/*
				页面加载时自动查询数据库，显示桌台信息 动态获取订单信息;
			 */
			
			function orderonload(){
				$.ajax({
					url : "addfood_searchOrder.action",
					type : "post",
					data : {},
					success : function flash(data) {
						var json = JSON.parse(data);
						var i=0;//订单进行中的状态
						var j=0;//订单结束状态
						var k=0;
						$.each(json,function(index,value){				
							if(value[0]==15){
								i++;
							}
							if(value[0]==16){
								j++;
							}
							k=i+j;
						});						
						$("#ordok").html(j);
						$("#orderr").html(i);
						$("#ordall").html(k);
					},
				});

			};

		/*
			清台
		*/	

		$("#allclears").click(function(){
			$.ajax({
				url:"addfood_clearAllDesk.action",
				type:"post",
				data:{},
				success:function(data){
					tabonload();
				}
			});
		})
		/*
			转台
		*/
		//点转台按钮
		$("#changetable").click(function(){
			$.ajax({
					url : "SxmTable_tableAdmin.action",
					type : "post",
					data : {map : null},
					success : function flash(data) {
						var json = JSON.parse(data);
						
						$("#after").html("");
						$("#before").html("");
						$.each(json,function(index, value) {			
							if(value[0]=="6"){
								var bopt="<option>"+value[1]+"</option>";	
							}
							$("#after").append(bopt);
							if(value[0]=="7"){
								var aopt="<option>"+value[1]+"</option>";
							}
							$("#before").append(aopt);
						});
						
					},
				});
		});
		//点转台模态框的保存按钮
		$("#changesave").click(function(){
			var cbefore=$("#before option:selected").val();
			var cafter=$("#after option:selected").val();
			$.ajax({
				url:"SxmTable_changedesk.action",
				type:"post",
				data:{"st.deskName":cbefore,"tablename":cafter},
				success:function(data){
					tabonload();

				}
			});
		})
	</script>
</body>
</html>
