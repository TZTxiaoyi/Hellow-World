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
</head>
<style>
	
	.modal-body1 input{
		width:145px;
		height:25px;
	}
	.modal-body1 div{
		margin-bottom:15px;
		width:350px;
	}
	#sel{
		width:140px;
	}
	#loag input{
		display:inline-block;
	}
	#file1{
		width:300px;
		margin:5px 5px 5px 0px;
	}
	#upload{
		width:70px;
		height:33px;
	}
	#aimg{
		display:block;
	}
	#fileloadchg{
		width:500px;
		float:left;
		text-align:center;
	}
	.chgError{
		display:none;
		margin:5px 5px 5px 5px;
		color:red;
		border:1px solid black;
	}
	
	
</style>

</head>
  
  <body>
<div class="panel admin-panel">
<div class="panel-head"><strong><span class="icon-pencil-square-o"></span>菜品信息</strong></div>
 <div>
	 <form method="post" action="">
	  <div class="panel admin-panel">	    
	    <div class="padding border-bottom">
	      <ul class="search">
	        <li>																
	          <a class="button border-yellow" href="fresh_dishmanage.action">查看所有</a>
	          <a type="button" class="button border-yellow" href="" data-target="#myModal" data-toggle="modal" id="myMo"><span class="icon-plus-square-o"></span> 添加菜品</a>
         		<!-- 
         			添加菜品模态框
         		 -->
         
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
									<h4 class="modal-title" id="myModalLabel">添加菜品</h4>
								</div>
								<!-- 
									添加菜品的输入框 
								 -->
								<div class="modal-body1">
									<div id="modb">
										<div>菜品名称:<input id="dishName"/><span id="nameNot"class="chgError">*菜品名称不能为空</span><span class="chgError" id="nameThan">*菜品名不能大于20个字符</span></div><!--1-->
										<div>菜品价格:<input id="price"/><span class="chgError" id="priceNum">*必须输入数字</span><span id="priceNot"class="chgError">*价格不能为空</span></div><!--2-->
										<div>									
	    									<div>菜品类别:
	      										<select id="sel">
	        					
	     										 </select>
	   										</div>														
										</div><!--3-->
										<div>菜品时间:<input id="makeTime"/><span class="chgError" id="TimeNum">*必须输入数字 </span><span id="TimeNot"class="chgError">*制作时间不能为空</span></div><!--4-->
										<div>菜品等级:<input id="priority"/><span class="chgError" id="pioNum">*必须输入数字</span><span id="pioNot"class="chgError">*优先级不能为空</span></div><!--5-->
										<div id="loag">
											<input type="file" id="file1"/><span id="fileload"></span></br>
											<input type="button" id="upload" value="上传图片" />
										</div>
										<div>可并菜数:<input id="maxCopies"/><span class="chgError" id="MaxNum">*必须输入数字</span><span id="MaxNot"class="chgError">*并菜数不能为空</span></div><!--7-->
									</div> 	
								</div>
								<div class="modal-footer">
									<!-- 
										关闭模态框按钮
									 -->
									 
									
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									<!-- 
										保存模态框按钮   --- 可以此按钮跳转到一个servlet执行SQL语句，插入数据到数据库
									 -->
									<button type="submit" class="btn btn-primary"id="togo" data-dismiss="modal">保存</button>
									
								</div>
						   </div>
						</div>
					</div>
		        </li>
		        <li>			<!--搜索框-->
  				<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" id="sekm" style="width:250px; line-height:17px;display:inline-block" />
          		<a href="javascript:void(0)" class="button border-main icon-search" class="seek"id="sekbt" > 搜索</a></li>
  			</li>
	      </ul>
	    </div>
	    <table class="table table-hover text-center" id="tab">
	    </table>
	   		<!--分页选项 -->
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
	</form>
</div>

</div>


	<!-- 修改选项的模态框（Modal） -->
