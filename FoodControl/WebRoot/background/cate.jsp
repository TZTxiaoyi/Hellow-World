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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>
	<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script src="ajaxfileupload.js" type="text/javascript"></script>


<style>

	#modb li{list-style-type:none;display:block;}
	#sel{width:135px;}
	.inName{border:1px solid black;color:red;display:none;}
	.chgName{border:1px solid black;color:red;display:none;}
	
</style>

</head>
  <body>
	<div class="panel admin-panel">
	<div class="panel-head"><strong><span class="icon-pencil-square-o"></span>菜品分类</strong></div>
 	<div>
	 	<form method="post" action="">
	  	<div class="panel admin-panel">	    
	    	<div class="padding border-bottom">
	      	<ul class="search">
	        	<li>																
	          	<button  class="button border-yellow" id="checkall"><span class="icon-check"></span>查看所有</button>
	      
	          	<a type="button" class="button border-yellow" href="" data-target="#myModal" data-toggle="modal"><span class="icon-plus-square-o"></span> 添加菜品</a>
         			<!-- 
         				添加员工模态框
         		 	-->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"></span></button>
										<h4 class="modal-title" id="myModalLabel">添加菜品分类</h4>
									</div>
									<!-- 
										添加菜品分类的输入框 ----form表单
									-->
									<div class="modal-body1">
										<ul id="modb">
											<li>									
	    										<div>菜品类别&nbsp&nbsp&nbsp&nbsp&nbsp:
	      										<input id="sel"><span class="inName">*分类名重复</span>
	   											</div>														
											</li><br/><!--3-->
										</ul> 	
									</div>
									<div class="modal-footer">
										<!-- 
											关闭模态框按钮
									 	-->
								
										<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
										<!-- 
											保存模态框按钮   --- 可以此按钮跳转到一个servlet执行SQL语句，插入数据到数据库
										 -->
										<button type="button" class="btn btn-primary"id="togo">保存</button>
									</div>
						  	 	</div>
							</div>
						</div>
		        		</li>
		        	<li>			<!--搜索框-->
  					<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" id="sekm" style="width:250px; line-height:17px;display:inline-block" />
          			<a href="javascript:void(0)" class="button border-main icon-search" class="seek"id="sekkid" > 搜索</a>
          			</li>
	      		</ul>
	    		</div>
	    		<table class="table table-hover text-center" id="tab">
	    		</table>
	   			<!--分页选项 -->
				<div class="pagelist">
					<a class="minuspage" name="firstname">首页</a>
					<a class="minuspage" name="minusname">上一页</a> 
					<a class="minuspage" name="addname">下一页</a>
					<a class="minuspage" name="lastname">尾页</a>
					共<span id="pagenum"></span>页
					<input type="text" id="someone" value="1">
					<input type="button" value="跳转" id="commitone">
				</div>					   
	  		</div>
		</form>
	</div>




	<!-- 修改选项的模态框（Modal） -->
	<div class="modal fade" id="cgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">更改菜品</h4>
					</div>
					<div class="modal-body">
					<ul id="modb">
						<li>									
	    					<div>修改分类<input id="Cobox"><span class="chgName">*分类名重复</span>
	   						</div>														
						</li><br/><!--3-->
					</ul> 	
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary"id="caghave">提交更改</button>
					</div>
				</div>
			</div>
		</div>

	  <!--白色，浅蓝色，深蓝色，绿色，黄色，红色，黑色，对应的class为btn,btn btn-primary,btn btn-info,btn btn-success,btn btn-warning,btn btn-danger,btn btn-inverse-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
  <script>
    
 
		/*搜索菜品分类*/
		$("#sekkid").click(function(){
			var allput=$("#sekm").val();
				$.ajax({
					url:"GJYKID_kidseek.action",
					type:"post",
					data:{"search":allput},
					success:function(data){
						var json = JSON.parse(data);
						sekkid(json);
					}
				});
			});
			
    
    	/*添加菜品分类*/
		$(function(){
			$("#togo").click(function(){
				var kidname=$("#sel").val();
				if(esim){
				alert(kidname);
				$.ajax({
					type:"post",
					url:"GJYKID_kidinsert.action",
					data:{"KID.kidname":kidname,"KID.kidState":19},
					success:function(data){
						if(data==-1){
							alert("修改失败");
						}else if(data==1){								
							location.reload(true); 
							alert("修改成功");
						}else{
							alert("没有权限");
						}	
					}
				});
			}else{
				alert("菜品分类添加失败");
			}
		});
	});
	
	
	/*修改菜品分类选项*/
	$("#tab").on('click',".chgb",function(){
		var p1=$(this).attr("id");
		$("#Cobox").val($("#b"+p1).html());
		$("#caghave").click(function(){
		 	var kid=$("#a"+p1).html();
			var sech=$("#Cobox").val();
			if(sech!=""){
				$.ajax({
					type:"post",
					url:"GJYKID_kidchange.action",
					data:{"KID.kidname":sech,"KID.kidID":kid},
					success:function(data){
						if(data==-1){
							alert("修改失败");
						}else if(data==1){								
							location.reload(true); 
							alert("修改成功");
						}else{
							alert("没有权限");
						}	  
					}													
				});
			}else{
				alert("不允许空值,请录入值");
			}
		});		
	});
		
	
	/*菜品分类查询*/
	function sekkid(json){
		var th="<tr><td>菜品分类编号</td><td>菜品分类名称</td></tr>";
			 $("#tab").html("");
			$("#tab").append(th);
				$.each(json,function(index,value){
					var emtable=
						"<tr><td id=\"amb"+value[0]+"\">"+value[0]+"</td>"+
						"<td id=\"dmb"+value[0]+"\">"+value[1]+"</td>"+ 
						"<td><div class=\"button border-red deskbtn\" id=\"num"+value[0]+"\">"+
						"<span class=\"icon-trash-o\"></span>删除 </div>"+
						"<a type=\"button\" class=\"button border-main chgb\"data-toggle=\"modal\"data-target=\"#cgModal\" id=\"mb"+value[0]+"\">"+
						"<span class=\con-edit\></span>修改</a></td></tr>";
						$("#tab").append(emtable);
				
					});
		};
			
	
	/*删除菜品选项*/
	$(function(){
		$("#tab").on('click',".deskbtn",function(){
			var selct=confirm("确定要删除这条数据吗？");
				if(selct==false){return};
			var p1=$(this).attr("id");
			var endStr=parseInt(p1.replace(/[^0-9]/ig,""));
				endStr=parseInt(endStr); 
				$.ajax({
					type:"post",
					url:"GJYKID_kiddelete.action",
					data:{"KID.kidID":endStr},
					success:function(data){
						if(data==-1){
							alert("修改失败");
						}else if(data==1){								
							location.reload(true); 
							alert("修改成功");
						}else{
							alert("没有权限");
						}	 	
					}													
				});
		
			});
		});
		
		
	/*分页跳转*/
	$("#commitone").click(function(){
		var page=$("#pagenum").text();
		var some=$("#someone").text();
		if(some>page){
			some=page;					
		}else if(some<1){
			some=1;	
		}
		
		ces(some);
			
	});
	
	
	/*获得总页数及判断用户点击选项做出相应*/
	$(function(){
			$.ajax({
				url:"GJYKID_kidgetcount.action",
				type:"post",
				data:{},
				success:function(data){						
					if(data%2==0){
						var pagesize=parseInt(data/6);
						$("#pagenum").text(pagesize);					
					}else{
						var pagesize=parseInt(data/6)+1;
						$("#pagenum").text(pagesize);
					}				
				},
			});	
			ces(0);								
		});
		
		
	/*控制分页上下也转换*/
	$(function(){
		$(".minuspage").click(function(){			
			var somename=$(this).attr("name");	 
			var onepage=parseInt($("#someone").val());	
			var pagesize=$("#pagenum").text();
			if(somename=="firstname"){
				onepage=1;					
			}else if(somename=="minusname"){
					if(onepage<=1){
						onepage=1;
					}else{
						onepage=onepage-1;
					}
				}else if(somename=="addname"){
					if(onepage>=pagesize){
						onepage = pagesize;
					}else{
						onepage = onepage +1;
					}
				}else{
					onepage = pagesize;
				}				
				$("#someone").val(onepage);
				a=onepage-1;
				ces(a);				
			});			
		});
		
		
	/*显示每页具体数据*/
	function ces(a){
		$.ajax({				
			url:"GJYKID_kidgetpage.action",
			type:"post",
			data:{"countpage":a},
			success:function(data){	
			var json=JSON.parse(data);				
			var th="<tr><td>菜品分类编号</td><td>菜品分类名称</td></tr>";
			$("#tab").html("");
			$("#tab").append(th);
			$.each(json,function(index,value){
				var emtable=
					"<tr><td id=\"amb"+value[0]+"\">"+value[0]+"</td>"+
					"<td id=\"bmb"+value[0]+"\">"+value[1]+"</td>"+ 
					"<td><div class=\"button border-red deskbtn\" id=\"num"+value[0]+"\">"+
					"<span class=\"icon-trash-o\"></span>删除 </div>"+
					"<a type=\"button\" class=\"button border-main chgb\"data-toggle=\"modal\"data-target=\"#cgModal\" id=\"mb"+value[0]+"\">"+
					"<span class=\con-edit\></span>修改</a></td></tr>";
					$("#tab").append(emtable);																							
				});								
			}
		});
	}
		
		
	/*判断添加的的菜品类型是否有重复的值*/
	$("#sel").blur(function(){
		$.ajax({
			url:"GJYKID_estiName.action",
			type:"post",
			data:{"KID.kidname":$(this).val()},
			success:function(data){	
				if(data>=1){
				$(".inName").css("display","inline");
				esmi=false;
					return 
				}else if(data==0){
					$(".inName").css("display","none");
						esim=true;
					}
				}
			});
			
		});
			
</script>
</body>
</html>
