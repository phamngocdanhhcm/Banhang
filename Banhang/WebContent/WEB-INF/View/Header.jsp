<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link href="Template/Backend/bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="Template/Backend/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
		
		<link href="Template/Backend/themes/css/bootstrappage.css" rel="stylesheet"/>
		
		<!-- global styles -->
		<link href="Template/Backend/themes/css/flexslider.css" rel="stylesheet"/>
		<link href="Template/Backend/themes/css/main.css" rel="stylesheet"/>

		<!-- scripts -->
		<script src="Template/Backend/themes/js/jquery-1.7.2.min.js"></script>
		<script src="Template/Backend/bootstrap/js/bootstrap.min.js"></script>				
		<script src="Template/Backend/themes/js/superfish.js"></script>	
		<script src="Template/Backend/themes/js/jquery.scrolltotop.js"></script>
</head>
<body>

	<%
		if (session.getAttribute("sessionuser") ==null)
		{
	%>



	<div id="top-bar" class="container">
			<div class="row">
				
				<div class="span12">
					<div class="account pull-right">
						<ul class="user-menu">				
							<li><a href="HomeForward">Home</a></li>
						
							<li><a href="CartForward">Your Cart</a></li>
											
							<li><a href="LoginForward">Account</a></li>		
						</ul>
					</div>
				</div>
			</div>
	</div>
	
	<%
		}
		else{
			
		
	%>
		<div id="top-bar" class="container">
			<div class="row">
				<div class="span3">
					<form method="POST" class="search_form">
						<input type="text" class="input-block-level search-query" Placeholder="Search">
					</form>
				</div>
				<div class="span9">
					<div class="account pull-right">
						<ul class="user-menu">				
							<li><a href="HomeForward">Home</a></li>
						
							<li><a href="CartForward">Your Cart</a></li>
							
							<li><a>Wellcome: ${sessionuser}</a></li>
											
							<li ><a href="LogoutController">Logout</a></li>		
						</ul>
					</div>
				</div>
			</div>
	</div>
	<%
	}
	%>
</body>
</html>