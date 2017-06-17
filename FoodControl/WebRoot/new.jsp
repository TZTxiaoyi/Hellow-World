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
<!-- 右侧打开网页自动添加菜单 -->
		<div class=" col-md-10" id="zbright">
			
			
			
		</div>
<!-- 底部 -->		
		<div id="zbbottom">
   
			<nav class="navbar-button navbar-fixed-bottom">
				<button type="button" id="LookOrder" class="btn btn-lg btn-info col-md-offset-10" data-toggle="modal" data-target="#myMenu">我点的菜 价格：<span id="Total">0</span></button>
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
							<div class="modal-body" id="modall-add" > <!-- 模态框显示的主要内容-->
								<table class="modall-table table table-striped" id="modall-table">
									
								</table>
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
		

  
  
 
		<script>
			//页面加载自动添加4个菜品（测试）
				$(function(){
				for(var i=1;i<5;i++){
					var show="<div><div><img  onclick = \"show()\" src=\"image/2.png\" alt=\"...\" class=\"img-circle\" width=\"200\" height=\"200\"><br/><span class=\"food-name-add"+i+"\">红烧狮子头"+i+"</span><span class=\"UPrice-add"+i+"\">20</span><br><input type=button value=\"-1\" class=\"remove\" id=\"add"+i+"\"><input type=text value=\"0\" id=\"number-add"+i+"\" size=\"3\" readonly><input type=button value=\"+1\" class=\"add\" id=\"add"+i+"\"></div></div>";
					$("#zbright").append(show);
				}
				
				});
				//更新菜单和总价
				function upfood(btnid,foodname,uprice,number,price){	
					$.ajax({
						type:"post",
						url:"addfood_addFood.action",
						data:{"addfood.foodname":foodname,"addfood.uprice":uprice,"addfood.number":number,"addfood.price":price},
						success:function(data){
							var json=JSON.parse(data);
							$("#Total").html(json);	
						}
					});
				};
				//减少点菜的数量更新总价
				$("#zbright").on('click',".remove",function(){
					var btnid=$(this).attr("id");//当前点击的按钮的id
					var foodname=$(".food-name-"+btnid).html();//当前添加的菜名
					var uprice=parseInt($(".UPrice-"+btnid).html());//单价
					//var number=parseInt($("#number-"+btnid).val());//数量
					var number=parseInt($("#number-"+btnid).val())-1;
					if(number<0){
						number=0;
					}
					var price=uprice*number;//价格*数量获得总价	
					$("#number-"+btnid).val(number);
						upfood(btnid,foodname,uprice,number,price);
				});
				//增加点菜的数量更新总价
				$("#zbright").on('click',".add",function(){
					var btnid=$(this).attr("id");//当前点击的按钮的id
					var foodname=$(".food-name-"+btnid).html();//当前添加的菜名
					var uprice=parseInt($(".UPrice-"+btnid).html());//单价
					var number=parseInt($("#number-"+btnid).val())+1;
					var price=uprice*number;//价格*数量获得总价	
					$("#number-"+btnid).val(number);
						upfood(btnid,foodname,uprice,number,price);
				});
				$("#modall-table").on('click',"#del",function(){
					alert("确认删除？");
				});
				//查看已点的菜单
				$("#LookOrder").click(function(){				
					$.ajax({
						type:"post",
						url:"addfood_lookFood.action",
						data:{"df":"df"},
						success:function(data){
							var json=JSON.parse(data);
							$("#modall-table").html("<tr><td>菜名</td><td>单价</td><td>数量</td><td>总价</td><td></td></tr>");
							$.each(json,function(index,value){
								var dd="<tr>"+"<td>"+value.foodname+"</td>"+"<td>"+value.uprice+"</td>"+"<td>"+value.number+"</td>"+"<td>"+value.price+"</td>"+"<td><button class=\"btn btn-danger\" id=\"del\">删除</button></td>"+"</tr>";
								$("#modall-table").append(dd);
							});	
						}
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
