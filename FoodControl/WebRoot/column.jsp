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
  <div class="panel-head"><strong class="icon-reorder"> 退单列表</strong></div>
  <div class="padding border-bottom">
  	<ul>
  		<li>
  			<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
  		</li>
  	</ul>  
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>     
      <th>订单号</th>  
      <th>退单原因</th>
      <th>退单时间</th>     
      <th width="250">操作</th>
    </tr>
   
    <tr>
      <td>1</td>      
      <td>201701</td>  
      <td>人太多了，不想吃了</td> 
      <td>2017-06-13</td>     
      <td>
      <div class="button-group">      
       <a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>
      </div>
      </td>
    </tr> 
    
    <tr>
      <td>2</td>      
      <td>201702</td>  
      <td>还没想好</td> 
      <td>2017-06-14</td>     
      <td>
      <div class="button-group">
       <a class="button border-red" href="javascript:void(0)" onclick="return del(17)"><span class="icon-trash-o"></span> 删除</a>
      </div>
      </td>
    </tr>  
    
    
    
    
    
   
    
  </table>
</div>
<script>
function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}
</script>

</body>
</html>
