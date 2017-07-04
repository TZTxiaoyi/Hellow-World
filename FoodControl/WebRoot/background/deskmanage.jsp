<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<!-- 
		后台桌位详情页面
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
		.fuze select{
			width: 250px;
			height: 40px;
		}
		#appenum,#appename{
			color:red;
		}
	</style>
</head>

<body>
	
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 桌台信息</strong>
		</div>
		<div>
			<form method="post" action="">
				<div class="panel admin-panel">
					<div class="padding border-bottom">
						<ul class="search">
							<li>
								<a class="button border-yellow" href="fresh_deskmanage.action">查看所有</a>
								<a class="button border-yellow " href="" data-toggle="modal"
								data-target="#myModaltable" id="alterbtn"><span class="icon-plus-square-o"></span>
									添加桌台</a>
							</li>
							<li><input type="text" placeholder="请输入搜索关键字"
								name="keywords" class="input"style="width:250px; line-height:17px;display:inline-block" /> <a
								href="javascript:void(0)" class="button border-main icon-search fastsearch"
								onclick="changesearch()">搜索</a>
							</li>
							</li>
						</ul>

					</div>
					<table class="table table-hover text-center"  id="tab">
						
						
					</table>
					<div class="pagelist">
						<a name="first" class="page" href="#">首页</a><a name="minus" class="page" href="#">上一页</a><a name="add" class="page" href="#">下一页</a><a name="last" class="page" href="#">尾页</a><input type="text" id="pageinp" value="1" size="5"/>
						<a class="page" type="button">跳转</a>共<span id="spanpage"></span>页
					</div>
				</div>
			</form>
		</div>
		<!-- 
			添加桌台模态框
 		-->
		<div class="media media-y margin-big-bottom"></div>
		<div class="modal fade" id="myModaltable" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss=modal></button>
						<div class="text-center margin-big padding-big-top">
							<h2>桌位详细信息</h2>
						</div>
						 <div id="modalform">
					    	<div>
					    		<span>桌位人数 </span><input type="text" name="st.personNum" class="personNum" id="personNum"/>
					    		<br/><span id="appenum"></span>
					    	</div>
					    	<div>
					    		<span>桌位名字 </span><input type="text" name="st.deskName" class="tableName"id="tablen"/>
					    		<br/><span id="appename"></span>
					    	</div>
					    	<div class="fuze">
					    		<span>&nbsp;负&nbsp;责&nbsp;人&nbsp;</span><select id="addtab">
					    			
					    		</select>
					    	</div>
					    	<div class="modal-footer">
								<button type="submit" class="btn btn-primary btn-group-lg confirm-btn" data-dismiss="modal" >确认添加</button>	
							</div>
							
					 </div>
					</div>
				</div>
			</div>
		</div>
		<!-- 
			修改按钮模态框
		 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close"></button>
						<div class="text-center margin-big padding-big-top">
							<h2>桌位详细信息</h2>
						</div>
						<div id="modalform">
					    	<div>
					    		<span>桌位人数 </span><input type="text" name="st.personNum" class="personNum" id="pname"/>
					    	</div>
					    	<div>
					    		<span>桌位名字 </span><input type="text" name="st.deskName" id="tableName" class="tableName"/>
					    	</div>
					    	
					    	<div class="fuze">
					    		<span>&nbsp;负&nbsp;责&nbsp;人&nbsp;</span><select  id="tableperson">
					    			
					    		</select>
					    	</div>
					    	
					 </div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning btn-default modal-alterbtn" data-dismiss="modal" >确定更改</button>

					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			/*
				总页数
			*/
			$(function (){
				var currpage=0;
				tabonload(currpage);
				allpage("");
			});
			
			/*
				总条数
			*/
			var pagestate=0;//记录当前页的状态
			function allpage(allput){
				$.ajax({
					url:"SxmTable_pageTotal.action",
					type:"post",
					data:{"search":allput},
					success:function(data){					
					var pagetotal=parseInt(data/5);	
						if(data%5==0){
							$("#spanpage").html(pagetotal);
							pagestate=1;
						}
						if(data%5!=0){
							$("#spanpage").html(parseInt(pagetotal)+1);							
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
			$(function (){
				$(".page").click(function(){
					var allput=$(".input").val();//获取输入框的值
					var name=$(this).attr("name");
					var inpval=parseInt($("#pageinp").val());
					
					
					if(name=="first"){
						inpval=1;
					}
					if(name=="minus"){
						inpval=inpval-1;
						if(inpval<=1){
							inpval=1;							
						}
					}
					if(name=="add"){
						inpval=inpval+1;
						if(inpval>=$("#spanpage").html()){
							inpval=$("#spanpage").html()
							
						}
					}
					if(name=="last"){
						inpval=$("#spanpage").html();
					}
					$("#pageinp").val(inpval);
					var curr=inpval-1;
					if(allput==""){
						tabonload(curr);
					}else{
						fastsearch(curr);
					}
				});
			});
			/*
				快速搜索
			*/
			
			$(".fastsearch").click(function(){
				var currpage=0;
				fastsearch(currpage);
				$("#pageinp").val("1");
			});
			function fastsearch(curr){
				var allput=$(".input").val();//获取输入框的值
				allpage(allput);//输入框的值传进查询总页数方法里
				//var curr=parseInt($("#pageinp").val());
				$.ajax({
					url : "../SxmTable_searchTable.action",
					type : "post",
					data : {"currPage":curr,"search" :allput},
					success:function(data){
						var json = JSON.parse(data);
						refresh(json);
						
					}
				});
			}
			/*
				点击删除按钮删除一行数据;
			*/
			$("#tab").on('click',".deskbtn",function(){
				var deskbtn=$(this).attr("id");
				var deskid=$("#desk"+deskbtn).html();
				var inpval=parseInt($("#pageinp").val());//获取当前页
				if(confirm("您确定要删除吗?")){
					$.ajax({
						url:"SxmTable_delLineTable.action",
						type:"post",
						data:{"st.deskId":deskid},
						success:function(data){	
							
							if(data==-1){
							alert("修改失败");
							}else if(data==1){
								allpage("");
								var allinpval=parseInt($("#spanpage").html());//获取总页数
								if(inpval==allinpval && pagestate==0){
									$("#pageinp").val(inpval-1);
									tabonload(inpval-2);//调用页面加载时自动查询数据库，显示桌台信息
								}else{
									$("#pageinp").val(inpval);
									tabonload(inpval-1);
								}  
								
							}else{
								alert("没有权限");
							}				
						}
					});
				}
			});
		/*
			点击修改按钮修改一行数据表单里自动获取这一行的值
		*/
		var deskid="";
		$("#tab").on('click',".alterbtn",function(){
			var deskalter=$(this).attr("id");
			deskid=$(".desk"+deskalter).html();//桌子Id
			var deskname=$("#name"+deskalter).html();//桌子名字
			var deskperson=$("#person"+deskalter).html();//桌子人数
			var tperalter=$("#tper"+deskalter).html();//负责人
			$("#pname").val(deskperson);
			$("#tableName").val(deskname);
			append();
			
		});
		//点击确定修改按钮时执行；
	
			$(".modal-alterbtn").bind('click', function() {//绑定事件处理函数
				//$(this).unbind('click');//移除当前事件处理函数
				//bind/unbind点击事件只执行一次
				alert(deskid);
			var inpval=parseInt($("#pageinp").val());
				var pn = $("#pname").val();
				var dn = $("#tableName").val();
				var tp=$("#tableperson option:selected").val();
				$.ajax({
					url : "SxmTable_upLineTable.action",
					type : "post",
					data : {"st.deskId":deskid,"st.deskName":dn,"st.personNum" : pn,"em.emid":tp},
					success : function(data){				
						if(data==-1){
							alert("修改失败");
						}else if(data==1){
							deskid="";
							tabonload(inpval-1,null);//调用页面加载时自动查询数据库，显示桌台信息
							
						}else{
							alert("没有权限");
						}						
					},
				});
			});

		

			$("#checkall").click(function() {
				$("input[name='id[]']").each(function() {
					if (this.checked) {
						this.checked = false;
					} else {
						this.checked = true;
					}
				});
			});

			function DelSelect() {
				var Checkbox = false;
				$("input[name='id[]']").each(function() {
					if (this.checked == true) {
						Checkbox = true;
					}
				});
				if (Checkbox) {
					var t = confirm("您确认要删除选中的内容吗？");
					if (t == false)
						return false;
				} else {
					alert("请选择您要删除的内容!");
					return false;
				}
			};

			/*
				添加桌子名字失焦时检测是否已存在改桌名的函数
			 */
			$(".tableName").focus(function(){
				$("#appename").html("");
			});
			$(".tableName").blur(function() {
				//var reg=new RegExp(/^[\u4e00-\u9fa5A-Za-z0-9]$/,"gi");
				var reg = /^[\u4e00-\u9fa5A-Za-z0-9]+$/i;
				var tname=$(this).val();
				if(tname.length>20||tname.length<1){
					$("#appename").html("长度有误！");
				}else if(reg.test(tname)){
					$.ajax({
						url : "../SxmTable_equalTable.action",
						type : "post",
						data : {"st.deskName" : $(this).val()},
						success : function(data) {
							var json = JSON.parse(data);
							if (json != -1) {
								$("#appename").html("该桌名已存在！");
							}
						},
					});
				}else{
					$("#appename").html("桌名含有非法字符");
				}
			});
			/*
				页面加载时自动查询数据库，显示桌台信息
			 */
			
			function tabonload(curr) {
				$.ajax({
					url : "SxmTable_tabPage.action",
					type : "post",
					data : {"currPage":curr},
					success : function(data){
						var json = JSON.parse(data);
						refresh(json);
					}
				});

			};
			function refresh(json) {
				var th = "<tr><td>Id</td><td>桌台名</td><td>桌台人数</td><td>负责人</td><td>桌台状态</td><td>操作</td></tr>";
					$("#tab").html("");
					$("#tab").append(th);
					$.each(json,function(index, value) {
					var chargeper=value[3];
						if(value[3]==null){
							chargeper="未分配";
						}
						var dd = "<tr><td class=\"deskalter"+
						value[0]+"\" id=\"desknumId"+value[0]+"\">"+ value[0]+ "</td><td id=\"namealter"+value[0]+"\">"+ 
						value[1]+ "</td><td id=\"personalter"+value[0]+"\">"+ value[2]+ "</td><td id=\"tperalter"+value[0]+"\">"+ chargeper+
						"</td><td id=\"statealter"+value[0]+"\">"+ value[4]+ "</td>"+
						"<td><a class=\"button border-red deskbtn\"  id=\"numId"+value[0]+"\">"+ 
						"<span class=\"icon-trash-o\"></span>删除 </a>"+ 
						"<a class=\"button border-main alterbtn\" id=\"alter"+value[0]+
					   	"\"data-toggle=\"modal\" data-target=\"#myModal\">"+ 
					   	"<span class=\"icon-edit\"></span> 修改</a></td></tr>";
						$("#tab").append(dd);
					});	
					
							
			}
			var sortBy = function (filed, rev, primer) {
    	rev = (rev) ? -1 : 1;
    		return function (a, b) {
       	 	a = a[filed];
        	b = b[filed];
        	if (typeof (primer) != 'undefined') {
            	a = primer(a);
            	b = primer(b);
        }
        if (a < b) { return rev * -1; }
        if (a > b) { return rev * 1; }
        return 1;
    }
};
			
			/*
				添加桌子信息
			 */
			$(function() {
				$(".confirm-btn").click(function() {
					var curr=$("#spanpage").html();
					var pn = $("#personNum").val();
					var dn = $(".tableName").val();
					var fu=$("#addtab option:selected").val();
					if(pn && dn){
						$.ajax({
							url : "../SxmTable_appendTable.action",
							type : "post",
							data : {"st.personNum" : pn,"st.deskName" : dn,"em.emid":fu},
							success : function(data){	
								if(data==-1){
									alert("添加失败");
								}else if(data==1){
									allpage("");
									var inpval=parseInt($("#spanpage").html());
									if(pagestate==1){
										$("#pageinp").val(inpval+1);
										tabonload(inpval);//调用页面加载时自动查询数据库，显示桌台信息
									}else{
										$("#pageinp").val(inpval);
										tabonload(inpval-1);
									}
									$("#personNum").html("");
									$(".tableName").html("");
								}else{
									alert("没有权限");
								}												
							},
	
						});
					}else{
						alert("没有数据，添加失败");
					}
				});

			});
			/*
				点击添加桌台时的功能,自动查询服务员
			*/
			
			
			$("#alterbtn").click(function (){
					append();
			});
			function append(){
				$.ajax({
						url:"achieve_selectservice.action",
						type:"post",
						data:{},
						success:function(data){
							var json=JSON.parse(data);
							$("#addtab").html("");
							$("#tableperson").html("");
							$.each(json,function(index,value){
								var opt="<option value=\""+value[1]+"\">"+value[0]+"</option>";
								$("#addtab").append(opt);
								$("#tableperson").append(opt);
							});
						}
				});
			};
			/*
				桌位人数的聚焦事件
			*/	
			$(".personNum").focus(function(){
				$("#appenum").html("");
			})
			/*
				桌位人数的失焦事件
			*/
			$(".personNum").blur(function(){
				var pnum=$(".personNum").val();
				var reg=new RegExp("[^0-9]+","gi");
				if(reg.test(pnum)){
					$("#appenum").html("请输入数字");
				}
				if(pnum>20||pnum<1){
					$("#appenum").html("输入人数过多或过少");
				}
			});
		</script>
	</div>
</body>
</html>
