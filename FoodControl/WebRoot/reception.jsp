<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css"></link>
  <script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  
  <style type="text/css">
  	body{
			margin:0px;
			padding:0px;
			position: relative;
		}
		#zbtou{
			border:1px solid red;
			
			width:auto;
			height:100px;
			background-image:url(image/zhongguo.png);
			
		}
		
		
		#zbnum{
			
			border:1px solid yellow;	
		}
		#zbnum button{
			width:150px;
			margin-top:30px;
			
		}
		#zbcon{
			border:1px solid green;
			position:absolute;
			left:225px;
			float:left;
			
			}
		
		
<!--菜谱图片 -->
		#zbim div{
			border:1px solid red;
			position:Absolute;
			
			float:left;
			

		}
		div p{
			text-align:center;
			
			float:left;
		}
		#zbbutton1{
			border:0px;
			font-size:20px;
			color:green;
			margin-left:30px;
		}
		


 
  </style>
</head>
  
  <body  >
<div class="container-fluid">
<div class="row">
   <div id="zbtou">
		<button type="button" class="btn btn-default"id="zbbutton1"><h1 class="glyphicon glyphicon-home"></h1></button>
		<button type="button" class="btn btn-default" id="zbbutton1"><h1 class="glyphicon glyphicon-map-marker"><input type ="text" size="10px"/></h1></button>
		<button type="button" class="btn btn-default"id="zbbutton1"><h1 class="glyphicon glyphicon-bell">呼叫员工</h1></button>
		
		
   </div>
   
   <div class=" col-md-2" id="zbnum">
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
   
	<div class=" col-md-10" id="zbcon">
		<div id="zbzb" data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example">
        <h4 id="php">凉菜</h4>
        <p>
        <div ><img src="image/1.png" alt="..." class="img-circle" width="200" height="200">
        	<span id="cm">红烧狮子头：</span><span id="UPrice">20</span>
        	<input type=button value="-1" id="remove" onclick="remove()">
  			<input type=text value="0" id="number" size="3">
  			<input type=button value="+1" id="add" onclick="add()">
        	<button id="addcc">添加</button>
        </div>
        	
        </p>
        <h4 id="js">主食</h4>
        <p>
         <div><img src="image/2.png" alt="..." class="img-circle" width="200" height="200">
        </p>
        <h4 id="mysql">面食</h4>
        <p>
         <div><img src="image/3.png" alt="..." class="img-circle" width="200" height="200">
        </p>
        <h4 id="pgsql">小吃</h4>
        <p>
        <div><img src="image/4.png" alt="..." class="img-circle" width="200" height="200">
        </p>
        <h4 id="mgdb">特色</h4>
        
    	</div>
    	<hr>
	    <script src="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>
	    <script src="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/js/bootstrap-dropdown.js"></script>
	    <script src="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/js/bootstrap-scrollspy.js"></script>
		
	</div>
   </div>
   <div id="zbdi">
   
		<nav class="navbar-button navbar-fixed-bottom">
					<button type="button" class="btn btn-lg btn-info col-md-offset-10" data-toggle="modal" data-target="#myMenu">我点的菜 价格：<span id="Total">0</span></button>
				</nav>
			
			<div class="modal fade" id="myMenu"> <!-- modal把div的内容识别为模态框 fade模态框切换时内容淡入淡-->
				<div class="modal-dialog">
					<div class="modal-content"><!-- 模态框居中显示-->
						<div class="modal-header"> <!-- 模态框标题-->
							<button type="button" class="close"			data-dismiss=modal>×
							</button>
							<h4 class="modal-title" id="MyMenuLabel">	我点的菜
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
	</div>
</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	
	
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
  </body>
  
  
</html>
