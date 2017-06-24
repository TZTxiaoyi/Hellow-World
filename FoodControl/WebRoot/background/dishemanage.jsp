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
<style>

	
	
	
</style>


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
	          <a type="button" class="button border-yellow"  data-target="#myModal4" data-toggle="modal"><span class="icon-plus-square-o"></span> 添加菜品</a>
         		<!-- 
         			添加员工模态框
         		 -->
         
				<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close"></span></button>
								<h4 class="modal-title" id="myModalLabel">添加菜品</h4>

							</div>
							<!-- 
								添加菜品的输入框 ----
							 -->
							<div class="modal-body1" >
								
									菜品名称:<input id="dishName"/><br><!--1-->
									菜品价格:<input id="price"/><br><!--2-->
																		
    									菜品类别:
      										<select id="sel">
        										<option>凉拌</option>
        										<option>主食</option>
        										<option>拌饭</option>
       		 									<option>小炒</option>
        										<option>汤类</option>
     										 </select><br>
   																							
									<!--3-->
									菜品时间:<input id="makeTime"/><br><!--4-->
									菜品优先级:<input id="priority"/><br><!--5-->
									菜品图片:<input id="pictureName"/><br><!--6-->
									最大并菜份数:<input id="maxCopies"/><br><!--7-->
									菜品状态:<input id="dishState"/><br>
									
							</div>
							<div class="modal-footer">
								<!-- 
									关闭模态框按钮
								 -->
							
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<!-- 
									保存模态框按钮   --- 可以此按钮跳转到一个servlet执行SQL语句，插入数据到数据库
								 -->
								<button type="button" class="btn btn-primary"id="togo">Save changes</button>
							</div>
					   </div>
					</div>
				</div>
	        </li>
	        <li>
  				<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" id="sekm" style="width:250px; line-height:17px;display:inline-block" />
          		<a href="javascript:void(0)" class="button border-main icon-search" class="seek"id="sekbt" > 搜索</a></li>
  			</li>
	      </ul>
	    </div>
	    <table class="table table-hover text-center"id=tab>
	      <tr >
	      </tr>    
	      <tr id="trtab">
	      </tr>
	    </table>
	  </div>
	   <div><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></div>
	</form>
</div>

</div>
	  <!--白色，浅蓝色，深蓝色，绿色，黄色，红色，黑色，对应的class为btn,btn btn-primary,btn btn-info,btn btn-success,btn btn-warning,btn btn-danger,btn btn-inverse-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   
  <script>
    
    $(function(){
		$.ajax({
			type:"post",
			url:"GJYFC_FindAll.action",
			data:{},
			success:function(data){
			var json=JSON.parse(data);
				ces(json);		
														
					
			}
		});
	});

    
    		/*
				快速搜索
			*/
			
			$("#sekbt").click(function(){
				var allput=$("#sekm").val();
				$.ajax({
					url:"GJYFC_seekfood.action",
					type:"post",
					data:{"search":allput},
					success:function(data){

						var json = JSON.parse(data);
							ces(json);
				}
			});
		});
			
    
    
	$(function(){
		$("#togo").click(function(){
			var dishName=$("#dishName").val();
			var price=$("#price").val();
			var kindId=$("#sel").val();
			var makeTime=$("#makeTime").val();
			var priority=$("#priority").val();
			var pictureName=$("#pictureName").val();
			var maxCopies=$("#maxCopies").val();
			var dishState=$("#dishState").val();
			
			if(kindId=="凉拌"){kindId=1;}
			else if(kindId=="主食"){kindId=2;}
			else if(kindId=="拌饭"){kindId=3;}
			else if(kindId=="小炒"){kindId=4;}
			else if(kindId=="汤类"){kindId=5;}
			
			if(dishName && price && kindId && makeTime && priority && pictureName && maxCopies ){
				$.ajax({
					type:"post",
					url:"GJYFC_save.action",
					data:{"fdCry.dishName":dishName,"fdCry.price":price,"fdCry.kindId":kindId,"fdCry.makeTime":makeTime,"fdCry.priority":priority,"fdCry.pictureName":pictureName,"fdCry.maxCopies":maxCopies,"fdCry.dishState":dishState},
					success:function(data){
						alert("员工添加成功");
					}
				});
			}else{
				alert("菜品添加失败");
			}
	
	});
});



	



	function ces(json){
		var th="<tr><td></td><td>菜品编号</td><td>菜品名称</td><td>菜品价格</td><td>类别</td><td>制作时间</td><td>菜品照片</td><td>最大并菜数</td><td>菜品状态</td></tr>";
			 $("#tab").html("");
			$("#tab").append(th);
				$.each(json,function(index,value){
					var emtable=
						"<tr><td><input type=\checkbox\name=\id[]\value=\1\/></td>"+
						"<td id=\"snum"+value[0]+"\">"+value[0]+"</td>"+
						"<td>"+value[1]+"</td>"+
						"<td>"+value[2]+"</td>"+
						"<td>"+value[3]+"</td>"+
						"<td>"+value[4]+"</td>"+
						"<td>"+value[5]+"</td>"+
						"<td>"+value[6]+"</td>"+
						"<td>"+value[7]+"</td>"+
						"<td><button class=\"button border-red deskbtn\" id=\"num"+value[0]+"\">"+"<span class=\"icon-trash-o\"></span>删除 </button>"+"<a type=\"button\" class=\"button border-main\"data-toggle=\"modal\">"+"<span class=\con-edit\></span>修改</a></td>"+
						"</tr>";
						//$("#trtab").before(emtable);
						$("#tab").append(emtable);	
						
		});	
	};

</script>
</body>
</html>
