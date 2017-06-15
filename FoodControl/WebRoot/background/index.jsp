
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
	

    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    
	<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
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
  <h2><span class="icon-user"></span>员工管理</h2>
  <ul style="display:block">
  <li><a href="employee.jsp" target="right"><span class="icon-caret-right"></span>员工管理</a></li>
    <li><a href="employeeId.jsp" target="right"><span class="icon-caret-right"></span>员工账号</a></li>
    <li><a href="employeePower.jsp" target="right"><span class="icon-caret-right"></span>员工权限</a></li>                     

  </ul>   
  <h2><span class="icon-pencil-square-o"></span>餐厅管理</h2>
  <ul>
  	<li><a href="deskmanage.jsp" target="right"><span class="icon-caret-right"></span>桌台管理</a></li>
  	<li><a href="dishemanage.jsp" target="right"><span class="icon-caret-right"></span>菜品管理</a></li>    
    <li><a href="cate.jsp" target="right"><span class="icon-caret-right"></span>分类管理</a></li>        
  </ul>
  <h2><span class="icon-pencil-square-o"></span>财务管理</h2>
  <ul>
    <li><a href="chargeback.jsp" target="right"><span class="icon-caret-right"></span>退单详情</a></li>
    <li><a href="finance.jsp" target="right"><span class="icon-caret-right"></span>财务管理</a></li>   
    <li><a href="cate.jsp" target="right"><span class="icon-caret-right"></span>分类管理</a></li>        
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

		$(function(){
		
			$("#tableAdmin").click(function(){
			alert(1);
				$.ajax({
					url:"SxmTable_TableAdmin.action",
					type:"post",
					data:{},
					success:function(data){
					alert(5555);
					 var json=JSON.parse(data);
						if(josn==1){
							alert(666);
						}
					},
				});
			});
		})
</script>
<ul class="bread">
  <li><a href="{:U('Index/employee')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  
  
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="employee.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">

</div>
</body>
</html>