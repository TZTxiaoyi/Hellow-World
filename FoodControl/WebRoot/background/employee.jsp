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
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>
	<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
	<!-- 
		触发点击事件后，先判断是否得到输入框中的值，
		当有一个输入框中的值为空时，将不执行Ajax语句
	 -->
	<script type="text/javascript">	
		$(function(){
			
		});	
		$(function(){
			$("#tableid").on('click',".deskbtn",function(){			
				var deskbtn=$(this).attr("id");
				var emhtml = $("#s"+deskbtn).html();
				$.ajax({
					url:"achieve_delem.action",
					type:"post",
					data:{"employee.emid":emhtml},
					
					success:function(data){
					alert(data);
						
					}
				});
			});	
		});
		
	$(function(){
			
			$.ajax({
				url:"achieve_selem.action",
				type:"post",
				data:{map:null},
				success:function(data){
					 var json=JSON.parse(data);
				 var th="<tr><td>员工姓名</td><td>员工编号</td><td>电话</td><td>性别</td><td>年龄</td><td>地址</td><td>就职时间</td><td>角色</td><td>负责桌台</td><td>操作</td></tr>";
					 $("#trtab").before(th);
						$.each(json,function(index,value){
								var emtable=
								"<tr><td><input type=\"checkbox\" name=\"id[]\" value=\"1\" />"+value[0]+
								"</td><td id=\"snum"+value[1]+"\">"+value[1]+"</td><td>"+value[2]+"</td><td>"+value[3]+"</td><td>"+value[4]+
								"</td><td>"+value[5]+"</td><td>"+value[6]+"</td><td>"+value[7]+"</td><td>"+value[8]+"</td>"+
								"<td><button class=\"button border-red deskbtn\" id=\"num"+value[1]+"\">"+
								"<span class=\"icon-trash-o\"></span>删除 </button>"+
								"<a type=\"button\" class=\"button border-main\"data-toggle=\"modal\" id=\"num"+value[1]+"\"0.>"+ 
								"<span class=\"icon-edit\"></span> 修改</a></td></tr>";
								$("#trtab").before(emtable);								
						});
					},
				});
			
		});
		
		$(function(){
			$("#addem").click(function(){
				var emid=$("#emid").val();
				var emname=$("#emname").val();
				var emsex=$("#emsex").val();
				var emage=$("#emage").val();
				var emphone=$("#emphone").val();
				var emadress=$("#emadress").val();
				var emjointime=$("#emjointime").val();
				var empart=$("#empart").val();
				var ementer=$("#ementer").val();	
				
											
				if(emid && emname && emsex && emage && emphone && emadress && emjointime && empart && ementer){					
					$.ajax({
						type:"post",
						url:"achieve_save.action",
						data:{"employee.emid":emid,"employee.emname":emname,"employee.emsex":emsex,"employee.emage":emage,
							"employee.emphone":emphone,"employee.emadress":emadress,"employee.emjointime":emjointime,"employee.empart":empart,"employee.ementer":ementer},
						success:function(data){
							alert("success");
						}
					});
				}else{
					alert("添加员工失败");
				}
			});
		});	
	</script>  
</head>
  <!-- 
  	员工信息页面
   -->
  <body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 员工信息</strong></div>
 <div>
	 
	  <div class="panel admin-panel">	    
	    <div class="padding border-bottom">
	      <ul class="search">
	        <li>
	          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
	          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
	          <!-- 
	          	添加员工按钮
	           -->
	          <a type="button" class="button border-yellow" href="" data-target="#myModal" data-toggle="modal"><span class="icon-plus-square-o"></span> 添加员工</a>
         		<!-- 
         			添加员工模态框
         		 -->
         
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								
								<h4 class="modal-title" id="myModalLabel">添加员工信息</h4>
							</div>
							<!-- 
								添加员工信息的输入框 ----
							 -->
							 
								<div class="modal-body1">
													
									编	号：<input type="text" id="emid" name="employee.emid"><br/>
									姓	名：<input type="text" id="emname" name="employee.emname"><br/>
									性	别：<input type="text" id="emsex" name="employee.emsex"><br/>
									年	龄：<input type="text" id="emage" name="employee.emage"><br/>
									电	话：<input type="text" id="emphone" name="employee.emphone"><br/> 									
									地	址：<input type="text" id="emadress" name="employee.emadress"><br/>
									就职时间：<input type="text" id="emjointime" name="employee.emjointime"><br/>
									员工角色：<input type="text" id="empart" name="empart"><br>
									员工账号：<input type="text" id="ementer" name="employee.ementer">	<br/>
										     
								
								</div>
								<div class="modal-footer">
								<!-- 
									关闭模态框按钮
								 -->
								<button type="submit" class="btn btn-default" data-dismiss="modal">关闭</button>
								<!-- 
									点击添加按钮，触发点击事件，当信息全部录入后执行Ajax语句；
								 -->
								 <input type="submit" class="btn btn-primary"  data-dismiss="modal" value="添加" id="addem"/>	
								
							
							</div>
					   </div>
					</div>
				</div>
	        </li>
	        <!-- 
	        	搜索员工信息框
	         -->
	        <li>
	        
	        	<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          		<a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
	        </li>
	      </ul>
	    </div>
	    <!-- 
	    	查询出来的员工信息生成的table
	     -->
	    <table class="table table-hover text-center" id="tableid">
	     
	       
	      <tr id="trtab">
	        <td colspan="10">
	        <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
	      </tr>
	    </table>
	  </div>
	
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
