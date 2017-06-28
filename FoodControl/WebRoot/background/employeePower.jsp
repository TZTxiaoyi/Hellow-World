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
<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>

<script type="text/javascript">

	/*
	*打印角色表
	*/
	
	$(function (){
		powers();
	});
	function powers(){
		$("#tableid").html("");
		$.ajax({
			url:"achieve_modul.action",
			type:"post",
			data:{},
			success:function(data){
			var json=JSON.parse(data);			
			var th="<tr><td>角色</td><td>操作</td></tr>";
			$("#tableid").append(th);
				$.each(json,function(index,value){												 									 			
				var emtable=
					"<tr><td id=\"anum"+value[0]+"\">"+value[0]+"</td>"+
					"<td><a class=\"button border-main alterbtn\" id=\"num"+value[0]+"\" aria-labelledby=\"myModalLabel\"  data-target=\"#myModal1\" data-toggle=\"modal\">"+
					"<span class=\"icon-edit\"></span> 修改</a></td></tr>";
				$("#tableid").append(emtable);																												
				});			
			},
		});
	}
	$(function(){		
		$("#addpart").click(function(){
			var partname=$("#inputpart").val();
			alert(partname);
			if(partname){
				$.ajax({
					url:"achieve_addpart.action",
					type:"post",
					data:{"partname.partname":partname},
					success:function(data){
						powers();
					}
				});
			}
		});
	});
	$(function(){	
		$("#tableid").on('click',".alterbtn",function(){
			var alterbtn = $(this).attr("id");
			//alert("sss:"+alterbtn);
			var namehtml =$("#a"+alterbtn).html();
			//alert(namehtml);	
			$("#powersname").html(namehtml);
						
			 $.ajax({
					url:"fresh_selpowers.action",
					type:"post",
					data:{"partname.partname":namehtml},
					success:function(data){
						var json=JSON.parse(data);
						for(var i=1;i<19;i++){
							$($("input[name=\"check"+i+"\"]")[0]).prop("checked",false);
						}	
						$.each(json,function(index,value){						
							//var check4=1;
							//alert(value[1]);
							$($("input[name=\"check"+value[1]+"\"]")[0]).prop("checked",true);				
						});
						
												
					}				
			}); 		
		});
	});
	$(function(){
		$("#save_powers").click(function(){
		var powersId=[];
		var j=0;
		var powersname=$("#powersname").html();
		//alert("000:"+powersname);
			for(var i=1;i<19;i++){	
			//$("#chk2").prop("checked") == true
				
				if($($("input[name=\"check"+i+"\"]")[0]).prop("checked")){
					powersId.push(i);
					//alert(powersId);
					alert(powersId);
					j++;
				}
			}
			$.ajax({
				type:"post",
				url:"fresh_sertpow.action",
				
				data:{"partname.partname":powersname,"powersId":powersId},
				traditional:true,
				success:function(data){
					
				}
			});
		});
	});
	
</script>
</head>
  
 <body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>权限管理</strong>
  	<div class="panel admin-panel">

  <div class="padding border-bottom">
    <button type="button"  class="button border-yellow" onclick="window.location.href='#add'" aria-labelledby="myModalLabel"  data-target="#myModal2" data-toggle="modal">
    	<span class="icon-plus-square-o"></span> 添加角色
    </button>
  </div>
  <table class="table table-hover text-center" id="tableid">
    
  </table>
</div>	
  </div>
</div>



<!-- 修改权限模态框 -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel"><span id="powersname"></span>权限更改</h4>
			</div>
			<div class="modal-body1">
				员工管理<input type="checkbox" name="check1" value="10"><br>  				
        		添加员工<input type="checkbox" name="check11" aria-label="...">
        		修改员工信息<input type="checkbox" name="check12" aria-label="...">
        		删除员工<input type="checkbox" name="check13" aria-label="..."><br>        		
        		<hr>
        		员工账号<input type="checkbox" name="check2" aria-label="..." value="员工管理"><br>  				
        		添加员工账号<input type="checkbox" name="check10" aria-label="...">
        		修改员工账号<input type="checkbox" name="check18" aria-label="..."><br>       		
        		<hr>
        		桌台管理<input type="checkbox" name="check4" aria-label="..."><br>
        		添加桌台<input type="checkbox" name="check14" aria-label="...">  
        		删除桌台<input type="checkbox" name="check16" aria-label="...">
        		修改桌台<input type="checkbox" name="check15" aria-label="..."><br>
        		<hr>
        		菜品管理<input type="checkbox" name="check5" aria-label="..."><br>
        		添加菜品<input type="checkbox" name="check17" aria-label="...">  
        		修改菜品<input type="checkbox" name="check" aria-label="...">  
        		删除菜品<input type="checkbox" name="check" aria-label="...">                  		      			
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="save_powers">Save changes</button>
			 </div>
		</div>
	 </div>
</div>

<!-- 添加角色模态框 -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">角色权限更改</h4>
			</div>
			<div class="modal-body1">
				角色名称：<input type="text"  aria-label="..." size="30" id="inputpart">				                  		      			
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="addpart">Save changes</button>
			 </div>
		</div>
	 </div>
</div>
</body>
</html>
