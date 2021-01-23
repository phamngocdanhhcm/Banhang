<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="BEAN.Order"%>
        <%@page import="DAO.ThemDienThoaiDAO"%>
    
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>Your Cart</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		<!-- bootstrap -->
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
		Order orders =(Order) session.getAttribute("order");
		ThemDienThoaiDAO dao = new ThemDienThoaiDAO();
		request.setAttribute("orders", orders);
				%>
		<jsp:include page="Header.jsp"></jsp:include>
		
		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<a href="index.html" class="logo pull-left"><img src="logo.png" class="site_logo" alt=""></a>
				<div class="navbar-inner main-menu">				
		
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
	
				<h4><span>Shopping Cart</span></h4>
			</section>
		
			<section class="main-content">				
				<div class="row">
					<div class="span9">					
						<h4 class="title"><span class="text"><strong>Your</strong> Cart</span></h4>
						
						
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Remove</th>
									<th>Image</th>
									<th>Product Name</th>
									<th>Quantity</th>
									<th>Unit Price</th>
									<th>Total</th>
								</tr>
							</thead>
							
							<tbody>
							<c:forEach items="${order.items}" var="phone" varStatus ="idx">
								<c:if test = "${phone.phone != null}" >      
								<tr>
									<td><a href="AddToCartController?action=xoaphone&idxoa=${phone.phone.idphone}" class="btn btn-secondary btn-lg"> Xóa </a>   </td>
									<td><a><img src="data:image/jpg;base64,${phone.phone.hinhanh}" width="250" height="250"/></a></td>
									<td>${phone.phone.name}</td>
									<td><a type="text" class="input-mini"> ${phone.soluong} </a></td>
									<td><a type="text" class="input-mini">${phone.giaca1} </a></td>
									<td><a type="text"  class="input-mini">${phone.tonggiatien1}</a></td>
									
								</tr>
								
							 </c:if>
							 
							 <c:if test = "${phone.laptop != null}" >      
								<tr>
									<td><a href="AddToCartController?action=xoalaptop&idxoa=${phone.laptop.malaptop}" class="btn btn-secondary btn-lg"> Xóa </a>   </td>
									<td><a><img src="data:image/jpg;base64,${phone.laptop.hinhanh}"  width="250" height="250"/></a></td>
									<td>${phone.laptop.name}</td>
									<td><a type="text" class="input-mini"> ${phone.soluong} </a></td>
									<td><a type="text" class="input-mini">${phone.giaca1} </a></td>
									<td><a type="text"  class="input-mini">${phone.tonggiatien1}</a></td>
								</tr>
							 </c:if>
							 
							  <c:if test = "${phone.ipad != null}" >      
								<tr>
									<td><a href="AddToCartController?action=xoaipad&idxoa=${phone.ipad.maipad}" class="btn btn-secondary btn-lg"> Xóa </a>   </td>
									<td><a><img src="data:image/jpg;base64,${phone.ipad.hinhanh}"  width="250" height="250"/></a></td>
									<td>${phone.ipad.name}</td>
									<td><a type="text" class="input-mini"> ${phone.soluong} </a></td>
									<td><a type="text" class="input-mini">${phone.giaca1} </a></td>
									<td><a type="text"  class="input-mini">${phone.tonggiatien1}</a></td>
								</tr>
							 </c:if>
							 
							 <c:if test = "${phone.watch != null}" >      
								<tr>
									<td><a href="AddToCartController?action=xoadongho&idxoa=${phone.watch.madongho}" class="btn btn-secondary btn-lg"> Xóa </a>   </td>
									<td><a><img src="data:image/jpg;base64,${phone.watch.hinhanh}"  width="250" height="250"/></a></td>
									<td>${phone.watch.name}</td>
									<td><a type="text" class="input-mini"> ${phone.soluong} </a></td>
									<td><a type="text" class="input-mini">${phone.giaca1} </a></td>
									<td><a type="text"  class="input-mini">${phone.tonggiatien1}</a></td>
								</tr>
							 </c:if>
							
						 	
							</c:forEach>
									  
							</tbody>
						</table>
						
						

						<hr>
						<p class="cart-total right">
							<strong>Sub - Total</strong>:<%=request.getAttribute("tongtien2")!=null?request.getAttribute("tongtien2"):"0" %><br>
							<strong>VAT (10.0%)</strong>:<%=request.getAttribute("vat")!=null?request.getAttribute("vat"):"0" %><br>
							<strong>Total</strong>: <%=request.getAttribute("tongtien1")!=null?request.getAttribute("tongtien1"):"0" %><br>
						</p>
						
						
						
						
						<hr/>
						
						<p class="buttons center">				
							<a href="HomeForward" class="btn btn-secondary btn-lg">Back</a>     
							<a href="CheckoutForWard" class="btn btn-secondary btn-lg">Check out</a> 
						</p>	
						<			
					</div>
					<div class="span3 col">
						<div class="block">	
							<ul class="nav nav-list">
								<li class="nav-header">SUB CATEGORIES</li>
								<li><a href="PhoneForward">Phone</a></li>
								<li><a href="IpadForward">Tablet</a></li>
								<li><a href="LaptopForward">Macbook</a></li>
								<li><a href="DonghoForward">Watch</a></li>
							</ul>
							<br/>
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
		<script>
			$(document).ready(function() {
				$('#checkout').click(function (e) {
					document.location.href = "checkout.html";
				})
			});
		</script>	
</body>
</html>