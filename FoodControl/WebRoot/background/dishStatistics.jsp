<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<!-- 
		后台订单详情页面
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

	<script type="text/javascript">
			/*
				总页数
			*/
			function stamp(json){
								
						var th="<tr><td>订单号</td><td>订单状态</td><td>订单价格</td><td>点菜数量</td><td>支付方式</td><td>订单时间</td><td>桌台名称</td><td>操作</td></tr>";
					 	$("#tableid").html("");	
					 	$("#tableid").append(th);				 
						$.each(json,function(index,value){
						var oldTime = (new Date(value[5])).getTime()/1000;
						//time=value[5].getfullyear+"-"+value[5].getfullmonth+"-"+value[5].getfullday
							var timett=format(value[5].time);
							var emtable=
								"<tr><td id=\"anum"+value[0]+"\">"+value[0]+
								"</td><td id=\"bnum"+value[0]+"\">"+value[1]+"</td><td id=\"cnum"+value[0]+"\">"+value[2]+"</td><td id=\"dnum"+value[0]+"\">"+value[3]+"</td><td id=\"enum"+value[0]+"\">"+value[4]+
								"</td><td id=\"fnum"+value[0]+"\">"+timett+"</td><td id=\"gnum"+value[0]+"\">"+value[6]+"</td>"+
								"<td id=\"fnum"+value[0]+"\">"+
								"<a class=\"button border-main alterbtn\" id=\"num"+value[0]+"\" aria-labelledby=\"myModalLabel\"  data-target=\"#myModal\" data-toggle=\"modal\">"+
								"<span class=\"icon-edit\"></span> 订单详情</a></td></tr>";
							$("#tableid").append(emtable);																												
						});
								
			}
		$(function(){
			
				$.ajax({
					url:"order_pageTotal.action",
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
		//时间戳转时间
		function add0(m){return m<10?'0'+m:m }
		function format(shijianchuo){
		//shijianchuo是整数，否则要parseInt转换
			var time = new Date(shijianchuo);
			var y = time.getFullYear();
			var m = time.getMonth()+1;
			var d = time.getDate();
			var h = time.getHours();
			var mm = time.getMinutes();
			var s = time.getSeconds();
			return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
		} 
		function liyang(a){
		//alert(a);
			$.ajax({				
					url:"order_getpage.action",
					type:"post",
					data:{"countpage":a},
					success:function(data){					
					var json=JSON.parse(data);
					stamp(json);					
					}
				});
		}
		/*
		* 将每个订单传给action
		*/
		$(function(){
			$("#tableid").on('click',".alterbtn",function(){
				var alterbtn = $(this).attr("id");
				//alert("sss:"+alterbtn);
				var namehtml =$("#a"+alterbtn).html();	
				//alert(namehtml);			
				$.ajax({
					url:"order_orderdish.action",
					type:"post",
					data:{"countpage":namehtml}
				});							
			});
		});
		$(function(){
			$("#searchorder").click(function(){
				var readyvalue=$("#readytime").val();
				var lastvalue=$("#lasttime").val();
				//alert(readyvalue);
				$.ajax({
					url:"order_selorder.action",
					type:"post",
					data:{"begintime":readyvalue,"endtime":lastvalue},
					success:function(data){
						var json=JSON.parse(data);
						stamp(json);
					}
				});
			});
		});
		</script>

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
			<strong><span class="icon-pencil-square-o"></span> 订单信息</strong>
		</div>
		<div>


				<div class="panel admin-panel">
					<div class="padding border-bottom">
						<ul>
							<li>
					  			<input type="text" placeholder="xxxx年xx月xx日" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" id="readytime"/>
					  		</li>
					  		<li>
					  			<input type="text" placeholder="xxxx年xx月xx日" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" id="lasttime"/>
					          <a type="button" href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" id="searchorder"> 搜索</a>
					  		</li>
					  		
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
							<input type="text" id="someone" value="1" size ="2">
							<input type="button" value="跳转" id="commitone">
					</div>			
				</div>
		

		</div>
		<!-- 
			查询订单模态框
 		-->
		<div class="media media-y margin-big-bottom"></div>
		<div class="modal fade" id="myModaltable" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss=modal></button>
						<div class="text-center margin-big padding-big-top">
							<h1>订单详细信息</h1>
						</div>
						 <div id="modalform">

					    	<table id="mdalform_tab">
					    		
					    	</table>

					    	<div>
								<button type="submit" class="btn btn-warning btn-group-lg confirm-btn" data-dismiss="modal" >确认添加</button>	
							</div>
					 </div>
					</div>
				</div>
			</div>
		</div>
		<!-- 
			订单详情模态框
		 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close"></button>
						<div class="text-center margin-big padding-big-top">
							<h1>订单详细信息</h1>
						</div>
						<div id="modalform">

					    	
					 </div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning btn-default modal-alterbtn" data-dismiss="modal" >确定更改</button>

					</div>
				</div>
			</div>
		</div>


	</div>
</body>
</html>
