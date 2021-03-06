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

	
	<style>
		.modal-body1 input{
			width:40%;
		}
		.modal-body1 div{
			margin-top:15px;
			margin-left:10%;
		}
		.modal-body1 select{
			width:40%;
			height:35px;
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
		#emid_span{
			color:red;
		}
		#emage_span{
			color:red;
		}
		#emphone_span{
			color:red;
		}
	</style>
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
	        	<a class="button border-yellow" href="fresh_staffinfo.action">查看所有</a>      
	          	<!-- 
	          		添加员工按钮
	           	-->
	         	<a type="button" class="button border-yellow" id="addstaffinfo"data-target="#myModal" data-toggle="modal"><span class="icon-plus-square-o"></span> 添加员工</a>
         		<!-- 
         			添加员工模态框
         		 -->
         
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							
							<div class="modal-header">
								<!-- 
									关闭模态框按钮
								 -->
								<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
								<h2 class="modal-title" id="myModalLabel">添加员工信息</h2>
							</div>
							<!-- 
								添加员工信息的输入框 ----
							 -->							 
								<div class="modal-body1">
									<div>
										<span>&nbsp;&nbsp;编	&nbsp;&nbsp;号：&nbsp;&nbsp;</span>
										<input type="text" class="inputname1" id="emid" name="employee.emid"><span id="emid_span"></span><br/>
									</div>
									<div>
										<span>&nbsp;&nbsp;姓	&nbsp;&nbsp;名：&nbsp;&nbsp;</span>
										<input type="text" class="inputname2" id="emname" name="employee.emname"><br/>
									</div>
									<div>
										<span>&nbsp;&nbsp;性&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;</span>
										<select id="emsex">
												<option>男</option>
												<option>女</option>
										</select><br/>
									</div>
									<div>
										<span>&nbsp;&nbsp;年	&nbsp;&nbsp;龄：&nbsp;&nbsp;</span>
										<input type="text" class="inputname4" id="emage" name="employee.emage"><span id="emage_span"></span><br/>
									</div>
									<div>
										<span>&nbsp;&nbsp;电	&nbsp;&nbsp;话：&nbsp;&nbsp;</span>
										<input type="text" class="inputname5" id="emphone" name="employee.emphone"><span id="emphone_span"></span><br/> 									
									</div>
									<div>
										<span>&nbsp;&nbsp;地&nbsp;&nbsp;	址：&nbsp;&nbsp;</span>
										<input type="text" class="inputname6" id="emadress" name="employee.emadress"><br/>
									</div>
									<div>
										<span>就职时间：&nbsp;</span><input type="text" class="inputname7" id="emjointime" name="employee.emjointime" placeholder="0000年00月00日"><br/>
									</div>
									<div>
										<span>员工角色：</span>
										<select id="empart">
											
										</select><br/>
									</div>
									<div>					
										<span>员工账号：</span>
										<select id="ementer">
										
										</select>
									</div>
									<!--  <input type="text" class="inputname9" id="ementer" name="employee.ementer">-->
																			   								

								</div>														
								<div class="modal-footer">
								
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
	        
	        	<input id="condition"type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          		<a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" id="searchem"> 搜索</a></li>
	        </li>
	      </ul>
	    </div>
	    <!-- 
	    	查询出来的员工信息生成的table
	     -->
	    <table class="table table-hover text-center" id="tableid">
	    </table>
	   
		<div class="pagelist">
				<a  class="minuspage" name="firstname">首页</a>
				<a  class="minuspage" name="minusname">上一页</a> 
				<a  class="minuspage" name="addname">下一页</a>
				<a  class="minuspage" name="lastname">尾页</a>
				共<span id="pagenum"></span>页
				<input type="text" id="someone" value="1" size ="2">
				<input type="button" value="跳转" id="commitone">
		</div>					   
	  </div>
	
</div>



