<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="BEAN.Order"%>
                <%@page import="BEAN.Users"%>
        <%@page import="DAO.RegisterDAO"%>
  	  <%@page import="DB.DBConnection"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>Check out</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		
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
		<jsp:include page="Header.jsp"></jsp:include>
		
		<%
		int kt = 0 ;
		Connection conn = DBConnection.CreateConnection();
		Users users = new Users();
		RegisterDAO dao = new RegisterDAO();
		Order order =(Order) session.getAttribute("order");
		session.setAttribute("order", order);
		if(session.getAttribute("username") !=null )
		{
			String username =(String) session.getAttribute("username");
			users  = dao.getUserById(conn,username);
			kt = 1;
		}
		Order orders = (Order) request.getAttribute("orders");
		request.setAttribute("orders", orders);
			
		%>
		
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
		
				<h4><span>Check Out</span></h4>
			</section>	
			<section class="main-content">
				<div class="row">
					<div class="span12">
						<div class="accordion" id="accordion2">
						<form action="TaodonhangController" method="post">
						<%
							if(kt != 1)
							{
						%>
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">Account &amp; Billing Details</a>
								</div>
								<div id="collapseTwo" class="accordion-body in collapse">
									<div class="accordion-inner">
										<div class="row-fluid">
											<div class="span6">
												<h4>Thông tin cần điền</h4>
												<div class="control-group">
													<label class="control-label">Họ và tên</label>
													<div class="controls">
														<input type="text" placeholder="" name="ten" value="" class="input-xlarge">
													</div>
												</div>
												<div class="control-group">
													<label class="control-label">Số điện thoại</label>
													<div class="controls">
														<input type="number" name="sodienthoai" placeholder="" class="input-xlarge">
													</div>
												</div>					  
												<div class="control-group">
													<label class="control-label">Email Address</label>
													<div class="controls">
														<input type="email" name = "email"  placeholder="" class="input-xlarge">
													</div>
												</div>
												<div class="control-group">
													<label class="control-label">Địa chỉ</label>
													<div class="controls">
														<input type="text" placeholder="" name="diachi" class="input-xlarge">
													</div>
												</div>
												
												<div class="control-group">
													<div class="controls">
														<input type="submit" value="Xác nhận" class="input-xlarge"  onclick="alert('Đặt hàng thành công.')" >
													</div>
												</div>
												
											</div>
								
										</div>
									</div>
								</div>
							</div>
						<%
							}
								else {
						%>	
								<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">Account &amp; Billing Details</a>
								</div>
								<div id="collapseTwo" class="accordion-body in collapse">
									<div class="accordion-inner">
										<div class="row-fluid">
											<div class="span6">
												<h4>Thông tin cần điền</h4>
												<div class="control-group">
													<label class="control-label">Họ và tên</label>
													<div class="controls">
														<input type="text" placeholder="" name="ten" value="<%=users.getName() %>" class="input-xlarge">
													</div>
												</div>
												<div class="control-group">
													<label class="control-label">Số điện thoại</label>
													<div class="controls">
														<input type="number" name="sodienthoai" placeholder="" value="<%=users.getPhone() %>"  class="input-xlarge">
													</div>
												</div>					  
												<div class="control-group">
													<label class="control-label">Email Address</label>
													<div class="controls">
														<input type="email" name = "email"  placeholder="" value="<%=users.getEmail() %>" class="input-xlarge">
													</div>
												</div>
												<div class="control-group">
													<label class="control-label">Địa chỉ</label>
													<div class="controls">
														<input type="text" placeholder="" name="diachi" value="" class="input-xlarge" >
													</div>
												</div>
												<div class="control-group">
													<div class="controls">
														<input type="submit" value="Xác nhận" class="input-xlarge" onclick="alert('Đặt hàng thành công.')" >
													</div>
												</div>
												
											</div>
								
										</div>
									</div>
								</div>
							</div>
							<%
							}
							%>
							
							</form>
							
						
						</div>				
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
							<li><a href="DonghoForWard">WATCH</a>
								
							</li>
						</ul>
					</div>
					<div class="span2">
						<h4>Account</h4>
						<ul class="nav">
							<li><a href="LoginForward">Login & Register</a></li>
							<li><a href="CartForward">Cart</a></li>
							<li><a href="CheckoutForward">Checkout</a></li>
							
							
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
</body>
</html>