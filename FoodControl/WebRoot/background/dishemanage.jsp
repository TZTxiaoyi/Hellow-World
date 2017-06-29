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

	#modb li{list-style-type:none;display:block;
	}
	#sel{width:135px;}
	
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
	          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
	          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
	          <a type="button" class="button border-yellow" href="" data-target="#myModal" data-toggle="modal"><span class="icon-plus-square-o"></span> 添加菜品</a>
         		<!-- 
         			添加员工模态框
         		 -->
         
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"></span></button>
									<h4 class="modal-title" id="myModalLabel">添加菜品</h4>
								</div>
								<!-- 
									添加员工的输入框 ----form表单
								 -->
								<div class="modal-body1">
									<ul id="modb">
										<li>菜品名称&nbsp&nbsp&nbsp&nbsp&nbsp:<input id="dishName"/></li><br/><!--1-->
										<li>菜品价格&nbsp&nbsp&nbsp&nbsp&nbsp:<input id="price"/></li><br/><!--2-->
										<li>									
	    									<div>菜品类别&nbsp&nbsp&nbsp&nbsp&nbsp:
	      										<select id="sel">
	        										<option>凉拌</option>
	        										<option>主食</option>
	        										<option>拌饭</option>
	       		 									<option>小炒</option>
	        										<option>汤类</option>
	     										 </select>
	   										</div>														
										</li><br/><!--3-->
										<li>菜品时间&nbsp&nbsp&nbsp&nbsp&nbsp:<input id="makeTime"/></li><br/><!--4-->
										<li>菜品优先级:<input id="priority"/></li><br/><!--5-->
										<li><input type="file" id="file1" /><br />
        											<input type="button" class="upload" value="上传" />
        											<span id="fileload"></span></li><br/><!--6-->
										
										<li>最大并菜份数:<input id="maxCopies"/></li><br/><!--7-->
										<li>菜品状态&nbsp&nbsp&nbsp&nbsp&nbsp:<input id="dishState"/></li><br/>
									</ul> 	
								</div>
								<div class="modal-footer">
									<!-- 
										关闭模态框按钮
									 -->
								
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									<!-- 
										保存模态框按钮   --- 可以此按钮跳转到一个servlet执行SQL语句，插入数据到数据库
									 -->
									<button type="button" class="btn btn-primary"id="togo">Save changes</button>
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
				<input type="text" id="someone" value="1">
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
			<div class="modal-body">
				<ul id="modb">
					<li>菜品名称&nbsp&nbsp&nbsp&nbsp&nbsp:<input id="dishNamechg"/></li><br/><!--1-->
					<li>菜品价格&nbsp&nbsp&nbsp&nbsp&nbsp:<input id="pricechg"/></li><br/><!--2-->
					<li>									
	    				<div>菜品类别&nbsp&nbsp&nbsp&nbsp&nbsp:
	      					<select id="selchg">
	        					<option>凉拌</option>
	        					<option>主食</option> 
	        					<option>拌饭</option>
	       		 				<option>小炒</option>
	        					<option>汤类</option>
	     					 </select>
	   					</div>														
					</li><br/><!--3-->
					<li>菜品时间&nbsp&nbsp&nbsp&nbsp&nbsp:<input id="makeTimechg"/></li><br/><!--4-->
					<li>菜品优先级:<input id="prioritychg"/></li><br/><!--5-->
					<li>选择文件:<input type="file" id="file2" />
        				<input type="button" class="upload" value="上传" />
        				<span id="fileload"></span>
					</li><br/><!--6-->
					<li>最大并菜份数:<input id="maxCopieschg"/></li><br/><!--7-->
					<li>菜品状态&nbsp&nbsp&nbsp&nbsp&nbsp:<input id="dishStatechg"/></li><br/>
				</ul> 	
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary"id="caghave">
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
    
    		/*
				菜品搜索
			*/
			
			$("#sekbt").click(function(){
				var allput=$("#sekm").val();
				$.ajax({
					url:"GJYFC_seekfood.action",
					type:"post",
					data:{"search":allput},
					success:function(data){
						var json = JSON.parse(data);
						sekfood(json);
				}
			});
		});
			
    
    /*添加菜品选项*/
	$(function(){
		$("#togo").click(function(){
			var dishName=$("#dishName").val();
			var price=$("#price").val();
			var kindId=$("#sel").val();
			var makeTime=$("#makeTime").val();
			var priority=$("#priority").val();
			var uppicture=$("#fileload").html();

			var maxCopies=$("#maxCopies").val();
			var dishState=$("#dishState").val();
			
			if(kindId=="凉拌"){kindId=1;}
			else if(kindId=="主食"){kindId=2;}
			else if(kindId=="拌饭"){kindId=3;}
			else if(kindId=="小炒"){kindId=4;}
			else if(kindId=="汤类"){kindId=5;}
			
			if(dishName && price && kindId && makeTime && priority && uppicture && maxCopies ){
				$.ajax({
					type:"post",
					url:"GJYFC_insertFood.action",
					data:{"fdCry.dishName":dishName,"fdCry.price":price,"fdCry.kindId":kindId,"fdCry.makeTime":makeTime,"fdCry.priority":priority,"fdCry.pictureName":uppicture,"fdCry.maxCopies":maxCopies,"fdCry.dishState":dishState},
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
			 $("#makeTimechg").val($("#e"+p1).html());			/*获得数据库中的值放入input中*/
		 	 $("#prioritychg").val($("#f"+p1).html());
		 	// $("#pictureNamechg").val($("#g"+p1).html());
		 	$("#fileload").html($("#g"+p1).html());
			 $("#maxCopieschg").val($("#h"+p1).html());
		 	 $("#dishStatechg").val($("#i"+p1).html());
		 
		
		$("#caghave").click(function(){
		 	var dsid=$("#a"+p1).html();
			var name=$("#dishNamechg").val();
			var pri= $("#pricechg").val();
			var sech= $("#selchg").val();
			var mati=$("#makeTimechg").val();
			var pror= $("#prioritychg").val();
			var pict= $("#fileload").html();
			var maco= $("#maxCopieschg").val();
			var stat= $("#dishStatechg").val();
			
			if(sech=="凉拌"){sech=1;}	
			else if(sech=="主食"){sech=2;}
			else if(sech=="拌饭"){sech=3;}
			else if(sech=="小炒"){sech=4;}
			else if(sech=="汤类"){sech=5;}
			
			if(dsid && name && pri && sech && mati && pror && pict && maco && stat){
				$.ajax({
					type:"post",
					url:"GJYFC_FCchange.action",
					data:{"fdCry.dishName":name,"fdCry.price":pri,"fdCry.kindId":sech,"fdCry.makeTime":mati,"fdCry.priority":pror,"fdCry.pictureName":pict,"fdCry.maxCopies":maco,"fdCry.dishState":stat,"fdCry.dishId":dsid},
					success:function(data){
						if(data==-1){
							alert("修改失败");
						}else if(data==1){
							alert("修改成功");
							location.reload(true);   
						}else{
							alert("没有权限");
						}		
						
					}													
				});
			}else{
				alert("修改失败");
			}
		
		});
	
		
	});
		
	/*
			上传文件；
		*/
	$(function () {
            $(".upload").click(function () {
            alert(2);
                var formData = new FormData();
                //formData.append("myfile", $("#file1").files[0]);  
                formData.append("myfile", document.getElementById("file1").files[0]);
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
                    alert(data);
                    $("#fileload").html(data);
                        if (data.status == "true") {
                            alert("上传成功！");
                        }
                    },
                    error: function () {
                        alert("上传失败！");
                       
                    }
                });
            });
        });
	
		
	
	
	

	function sekfood(json){
		var th="<tr><td></td><td>菜品编号</td><td>菜品名称</td><td>菜品价格</td><td>类别</td><td>制作时间</td><td>优先级</td><td>菜品照片</td><td>最大并菜数</td><td>菜品状态</td></tr>";
			 $("#tab").html("");
			$("#tab").append(th);
				$.each(json,function(index,value){
					var emtable=
						"<tr><td><input type=\checkbox\name=\id[]\value=\1\/></td>"+
						"<td id=\"amb"+value[0]+"\">"+value[0]+"</td>"+
						"<td id=\"bmb"+value[0]+"\">"+value[1]+"</td>"+
						"<td id=\"cmb"+value[0]+"\">"+value[2]+"</td>"+
						"<td id=\"dmb"+value[0]+"\">"+value[3]+"</td>"+ 
						"<td id=\"emb"+value[0]+"\">"+value[4]+"</td>"+
						"<td id=\"fmb"+value[0]+"\">"+value[5]+"</td>"+
						"<td id=\"gmb"+value[0]+"\"><img  src=\"image/"+value[6]+
						"\"  class=\"img-circle\" width=\"50\" height=\"50\"></td>"+
						"<td id=\"hmb"+value[0]+"\">"+value[7]+"</td>"+
						"<td id=\"imb"+value[0]+"\">"+value[8]+"</td>"+
						"<td><div class=\"button border-red deskbtn\" id=\"num"+value[0]+"\">"+
						"<span class=\"icon-trash-o\"></span>删除 </div>"+
						"<a type=\"button\" class=\"button border-main chgb\"data-toggle=\"modal\"data-target=\"#cgModal\" id=\"mb"+value[0]+"\">"+
						"<span class=\con-edit\></span>修改</a></td></tr>";
						$("#tab").append(emtable);
				
					});
	};
	
	
	/*删除选项*/
	$(function(){
		$("#tab").on('click',".deskbtn",function(){
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
							alert("删除成功");
							location.reload(true);  	  
						}else{
							alert("没有权限");
						}		
						
				}													
			});
		
		});
	});
	
	
	
	
	
	/*获得总页数及判断用户点击选项做出相应*/
	
	$(function(){
			
			$.ajax({
				url:"GJYFC_getcount.action",
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
			ces(0);								
		});
		$(function(){
			$(".minuspage").click(function(){			
				var somename=$(this).attr("name");	 
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
				ces(a);				
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
					var th="<tr><td></td><td>菜品编号</td><td>菜品名称</td><td>菜品价格</td><td>类别</td><td>制作时间</td><td>优先级</td><td>菜品照片</td><td>最大并菜数</td><td>菜品状态</td></tr>";
			 		$("#tab").html("");
					$("#tab").append(th);
				$.each(json,function(index,value){
					var emtable=
						"<tr><td><input type=\checkbox\name=\id[]\value=\1\/></td>"+
						"<td id=\"amb"+value[0]+"\">"+value[0]+"</td>"+
						"<td id=\"bmb"+value[0]+"\">"+value[1]+"</td>"+
						"<td id=\"cmb"+value[0]+"\">"+value[2]+"</td>"+
						"<td id=\"dmb"+value[0]+"\">"+value[3]+"</td>"+ 
						"<td id=\"emb"+value[0]+"\">"+value[4]+"</td>"+
						"<td id=\"fmb"+value[0]+"\">"+value[5]+"</td>"+
						"<td id=\"gmb"+value[0]+"\"><img  src=\"image/"+value[6]+
						"\"  class=\"img-circle\" width=\"50\" height=\"50\"></td>"+
						"<td id=\"hmb"+value[0]+"\">"+value[7]+"</td>"+
						"<td id=\"imb"+value[0]+"\">"+value[8]+"</td>"+
						"<td><div class=\"button border-red deskbtn\" id=\"num"+value[0]+"\">"+
						"<span class=\"icon-trash-o\"></span>删除 </div>"+
						"<a type=\"button\" class=\"button border-main chgb\"data-toggle=\"modal\"data-target=\"#cgModal\" id=\"mb"+value[0]+"\">"+
						"<span class=\con-edit\></span>修改</a></td></tr>";
						//$("#trtab").before(emtable);
						$("#tab").append(emtable);																							
						});
													
					}
				});
		}
	
</script>
</body>
</html>
