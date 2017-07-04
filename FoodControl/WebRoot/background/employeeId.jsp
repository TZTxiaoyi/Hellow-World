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
	<style>
			.modal-body1 input{
			width:40%;
			height:40px;
		}
		.modal-body1 div{
			margin-top:15px;
			margin-left:10%;
			margin-bottom:15px;
		}
		
		.modal-body1 span{
			font-size:20px;
		}
		#modalform div{
			margin-top:15px;
			margin-left:10%;
		}
		#modalform span{
			font-size:20px;
		}
		#modalform input{
			width:40%;
			height:35px;
		}
		#ementer_span{
			color:red;
		}
		#emword_span{
			color:red;
		}
	</style>
		
	</head>
	<body>	
		  <div class="panel admin-panel">
		    <div class="panel-head">
			    <strong class="icon-reorder">内容列表</strong> 
			    <a href="" style="float:right; display:none;">添加字段</a>
		    </div>
		    <div class="padding border-bottom">
		      <ul class="search" style="padding-left:10px;">       
		        
		        <li>
		        	<a class="button border-yellow" href="fresh_staffid.action">查看所有</a>
		         	<a type="button" class="button border-yellow" href="" data-target="#myModal" data-toggle="modal">
		         		<span class="icon-plus-square-o"></span>添加员工账号
		         	</a>	         
		        <li>
		          <input type="text" placeholder="请输入搜索关键字" name="keywords" id="input_value"class="input" style="width:250px; line-height:17px;display:inline-block" />
		          <a id="search_account" type="button" class="button border-main icon-search" onclick="changesearch()" >搜索</a></li>
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
		  
		  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">	
						<!-- 
							关闭模态框按钮
						-->
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>								
						<h2 class="modal-title" id="myModalLabel">添加员工账号</h2>
					</div>
						<!-- 
							添加员工账号的输入框 ----
						-->									 
					<div class="modal-body1">
						<div>								
							<span>账	号：</span><input type="text" id="ementer" name="ementer"><span id="ementer_span"></span><br/>
						</div>
						<div>
							<span>密	码：</span><input type="text" id="emword" name="emword"><span id="emword_span"></span><br/>									
						</div>
					</div>
					<div class="modal-footer">
										<!-- 
											点击添加按钮，触发点击事件，当信息全部录入后执行Ajax语句；
										 -->
						<input type="submit" class="btn btn-primary"  value="添加" id="addent" data-dismiss="modal"/>	
					</div>
				 </div>
			</div>
		  </div>
		  <div class="modal fade" id="myModal2" tabindex="-1" role="dialog"aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
						<div class="text-center margin-big padding-big-top">

								<h2>密码修改</h2>
						</div>
					</div>
					<div id="modalform">
						<!--<div>
							   <span>账号</span><input type="text" name="st.personNum" id="per"/>
						</div>  -->
						<div>
							<span>&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;</span><input type="text" name="st.deskName" id="perid"/>

						</div>									   
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning btn-default confirm-btn" data-dismiss="modal" id="sureup">确定更改</button>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			/*
			*添加员工账号
			*/
			$(function(){
				$("#addent").click(function(){
					var ementer = $("#ementer").val();
					var emword	= $("#emword").val();				
					if(ementer && emword && emword.length>=6 && ementer>=5){					
						$.ajax({
							type:"post",
							url:"achieve_enterid.action",
							data:{"employId.ementer":ementer,"employId.emword":emword},
							success:function(data){
								if(data==-1){
									alert("添加失败");
								}else if(data==1){								 	 
									 allpages();
									 var inputvalue=parseInt($("#pagenum").html());//获取共多少页																	
									 	if(pagestate==1){
										 	$("#someone").val(inputvalue+1);
										 	liyang(inputvalue);
									 	}else{
									 		$("#someone").val(inputvalue);
										 	liyang(inputvalue-1);
									 	}										
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
			allpages();
			liyang(0);		
		});
		var pagestate=0;
		function allpages(){			
			$.ajax({
				url:"achieve_getaccount.action",
				type:"post",
				data:{},
				success:function(data){						
					if(data%5==0){
						var pagesize=parseInt(data/5);
						$("#pagenum").html(pagesize);	
						pagestate=1;				
					}else{
						var pagesize=parseInt(data/5)+1;
						$("#pagenum").html(pagesize);
						if(data%5==1){
							pagestate=0;
						}
					}				
				},
			});										
		}
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
						var th="<tr><td>账号</td><td>密码</td><td>当前状态</td><td>操作</td></tr>";
					 	$("#tableid").html("");	
					 	$("#tableid").append(th);					 
						$.each(json,function(index,value){
						//value[6].getfullyear+"-"+value[6].getfullmonth+"-"+value[6].getfullmonth
							var emtable=
								"<tr><td id=\"anum"+value[1]+"\">"+value[0]+
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
		/**
		* 跳转页码点击事件
		*/
		$(function(){
			$("#commitone").click(function(){
				var input_page=$("#someone").val();
				liyang(input_page);
			});
		});
		/**
		* 模糊查询账号
		*
		*
		*/
		$(function(){
			$("#search_account").click(function(){
				var putvalue=$("#input_value").val();	
				$.ajax({
					url:"achieve_searchac.action",
					type:"post",
					data:{"putvalue":putvalue},
					success:function(data){
						var json=JSON.parse(data);
						$("#tableid").html("");
						var th="<tr><td>账号</td><td>密码</td><td>状态</td><td>操作</td></tr>";
					 	$("#tableid").append(th);
						$.each(json,function(index,value){					
							var emtable=
								"<tr><td id=\"anum"+value[1]+"\">"+value[0]+"</td>"+
								"<td id=\"bnum"+value[1]+"\">"+value[1]+"</td><td id=\"cnum"+value[1]+"\">"+value[2]+"</td>"+
								"<td id=\"fnum"+value[1]+"\"><button class=\"button border-red deskbtn\" id=\"num"+value[1]+"\" >"+
								"<span class=\"icon-trash-o\"></span>删除 </button>"+
								"<a class=\"button border-main alterbtn\" id=\"num"+value[1]+"\" aria-labelledby=\"myModalLabel\"  data-target=\"#myModal2\" data-toggle=\"modal\">"+
								"<span class=\"icon-edit\"></span> 修改</a></td></tr>";
								$("#tableid").append(emtable);																
						});
						var emtable="<tr id=\"trtab\">"+
	        				"<td colspan=\"10\">"+
	        				"<div class=\"pagelist\"> <a href=\"\">上一页</a> <span class=\"current\">1</span><a href=\"\">2</a><a href=\"\">3</a><a href=\"\">下一页</a><a href=\"\">尾页</a> </div></td></tr>"
						
						$("#trtab").append(emtable);
						
						
					
					}
				});
			});
		});
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
				var phonehtml =$("#c"+alterbtn).html();			
				//$("#per").val(namehtml);//将要修改某行的数据放入到模态框中
				$("#perid").val(idhtml);
				//$("#perphone").val(phonehtml);
					
				
				update(namehtml);					
			});
			function update(namehtml){
				$("#sureup").bind('click',function(){
					$(this).unbind('click');
					//var sname=$("#per").val();//修改后将值传给action
					var sid=$("#perid").val();
					//var sphone=$("#perphone").val();
					//alert(sphone);
					$.ajax({
						url:"achieve_updatestaffid.action",
						type:"post",
						data:{"employId.emword":sid,"employId.ementer":namehtml},
						success:function(data){
							if(data==-1){
								alert("修改失败");
							}else if(data==1){
								var inputvalue=parseInt($("#someone").val());
								//alert("565:"+inputvalue)
								liyang(inputvalue);
								alert("修改成功");
							}else{
								alert("没有权限");
							}		
															
						}
					});
				});
			}
		});
		/**
		*	删除账号
		*/
		$("#tableid").on('click',".deskbtn",function(){
			var alterbtn = $(this).attr("id");
			//alert("sss:"+alterbtn);
			var namehtml =$("#a"+alterbtn).html();	
			$.ajax({
				url:"achieve_delaccount.action",
				type:"post",
				data:{"employId.ementer":namehtml},
				success:function(data){
					if(data==-1){
						alert("删除失败");
					}else if(data==1){
						allpages();
						var inputvalue=parseInt($("#someone").val());//获取当前页																
					if(pagestate==0){								 	
						$("#someone").val(inputvalue-1);
						liyang(inputvalue-2);
					}else{
						$("#someone").val(inputvalue);
								//alert("565:"+inputvalue)
						liyang(inputvalue-1);								
					}
						alert("删除成功");
					}else{
						alert("没有权限");
					}				
				},			
			});
		});
		/*
		* 添加员工账号聚焦清空提示信息
		*/
		$("#ementer").focus(function(){
			$("#ementer_span").html("");
		});		
		/**
		*添加员工账号的失焦事件，查询是否添加的账号是否已存在
		*/
		$("#ementer").blur(function(){
				if($(this).val().length<5){
					$("#ementer_span").html("长度不能小于5");
				}		
				$.ajax({
					url : "achieve_selaccount.action",
					type : "post",
					data : {"employId.ementer":$(this).val()},
					success : function(data){						
						if(data == 1){
							$("#ementer_span").html("该角色已存在");
						}
					},
				});
			});
		/*
		* 添加员工账号聚焦清空提示信息
		*/
		$("#emword").focus(function(){
			$("#emword_span").html("");
		});	
		/**
		*	添加密码失焦事件
		*/
		$("#emword").blur(function(){
			if($(this).val().length<6){
				$("#emword_span").html("密码长度不能小于6");
			}
		});
		</script>
	</body>
</html>