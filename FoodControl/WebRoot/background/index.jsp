
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!-- 
	后台主页面
 -->
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<<<<<<< HEAD
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    
	<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:"",
				data:{},
				type:"post",
				success:function(data){
					
				}
			})
		})
	</script>
  </head>
														  <!-- 
														  	后台主页面
														   -->
 <body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/index.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l">
	  <a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> 
	   &nbsp;&nbsp;<a class="button button-little bg-red" href="login.jsp"><span class="icon-power-off"></span> 退出登录</a> 
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>人事管理</h2>
  <ul style="display:block">
  <li><a href="fresh_staffinfo.action" target="right"><span class="icon-caret-right"></span>员工管理</a></li>
    <li><a href="fresh_staffid.action" target="right"><span class="icon-caret-right"></span>员工账号</a></li>
    <li><a href="fresh_powers.action" target="right"><span class="icon-caret-right"></span>角色权限</a></li>                     
	
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>餐厅管理</h2>
  <ul>
  	<li><a href="fresh_deskmanage.action" target="right"><span class="icon-caret-right"></span>桌台管理</a></li>
  	<li><a href="fresh_dishmanage.action" target="right"><span class="icon-caret-right"></span>菜品管理</a></li>    
    <li><a href="fresh_kindmanage.action" target="right"><span class="icon-caret-right"></span>分类管理</a></li>        
  </ul>
  <h2><span class="icon-pencil-square-o"></span>财务管理</h2>
  <ul> 
    <li><a href="fresh_orderdetail.action" target="right"><span class="icon-caret-right"></span>订单详情</a></li>
    <li><a href="fresh_returnorder.action" target="right"><span class="icon-caret-right"></span>退单详情</a></li>   
    <li><a href="fresh_incomedetail.action" target="right"><span class="icon-caret-right"></span>收入详情</a></li>        
  </ul>
  <h2><span class="icon-pencil-square-o"></span>其他</h2>
  <ul>
  	<li><a href="leaveword.jsp" target="right"><span class="icon-caret-right"></span>留言管理</a></li>      
  </ul>    
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});

		
</script>
<ul class="bread">
  <li><a href="{:U('Index/employee')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  
  
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
=======
<title>后台管理中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">

<script type="text/javascript"
	src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
	
	<style>
		#datatime span{
			font-size:20px;
			position:absolute;
			right:20px;
			
		}
		.admin{
			border:1px solid;
		}
		#user{
			margin-left:120px;
			font-size:20px;
		}
	</style>
</head>
<!-- 
														  	后台主页面
														   -->
<body style="background-color:#f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="images/index.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />后台管理中心
				<span id="user"></span>
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="" target="_blank"><span
				class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a
				class="button button-little bg-red" href="login.jsp"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>员工管理
		</h2>
		<ul style="display:block">
			<li><a href="employee.jsp" target="right"><span
					class="icon-caret-right"></span>员工管理</a>
			</li>
			<li><a href="employeeId.jsp" target="right"><span
					class="icon-caret-right"></span>员工账号</a>
			</li>
			<li><a href="employeePower.jsp" target="right"><span
					class="icon-caret-right"></span>角色权限</a>
			</li>

		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>餐厅管理
		</h2>
		<ul>
			<li><a href="deskmanage.jsp" target="right"><span
					class="icon-caret-right"></span>桌台管理</a>
			</li>
			<li><a href="dishemanage.jsp" target="right"><span
					class="icon-caret-right"></span>菜品管理</a>
			</li>
			<li><a href="cate.jsp" target="right"><span
					class="icon-caret-right"></span>分类管理</a>
			</li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>财务管理
		</h2>
		<ul>
			<li><a href="chargeback.jsp" target="right"><span
					class="icon-caret-right"></span>退单详情</a>
			</li>
			<li><a href="finance.jsp" target="right"><span
					class="icon-caret-right"></span>财务管理</a>
			</li>
			<li><a href="cate.jsp" target="right"><span
					class="icon-caret-right"></span>分类管理</a>
			</li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>其他
		</h2>
		<ul>
			<li><a href="leaveword.jsp" target="right"><span
					class="icon-caret-right"></span>留言管理</a>
			</li>
		</ul>
	</div>
	
	<ul class="bread">
		<li><a href="{:U('Index/employee')}" target="right"
			class="icon-home"> 首页</a>
		</li>
		<li><a href="##" id="a_leader_txt">网站信息</a>
		</li>

>>>>>>> 1e91209ac6cd4c43d80cc7d3c90fb56ed49d713d

	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="employee.jsp"
			name="right" width="100%" height="95%"></iframe>
		<div id="datatime">
		<span id="times"></span>

		</div>
	</div>
	<div style="text-align:center;"></div>
	
	<script text="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			});
		});
		
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
		/*
			登陆成功后带值显示到本页面；
		*/
		$(function(){
    		var dd='${username}';
    		$("#user").html("操作员："+dd);	
    		dd=null;
    	})
	</script>
</body>
</html>