<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
				<div class="text-center margin-big padding-big-top">
							<h2>当前要修改的员工</h2>
				</div>
				<div id="modalform">
					<div>
					    <span>&nbsp;&nbsp;姓&nbsp;&nbsp;名&nbsp;&nbsp;</span>
					    <input type="text" name="st.personNum" id="per"/>
					</div>
					 <div>
					   <span>&nbsp;&nbsp;编&nbsp;&nbsp;号&nbsp;&nbsp;</span>
					   <input type="text" name="st.deskName" id="perid"/>
					 </div>
					  <div>
					    <span>&nbsp;&nbsp;电&nbsp;&nbsp;话&nbsp;&nbsp;</span>
					    <input type="text" name="st.deskState" id="perphone"/>
					  </div>
					   <div>
					    	<span>&nbsp;&nbsp;性&nbsp;&nbsp;别&nbsp;&nbsp;</span>
					    	<input type="text" name="st.deskState" id="persex"/>
					   </div>
					   <div>
					    	<span>&nbsp;&nbsp;年&nbsp;&nbsp;龄&nbsp;&nbsp;</span>
					    	<input type="text" name="st.deskState" id="perage"/>
					   </div>
					   <div>
					    	<span>&nbsp;&nbsp;地&nbsp;&nbsp;址&nbsp;&nbsp;</span>
					    	<input type="text" name="st.deskState" id="perdress"/>
					    </div>
				   		<div>
					    	<span>角色</span><select id="perpart">					    		
					    	</select>
					    </div>
					    <div>
					    	<span>就职时间</span><input type="text" name="st.deskState" id="pertime"/>
					    </div>

				   							 
					 </div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning btn-default confirm-btn" data-dismiss="modal" id="sureup">确定更改</button>

					</div>
				</div>
			</div>
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
	/*
		分页-获取总条数；
	*/
	var pageflag=0;
	function pagetotal(){
	var putvalue=$("#condition").val();
			$.ajax({
				url:"achieve_getcount.action",
				type:"post",
				data:{"pageflag":pageflag,"putvalue":putvalue},
				success:function(data){					
					if(data%5==0){
						var pagesize=parseInt(data/5);
						$("#pagenum").html(pagesize);					
					}else{
						var pagesize=parseInt(data/5)+1;
						$("#pagenum").html(pagesize);
						if(data%5==1){
							pagestate=0;
						}
					}				
				},
			});								
		};

		/*
			分页
		*/

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
				var a=onepage-1;
				if(pageflag==1){
					searchEM(a);
				}else if(pageflag==0){
					liyang(a);
				}				
				
				//alert(inputnum);	
								
			});			
		});
		/*
			分页完成动态添加；
		*/
		function liyang(a){
		//alert("ddf1"+a);
			$.ajax({				
					url:"achieve_getpage.action",
					type:"post",
					data:{"countpage":a},
					success:function(data){					
					var json=JSON.parse(data);				
						var th="<tr><td>员工姓名</td><td>员工编号</td><td>电话</td><td>性别</td><td>年龄</td><td>地址</td><td>就职时间</td><td>角色</td><td>账号</td><td>操作</td></tr>";
					 	$("#tableid").html("");	
					 	$("#tableid").append(th);					 
						$.each(json,function(index,value){
						//value[6].getfullyear+"-"+value[6].getfullmonth+"-"+value[6].getfullmonth
							var emtable=
								"<tr><td id=\"anum"+value[1]+"\">"+value[0]+
								"</td><td id=\"bnum"+value[1]+"\">"+value[1]+"</td><td id=\"cnum"+value[1]+"\">"+value[2]+"</td><td id=\"dnum"+value[1]+"\">"+value[3]+"</td><td id=\"enum"+value[1]+"\">"+value[4]+
								"</td><td id=\"fnum"+value[1]+"\">"+value[5]+"</td><td id=\"gnum"+value[1]+"\">"+value[6]+"</td><td id=\"hnum"+value[1]+"\">"+value[7]+"</td><td id=\"inum"+value[1]+"\">"+value[8]+"</td>"+
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
		* 模糊查询
		* 点击搜索按钮，触发点击事件
		* 先获得输入框中的值
		* ajax将值传给action
		* 从action得到json，遍历json,将值打印到表格中
		*
		*/
		$(function(){
			$("#searchem").click(function(){  //button
			var putvalue=$("#condition").val();
				if(putvalue==""){
					pageflag=0;
					curr=0;
					pagetotal();
					liyang(curr);
				}else if(putvalue!=""){
					pageflag=1;
					curr=0;
					pagetotal();
					searchEM(curr);
				}
				
			});
		});
		$(function(){
			pagetotal();
			liyang(0);		
		})
		function searchEM(curr){
			var putvalue=$("#condition").val();	 //shurukuang		
				$.ajax({
					url:"achieve_searchEM.action",
					type:"post",
					data:{"putvalue":putvalue,"countpage":curr},	//action穿件一个属性类型	
					datatype:"json",	
					success:function(data){
					var json=JSON.parse(data);
					$("#tableid").html("");
						var th="<tr><td>员工姓名</td><td>员工编号</td><td>电话</td><td>性别</td><td>年龄</td><td>地址</td><td>就职时间</td><td>角色</td><td>账号</td><td>操作</td></tr>";
					 	$("#tableid").append(th);
						$.each(json,function(index,value){
							var emtable=
								"<tr><td></td><td id=\"anum"+value[1]+"\">"+value[0]+
								"</td><td id=\"bnum"+value[1]+"\">"+value[1]+"</td><td id=\"cnum"+value[1]+"\">"+value[2]+"</td><td id=\"dnum"+value[1]+"\">"+value[3]+"</td><td id=\"enum"+value[1]+"\">"+value[4]+
								"</td><td id=\"fnum"+value[1]+"\">"+value[5]+"</td><td id=\"gnum"+value[1]+"\">"+value[6]+"</td><td id=\"hnum"+value[1]+"\">"+value[8]+"</td><td id=\"inum"+value[1]+"\">"+value[9]+"</td>"+
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
				var namehtml =$("#a"+alterbtn).html();			
				var idhtml =$("#b"+alterbtn).html();
				var phonehtml =$("#c"+alterbtn).html();
				var sexhtml =$("#d"+alterbtn).html();
				var agehtml =$("#e"+alterbtn).html();
				var adresshtml =$("#f"+alterbtn).html();
				var timehtml =$("#g"+alterbtn).html();
				//var parthtml =$("#h"+alterbtn).html();
				
				$("#per").val(namehtml);//将要修改某行的数据放入到模态框中
				$("#perid").val(idhtml);
				$("#perphone").val(phonehtml);
				$("#persex").val(sexhtml);
				$("#perage").val(agehtml);
				$("#perdress").val(adresshtml);
				$("#pertime").val(timehtml);
				//$("#perpart").val(parthtml);
				//$("#pertable").val(tablehtml);		
				updpart();
				update(idhtml);					
			});
			function update(idhtml){
				$("#sureup").bind('click',function(){
					$(this).unbind('click');
					var sname=$("#per").val();//修改后将值
					var sid=$("#perid").val();
					var sphone=$("#perphone").val();
					var ssex=$("#persex").val();
					var sage=$("#perage").val();
					var sadress=$("#perdress").val();
					var stime=$("#pertime").val();
					var spart=$("#perpart option:selected").html();
					//var stable=$("#per").val();
					//alert(spart);
					if(ssex=="女"){
						ssex=5;
					}else{
						ssex=4;
					}
					$.ajax({
						url:"achieve_updatestaff.action",
						type:"post",
						data:{"employee.emid":sid,"employee.emname":sname,"employee.emsex":ssex,"employee.emage":sage,"employee.emphone":sphone,"employee.emadress":sadress,
						"employee.emjointime":stime,"partname.partname":spart},
						success:function(data){
							if(data==-1){
								alert("修改失败");
							}else if(data==1){
								var inputvalue=parseInt($("#someone").val());
									 	//alert("565:"+inputvalue)
								liyang(inputvalue-1);
								//alert("修改成功");
							}else{
								alert("没有权限");
							}		
														
						}
					});
				});
			}
		});
		/**
		*	修改员工 角色下拉框
		*/
		function updpart(){
				$.ajax({
					url:"achieve_selpa.action",
					type:"post",
					data:{},
					success:function(data){
					//alert(data);
						$("#perpart").html("");
						var json=JSON.parse(data);
												
							$.each(json,function(index,value){							
								var partname="<option value=\""+value[1]+"\">"+value[0]+"</option>";
								$("#perpart").append(partname);
							});				
					}
				});
			
		}
			/*
			* tableid：表id
			* deskbtn：删除id
			* 点击删除按钮触发点击事件
			* 
			* 
			* 
			*/
		$(function(){
			$("#tableid").on('click',".deskbtn",function(){			
				var deskbtn=$(this).attr("id");
				var emhtml = $("#b"+deskbtn).html();
				var ementer =$("#i"+deskbtn).html();
				$.ajax({
					url:"achieve_delem.action",
					type:"post",
					data:{"employee.emid":emhtml,"employId.ementer":ementer},					
					success:function(data){
						if(data==-1){
							alert("删除失败");
						}else if(data==1){
							pagetotal();
							var inputvalue=parseInt($("#someone").val());//获取当前页																
							if(pagestate==0){
							//alert("111:"+inputvalue);								 	
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
					}
				});
			});	
		});
		

			/*
			* 点击添加员工；动态添加员工角色下拉框	
			*/

		$(function(){
			$("#addstaffinfo").click(function(){
				$.ajax({
					url:"achieve_selpa.action",
					type:"post",
					data:{},
					success:function(data){
					$("#empart").html("");
						var json=JSON.parse(data);						
							$.each(json,function(index,value){							
								var partname="<option value=\""+value[1]+"\">"+value[0]+"</option>";
								$("#empart").append(partname);
							});							
					}
				});
			});
		});
		/*
			 点击添加员工；动态添加员工账号下拉框	
		*/
		$(function(){
			$("#addstaffinfo").click(function(){
				$.ajax({
					url:"achieve_appendlogin.action",
					type:"post",
					data:{},
					success:function(data){
					$("#ementer").html("");
						var json=JSON.parse(data);						
							$.each(json,function(index,value){							
								var partname="<option value=\""+value[1]+"\">"+value[0]+"</option>";
								$("#ementer").append(partname);
							});
							
					}
				});
			});
		});
			/*
			* 添加员工按钮，弹出模态框
			* 
			* addem：点击添加按钮触发点击事件
			* 先判断输入框中有没有空值，如果有，将插入失败，你有那么多属性就得给我加上，我不管数据库要求是否为空，
			* 在我这就是不能为空
			*/
		$(function(){
		
			$("#addem").click(function(){
			
				var emid=$("#emid").val();				
				var emname=$("#emname").val();
				var emsex=$("#emsex option:selected").val();
				//alert("55555:"+emsex);
				var emage=$("#emage").val();
				//alert(emage);
				var emphone=$("#emphone").val();
				var emadress=$("#emadress").val();
				var emjointime=$("#emjointime").val();
				var empart=$("#empart option:selected").html();			
				var ementer=$("#ementer option:selected").html();
				alert(ementer);	
				//alert(empart+";"+ementer);							
					if(emsex=="男"){
						emsex=4;
					}else{
						emsex=5;
					}			
					$.ajax({
						type:"post",
						url:"achieve_save.action",
						data:{"employee.emid":emid,"employee.emname":emname,"employee.emsex":emsex,"employee.emage":emage,
							"employee.emphone":emphone,"employee.emadress":emadress,"employee.emjointime":emjointime,
							"partname.partname":empart,"employId.ementer":ementer},
						success:function(data){
							//alert(data);
							if(data==-1){
								alert("添加失败");
							}else if(data==1){
									pagetotal();
								
									 var inputvalue=parseInt($("#pagenum").html());//获取共多少页																										
									 	if(pagestate==1){
										 	$("#someone").val(inputvalue+1);
										 	//alert("565:"+inputvalue)
										 	liyang(inputvalue);
									 	}else{
									 		$("#someone").val(inputvalue);
										 	//alert("565:"+inputvalue)
										 	liyang(inputvalue-1);
									 	}								 										 
								alert("添加成功");
							}else{
								alert("没有权限");
							}	
						}
					});
				
			});
		});	
		/**
		* 添加员工编号聚焦事件
		*/
		$("#emid").focus(function(){
			$("#emid_span").html("");
		});
		/**
		*员工编号失焦事件
		*/
		
	$("#emid").blur(function(){
				var emidvalue=$("#emid").val();
				//alert("sss:"+emidvalue);
				if(emidvalue==""){				
					$("#emid_span").html("员工编号必须填写！");
				}			
				$.ajax({
					url : "achieve_selemid.action",
					type : "post",
					data : {"employee.emid":$(this).val()},
					success : function(data){						
						if (data == 1) {
							$("#emid_span").html("该员工编号已存在！");
						}
					},
				});
			});
	/**
		* 添加员工姓名聚焦事件
		*/
		$("#emname").focus(function(){
			$("#emname_span").html("");
		});
	/**
	* 员工姓名失焦事件验证
	*/
	$("#emname").blur(function(){
		var reg = /^[\u4e00-\u9fa5A-Za-z]+$/i;
				var tname=$(this).val();
				//alert(tname);
				if(tname.length>20||tname.length<1){
					$("#emname_span").html("长度有误！");
				}else if(reg.test(tname)){
				}else{
					$("#emname_span").html("格式有误");
				}
	});
	/**
	*	聚焦清空提示信息
	*/
	
	$("#emage").focus(function(){
		$("#emage_span").html("");
	});
	   /**
		* 失焦表单验证年龄
		*/	
	$("#emage").blur(function(){	
		var	emage=parseInt($("#emage").val());
			if(emage<=18 || emage>=60){
				$("#emage_span").html("年龄或大或小");
			}
	});
	/**
	* 聚焦清空提示信息
	*/	
	$("#emphone").focus(function(){	
		$("#emphone_span").html("");
	})
	/**
	* 失焦表单验证手机号
	*/	
	$("#emphone").blur(function(){	
		var reg=new RegExp("^1[0-9]{10}","gi");
		var emphone=$("#emphone").val();
		if(reg.test(emphone)){			
		}else{
			$("#emphone_span").html("号码格式有误");
		}
	});
		/**
		* 跳转点击事件
		*/
		$(function(){
			$("#commitone").click(function(){
				var inputpage=parseInt($("#someone").val());
				liyang(inputpage);
			});
		});
</script>

</body>
</html>
