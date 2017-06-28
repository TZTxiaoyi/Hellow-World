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
			/*
			*添加员工账号
			*/
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
			
		$(function(){
			
			$.ajax({
				url:"achieve_getaccount.action",
				type:"post",
				data:{},
				success:function(data){						
					if(data%2==0){
						var pagesize=parseInt(data/2);
						$("#pagenum").html(pagesize);					
					}else{
						var pagesize=parseInt(data/2)+1;
						$("#pagenum").html(pagesize);
					}				
				},
			});	
			liyang(0);								
		});
		$(function(){
			$(".minuspage").click(function(){			
				var somename=$(this).attr("name");
						//alert(somename);				 
				var onepage=parseInt($("#someone").val());	
							
				var pagesize=$("#pagenum").html();
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
				//alert(inputnum);	
				liyang(a);				
			});			
		});
		function liyang(a){
			$.ajax({				
					url:"achieve_getidpage.action",
					type:"post",
					data:{"countpage":a},
					success:function(data){					
					var json=JSON.parse(data);				
						var th="<tr><td></td><td>账号</td><td>密码</td><td>当前状态</td><td>操作</td></tr>";
					 	$("#tableid").html("");	
					 	$("#tableid").append(th);
					 
						$.each(json,function(index,value){
						//value[6].getfullyear+"-"+value[6].getfullmonth+"-"+value[6].getfullmonth
							var emtable=
								"<tr><td><input type=\"checkbox\" name=\"id[]\" value=\"1\" /></td><td id=\"anum"+value[1]+"\">"+value[0]+
								"</td><td id=\"bnum"+value[1]+"\">"+value[1]+"</td><td id=\"cnum"+value[1]+"\">"+value[2]+"</td>"+
								"<td id=\"fnum"+value[1]+"\"><button class=\"button border-red deskbtn\" id=\"num"+value[1]+"\" >"+
								"<span class=\"icon-trash-o\"></span>删除 </button>"+
								"<a class=\"button border-main alterbtn\" id=\"num"+value[1]+"\" aria-labelledby=\"myModalLabel\"  data-target=\"#myModal2\" data-toggle=\"modal\">"+
								"<span class=\"icon-edit\"></span> 修改</a></td></tr>";
							$("#tableid").append(emtable);																												
						});
													
					}
				});
		}	
		
		
				/*
		* tableid：表id
		* 点击修改按钮触发点击事件，获得每行数据放到模态框中
		* alterbtn：修改按钮的类名
		* 修改某个或者某几个当前行属性值后，调用修改函数
		* 
		*/		
		$(function(){
			$("#tableid").on('click',".alterbtn",function(){
				var alterbtn = $(this).attr("id");
				//alert("sss:"+alterbtn);
				var namehtml =$("#a"+alterbtn).html();	
				//alert(namehtml);			
				var idhtml =$("#b"+alterbtn).html();
				//alert(idhtml); 
				//var phonehtml =$("#c"+alterbtn).html();
				
			 
				
				//$("#per").val(namehtml);//将要修改某行的数据放入到模态框中
				$("#perid").val(idhtml);
				//$("#perphone").val(phonehtml);
					
				
				update(namehtml);					
			});
			function update(namehtml){
				$("#sureup").bind('click',function(){
					$(this).unbind('click');
					//var sname=$("#per").val();//修改后将值
					var sid=$("#perid").val();
					//var sphone=$("#perphone").val();
					
					$.ajax({
						url:"achieve_updatestaffid.action",
						type:"post",
						data:{"employId.emword":sid,"employId.ementer":namehtml},
						success:function(data){
							if(data==-1){
								alert("修改失败");
							}else if(data==1){
								alert("修改成功");
							}else{
								alert("没有权限");
							}		
							liyang();								
						}
					});
				});
			}
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
		         			
		         		 -->
		         
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
								<div class="modal-header">
									
								<h4 class="modal-title" id="myModalLabel">添加员工账号</h4>
								</div>
									<!-- 
										¡ ----
									 -->
									 
								<div class="modal-body1">															
									账	号：<input type="text" id="ementer" name="ementer"><br/>
									密	码：<input type="text" id="emword" name="emword"><br/>
								</div>
								<div class="modal-footer">
										<!-- 
											
										 -->
									<button type="submit" class="btn btn-default" data-dismiss="modal">关闭</button>
										<!-- 
											
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
		    <table class="table table-hover text-center" id="tableid">
	    	</table>	  
		     <div class="pagelist">
				<a  class="minuspage" name="firstname">首页</a>
				<a  class="minuspage" name="minusname">上一页</a> 
				<a  class="minuspage" name="addname">下一页</a>
				<a  class="minuspage" name="lastname">尾页</a>
				共<span id="pagenum"></span>页
				<input type="text" id="someone" value="1">
				<input type="button" value="跳转" id="commitone">
			</div>	
		  </div>
		  
		  
		  <div class="modal fade" id="myModal2" tabindex="-1" role="dialog"aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
				<div class="text-center margin-big padding-big-top">
							<h1>密码或状态修改</h1>
				</div>
				<div id="modalform">
					<div>
					    <span>账号</span><input type="text" name="st.personNum" id="per"/>
					</div>
					 <div>
					   <span>密码</span><input type="text" name="st.deskName" id="perid"/>
					 </div>
					  <div>
					    <span>当前状态</span><input type="text" name="st.deskState" id="perphone"/>
					  </div>
					   
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning btn-default confirm-btn" data-dismiss="modal" id="sureup">确定更改</button>

					</div>
				</div>
			</div>
		</div>
	</body>
</html>