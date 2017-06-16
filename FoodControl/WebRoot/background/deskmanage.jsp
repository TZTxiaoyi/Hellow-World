<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<!-- 
		后台桌位详情页面
	 -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	<title></title>
	<link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
	
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"
		type="text/css"></link>
	<script type="text/javascript"
		src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
	
	<style>
		#modalform input {
			
			width: 250px;
			height: 40px;
			
		}
		#modalform div{
			margin-top:30;
			margin-left:20%;
		}
		#modalform span{
			font-size:20px;
		}
	
	</style>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 桌台信息</strong>
		</div>
		<div>
			<form method="post" action="">
				<div class="panel admin-panel">
					<div class="padding border-bottom">
						<ul class="search">
							<li>
								<button type="button" class="button border-green" id="checkall">
									<span class="icon-check"></span> 全选
								</button> <a class="button border-yellow" href="" data-toggle="modal"
								data-target="#myModaltable"><span class="icon-plus-square-o"></span>
									添加桌台</a></li>
							<li><input type="text" placeholder="请输入搜索关键字"
								name="keywords" class="input"
								style="width:250px; line-height:17px;display:inline-block" /> <a
								href="javascript:void(0)" class="button border-main icon-search"
								onclick="changesearch()"> 搜索</a>
							</li>
							</li>
						</ul>

					</div>
					<table class="table table-hover text-center">
					
						<tr id="modall-table">
							<td colspan="4">
								<div class="pagelist">
									<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
										href="">3</a><a href="">下一页</a><a href="">尾页</a>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<!-- 
			添加桌台模态框
 		-->
		<div class="media media-y margin-big-bottom"></div>
		<div class="modal fade" id="myModaltable" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss=modal></button>
						<div class="text-center margin-big padding-big-top">
							<h1>桌位详细信息</h1>
						</div>
						 <div id="modalform">
					    	<div>
					    		<span>桌位人数 </span><input type="text" name="st.personNum" id="personNum"/>
					    	</div>
					    	<div>
					    		<span>桌位名字</span><input type="text" name="st.deskName" id="tableName"/>
					    	</div>
					    	<div>
					    		<span>桌子状态</span><input  name="st.deskState" id="deskState"/>
					    	</div>
					    	<div>
								<button type="submit" class="btn btn-warning btn-group-lg" data-dismiss="modal" id="confirm-btn">确认添加</button>	
							</div>
					 </div>
					</div>
				</div>
			</div>
		</div>
		<!-- 
			添加按钮模态框
		 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close"></button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			
			function del(id){
				if(confirm("您确定要删除吗?")){
					$.ajax({
						url:"SxmTable_delLineTable.action",
						type:"post",

						data:{deskId:$("#deskId").val()},
						success:function(data){
							var json=JSON.parse(data);
							if(json!=-1){
								alert("删除成功！");
							}else{
								alert("删除失败！");
							}
						}
					});
				}
			};
			
			$("#checkall").click(function(){ 
			  $("input[name='id[]']").each(function(){
				  if (this.checked) {
					  this.checked = false;
				  }
				  else {
					  this.checked = true;
				  }
			  });
			});
			
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
			};
			
			/*
				添加桌子名字失焦时检测是否已存在改桌名的函数
			*/
			$("#tableName").blur(function(){
				$.ajax({
					url:"../SxmTable_equalTable.action",
					type:"post",
					data:{deskName:$(this).val()},
					success:function(data){
						var json=JSON.parse(data);
						if(json==1){
							alert("该桌名已存在！");
						}
					},
				});
			});
		/*
			页面加载时自动查询数据库，显示桌台信息
		*/	
		$(function(){
			$.ajax({
				url:"SxmTable_tableAdmin.action",
				type:"post",
				data:{map:null},
				success:function(data){
					 var json=JSON.parse(data);
					 var th="<tr><td></td><td>Id</td><td>桌台名</td><td>桌台人数</td><td>负责人</td><td>桌台状态</td><td>操作</td></tr>";
					 $("#modall-table").before(th);
						$.each(json,function(index,value){
								var dd=
								"<tr><td><input type=\"checkbox\" name=\"id[]\" value=\"1\" /></td><td->"+value[0]+
								"</td><td>"+value[1]+"</td><td>"+value[2]+"</td><td>"+value[3]+"</td><td>"+value[4]+"</td>"+
								"<td><a class=\"button border-red\" href=\"javascript:void(0)\">"+
								"<span class=\"icon-trash-o\"></span>删除 </a>"+
								"<a type=\"button\" class=\"button border-main\"data-toggle=\"modal\" data-target=\"#myModal\">"+
								"<span class=\"icon-edit\"></span> 修改</a></td></tr>";
								$("#modall-table").before(dd);
								
							});
					},
				});
			
		});
		$(function(){
			$("#confirm-btn").click(function(){
				var pn=$("#personNum").val();
				var dn=$("#tableName").val();
				var ds=$("#deskState").val();
					$.ajax({
						url:"../SxmTable_appendTable.action",
						type:"post",
						data:{"st.personNum":pn,"st.deskName":dn,"st.deskState":ds},
						success:function(data){
						var json=JSON.parse(data);
							if(json!=-1){
								alert("success");
							}else{
								alert("添加失败！");
							}
						},
					});
				
			});
		})
		
		</script>
	</div>
</body>
</html>
