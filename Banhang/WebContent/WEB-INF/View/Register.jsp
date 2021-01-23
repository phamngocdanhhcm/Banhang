<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login & Register</title>

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
	
		<script type="text/javascript">
		
			function Validate() {
				var username = document.myform.username.value;
				var password = document.myform.password.value;
				var name     = document.myform.name.value;
				var phone    = document.myform.phone.value;
				var email    = document.myform.email.value;
				
				if(username == "" || name =="" || phone == "" || email =="" || password=="")
				{
					alert("Yêu cầu không bỏ trống bất kì thông tin nào, yêu cầu yêu Tường Lam nhiều hơn");
					return false;
				}
				else {
					if(password.length <6)
						{
						 document.getElementById("errorpass").innerHTML="Độ dài pass >= 6";
						 return false;
						}
				}
				
			}
			
		
		</script>
	
</head>


<body>
		
		<jsp:include page="Header.jsp"></jsp:include>
		
			<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
					<a href="index.html" class="logo pull-left"><img src="logo.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a href="PhoneForward">PHONE</a>					
							
							</li>															
							<li><a href="IpadForward">TABLET</a>
								</li>			
							<li><a href="LaptopForward">MACBOOK</a>
								
							</li>							
							<li><a href="DonghoForward">WATCH</a>
								
							</li>
							
						</ul>
					</nav>
				</div>
			</section>		
			<section class="header_text sub">
				<h4><span>Login or Regsiter</span></h4>
			</section>			
			<section class="main-content">				
				<div class="row">
					<div class="span5">					
						<h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>
						<form action="LoginController" method="post">
							<input type="hidden" name="next" value="/">
							<fieldset>
								<div class="control-group">
								
									<label class="control-label" style="color:red">
									<%=request.getAttribute("msglogin")!=null?request.getAttribute("msglogin"):"" %>
									</label>
									
									<label class="control-label">Username</label>
									<div class="controls">
										<input type="text" name="username" placeholder="Enter your username" id="username" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Password</label>
									<div class="controls">
										<input type="password" name="password" placeholder="Enter your password" id="password" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<input tabindex="3" class="btn btn-inverse large" type="submit" value="Login">
									<hr>
									
								</div>
							</fieldset>
						</form>				
					</div>
					
					
					<div class="span7">					
						<h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>
						<form name="myform" action="RegisterController" method="post" class="form-stacked" onsubmit="return Validate()">
							<fieldset>
								<label class="control-label" style="color:red" >
								<%=request.getAttribute("mess")!=null?request.getAttribute("mess"):" " %>
								</label>
								<div class="control-group">
									<label class="control-label">Username</label>
									<div class="controls">
										<input type="text" name="username" placeholder="Enter your username" class="input-xlarge">
									</div>
									
									
								</div>
								<div class="control-group">
									<label class="control-label">Password</label>
									<div class="controls">
										<input type="password" name="password" placeholder="Enter your password" class="input-xlarge">
										<label class="control-label" id="errorpass" style="color:red">
										</label>
									</div>
									
									
								</div>	
								<div class="control-group">
									<label class="control-label">Email address</label>
									<div class="controls">
										<input type="email" name="email" placeholder="Enter your email" class="input-xlarge">
									</div>
									
									
								</div>
						
								<div class="control-group">
									<label class="control-label">Name</label>
									<div class="controls">
										<input type="text" name="name" placeholder="Enter your name" class="input-xlarge">
									</div>
									
									
								</div>
								<div class="control-group">
									<label class="control-label">Phone</label>
									<div class="controls">
										<input type="number" name="phone" placeholder="Enter your phone number" class="input-xlarge">
									</div>
									
									
								</div>									
								<hr>
								<div class="actions"><input tabindex="9" class="btn btn-inverse large" type="submit" value="Register"></div>
							</fieldset>
						</form>					
					</div>				
				</div>
			</section>			
			<section id="footer-bar">
				<div class="row">
					<div class="span2">
						<h4>Product</h4>
						<ul class="nav">
							<li><a href="PhoneForward">PHONE</a>					
							
							</li>															
							<li><a href="IpadForward">TABLET</a>
								</li>			
							<li><a href="LaptopForward">MACBOOK</a>
								
							</li>							
							<li><a href="DonghoForward">WATCH</a>
								
							</li>
						</ul>
					</div>
					<div class="span2">
						<h4>Account</h4>
						<ul class="nav">
							<li><a href="LoginForward">Login & Register</a></li>
							<li><a href="CartForward">Cart</a></li>
							<li><a href="CheckoutForWard">Checkout</a></li>
							
							
						</ul>
					</div>
					<div class="span6">
						<p class="logo"><img src="logo.png" class="site_logo" alt=""></p>
						<p>Design is not just what it looks like and feels like. Design is how it works.</p>
						<p>Innovation distinguishes between a leader and a follower.</p>
						<br/>

					</div>					
				</div>	
			</section>
			<section id="copyright">
				<span>Copyright © 2020 Apple Inc. All rights reserved.</span>
			</section>
		</div>




	<script src="Template/Backend/themes/js/common.js"></script>
		<script>
			$(document).ready(function() {
				$('#checkout').click(function (e) {
					document.location.href = "checkout.html";
				})
			});
		</script>	
</body>
</html>