<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
   

    <style type="text/css">
        .scrollspy-example {
            height: 200px;
            overflow: auto;
            position: relative;
        }
        #zong{
        	border:1px solid green;
        	width:800px;
        	Position:absolute;
        }
        #zbzb{
        	border:1px solid red;
        	float:left;
        }
    </style> 
	
	

  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" type="text/css"></link>
  
  <script type="text/javascript" src="bootstrap/jquery/jquery-2.1.3.min.js"></script>
  
  <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
<div class="container-fluid">
	<div class="row">
		   <div>
		    
		    <div id="navbarExample" class="navbar navbar-static">
		        <div class="navbar-inner">
		            <div class="container" style="width: auto;">
		                
		                <ul class="nav">
		                    <li class="active"><a href="#php">
		                     <button type="button" class="btn btn-primary btn-lg" >凉菜</button>
		
		                    </a></li>
		                    <li class=""><a href="#js">
		                     <button type="button" class="btn btn-primary btn-lg" >主食</button>
		                    
		                    </a></li>
		                    <li class=""><a href="#js">
		                     <button type="button" class="btn btn-primary btn-lg" >热菜</button>
		                    
		                    </a></li>
		                    <li class=""><a href="#js">
		                     <button type="button" class="btn btn-primary btn-lg" >小吃</button>
		                    
		                    </a></li>
		                    <li class=""><a href="#js">
		                     <button type="button" class="btn btn-primary btn-lg" >特色</button>
		                    
		                    </a></li>
		                    <!-- <li class="dropdown">
		                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                        <button type="button" class="btn btn-primary btn-lg" >分类</button>
		                        
		                        <b class="caret"></b></a>
		                        <ul class="dropdown-menu">
		                            <li class=""><a href="#mysql">面食</a></li>
		                            <li class=""><a href="#pgsql">汤类</a></li>
		                            <li class=""><a href="#mgdb">小吃</a></li>
		                        </ul>
		                    </li>
		                    <li class="dropdown">
		                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                        <button type="button" class="btn btn-primary btn-lg" >小吃分类</button>
		                        
		                        <b class="caret"></b></a>
		                        <ul class="dropdown-menu">
		                            <li class=""><a href="#my">麻辣烫</a></li>
		                            <li class=""><a href="#pg">冒菜</a></li>
		                            <li class=""><a href="#mg">火锅</a></li>
		                        </ul>
		                    </li> -->
		                </ul>
		            </div>
		        </div>
		    </div>
		    <div id="zbzb" data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example">
		        <h4 id="php">凉菜</h4>
		        <p>
		        <div ><img src="image/1.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        <h4 id="js">主食</h4>
		        <p>
		         <div><img src="image/2.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        <h4 id="mysql">面食</h4>
		        <p>
		         <div><img src="image/3.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        <h4 id="pgsql">汤类</h4>
		        <p>
		        <div><img src="image/4.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        <h4 id="mgdb">小吃</h4>
		        <p>
		        <div><img src="image/5.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        <p>
		        <div><img src="image/6.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        
		        
		        <h4 id="my">麻辣烫</h4>
		        <p>
		         <div><img src="image/3.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        <h4 id="pg">冒菜</h4>
		        <p>
		        <div><img src="image/4.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        <h4 id="mg">火锅</h4>
		        <p>
		        <div><img src="image/5.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		        <p>
		        <div><img src="image/6.png" alt="..." class="img-circle" width="200" height="200">
		        </p>
		    </div>
		    <hr>
		    <script src="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>
		    <script src="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/js/bootstrap-dropdown.js"></script>
		    <script src="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/js/bootstrap-scrollspy.js"></script>
	</div>
</div>
</body> 
  </body>
</html>
