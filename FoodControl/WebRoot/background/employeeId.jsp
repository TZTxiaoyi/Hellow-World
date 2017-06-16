   <!DOCTYPE html>
<html lang="zh-cn">
	<head>
	
		<title></title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js"></script>
		<script src="js/pintuer.js"></script>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>
		<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
		<!-- 
			添加按钮触发点击事件，先判断输入框中的值是否为空，若为空将不执行Ajax语句
		 -->
		<script type="text/javascript">
			$(function(){
				$("#addent").click(function(){
					var ementer = $("#ementer").val();
					var emword	= $("#emword").val();					
					if(ementer && emword){
					alert("dadad")					
						$.ajax({
							type:"post",
							url:"achieve_enterid.action",
							data:{"employId.ementer":ementer,"employId.emword":emword},
							success:function(data){
								alert("success");
							}
						});
					}else{
						alert("添加员工账号失败");
					}
				});
			});
		</script>
	</head>
	<body>
	
		  <div class="panel admin-panel">
		    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
		    <div class="padding border-bottom">
		      <ul class="search" style="padding-left:10px;">       
		        
		        <li>
		         	<a type="button" class="button border-yellow" href="" data-target="#myModal" data-toggle="modal"><span class="icon-plus-square-o"></span> 添加员工账号</a>
		         		<!-- 
		         			添加员工账号模态框
		         		 -->
		         
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
								<div class="modal-header">
									
								<h4 class="modal-title" id="myModalLabel">添加员工账号</h4>
								</div>
									<!-- 
										添加员工信息的输入框 ----
									 -->
									 
								<div class="modal-body1">
															
									账	号：<input type="text" id="ementer" name="ementer"><br/>
									密	码：<input type="text" id="emword" name="emword"><br/>
											
												     
										
								</div>
								<div class="modal-footer">
										<!-- 
											关闭模态框按钮
										 -->
									<button type="submit" class="btn btn-default" data-dismiss="modal">关闭</button>
										<!-- 
											点击添加按钮，触发点击事件，当信息全部录入后执行Ajax语句；
										 -->
									<input type="submit" class="btn btn-primary"  value="添加" id="addent"/>	
								</div>
							 </div>
						</div>
					</div>
		        <li>
		          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
		          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
		      </ul>
		    </div>
		    <table class="table table-hover text-center">
		      
			      <tr>	              
			        <th>账号</th>
			        <th>密码</th>	
			        <th>账号状态</th>        
			        <th>操作</th>       
			      </tr>      
			        <tr>
			          <td><input type="checkbox" name="id[]" value="1" />101</td>
			          <td>123456</td>
			          <td>SSR</td>	          	          
			          <td>
			          	<div class="button-group"> 
			          		<a class="button border-red" href="javascript:void(0)" onclick="return del(1)">
			          			<span class="icon-trash-o"></span> 删除
			          		</a>     		
			          	</div>
			          </td>
			        </tr>	           
			      <tr>
			        <td colspan="4">
			        <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
			      </tr>
			    </table>	  
		    
		  </div>
		
		<script type="text/javascript">
		</script>
	</body>
</html>