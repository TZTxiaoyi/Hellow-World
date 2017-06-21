<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>

<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"achieve_"
		});
	});
</script>
</head>
  
 <body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>权限管理</strong>
  	<div class="panel admin-panel">

  <div class="padding border-bottom">
    <button type="button" class="button border-yellow" onclick="window.location.href='#add'">
    	<span class="icon-plus-square-o"></span> 添加分类
    </button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">角色名称</th>
     <th width="15%">权限等级</th>
      <th width="10%">权限备注</th>
      <th width="10%">修改权限</th>
    </tr>
    <tr>
      <td>管理员</td>
      <td>最高等级</td>
      <td>管理所有业务</td>
      <td>
      	<div class="button-group"> 
      		<a type="button" class="button border-main" data-target="#myModal1" data-toggle="modal" aria-labelledby="myModalLabel">
      		<span class="icon-edit"></span> 修改</a>
      	</div>
      </td>
    </tr>
    
  </table>
</div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){			
		
	}
}
</script>
  	
  </div>
</div>



<!-- Modal -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">角色权限更改</h4>
			</div>
			<div class="modal-body1">
				<span class="input-group-addon">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			 </div>
		</div>
	 </div>
</div>
</body>
</html>
