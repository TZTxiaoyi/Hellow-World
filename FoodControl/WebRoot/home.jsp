<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 前台主页面 -->

<title>My JSP 'Home.jsp' starting page</title>

<!--
			<link rel="stylesheet" type="text/css" href="styles.css">
			-->

	
	
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
		type="text/css"></link>
	<script type="text/javascript"
		src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
	
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	


	<style type="text/css">
		body {
			background: url("image/timg.jpg");
		}
		
		.container {
			margin-left: 250px;
		}
		
		#model input {
			width: 200px;
			height: 40px;
		}
		
		form div {
			margin-left:15%;
			width: 350px;
			height: 40px;
			margin-top: 30;
		}
		
		input {
			width: 210px;
			height: 40px;
		}
		
		.p {
			display: none;
		}
		span{
			color:red;
		}
		.form-control{
			width:210px;
			height:40px;
		}
		#hometext{
			position:absolute;
			top:0%;
			left:30%;
			color:white;
		}
		#times{
			position:absolute;
			top:10px;
			right:10px;
			font-size:20px;
		}
		#username{
			position:absolute;
			top:10px;
			right:300px;
			font-size:20px;
		}
		form span{
			font-size:18px;
			white-space:nowrap;
			color:red;
		}
	</style>
	

</head>

<body>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:450px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<h1 id="hometext">欢&nbsp;&nbsp;&nbsp;迎&nbsp;&nbsp;&nbsp;使&nbsp;&nbsp;&nbsp;用&nbsp;&nbsp;&nbsp;
				网&nbsp;&nbsp;&nbsp;上&nbsp;&nbsp;&nbsp;点&nbsp;&nbsp;&nbsp;餐&nbsp;&nbsp;&nbsp;系&nbsp;&nbsp;&nbsp;统</h1>
				<div id="btn">
					<button type="button" class="btn btn-default btn-lg btn-danger" 
					data-toggle="modal" data-target="#myModal4">
						<h1 class="glyphicon glyphicon-cutlery" aria-hidden="true"></h1>
						<p>网络点餐</p>
					</button>
					
					<button type="button" class="btn btn-default btn-lg btn-Info"
						data-toggle="modal" data-target="#myModal2"  id="orderfood">
						<h1 class="glyphicon glyphicon-heart" aria-hidden="true"></h1>
						<p>自助点餐</p>
					</button>
				</div>
				<div class="media media-y margin-big-bottom"></div>
				<div id="btn">
					<button type="button" class="btn btn-default btn-lg btn-primary "
						data-toggle="modal" data-target="#myModal1">
						<h1 class="glyphicon glyphicon-tint" aria-hidden="true"></h1>
						<p>用户登录</p>
					</button>
					<button type="button" class="btn btn-default btn-lg btn-success"
						data-toggle="modal" data-target="#myModal">
						<h1 class="glyphicon glyphicon-leaf" aria-hidden="true"></h1>
						<p>用户注册</p>
					</button>
				</div>
			</div>
			<div id="username"></div>
			<div id="times"></div>
		</div>
	</div>
<!-- 网络点餐模态框 -->	
		<div class="media media-y margin-big-bottom"></div>
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss=modal>×</button>
					<div class="text-center margin-big padding-big-top">
						<h1>餐饮管理系统</h1>
					</div>
				</div>

				<form action="addfood_newFood.action" method="post"  onsubmit="return show3()">


					<div>
						<input placeholder="手机号" type="text" id="zbphone"
							 name ="zbphone"/><span id ="zbtext1"></span>
					</div>
					<div>
						<input placeholder="地址" type="text" id="zbaddress"
							 name ="zbaddress"/><span id = "zbtext2"></span>
					</div>
					
					<div>
						<input type="submit"
							class="button button-block bg-main text-big input-big" id="zbclick" value="点击进入">
							
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
<!-- 自助点餐模态框 -->

	<div class="media media-y margin-big-bottom"></div>
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss=modal><h1>×</h1></button>
						<div class="text-center margin-big padding-big-top">
							<h1>餐饮管理系统</h1>
						</div>
					</div>
					<form action ="addfood_newFood.action" method ="post" onsubmit="return show2()">
						<div>
						<!-- <input placeholder="请输入桌号" type="text" id="desknub"
							 name ="desknub"/> -->
							  <select class="form-control" id ="desknub" name="selectvalue">
							 	  
							</select>
					</div>
					<div>
						<input placeholder="请输入人数" type="text" id="personnub"
							 name ="personnub"/><span id="pernum"></span>
					</div>
					<div>
						<!-- <a class="btn btn-lg btn-info bg-main text-big input-big"  href="addfood_newFood.action" id="orderfood2">
						开始点餐</a> -->
						<input type="submit"
							class="button button-block bg-main text-big input-big" id="orderfood2" value="开始点餐">
					</div>
						
					</form>
				</div>
			</div>
		</div>
<!-- 用户登录模态框 -->

	<div class="media media-y margin-big-bottom"></div>
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss=modal>×</button>
					<div class="text-center margin-big padding-big-top">
						<h1>餐饮管理系统</h1>
					</div>
				</div>

				<form action="home_login.action" method="post" onsubmit="return show1()">


					<div>
						<input placeholder="手机号/用户名/邮箱" type="text" id="usageuser"
							 name ="zbud.account"/> 
							 <span ></span>
					</div>
					<div>
						<input placeholder="输入密码" type="password" id="usagepwd"
							 name ="zbud.pwd"/> <span
							id="aaa2"></span>
					</div>
					<div class="field">
						<input type="text" class="input input-big" name="code" width="100" onblur="paBlur1()"
							placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" /> <img
							src="image/passcode.jpg" alt="" width="100" height="32"
							class="passcode" style="height:43px;cursor:pointer;"
							onclick="this.src=this.src+'?'">

					</div>
					<div>
						<input type="submit"
							class="button button-block bg-main text-big input-big" id="login" value="登录">
					</div>
				</form>
			</div>
		</div>
	</div>


