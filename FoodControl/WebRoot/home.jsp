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
	


	<style>
		body {
			background: url("image/timg.jpg");
		}
		
		.container {
			margin-left: 280px;
		}
		
		#model input {
			width: 210px;
			height: 40px;
		}
		
		form div {
			margin-left: 20%;
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
	</style>
</head>

<body>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:450px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<div id="btn">
					<button type="button" class="btn btn-default btn-lg btn-danger">
						<h1 class="glyphicon glyphicon-cutlery" aria-hidden="true"></h1>
						<p>自助点餐</p>
					</button>
					
					<button type="button" class="btn btn-default btn-lg btn-Info"
						data-toggle="modal" data-target="#myModal2">
						<h1 class="glyphicon glyphicon-heart" aria-hidden="true"></h1>
						<p>开始点餐</p>
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
		</div>
	</div>
<!-- 开始点餐模态框 -->

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
					<form>
						
						
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
							 name ="zbud.account"/> <span
							id="aa1"></span>
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
						<input placeholder="手机号/用户名/邮箱" type="text" id="adduser"
							onfocus="userFocus()" onblur="userBlur()" name ="userdata.account"/> <span
							id="aaa1"></span>
					</div>
					<div>
						<input placeholder="输入密码" type="password" id="addpwd"
							onfocus="passFocus()" onblur="passBlur()" name ="userdata.pwd"/> <span
							id="aa2"></span>
					</div>
					<div>
						<input placeholder="再次输入密码" type="password" id="addpwds"
							onfocus="repassFocus()" onblur="repassBlur()" /> <span
							id="aa3"></span>
					</div>
					<div>
						<button type="submit" class="btn btn-warning btn-group-lg" >注册</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type ="text/javascript">
		function userFocus(){
			var user1=document.getElementById("aa1");
			//user1.style.display="none";
			user1.innerHTML="";
		}
		function userBlur(){
		
			var user2=document.getElementById("adduser").value;
			var user1=document.getElementById("aa1");
			var reg=new RegExp("[^A-Za-z0-9]+","gi");
			if (reg.test(user2)){
				
				user1.innerHTML="用户名格式有误";
				//user1.style.display="block";
				return false;
				
			}else{
			
				$.ajax({
					type:"post",
					url:"home_seluser.action",
					data:{"userdata.account":user2},
					success:function(data){
						
						if(data!=0){
							$("#aaa1").html("*用户名已占用");
							
							
						}else{
							
							$("#aaa1").html("");
						}
					}
				});
				return true;
			}
		}
		
		function passFocus(){
			var user1=document.getElementById("aa2");
			//user1.style.display="none";
			user1.innerHTML="";
		}
		function passBlur(){
		
			var user2=document.getElementById("addpwd").value;
			var user1=document.getElementById("aa2");
			if (user2.length>=6){
				
				return true;
			}else{
				
				user1.innerHTML="密码不正确";
				return false;
			}
		}
		function repassFocus(){
			var user1=document.getElementById("aa3");
			//user1.style.display="none";
			user1.innerHTML="";
		}
		function repassBlur(){
			var user2=document.getElementById("addpwd").value;
			var user1=document.getElementById("aa3");
			var user3=document.getElementById("addpwds").value;
			
			if (user2 == user3){
				
				return true;
			}else{
				user1.innerHTML="密码不一致";
				return false;
			}
		}
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
		/* $(function(){
			$("#login").click(function(){
			
				var val = $("#usageuser").val();
				var valpa= $("#usagepwd").val();
				$.ajax({
					type:"post",
					url:"Home_login.action",
					data:{"zbud.account":val,"zbud.pwd":valpa},
					success:function(data){
					alert(1);
						var json = JSON.parse(data);
						
						if(data == -1){
							alert("用户名或密码不对");
						}
						
					},
				});
			});
		}); */
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
		</script>
		
		
</body>
</html>