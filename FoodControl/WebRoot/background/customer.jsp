<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'customer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css"></link>
	<script type="text/javascript" src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <div class="panel admin-panel">
	  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 顾客信息</strong></div>
	 <div>
		 
		  <div class="panel admin-panel">	    
		    <div class="padding border-bottom">
		      <ul class="search">
		        <li>
		          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
		          <!-- <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button> -->
		          
		      
		        
		        <!-- 
		        	搜索员工信息框
		         -->
		        <li>
		        
		        	<input id="condition"type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
	          		<a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" id="searchinfo"> 搜索</a></li>
		        </li>
		      </ul>
		    </div>
		    <!-- 
		    	查询出来的员工信息生成的table
		     -->
		    <table class="table table-hover text-center" id="tableid">
		    
		    </table>
		   
			<div class="zbpagelist">
					<a  class="zbpage" name="zbfirst" href="#">首页</a>
					<a  class="zbpage" name="zbminus" href="#">上一页</a> 
					<a  class="zbpage" name="zbadd" href="#">下一页</a>
					<a  class="zbpage" name="zblast" href="#">尾页</a>
					共<span id="zbpagenum"></span>页
					<input type="text" id="zbsome" value="1" size ="5">
					<input type="button" value="跳转" class ="zbpage" name ="zbcommit" id="zbcommit">
			</div>					   
		  </div>
		
	</div>
	
	
	
	
	<!-- +++++++++++++++++++++++++++6.24顾客++++++++++++++++++++++++++++++++++ -->
	<script type ="text/javascript">
		$(function(){
			/* $.ajax({
				url:"home_client.action",
				data:{},
				type:"post",
				success:function(data){
					alert("guke");
					var json = JSON.parse(data);
					var th = "<tr><td></td><td>姓名</td><td>性别</td><td>电话</td><td>地址</td><td>帐号</td></tr>";
					
					$("#tableid").append(th);
					$.each(json,function(index, value) {
						var dd = "<tr><td><input type=\"checkbox\" name=\"id[]\" value=\"1\" /></td><td class=\"deskalter"+
						value[0]+"\" id=\"desknumId"+value[0]+"\">"+ value[0]+ "</td><td id=\"namealter"+value[0]+"\">"+ 
						value[1]+ "</td><td id=\"personalter"+value[0]+"\">"+ value[2]+ "</td><td>"+ value[3]+
						"</td><td id=\"statealter"+value[0]+"\">"+ value[4]+ "</td>";
						$("#tableid").append(dd);
					});
					
				},
			}); */
		});
		function refresh(json) {
				var th = "<tr><td></td><td>Id</td><td>姓名</td><td>性别</td><td>电话</td><td>地址</td><td>年龄</td></tr>";
					$("#tableid").html("");
					$("#tableid").append(th);
					$.each(json,function(index, value) {
						var dd = "<tr><td><input type=\"checkbox\" name=\"id[]\" value=\"1\" /></td><td class=\"Id"+
						value[0]+"\" id=\"Name"+value[0]+"\">"+ value[0]+ "</td><td id=\"sex"+value[0]+"\">"+ 
						value[1]+ "</td><td id=\"plone"+value[0]+"\">"+ value[2]+ "</td><td>"+ value[3]+
						"</td><td id=\"adress"+value[0]+"\">"+ value[4]+ "</td>"+
						"<td id=\"age"+value[0]+"\">"+ value[5]+ "</td>";
						$("#tableid").append(dd);
					});
		
		}
	//----------------------------全选按钮----------------------------
		$("#checkall").click(function() {
				$("input[name='id[]']").each(function() {
					if (this.checked) {
						this.checked = false;
					} else {
						this.checked = true;
					}
				});
			});
		
	//===========================快速查询=========================
		$("#searchinfo").click(function(){
			var allput = $(".input").val();
			alert(allput);
			$.ajax({
				url : "../home_zbquinfo.action",
				data : {"ser":allput},
				type : "post",
				success : function(data){
					var json = JSON.parse(data);
						refresh(json);
				}
			});
		});
	//------------------------------分页 （总页数）-----------------------------------------
		$(function(){
			$.ajax({
				url : "home_zbtotalpage.action",
				data: {},
				type: "post",
				success : function(data){
					var zbtotal = parseInt(data/3);
					if(data%3 == 0){
						$("#zbpagenum").html(zbtotal);
					}
					if(data%3 != 0){
						$("#zbpagenum").html(parseInt(zbtotal)+1);
					}
				},
			});
		});
	//++++++++++++++++++++++++分页++++++++++++++++++++++++++++++
		$(function(){
			$(".zbpage").click(function(){
				var name = $(this).attr("name");
				var zbsome1 = parseInt($("#zbsome").val());
				if(name == "zbfirst"){
					zbsome1 = 1;
				}
				if(name == "zbminus"){
					zbsome1 = zbsome1 - 1;
					if(zbsome1 <= 1){
						zbsome1 = 1;
					}
				}
				if(name=="zbadd"){
						zbsome1=zbsome1+1;
						if(zbsome1>=$("#zbpagenum").html()){
							zbsome1=$("#zbpagenum").html()
							
						}
				}
				
				if(name=="zblast"){
					zbsome1=$("#zbpagenum").html();
				}
					$("#zbsome").val(zbsome1);
					var curr=zbsome1-1;
					
					zbtabonload(curr);
			});
		});
		$(function() {
				var currpage=0;
				zbtabonload(currpage);
			});
		function zbtabonload(curr){
			$.ajax({
				url : "home_zbtabpage.action",
				data : {"currpage":curr},
				type : "post",
				success : function flash(data){
					var json = JSON.parse(data);
					refresh(json);
				},
			});
		}
		
		
	</script>
  </body>
</html>
