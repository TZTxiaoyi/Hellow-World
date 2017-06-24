<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
		
		<script type="text/javascript">
			$(function(){
				$("#addent").click(function(){
					var ementer = $("#ementer").val();
					var emword	= $("#emword").val();					
					if(ementer && emword){					
						$.ajax({
							type:"post",
							url:"fresh_enterid.action",
							data:{"employId.ementer":ementer,"employId.emword":emword},
							success:function(data){
								if(data==-1){
									alert("添加失败");
								}else if(data==1){
									alert("添加成功");
								}else{
									alert("没有权限");
								}								
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
		    <div class="panel-head"><strong class="icon-reorder">内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
		    <div class="padding border-bottom">
		      <ul class="search" style="padding-left:10px;">       
		        
		        <li>
		         	<a type="button" class="button border-yellow" href="" data-target="#myModal" data-toggle="modal"><span class="icon-plus-square-o"></span>添加员工账号</a>
		         		<!-- 
		         			æ·»å åå·¥è´¦å·æ¨¡ææ¡
		         		 -->
		         
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
								<div class="modal-header">
									
								<h4 class="modal-title" id="myModalLabel">添加员工账号</h4>
								</div>
									<!-- 
										æ·»å åå·¥ä¿¡æ¯çè¾å¥æ¡ ----
									 -->
									 
								<div class="modal-body1">
															

									账	号：<input type="text" id="ementer" name="ementer"><br/>
									密	码：<input type="text" id="emword" name="emword"><br/>

											
												     
										
								</div>
								<div class="modal-footer">
										<!-- 
											å³é­æ¨¡ææ¡æé®
										 -->
									<button type="submit" class="btn btn-default" data-dismiss="modal">关闭</button>
										<!-- 
											ç¹å»æ·»å æé®ï¼è§¦åç¹å»äºä»¶ï¼å½ä¿¡æ¯å¨é¨å½å¥åæ§è¡Ajaxè¯­å¥ï¼
										 -->
									<input type="submit" class="btn btn-primary"  value="添加" id="addent"/>	
								</div>
							 </div>
						</div>
					</div>
		        <li>
		          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
		          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" >搜索</a></li>
		      </ul>
		    </div>
		    <table class="table table-hover text-center">
		      
			      <tr>	              
			        <th>账号</th>
			        <th>密码</th>	
			        <th>账号状态</th>        
			        <th>操作</th>       
			      </tr>      
			        <tr>
			          <td><input type="checkbox" name="id[]" value="1" />101</td>
			          <td>123456</td>
			          <td>SSR</td>	          	          
			          <td>
			          	<div class="button-group"> 
			          		<a class="button border-red" href="javascript:void(0)" onclick="return del(1)">
			          			<span class="icon-trash-o"></span>删除
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