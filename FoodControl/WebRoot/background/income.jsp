<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<!-- 
		后台财务统计页面
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
	<script type="text/javascript"
		src="../bootstrap/jquery/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
		
	<script type="text/javascript" src="../bootstrap/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<link rel="stylesheet" href="../bootstrap/css/bootstrap-datetimepicker.css" type="text/css"></link>
	
	
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"
		type="text/css"></link>
	
	
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
		#Statistics{
			margin-top:30px;
			height:40px;
			font-size:25px;
			lien-height:40px;
		}
		.tds{ 
			color:#FF0000;
			width:14%;
			text-align:center;
		}
		.tdss{
			color:#FF0000;
			width:14%;
			text-align:right;
		}
		#tabs tr{
			border-top:1px solid red;
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
						
						      起始时间：<input size="16" type="text" class="form_datetime" value="" readonly id ="inpu1">
						      <span class="add-on"><i class="icon-th"></i></span>
						      截止时间：<input size="16" type="text" value=""class="form_datetime" readonly id ="inpu2">
						      <span class="add-on"><i class="icon-th"></i></span>
						      选择桌名： <select id ="desknub"style="width:100"  name="selectvalue"> 	  
							</select>
							<a class="button border-yellow" id="zbdesk">桌台销售统计</a>
							选择菜名：<select  id ="dishnub" style="width:100" name="selectvalue">
							 	  
							</select>			
							<a class="button border-yellow" id="zbdish">菜品销售统计</a>
						<div id="Statistics">
							
						</div>
					</div>
					<table class="table table-hover text-center"  id="tab">
						
						
					</table>
					<table class="table table-hover text-center"  id="tabs">
						
					</table>
					<!-- <div class="pagelist">
						<a name="first" class="page" href="#">首页</a><a name="minus" class="page" href="#">上一页</a><a name="add" class="page" href="#">下一页</a><a name="last" class="page" href="#">尾页</a><input type="text" id="pageinp" value="1" size="5"/>
						<a class="page" type="button">跳转</a>共<span id="spanpage"></span>页
					</div> -->
					<div class="zbpagelist pagelist">
						<a  class="zbpage" name="zbfirst" href="#">首页</a>
						<a  class="zbpage" name="zbminus" href="#">上一页</a> 
						<a  class="zbpage" name="zbadd" href="#">下一页</a>
						<a  class="zbpage" name="zblast" href="#">尾页</a>
						共<span id="zbpagenum"></span>页
						<input type="text" id="zbsome" value="1" size ="2">
						<input type="button" value="跳转" class ="zbpage" name ="zbcommit" id="zbcommit">
					</div>
				</div>
			</form>
		</div>	
	</div>
	
	<script type="text/javascript">
	
		//菜品查询
		//var selstate=0;
		var selflag=0;
		$(function(){
				deskname();
				dishname();
			var va = $("#desknub").val();
	   		var va1 = $("#inpu1").val();
	   		var va2 = $("#inpu2").val();
	   		//alert(va);
			//if(va=="desk"&&va1==""&&va2==""){
	   			//alert("kong");
	   			selflag=5;
	   			curr=0;
	   			totalpage(va,va1,va2);
	   			Zbdedeskallno(curr);
	   		//}
				//totalpage();
		});
		function deskname(){
			$.ajax({
				url:"zborders_orders.action",
				type:"type",
				data:{},
				success:function(data){
						$("#desknub").html("");
						var json = JSON.parse(data);
						var op="<option value=\"desk\">全部桌子</option>";
						$("#desknub").append(op);
						$.each(json,function(index,value){
							var opt="<option value=\""+value[0]+"\">"+value[2]+"</option>";
							$("#desknub").append(opt);
						});
				}
			});
		};
		function dishname(){
			$.ajax({
					url:"zborders_dishnum.action",
					data:{},
					type:"post",
					success:function(data){
						$("#dishnub").html("");
						var json=JSON.parse(data);
						var op="<option value=\"dish\">全部菜品</option>";
						$("#dishnub").append(op);
						$.each(json,function(index,value){
							var options="<option value=\""+value[0]+"\">"+value[1]+"</option>";
							$("#dishnub").append(options);
						});
					}
				});
		};
		$("#zbdesk").click(function(){
			var curr=0;
			//alert("clickselfalg:"+selflag);
			$("#zbsome").val(1);
			var va = $("#desknub").val();
	   		var va1 = $("#inpu1").val();
	   		var va2 = $("#inpu2").val();
	   		//alert("desk:"+va);
	   		if (va=="desk"&&va1!=""&&va2!=""){
	   			selflag=3;
	   			totalpage(va,va1,va2);
	   			Zbdeskall(curr);
	   		}else if(va!="desk"&&va1!=""&&va2!=""){
	   			selflag=1;
	   			totalpage(va,va1,va2);
	   			pageresultsdesk(curr);
	   			deskStatistics(va,va1,va2);
	   		}else if(va=="desk"&&va1==""&&va2==""){
	   		//	alert("kong");
	   			selflag=5;
	   			totalpage(va,va1,va2);
	   			Zbdedeskallno(curr);
	   		}else{
	   			alert("请选择时间段。");
	   		}
	   		//alert( va+","+va1+","+va2);
	   		
			
			//deskStatistics(va,va1,va2)
		
		});
		$("#zbdish").click(function(){
			//alert("dish");
			var curr=0;
			//alert("clickselfalg:"+selflag);
			$("#zbsome").val(1);
			var va = $("#dishnub").val();
	   		var va1 = $("#inpu1").val();
	   		var va2 = $("#inpu2").val();
	   		if (va=="dish"&&va1!=""&&va2!=""){
	   			selflag=4;
	   			totalpage(va,va1,va2);
	   			Zbdedishall(curr);
	   		}else if (va!="dish"&&va1!=""&&va2!=""){
	   			selflag=2;
		   		//alert( va+","+va1+","+va2);
		   		totalpage(va,va1,va2);
				pageresultsdish(curr);
				Statistics(va,va1,va2);
			}else if(va=="dish"&&va1==""&&va2==""){
				selflag=6;
				totalpage(va,va1,va2);
				Zbdedishallno(curr);
			}else{
	   			alert("请选择时间段！。");
	   		}
		});
		function pageresultsdesk(curr){
	   		var va = $("#desknub").val();
	   		var va1 = $("#inpu1").val();
	   		var va2 = $("#inpu2").val();
	   		//alert( va+","+va1+","+va2);
	   		//totalpage(va,va1,va2);
	   		$.ajax({
	   			url:"zborders_zbDeskQu.action",
	   			type:"post",
	   			data:{"zbde.va":va,"zbde.va1":va1,"zbde.va2":va2,"zbde.curr":curr},
	   			success:function(data){
	   				var json = JSON.parse(data);
	   				$("#tab").html("");
	   				var zbva ="<tr><td>订单号</td><td>订单总价(元)</td><td>订单状态</td><td>支付方式</td></tr>";
	   				$("#tab").append(zbva);
	   				var cost="";
	   				var orderstatus="";
	   				$.each(json,function(index,value){
	   					if(value[4]==21){
	   						cost="未支付";
	   					}else if(value[4]==9){
	   						cost="现金支付";
	   					}else if(value[4]==10){
	   						cost="支付宝支付";
	   					}else if(value[4]==11){
	   						cost="微信支付";
	   					}
	   					if(value[1]==15){
	   						orderstatus="进行中";
	   					}else if(value[1]==16){
	   						orderstatus="已完成";
	   					}else if(value[1]==17){
	   						orderstatus="已取消";
	   					}
	   					var va = "<tr><td>"+value[0]+"</td><td>"+value[2]+"</td><td>"+orderstatus+"</td><td>"+cost+"</td></tr>";
	   					$("#tab").append(va);
	   					
	   				});	
	   			}
	   		});
	   }; 
	   function pageresultsdish(curr){
	   		var va = $("#dishnub").val();
	   		var va1 = $("#inpu1").val();
	   		var va2 = $("#inpu2").val();
	   		//alert( va+","+va1+","+va2);
	   		//totalpage(va,va1,va2);
	   		$.ajax({
	   			url:"zborders_zbDishQu.action",
	   			type:"post",
	   			data:{"zbde.va":va,"zbde.va1":va1,"zbde.va2":va2,"zbde.curr":curr},
	   			success:function(data){
	   				var json = JSON.parse(data);
	   				$("#tab").html("");
	   				var zbva ="<tr><td>订单号</td><td>菜品单价(元)</td><td>菜品下单时间</td><td>菜品状态</td><td>菜品数量</td><td>菜品金额</td></tr>";
	   				$("#tab").append(zbva);
	   				$.each(json,function(index,value){
	   				var time=format(value[6].time);
	   				//alert(value[11]);
	   				var price=value[9]*value[1];
	   					var va = "<tr><td>"+value[3]+"</td><td>"+value[9]+"</td><td>"+time+"</td><td>"+value[11]+"</td><td>"+value[1]+"</td><td>"+price+"</td></tr>";
	   					$("#tab").append(va);
	   				});	
	   			}
	   		});
	   };
	   function deskStatistics(va,va1,va2){
	   		$.ajax({
	   			url:"zborders_ZbdeskStatistics.action",
	   			type:"post",
	   			data:{"zbde.va":va,"zbde.va1":va1,"zbde.va2":va2},
	   			success:function(data){
	   				var json=JSON.parse(data);
	   				var orders="";
	   				$("#tabs").html("");
	   				var information="<tr><td></td><td class=\"tdss\"></td><td class=\"tds\">订单数量</td><td class=\"tds\">订单金额</td></tr>";
	   				$("#tabs").append(information);
	   				$.each(json,function(index,value){
	   					if(value[0]==15){
	   						orders="进行中订单合计：";
	   					}else if(value[0]==16){
	   						orders="已完成订单合计：";
	   					}else if(value[0]==17){
	   						orders="已取消订单合计：";
	   					}
	   					var information="<tr><td></td><td class=\"tdss\">"+orders+"</td><td class=\"tds\">"+value[1]+"</td><td class=\"tds\">"+value[2]+"</td></tr>";
	   					$("#tabs").append(information);
	   				});
	   				
	   				
	   			}
	   		});
	   }
	   function Statistics(va,va1,va2){
	   //alert("dd");
	   		$.ajax({
	   			url:"zborders_ZbdishStatistics.action",
	   			type:"post",
	   			data:{"zbde.va":va,"zbde.va1":va1,"zbde.va2":va2},
	   			success:function(data){
	   			//alert("pp");
	   				var json = JSON.parse(data);
	   				var num=0;
	   				var numConduct=0;
	   				var priceConduct=0;
	   				var information="";
	   				var informationc="";
	   				$("#tabs").html("");
	   				$.each(json,function(index,value){
	   				//alert("9985");
	   					num=num+parseInt(value[3]);
	   					if(value[0]==14){
	   						information="已完成菜品合计：";
	   					}else if(value[0]==17){
	   						information="已取消菜品合计：";
	   					}else if(value[0]==12||value[0]==13){
	   						numConduct=numConduct+parseInt(value[3]);
	   						priceConduct=priceConduct+parseInt(value[1]);
	   						informationc="进行中菜品合计：";
	   					}
	   					if(value[0]==14||value[0]==17){
	   						information="<tr><td></td><td class=\"tdss\">"+information+"</td><td class=\"tds\">"+value[3]+"</td><td class=\"tds\">"+value[1]+"</td></tr>";
	   						$("#tabs").append(information);
	   					}
	   					
	   				});	
	   				informationc="<tr><td></td><td class=\"tdss\">"+informationc+"</td><td class=\"tds\">"+numConduct+"</td><td class=\"tds\">"+priceConduct+"</td></tr>";
	   				$("#tabs").append(informationc);	
	   			}
	   		});
	   }
	   function Zbdeskall(curr){
	  // alert("all");
	   		var va1 = $("#inpu1").val();
	   		var va2 = $("#inpu2").val();
	   		$.ajax({
	   			type:"post",
	   			url:"zborders_Zbdeskall.action",
	   			data:{"zbde.va1":va1,"zbde.va2":va2,"zbde.curr":curr},
	   			success:function(data){
	   				var json=JSON.parse(data);
	   				$("#tab").html("");
	   				var desk="<tr><td>桌台名称</td><td>订单数量</td><td>订单金额</td></tr>";
	   				
	   				$("#tab").append(desk);
	   				$.each(json,function(index,value){
	   					//alert("value[2]:"+value[2]);
	   					var price=0;
	   					if(value[2]!=null){
	   						price=value[2];
	   					}
	   					var desk="<tr><td>"+value[3]+"</td><td>"+value[1]+"</td><td>"+price+"</td></tr>";
	   					$("#tab").append(desk);
	   				});
	   			}
	   		});
	   }
	   function Zbdedishall(curr){
	   		var va1 = $("#inpu1").val();
	   		var va2 = $("#inpu2").val();
	   		$.ajax({
	   			type:"post",
	   			url:"zborders_Zbdishall.action",
	   			data:{"zbde.va1":va1,"zbde.va2":va2,"zbde.curr":curr},
	   			success:function(data){
	   				var json=JSON.parse(data);
	   				$("#tab").html("");
	   				var dish="<tr><td>菜品名称</td><td>菜品单价</td><td>销售数量</td><td>销售金额</td></tr>";
	   				$("#tab").append(dish);
	   				$.each(json,function(index,value){
	   					var num=0;
	   					if(value[3]!=null){
	   						num=value[3];
	   					}
	   					var price=value[2]*num;
	   					var dish="<tr><td>"+value[1]+"</td><td>"+value[2]+"</td><td>"+num+"</td><td>"+price+"</td></tr>";
	   					$("#tab").append(dish);
	   				});
	   			}
	   		});
	   }
	   function Zbdedeskallno(curr){
	   //alert("no");
	   		$.ajax({
	   			type:"post",
	   			url:"zborders_Zbdeskallno.action",
	   			data:{"zbde.curr":curr},
	   			success:function(data){
	   				var json=JSON.parse(data);
	   				$("#tab").html("");
	   				var desk="<tr><td>桌台名称</td><td>订单数量</td><td>订单金额</td></tr>";
	   				$("#tab").append(desk);
	   				$.each(json,function(index,value){
	   					//alert("value[2]:"+value[2]);
	   					var price=0;
	   					if(value[2]!=null){
	   						price=value[2];
	   					}
	   					var desk="<tr><td>"+value[3]+"</td><td>"+value[1]+"</td><td>"+price+"</td></tr>";
	   					$("#tab").append(desk);
	   				});
	   			}
	   		});
	   }
	   function Zbdedishallno(curr){
	   		$.ajax({
	   			type:"post",
	   			url:"zborders_Zbdishallno.action",
	   			data:{"zbde.curr":curr},
	   			success:function(data){
	   				var json=JSON.parse(data);
	   				$("#tab").html("");
	   				var dish="<tr><td>菜品名称</td><td>菜品单价</td><td>销售数量</td><td>销售金额</td></tr>";
	   				$("#tab").append(dish);
	   				$.each(json,function(index,value){
	   					var num=0;
	   					if(value[3]!=null){
	   						num=value[3];
	   					}
	   					var price=value[2]*num;
	   					var dish="<tr><td>"+value[1]+"</td><td>"+value[2]+"</td><td>"+num+"</td><td>"+price+"</td></tr>";
	   					$("#tab").append(dish);
	   				});
	   			}
	   		});
	   }
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
	   //----------------------------日历----------------------------------------------
	    $(".form_datetime").datetimepicker({
	      format: "yyyy-mm-dd hh:ii",
	      autoclose: true,
	      todayBtn: true,
	      language:'zh-CN',
	      pickerPosition:"bottom-left"
	    });
    	//------------------------分页（总）-------------------------
    	function totalpage(va,va1,va2){
    	//alert( va+","+va1+","+va2);
			$.ajax({
				type: "post",
				url : "zborders_zbtotalpage.action",
				data: {"zbde.va":va,"zbde.va1":va1,"zbde.va2":va2,"zbde.selflag":selflag},
				success : function(data){
					var zbtotal = parseInt(data/5);
					if(data%5 == 0){
						$("#zbpagenum").html(zbtotal);
					}
					if(data%5 != 0){
						$("#zbpagenum").html(parseInt(zbtotal)+1);
					}
				},
			});
		};
	//++++++++++++++++++++++++分页++++++++++++++++++++++++++++++
	
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
						//alert("add:"+$("#zbpagenum").html());
						if(zbsome1>$("#zbpagenum").html()){
							zbsome1=$("#zbpagenum").html()
							
						}
				}
				
				if(name=="zblast"){
					zbsome1=$("#zbpagenum").html();
				}
				$("#zbsome").val(zbsome1);
				var curr=zbsome1-1;
				//alert("curr:"+curr);
				//alert("selflag:"+selflag);
				if (selflag==1){
					pageresultsdesk(curr);
				}else if(selflag==2){
					pageresultsdish(curr);
				}else if(selflag==3){
					Zbdeskall(curr);
				}else if(selflag==4){
					Zbdedishall(curr);
				}else if(selflag==5){
					Zbdedeskallno(curr);
				}else if(selflag==6){
					Zbdedishallno(curr);
				}
			});

	</script>
</body>
</html>
