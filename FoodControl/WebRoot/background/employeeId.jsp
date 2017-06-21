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
							url:"achieve_enterid.action",
							data:{"employId.ementer":ementer,"employId.emword":emword},
							success:function(data){
								alert("success");
							}
						});
					}else{
						alert("æ·»å åå·¥è´¦å·å¤±è´¥");
					}
				});
			});
		</script>
	</head>
	<body>
	
		  <div class="panel admin-panel">
		    <div class="panel-head"><strong class="icon-reorder"> åå®¹åè¡¨</strong> <a href="" style="float:right; display:none;">æ·»å å­æ®µ</a></div>
		    <div class="padding border-bottom">
		      <ul class="search" style="padding-left:10px;">       
		        
		        <li>
		         	<a type="button" class="button border-yellow" href="" data-target="#myModal" data-toggle="modal"><span class="icon-plus-square-o"></span> æ·»å åå·¥è´¦å·</a>
		         		<!-- 
		         			æ·»å åå·¥è´¦å·æ¨¡ææ¡
		         		 -->
		         
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
								<div class="modal-header">
									
								<h4 class="modal-title" id="myModalLabel">æ·»å åå·¥è´¦å·</h4>
								</div>
									<!-- 
										æ·»å åå·¥ä¿¡æ¯çè¾å¥æ¡ ----
									 -->
									 
								<div class="modal-body1">
															
									è´¦	å·ï¼<input type="text" id="ementer" name="ementer"><br/>
									å¯	ç ï¼<input type="text" id="emword" name="emword"><br/>
											
												     
										
								</div>
								<div class="modal-footer">
										<!-- 
											å³é­æ¨¡ææ¡æé®
										 -->
									<button type="submit" class="btn btn-default" data-dismiss="modal">å³é­</button>
										<!-- 
											ç¹å»æ·»å æé®ï¼è§¦åç¹å»äºä»¶ï¼å½ä¿¡æ¯å¨é¨å½å¥åæ§è¡Ajaxè¯­å¥ï¼
										 -->
									<input type="submit" class="btn btn-primary"  value="æ·»å " id="addent"/>	
								</div>
							 </div>
						</div>
					</div>
		        <li>
		          <input type="text" placeholder="è¯·è¾å¥æç´¢å³é®å­" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
		          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > æç´¢</a></li>
		      </ul>
		    </div>
		    <table class="table table-hover text-center">
		      
			      <tr>	              
			        <th>è´¦å·</th>
			        <th>å¯ç </th>	
			        <th>è´¦å·ç¶æ</th>        
			        <th>æä½</th>       
			      </tr>      
			        <tr>
			          <td><input type="checkbox" name="id[]" value="1" />101</td>
			          <td>123456</td>
			          <td>SSR</td>	          	          
			          <td>
			          	<div class="button-group"> 
			          		<a class="button border-red" href="javascript:void(0)" onclick="return del(1)">
			          			<span class="icon-trash-o"></span> å é¤
			          		</a>     		
			          	</div>
			          </td>
			        </tr>	           
			      <tr>
			        <td colspan="4">
			        <div class="pagelist"> <a href="">ä¸ä¸é¡µ</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">ä¸ä¸é¡µ</a><a href="">å°¾é¡µ</a> </div></td>
			      </tr>
			    </table>	  
		    
		  </div>
		
		<script type="text/javascript">
		</script>
	</body>
</html>