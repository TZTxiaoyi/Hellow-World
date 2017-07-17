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
	<style>
		
	</style>

</head>
  
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>权限管理</strong>
  	<div class="panel admin-panel">

  <div class="padding border-bottom">
  	<a class="button border-yellow" href="fresh_powers.action">查看所有</a>
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
				</button>
				<h2 class="modal-title" id="myModalLabel"><span id="powersname"></span>权限更改</h2>
			</div>
			<div class="modal-body1">
				员工管理<input type="checkbox" checkflag="check1" name="check1" value="10" class="parent_one"><br>  				
        		添加员工<input type="checkbox" checkflag="check1" name="check11" aria-label="..." class="children1">
        		修改员工信息<input type="checkbox" checkflag="check1" name="check12" aria-label="..." class="children1">
        		删除员工<input type="checkbox" checkflag="check1" name="check13" aria-label="..." class="children1"><br>        		
        		<hr>
        		员工账号<input type="checkbox" checkflag="check2" name="check2" aria-label="..." class="parent_one"><br>  				
        		添加员工账号<input type="checkbox" checkflag="check2" name="check10" aria-label="..." class="children1">
        		删除员工账号<input type="checkbox" checkflag="check2" name="check24" aria-label="..." class="children1">
        		修改员工账号<input type="checkbox" checkflag="check2" name="check18" aria-label="..." class="children1"><br>       		
        		<hr>
        		桌台管理<input type="checkbox" checkflag="check3" name="check4" aria-label="..." class="parent_one"><br>
        		添加桌台<input type="checkbox" checkflag="check3" name="check14" aria-label="..." class="children1">  
        		删除桌台<input type="checkbox" checkflag="check3" name="check16" aria-label="..." class="children1">
        		修改桌台<input type="checkbox" checkflag="check3" name="check15" aria-label="..." class="children1"><br>
        		<hr>
        		菜品管理<input type="checkbox" checkflag="check4" name="check5" aria-label="..." class="parent_one"><br>
        		添加菜品<input type="checkbox" checkflag="check4" name="check17" aria-label="..." class="children1">  
        		修改菜品<input type="checkbox" checkflag="check4" name="check22" aria-label="..." class="children1" >  
        		删除菜品<input type="checkbox" checkflag="check4" name="check23" aria-label="..."class="children1"><br>
        		<hr>
        		分类管理<input type="checkbox" checkflag="check5" name="check6" aria-label="..." class="parent_one"><br>
        		添加分类<input type="checkbox" checkflag="check5" name="check28" aria-label="..." class="children1">  
        		修改分类<input type="checkbox" checkflag="check5" name="check29" aria-label="..." class="children1" >  
        		删除分类<input type="checkbox" checkflag="check5" name="check30" aria-label="..."class="children1"><br>
        		<hr>
        		订单详情<input type="checkbox" name="check19" aria-label="...">
        		退单详情<input type="checkbox" name="check20" aria-label="...">  
        		收入详情<input type="checkbox" name="check21" aria-label="...">
        		<hr>
        		 后厨界面<input type="checkbox" name="check25" aria-label="...">
        		 服务员面<input type="checkbox" name="check26" aria-label="...">                     		      			
				<hr>
								
			</div>
			<div class="modal-footer">			
				<button type="button" class="btn btn-warning" id="save_powers" data-dismiss="modal">保存</button>
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
				</button>
				<h2 class="modal-title" id="myModalLabel">角色权限更改</h2>
			</div>
			<div class="modal-body1">
				角色名称：<input type="text"  aria-label="..." size="30" id="inputpart">				                  		      			
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="addpart" data-dismiss="modal">保存</button>
			 </div>
		</div>
	 </div>
</div>
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
					"<td><button class=\"button border-red deskbtn\" id=\"num"+value[0]+"\" >"+
					"<span class=\"icon-trash-o\"></span>删除 </button>"+
					"<a class=\"button border-main alterbtn\" id=\"num"+value[0]+"\" aria-labelledby=\"myModalLabel\"  data-target=\"#myModal1\" data-toggle=\"modal\">"+
					"<span class=\"icon-edit\"></span> 修改</a></td></tr>";
				$("#tableid").append(emtable);																												
				});			
			},
		});
	}
	/**
	* 添加角色
	*/
	$(function(){		
		$("#addpart").click(function(){
			var partname=$("#inputpart").val();
			//alert(partname);
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
	/**
	*	删除角色
	*/
	$(function(){
		$("#tableid").on('click',".deskbtn",function(){
				var alterbtn = $(this).attr("id");
				//alert("sss:"+alterbtn);
				var partname =$("#a"+alterbtn).html();
				//alert(partname);
				$.ajax({
					url:"fresh_delpart.action",
					type:"post",
					data:{"partname.partname":partname},
					success:function(data){
						if(data==1){
							alert("删除成功");
							powers();
						}
					}
				});
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
						for(var i=1;i<31;i++){
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
	//alert("0000");
		$("#save_powers").click(function(){
		var powersId=[];
		var j=0;
		var powersname=$("#powersname").html();
		//alert("000:"+powersname);
			for(var i=1;i<31;i++){	
			//$("#chk2").prop("checked") == true				
				if($($("input[name=\"check"+i+"\"]")[0]).prop("checked")){
					powersId.push(i);
					//alert(powersId);
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
	$("#inputpart").blur(function() {	
		//alert("0000");		
				$.ajax({
					url : "achieve_reselpart.action",
					type : "post",
					data : {"partname.partname":$(this).val()},
					success : function(data){						
						if(data == 1){
							alert("该角色已存在！");
						}
					},
				});
			});
			
	/**
	* 子绑定点击事件
	*/		
		$(function(){
		//alert("00000");
	 		$(".children1").click(function(){ 
	 		var checkflag=$(this).attr("checkflag");
	 			if($(this).prop("checked")){
	 				//$(".parent_one").prop("checked",true);
	 				$($("input[checkflag=\""+checkflag+"\"]")[0]).prop("checked",true);
	 			}
	 		});	 		
	 	});
	 	$(function(){
	 	//alert("8888");
	 		$(".parent_one").click(function(){
	 			var checkflag=$(this).attr("checkflag");
	 			if(!$(this).prop("checked")){
	 			//alert("222");
	 				//$(".children1").prop("checked",false);
	 				$("input[checkflag=\""+checkflag+"\"]").prop("checked",false);
	 			}	 			
	 		});
	 	});
</script>
</body>
</html>
