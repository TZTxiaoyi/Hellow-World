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
			url:"achieve_modul.action",
			type:"post",
			data:{},
			success:function(data){
			var json=JSON.parse(data);
			var th="<tr><td>角色</td><td>权限名称</td><td>权限等级</td><td>操作</td></tr>";
			$("#tableid").append(th);
				$.each(json,function(index,value){												 									 			
				var emtable=
				"<tr><td id=\"anum"+value[1]+"\">"+value[0]+
				"</td><td id=\"bnum"+value[1]+"\">"+value[1]+"</td><td id=\"cnum"+value[1]+"\">"+value[2]+"</td>"+								
				"<td id=\"fnum"+value[1]+"\">"+
				"<a class=\"button border-main alterbtn\" id=\"num"+value[1]+"\" aria-labelledby=\"myModalLabel\"  data-target=\"#myModal1\" data-toggle=\"modal\">"+
				"<span class=\"icon-edit\"></span> 修改</a></td></tr>";
				$("#tableid").append(emtable);																												
				});			
			}
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
  <table class="table table-hover text-center" id="tableid">
    
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
				人事管理<input type="checkbox" aria-label="..."><br>  				
        		员工管理<input type="checkbox" aria-label="...">
        		账号管理<input type="checkbox" aria-label="..."><br>
        		<hr>
        		餐厅管理<input type="checkbox" aria-label="..."><br>
        		桌台管理<input type="checkbox" aria-label="...">  
        		菜品管理<input type="checkbox" aria-label="...">
        		分类管理<input type="checkbox" aria-label="..."><br>
        		<hr>
        		财务管理<input type="checkbox" aria-label="..."><br>
        		订单详情<input type="checkbox" aria-label="...">  
        		退单详情<input type="checkbox" aria-label="...">  
        		收入详情<input type="checkbox" aria-label="...">                  		      			
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