<div class="modal fade" id="cgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title" id="myModalLabel">
					更改菜品
				</h4>
			</div>
			<div class="modal-body1">
				<div id="modb">
					<div>菜品名称:<input id="dishNamechg"/><span id="namechgNotnull"class="chgError">*菜品名称不能为空</span><span class="chgError" id="nameNothan">*菜品名不能大于20个字符</span></div><!--1-->
					<div>菜品价格:<input id="pricechg"/><span class="chgError" id="pricechgNum">*必须输入数字</span><span id="pricechgNotnull"class="chgError">*价格不能为空</span></div><!--2-->								
	    			<div><div>菜品类别:
	      				<select id="selchg">
	        			
	     				</select>
	     				</div>
	   				</div>														
				
					<div>菜品时间:<input id="makeTimechg"/><span class="chgError" id="TimechgNum">*必须输入数字 </span><span id="TimechgNotnull"class="chgError">*制作时间不能为空</span></div><!--4-->
					<div>菜品等级:<input id="prioritychg"/></span><span class="chgError" id="priochgNum">*必须输入数字</span><span id="piochgNotnull"class="chgError">*优先级不能为空</div><!--5-->
					<div id="loag">
						<input type="file" id="file2"/><span id="fileload2"></span></br>
						<input type="button" id="upload2" value="上传图片" />
					</div>
					<div>可并菜数:<input id="maxCopieschg"/><span class="chgError" id="MaxchgNum">*必须输入数字</span><span id="MaxchgNotnull"class="chgError">*并菜数不能为空</span></div><!--7-->
				</div> 	
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary"id="caghave" data-dismiss="modal">
					提交更改
				</button>
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
    		
			var namchg; 
			var namNul;
			var prichg; 
			var pricNul;
			var Timchg;
			var TimNul;
			var prtchg; 
			var prtNu;
			var maCopichg;
			var maCopiNul;
			var onepage;
    	
    		
    		/*
				菜品搜索
			*/
			
		$("#sekbt").click(function(){
			var currpage=0;
			fastsearch(currpage);
			$("#someone").val("1");
		});
		function fastsearch(curr){
			var allput=$("#sekm").val();
			allpage(allput);
				$.ajax({
					url:"GJYFC_seekfood.action",
					type:"post",
					data:{"countpage":curr,"search":allput},
					success:function(data){
						var json = JSON.parse(data);
						sekfood(json);
				}
			});
		}
    
    /*添加菜品选项*/
	$("#myMo").click(function(){
	
				/*判断修改模态框中的值是否合法*/
		
		$("#dishName").blur(function(){
			var disnam=$("#dishName").val();
			if(disnam.length==""){//菜品名称不能为空，如果为空将提示
				$("#nameNot").css("display","inline");
				namchg=false;
			}else{
				$("#nameNot").css("display","none");
				namchg=true
			}
			
			if(disnam.length>20){//输入的字符串不能大于20个
				$("#nameThan").css("display","inline");
				namNul=false;
			}else{
				$("#nameThan").css("display","none");
				namNul=true;
			}	
		});
			 
			
			/*判断价格输入是否合法*/
			
			$("#price").blur(function(){
		 		var pric=$("#price").val();
				if(pric.length==""){//菜品名称不能为空，如果为空将提示
					$("#priceNot").css("display","inline");
					prichg=false;
				}else{
					$("#priceNot").css("display","none");
					 prichg=true;
				}
			
				var limitnum=/^[0-9]*$/;//设置判断的正则表达式
			
				if(limitnum.test(pric)!=true){//判断是否除数字以外有其他字符
					$("#priceNum").css("display","inline");
					 pricNul=false;
				}else{
					$("#priceNum").css("display","none");
					 pricNul=true;
				}	
		});
				
				
				/*判断输入框中的菜品制作时间是否为数字*/
					
			$("#makeTime").blur(function(){
		 		var makeTim=$("#makeTime").val();
				if(makeTim.length==""){//菜品名称不能为空，如果为空将提示
					$("#TimeNot").css("display","inline");
					Timchg=false;
				}else{
					$("#TimeNot").css("display","none");
					Timchg=true;
				}
			
				var limitim=/^[0-9]*$/;//设置判断的正则表达式
			
				if(limitim.test(makeTim)!=true){//判断是否除数字以外有其他字符
					$("#TimeNum").css("display","inline");
					TimNul=false;
				}else{
					$("#TimeNum").css("display","none");
					TimNul=true;
				}	
			
		});
		
		
		
			/*判断输入框中的菜品优先级是否为数合法*/
					
			$("#priority").blur(function(){
		 		var prit=$("#priority").val();
				if(prit.length==""){//菜品名称不能为空，如果为空将提示
					$("#pioNot").css("display","inline");
					prtchg=false;
				}else{
					
					$("#pioNot").css("display","none");
					prtchg=true;
				}
			
				var limipr=/^[0-9]*$/;//设置判断的正则表达式
			
				if(limipr.test(prit)!=true){//判断是否除数字以外有其他字符
					$("#pioNum").css("display","inline");
					 prtNul=false;
				}else{
					$("#pioNum").css("display","none");
					 prtNul=true;
				}	
			});
		
		
		/*判断输入框中的最大并菜数是否为数合法*/
					
			$("#maxCopies").blur(function(){
		 		var maCopi=$("#maxCopies").val();
				if(maCopi.length==""){//菜品名称不能为空，如果为空将提示
					$("#MaxNot").css("display","inline");
					maCopichg=false;
					
				}else{
					$("#MaxNot").css("display","none");
					maCopichg=true;
				}
			
				var limCopi=/^[0-9]*$/;//设置判断的正则表达式
			
				if(limCopi.test(maCopi)!=true){//判断是否除数字以外有其他字符
					$("#MaxNum").css("display","inline");
					 maCopiNul=false;
				}else{
					$("#MaxNum").css("display","none");
					maCopiNul=true;
				}	

			}); 
	
		/*
			添加菜品
		*/
		$("#togo").bind('click', function() {//绑定事件处理函数
			$(this).unbind('click');//移除当前事件处理函数	
			var dishName=$("#dishName").val();
			var price=$("#price").val();
			var kindId=$("#sel option:selected").val();	
			var makeTime=$("#makeTime").val();
			var priority=$("#priority").val();
			var uppicture=$("#fileload").html();
			var maxCopies=$("#maxCopies").val();
			if(kindId=="凉菜"){kindId=1;}
			else if(kindId=="主食"){kindId=2;}
			else if(kindId=="拌饭"){kindId=3;}
			else if(kindId=="小炒"){kindId=4;}
			else if(kindId=="汤类"){kindId=5;}
			if( (namchg&&namNul)&&(prichg&&pricNul)&&(Timchg&&TimNul)&&(prtchg&&prtNul)&&(maCopichg&&maCopiNul)&& uppicture && kindId ){
				$.ajax({
					type:"post",
					url:"GJYFC_insertFood.action",
					data:{"fdCry.dishName":dishName,"fdCry.price":price,"fdCry.kindId":kindId,"fdCry.makeTime":makeTime,"fdCry.priority":priority,"fdCry.pictureName":uppicture,"fdCry.maxCopies":maxCopies,"fdCry.dishState":19},
					success:function(data){
						if(data==-1){
							alert("添加失败");
						}else if(data==1){
							allpage("");
									var inpval=parseInt($("#pagenum").html());
									if(pagestate==1){
										$("#someone").val(inpval+1);
										ces(inpval);//调用页面加载时自动查询数据库，显示桌台信息
									}else{
										$("#someone").val(inpval);
										ces(inpval-1);
									}
						}else{
							alert("没有权限");
						}		
					}
				});
			}else{
				alert("菜品添加失败");
			}
		});
	});
		
		
		/*修改选项*/
	
	$("#tab").on('click',".chgb",function(){
			var p1=$(this).attr("id");
			 $("#dishNamechg").val($("#b"+p1).html());// 菜品编号的值    第一个td里面的值
			 $("#pricechg").val($("#c"+p1).html());
			 $("#selchg").val($("#d"+p1).html());
			 $("#makeTimechg").val($("#e"+p1).html());			//获得数据库中的值放入input中
		 	 $("#prioritychg").val($("#f"+p1).html());
		 	 $("#fileloadchg").text($("#j"+p1).html());
			 $("#maxCopieschg").val($("#h"+p1).html());
			 $("#selchg option:first").prop("selected",'selected');
			 
			 	 /*判断修改模态框中的值是否合法*/
			//nameNothan
		$("#dishNamechg").blur(function(){
			var disnam=$("#dishNamechg").val();
			if(disnam.length==""){//菜品名称不能为空，如果为空将提示
				$("#namechgNotnull").css("display","inline");
				namchg=false;
			}else{
				$("#namechgNotnull").css("display","none");
				namchg=true;
			}
			
			if(disnam.length>20){//输入的字符串不能大于20个
				$("#nameNothan").css("display","inline");
				namNul=false;
			}else{
				$("#nameNothan").css("display","none");
				namNul=true;
			}	
		});
			 
			
			/*判断价格输入是否合法*/
			
			$("#pricechg").blur(function(){
		 		var pric=$("#pricechg").val();
				if(pric.length==""){//菜品名称不能为空，如果为空将提示
					$("#pricechgNotnull").css("display","inline");
					prichg=false;
				}else{
					$("#pricechgNotnull").css("display","none");
					 prichg=true;
				}
			
				var limitnum=/^[0-9]*$/;//设置判断的正则表达式
			
				if(limitnum.test(pric)!=true){//判断是否除数字以外有其他字符
					$("#pricechgNum").css("display","inline");
					 pricNul=false;
				}else{
					$("#pricechgNum").css("display","none");
					 pricNul=true;
				}	
		});
				
				
				/*判断输入框中的菜品制作时间是否为数字*/
					
			$("#makeTimechg").blur(function(){
		 		var makeTim=$("#makeTimechg").val();
				if(makeTim.length==""){//菜品名称不能为空，如果为空将提示
					$("#TimechgNotnull").css("display","inline");
					Timchg=false;
				}else{
					$("#TimechgNotnull").css("display","none");
					Timchg=true;
				}
			
				var limitim=/^[0-9]*$/;//设置判断的正则表达式
			
				if(limitim.test(makeTim)!=true){//判断是否除数字以外有其他字符
					$("#TimechgNum").css("display","inline");
					TimNul=false;
				}else{
					$("#TimechgNum").css("display","none");
					TimNul=true;
				}	
			
		}); 
		
		
		
			/*判断输入框中的菜品优先级是否为数合法*/
					
			$("#prioritychg").blur(function(){
		 		var prit=$("#prioritychg").val();
				if(prit.length==""){//菜品名称不能为空，如果为空将提示
					$("#piochgNotnull").css("display","inline");
					prtchg=false;
				}else{
					
					$("#piochgNotnull").css("display","none");
					prtchg=true;
				}
			
				var limipr=/^[0-9]*$/;//设置判断的正则表达式
			
				if(limipr.test(prit)!=true){//判断是否除数字以外有其他字符
					$("#priochgNum").css("display","inline");
					 prtNul=false;
				}else{
					$("#priochgNum").css("display","none");
					 prtNul=true;
				}	
			}); 
		
		
		/*判断输入框中的最大并菜数是否为数合法*/
					
			$("#maxCopieschg").blur(function(){
		 		var maCopi=$("#maxCopieschg").val();
				if(maCopi.length==""){//菜品名称不能为空，如果为空将提示
					$("#MaxchgNotnull").css("display","inline");
					maCopichg=false;
					
				}else{
					$("#MaxchgNotnull").css("display","none");
					maCopichg=true;
				}
			
				var limCopi=/^[0-9]*$/;//设置判断的正则表达式
			
				if(limCopi.test(maCopi)!=true){//判断是否除数字以外有其他字符
					$("#MaxchgNum").css("display","inline");
					 maCopiNul=false;
				}else{
					$("#MaxchgNum").css("display","none");
					maCopiNul=true;
				}	

			}); 
		
			
			
			 
		$("#caghave").click(function(){
		  		$("#dishNamechg").trigger("blur");
			  	$("#pricechg").trigger("blur");
			  	$("#makeTimechg").trigger("blur");
			  	$("#prioritychg").trigger("blur");
			  	$("#maxCopieschg").trigger("blur");
			var aa=$("#someone").val();	
			var dsid=$("#a"+p1).html();
			var name=$("#dishNamechg").val();
			var pri=$("#pricechg").val();
			var sech= $("#selchg").val();
			var mati=$("#makeTimechg").val();
			var pror= $("#prioritychg").val();
			var picname=$("#fileload2").html();
			var maco= $("#maxCopieschg").val();
			
			if(sech=="凉菜"){sech=1;}	
			else if(sech=="主食"){sech=2;}
			else if(sech=="拌饭"){sech=3;}
			else if(sech=="小炒"){sech=4;}
			else if(sech=="汤类"){sech=5;}
			if( (namchg&&namNul)&&(prichg&&pricNul)&&(Timchg&&TimNul)&&(prtchg&&prtNul)&&(maCopichg&&maCopiNul) && dsid && sech && picname){
				$.ajax({
					type:"post",
					url:"GJYFC_FCchange.action",
					data:{"fdCry.dishName":name,"fdCry.price":pri,"fdCry.kindId":sech,"fdCry.makeTime":mati,"fdCry.priority":pror,"fdCry.pictureName":picname,"fdCry.maxCopies":maco,"fdCry.dishState":19,"fdCry.dishId":dsid},
					success:function(data){
						ces(aa-1);
					}													
				});
			}else{
				alert("修改失败");
			}
		});	
	});

		/*显示具体数据*/
		function ces(a){
			$.ajax({				
					url:"GJYFC_getpage.action",
					type:"post",
					data:{"countpage":a},
					success:function(data){	
					var json=JSON.parse(data);				
						sekfood(json);							
					}
				});
		}
	function sekfood(json){
		var th="<tr><td>菜品编号</td><td>菜品名称</td><td>菜品价格</td><td>类别</td><td>制作时间</td><td>优先级</td><td>菜品照片</td><td>最大并菜数</td></tr>";
			 $("#tab").html("");
			$("#tab").append(th);
				$.each(json,function(index,value){
					var emtable=
						"<tr>"+
						"<td id=\"amb"+value[0]+"\">"+value[0]+"</td>"+
						"<td id=\"bmb"+value[0]+"\">"+value[1]+"</td>"+
						"<td id=\"cmb"+value[0]+"\">"+value[2]+"</td>"+
						"<td id=\"dmb"+value[0]+"\">"+value[3]+"</td>"+ 
						"<td id=\"emb"+value[0]+"\">"+value[4]+"</td>"+
						"<td id=\"fmb"+value[0]+"\">"+value[5]+"</td>"+
						"<td id=\"gmb"+value[0]+"\"><img  src=\"../image/"+value[6]+
						"\"  class=\"img-circle\" width=\"50\" height=\"50\"></td>"+
						"<td id=\"hmb"+value[0]+"\">"+value[7]+"</td>"+
						"<td><div class=\"button border-red deskbtn\" id=\"num"+value[0]+"\">"+
						"<span class=\"icon-trash-o\"></span>删除 </div>"+
						"<a class=\"button border-main chgb\"data-toggle=\"modal\"data-target=\"#cgModal\" id=\"mb"+value[0]+"\">"+
						"<span class=\con-edit\></span>修改</a></td></tr>";
						$("#tab").append(emtable);
				
					});
	};
	
	
	/*删除选项*/
	$(function(){
		$("#tab").on('click',".deskbtn",function(){
			var onepage=parseInt($("#someone").val());
			var selct=confirm("确定要删除这条数据吗？");
			if(selct==false){return};
			var p1=$(this).attr("id");
			var endStr=parseInt(p1.replace(/[^0-9]/ig,""));
				endStr=parseInt(endStr); 
				$.ajax({
					type:"post",
					url:"GJYFC_FCdelete.action",
					data:{"fdCry.dishId":endStr},
					success:function(data){
						if(data==-1){
							alert("删除失败");
						}else if(data==1){
							//alert("删除成功");
							//location.reload(true); 
							allpage("");
									var inpval=parseInt($("#pagenum").html());
									if(onepage==inpval && pagestate==0){
										$("#someone").val(inpval-1);
										ces(inpval-2);//调用页面加载时自动查询数据库，显示桌台信息
									}else{
										$("#someone").val(inpval);
										ces(inpval-1);
									}	  
						}else{
							alert("没有权限");
						}		
						
				}													
			});
		
		});
	});
	
	
	
	/*获得总页数及判断用户点击选项做出相应*/
	var pagestate=0;
	$(function(){
		allpage("");
		ces(0);	
							
	});
		function allpage(allput){
			$.ajax({
				url:"GJYFC_getcount.action",
				type:"post",
				data:{"search":allput},
				success:function(data){
					var pagesize=parseInt(data/5);				
					if(data%5==0){
						$("#pagenum").html(pagesize);
						pagestate=1;					
					}else if(data%5!=0){
						$("#pagenum").html(parseInt(pagesize)+1);
						if(data%5==1){
							pagestate=0;
						}
					}				
				},
			});	
					
		}
		/*
			分页
		*/
		$(function(){
			$(".minuspage").click(function(){			
				var somename=$(this).attr("name");	 
				var	onepage=parseInt($("#someone").val());
				var allput=$("#sekm").val();	
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
				if(allput==""){
						ces(a);	
				}else{
					fastsearch(a);
				}			
			});			
		});
		
		
		
		/*
			添加上传文件；
		*/
		
		$(function () {
            $("#upload").click(function () {
            	var a=$("#file1").attr("id");
            	var b=$("#fileload").attr("id");
                upload(a,b)
            });
        });
        /*
			修改上传文件；
		*/
       	$(function () {
            $("#upload2").click(function () {
                var a=$("#file2").attr("id");
            	var b=$("#fileload2").attr("id");
                upload(a,b)
            });
        });
        /*
			上传文件；
		*/
        function upload(file,id){
        	var formData = new FormData();
                //formData.append("myfile", $("#file1").files[0]);  
                formData.append("myfile", document.getElementById(file).files[0]);
                $.ajax({
                    url: "GJYFC_uploads.action",
                    type: "POST",
                    data: formData,
                    /**
                    *必须false才会自动加上正确的Content-Type
                    */
                    contentType: false,
                    /**
                    * 必须false才会避开jQuery对 formdata 的默认处理
                    * XMLHttpRequest会对 formdata 进行正确的处理
                    */
                    processData: false,
                    success: function (data) {
                    $("#"+id).html(data);
                    //$("#fileloadchg").html(data);
                        if (data.status == "true") {
                            alert("上传成功！");
                        }
                    },
                    error: function () {
                        alert("上传失败！");
                       
                    }
                });
        }
        
        
     $(function(){
       		var op=1;
       		var oi=1;
  		$.ajax({
         	 url:"GJYFC_getselect.action",
          	type:"POST",
          	data:{},
          	success:function(data){
           	 	var json=JSON.parse(data);
            	$.each(json,function(index,value){
            	op++;
            	oi++;
				var emtable="<option value=\""+value[0]+"\"id=\"op"+op+"\">"+value[1]+"</option>";
				$("#sel").append(emtable);	
				$("#selchg").append(emtable);																							
				
				});
			}
		});		
	});
				

  
   
</script>
</body>
</html>
