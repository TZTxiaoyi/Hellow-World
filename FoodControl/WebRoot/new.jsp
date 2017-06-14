<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css"></link>
  <script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
   <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
   <style type ="text/css">
   		body{
   			margin:0px;
   			padding:0px;
   			position:relative;
   		}
   		#zbtop{
   			border:1px solid red;			
			width:auto;
			height:100px;
			background-image:url(image/zhongguo.png);
   		}
   		#zbleft{
   			border:1px solid yellow;
   		}
   		#zbright{
   			border:1px solid green;
   			position:Absolute;
   			margin-left:190px;
   			margin-top:-350px;
   			
   		}
   		#zbright div{
   			float:left;
   			width:300px;
   			height:300px;
   			margin-top:00px;
   			margin-left:20px;
   			text-align:center;
   		}
   		#zbbutton1{
			border:0px;
			font-size:20px;
			color:green;
			margin-left:30px;
		}
		#z1{
			position:absolute;
			top:-100px;
			height:0px;
			background-color:gray;
			z-index:3;
			filter:alpha(opacity=70);
			opacity:0.8!impotrant;
			display:none;
		}
		#z2{
			position:absolute;
			top:-50px;
			left:100px;
			z-index:100;
			
			display:none;
		}
   </style>
   </head>
  
<body>
  <div class="container-fluid">
	<div class="row">
<!-- 头部 -->
		<div id="zbtop">
			<button type="button" class="btn btn-default"id="zbbutton1"><h1 class="glyphicon glyphicon-home"></h1></button><!-- 主页 -->
			<button type="button" class="btn btn-default" id="zbbutton1"><h1 class="glyphicon glyphicon-map-marker"><input type ="text" size="10px"/></h1></button><!-- 模糊查询菜名 -->
			<button type="button" class="btn btn-default"id="zbbutton1"><h1 class="glyphicon glyphicon-bell">呼叫员工</h1></button><!-- 呼叫员工按钮 -->
		</div>
<!-- 左侧 -->		
		<div class=" col-md-2" id="zbleft">
			<div id="navbarExample" class="navbar navbar-static">
		        <div class="navbar-inner">
		            <div class="container" style="width: auto;">                
		                <ul class="nav">
		                    <li class="active"><a href="#php">
		                     <button type="button" class="btn btn-primary btn-lg" >凉菜</button>
		
		                    </a></li>
		                    <li class="active"><a href="#js">
		                     <button type="button" class="btn btn-primary btn-lg" >主食</button>
		                    
		                    </a></li>
		                    <li class="active"><a href="#mysql">
		                     <button type="button" class="btn btn-primary btn-lg" >热菜</button>
		                    
		                    </a></li>
		                    <li class="active"><a href="#pgsql">
		                     <button type="button" class="btn btn-primary btn-lg" >小吃</button>
		                    
		                    </a></li>
		                    <li class=""><a href="#mgdb">
		                     <button type="button" class="btn btn-primary btn-lg" >特色</button>
		                    
		                    </a></li>
		                    
		                </ul>
		            </div>
		        </div>
		    </div>
			</div>
		</div>
<!-- 右侧 -->
		<div class=" col-md-10" id="zbright">
			
		<div>
			<div><img  onclick = "show()" src="image/2.png" alt="..." class="img-circle" width="200" height="200"><br>
				<span id="cm">红烧狮子头：</span><span id="UPrice">20</span><br>
	        	<input type=button value="-1" id="remove" onclick="remove()">
	  			<input type=text value="0" id="number" size="3">
	  			<input type=button value="+1" id="add" onclick="add()">
	        	<button id="addcc">添加</button>
			</div>
			<div id ="z1"></div>
			<div id="z2"><input type="button" value="×" onclick="close1()"/>
				<div><img src = "image/1.png" width="400" height ="400"></div>
				<span>菜名打飞机洒垃圾分类法就是犯贱</span>
		</div>
			</div>
			<div><img src="image/2.png" alt="..." class="img-circle" width="200" height="200"><br>
				<span id="cm">红烧李金梁：</span><span id="UPrice">20</span><br>
        		<input type=button value="-1" id="remove" onclick="remove()">
  				<input type=text value="0" id="number" size="3">
  				<input type=button value="+1" id="add" onclick="add()">
        		<button id="addcc">添加</button>
			</div>
			<div><img src="image/2.png" alt="..." class="img-circle" width="200" height="200"></div>
			<div><img src="image/2.png" alt="..." class="img-circle" width="200" height="200"></div>
			<div><img src="image/2.png" alt="..." class="img-circle" width="200" height="200"></div>
			<div><img src="image/2.png" alt="..." class="img-circle" width="200" height="200"></div>
			<div><img src="image/2.png" alt="..." class="img-circle" width="200" height="200"></div>
			
		</div>
<!-- 底部 -->		
		<div id="zbbottom">
   
			<nav class="navbar-button navbar-fixed-bottom">
						<button type="button" class="btn btn-lg btn-info col-md-offset-10" data-toggle="modal" data-target="#myMenu">我点的菜 价格：<span id="Total">0</span></button>
					</nav>
				
				<div class="modal fade" id="myMenu"> <!-- modal把div的内容识别为模态框 fade模态框切换时内容淡入淡-->
					<div class="modal-dialog">
						<div class="modal-content"><!-- 模态框居中显示-->
							<div class="modal-header"> <!-- 模态框标题-->
								<button type="button" class="close"			data-dismiss=modal>×
								</button>
								<h4 class="modal-title" id="MyMenuLabel">		我点的菜
								</h4>
							</div>
							<div class="modal-body" id="modall-add"> <!-- 模态框显示的主要内容-->
								
								
							</div>
							
							<div class="modal-footer"> <!-- 模态框下的关闭和保存按钮--> 
								<button type="button" class="btn btn-default" data-dismiss="modal">
									关闭
								</button>
								<button type="button" class="btn btn-danger">
									立刻下单
								</button>
							</div>
						</div>
					</div>
				</div>
	  		</div>
		</div><!-- 底部div -->
		
	</div>
  </div> 
  
  
  
	  <script>
			function add() {
	            var obj = document.getElementById("number");
	 
	            obj.value = parseInt(obj.value) + 1;
	        }
	 
	        function remove() {
	            var obj = document.getElementById("number");
	 
	            if(obj.value == 0) {
	                return;
	            }
	 
	            obj.value = parseInt(obj.value) - 1;
	        }
		</script>
		<script>
			$(function(){
				$("#addcc").click(function(){
				
					var price=$("#UPrice").html()*$("#number").val();//价格*数量获得总价
					var total=parseInt($("#Total").html())+price;//先转为int类型再做加法运算
					
					$("#Total").html(total);//把当前菜的总价格加上当前订单的金额
					$("#modall-add").html("<div>"+"菜名："+$("#cm").html()+"单价："+$("#UPrice").html()+"数量："+$("#number").val()+"</div>");
				});
			});
		</script> 
		<script type="text/javascript" language="javascript">
			var z1=document.getElementById("z1");
			var z2=document.getElementById("z2");
			function show(){
				z1.style.width=document.body.offsetWidth+"px";
				z1.style.height=document.body.offsetHeight+"px";
				z1.style.display="block";
				z2.style.display="block";
			}
			function close1(){
				z1.style.display="none";
				z2.style.display="none";
			}
  		</script>
</body>
</html>
