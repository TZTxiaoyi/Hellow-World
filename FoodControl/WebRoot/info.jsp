<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
  
  <body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 员工信息</strong></div>
 <div>
	 <form method="post" action="">
	  <div class="panel admin-panel">	    
	    <div class="padding border-bottom">
	      <ul class="search">
	        <li>
	          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
	          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
	          <a class="button border-yellow" href=""><span class="icon-plus-square-o"></span> 添加员工</a>
	        </li>
	        <li>
	        	<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          		<a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
	        </li>
	      </ul>
	    </div>
	    <table class="table table-hover text-center">
	      <tr>
	        <th width="120">姓名</th>
	        <th>角色</th>       
	        <th>电话</th>
	        <th>性别</th>
	        <th>年龄</th>
	        <th width="25%">地址</th>
	         <th width="120">就职时间</th>
	         <th>负责桌台</th>
	        <th>操作</th>       
	      </tr>      
	        <tr>
	          <td><input type="checkbox" name="id[]" value="1" />路飞</td>
	          <td>收银</td>
	          <td>18838972400</td>
	          <td>男</td>  
	           <td>15</td>         
	          <td>海贼王之东海风车村</td>
	          <td>2016-07-01</td>
	          <td>1</td>
	          <td>
	          	<div class="button-group"> 
	          		<a class="button border-red" href="javascript:void(0)" onclick="return del(1)">
	          			<span class="icon-trash-o"></span> 删除
	          		</a>
	          		<a type="button" class="button border-main" href="#">
	          			<span class="icon-edit"></span>
	          		修改</a> 
	          	</div>
	          </td>
	        </tr>
	        <tr>
	          <td><input type="checkbox" name="id[]" value="1" />索隆</td>
	          <td>收银</td>
	          <td>18838972400</td>
	          <td>男</td>  
	           <td>16</td>         
	          <td>海贼王之东海霜月村</td>
	          <td>2016-07-01</td>
	          <td>1</td>
	          <td>
	          	<div class="button-group"> 
	          		<a class="button border-red" href="javascript:void(0)" onclick="return del(1)">
	          			<span class="icon-trash-o"></span> 
	          		删除</a>
	          		<a type="button" class="button border-main" href="#">
	          			<span class="icon-edit"></span>
	          		修改</a> 
	          	</div>
	          </td>
	        </tr>
	          <tr>
	          <td><input type="checkbox" name="id[]" value="1" />山治</td>
	          <td>厨师</td>
	          <td>18838972400</td>
	          <td>男</td>  
	           <td>16</td>         
	          <td>海贼王之东海巴拉蒂耶海上餐厅</td>
	          <td>2016-07-01</td>
	          <td>1</td>
	          <td>
	          	<div class="button-group"> 
	          		<a class="button border-red" href="javascript:void(0)" onclick="return del(1)">
	          			<span class="icon-trash-o"></span> 
	          		删除</a> 
	          		<a type="button" class="button border-main" href="#">
	          			<span class="icon-edit"></span>
	          		修改</a>
	          	</div>
	          </td>
	        </tr>
	          <tr>
	          <td><input type="checkbox" name="id[]" value="1" />娜美</td>
	          <td>服务员</td>
	          <td>13420925611</td>
	          <td>女</td>  
	           <td>15</td>         
	          <td>海贼王之东海可可亚西村</td>
	          <td>2016-07-01</td>
	          <td>1</td>
	          <td>
	          	<div class="button-group"> 
	          		<a class="button border-red" href="javascript:void(0)" onclick="return del(1)">
	          			<span class="icon-trash-o"></span> 
	          		删除</a> 
	          		<a type="button" class="button border-main" href="#">
	          			<span class="icon-edit"></span>
	          		修改</a>
	          	</div>
	          </td>
	        </tr>
	          <tr>
	          <td><input type="checkbox" name="id[]" value="1" />罗宾</td>
	          <td>服务员</td>
	          <td>13420925611</td>
	          <td>女</td>  
	           <td>15</td>         
	          <td>海贼王之西海奥哈拉</td>
	          <td>2016-07-01</td>
	          <td>1</td>
	          <td>
	          	<div class="button-group"> 
	          		<a class="button border-red" href="javascript:void(0)" onclick="return del(1)">
	          			<span class="icon-trash-o"></span> 
	          		删除</a> 
	          		<a type="button" class="button border-main" href="#">
	          			<span class="icon-edit"></span>
	          		修改</a>
	          	</div>
	          </td>
	        </tr>
	      <tr>
	        <td colspan="8">
	        <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
	      </tr>
	    </table>
	  </div>
	</form>
</div>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</div>
</body>
</html>