<!-- 用户注册模态框 -->

	<div class="media media-y margin-big-bottom"></div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss=modal>×</button>
					<h4 class="modal-title margin-big padding-big-top"
						id="myModalLabel">

						如有账号， <a href="home.jsp">请登录</a>
					</h4>
				</div>
				<form action="home_register.action" method="post" onsubmit="return show()">

					<div>
						<input placeholder="手机号/用户名/邮箱" type="text" id="adduser" name ="userdata.account"/> 
						<br/><span id="loginuser"></span>
					</div>
					<div>
						<input placeholder="输入密码" type="password" id="addpwd"
						name ="userdata.pwd"/><br/> <span id="aa2"></span>
					</div>
					<div>
						<input placeholder="再次输入密码" type="password" id="addpwds"/> 
						<br/><span id="aa3"></span>
					</div>
					<div>
						<button type="submit" class="btn btn-warning btn-group-lg" >注册</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type ="text/javascript">
		function getTime(){
    		var time = new Date();
   			$("#times").html(time.toLocaleString());
		}
		$(function(){
    		setInterval("getTime()",1000);
    		$("#username").html("");
    		if('${user}'!=""){
    			$("#username").html("欢迎用户："+'${user}');
    			
    		}
    		
		});
		/*
			注册的用户名聚焦事件
		*/
		$("#adduser").focus(function(){
			$("#loginuser").html("");
		});
		/*
			注册的用户名失焦事件
		*/
		$("#adduser").blur(function(){
			var user2=$("#adduser").val();
			var reg=new RegExp("[^A-Za-z0-9\u4e00-\u9fa5]+","gi");
			if (reg.test(user2)){
				$("#loginuser").html("用户名格式有误");
			}else if(user2.length<=6||user2.length>=20){
				$("#loginuser").html("请输入6位以上20位以下账号");
			}else{
				$.ajax({
					type:"post",
					url:"home_seluser.action",
					data:{"userdata.account":user2},
					success:function(data){
						if(data!=0){
							$("#aa1").html("*用户名已占用");	
						}else{	
							$("#aa1").html("");
						}
					}
				});
				return true;
			}
		});
		/*
			密码的聚焦事件
		*/
		$("#addpwd").focus(function(){
			$("#aa2").html("");
		});
		/*
			密码的失焦事件
		*/
		$("#addpwd").blur(function(){
			var reg=new RegExp("[^A-Za-z0-9]+","gi");
			var user2=$("#addpwd").val();
			if (reg.test(user2)){
				$("#aa2").html("密码格式有误");
			}else if (user2.length>=6 && user2.length<=20){
				return true;
			}else{
				$("#aa2").html("请输入6位以上20位以下密码");
				return false;
			}
		})
		/*
			重复密码的聚焦事件
		*/
		$("#addpwds").focus(function(){
			$("#aa3").html("");
		});
		/*
			重复密码的失焦事件
		*/
		$("#addpwds").blur(function(){
			var user2=$("#addpwd").val();
			var user3=$("#addpwds").val();
			if (user2 == user3){
				return true;
			}else{
				$("#aa3").html("密码不一致");
				return false;
			}
		});
		function show(){
			var c1=userBlur();
			var c2=passBlur();
			var c3=repassBlur();
			
			
			if (c1&&c2&&c3){
				return true;
			}else{
				alert("不能提交")
				return false;
				
			}
			
		}
		
		
	//开始点餐================================
		$(function(){
			/*$("#orderfood").click(function(){
				
			});*/
			$.ajax({
				url:"home_orders.action",
				type:"type",
				data:{},
				success:function(data){
					var json = JSON.parse(data);
					var op="<option>选取桌号</option>";
					$("#desknub").append(op);
					$.each(json,function(index,value){
						var opt="<option>"+value[2]+"</option>"
						$("#desknub").append(opt);
					});
				},
			});
		});
		function show2(){
			var va1 = $("select").val();
			var va2 = $("#personnub").val();
			if(va1=="选取桌号" || va2==""){
				alert("信息须填写完整");
				return false;
			}else{
				return true;
			}
		}
		function show3(){
			var zbphone = $("#zbphone").val();
			var zbaddress = $("#zbaddress").val();
			if(zbphone == "" || zbaddress == ""){
				alert("信息须填写完整");
				return false;
			}else{
				return true;
			}
		}

//聚焦事件
		$(function(){
			$("#zbphone").focus(function(){
				$("#zbtext1").html("*为保证服务质量，请填写真实号码");
			});
			$("#zbphone").blur(function(){
				$("#zbtext1").html("");
			});
			$("#zbaddress").focus(function(){
				$("#zbtext2").html("*请填写详细地址");
			});
			$("#zbaddress").blur(function(){
				$("#zbtext2").html("");
			});
		});
//=================================================	
		$(function(){
			if('${na}' == "k"){
				alert("用户名或密码不一致");	
			}	
		});
		$(function(){
			if('${zb}' == 1){
				alert("注册成功");
			}
		});
		$("#personnub").blur(function(){
			var pnum=$(this).val();
			var reg=new RegExp("[^0-9]+","gi");
			if(reg.test(pnum)){
				//alert("请正确输入人数");
				$("#pernum").html("请正确输入人数");
			}
			if(pnum>20 || pnum<1){
					//alert("输入人数过多");
				$("#pernum").html("输入人数过多");
			}
			if(pnum==0){
				$("#pernum").html("至少输入1人");
			}
		});
		$("#personnub").focus(function(){
			$("#pernum").html("");
		});
		</script>
		
		
</body>
</html>