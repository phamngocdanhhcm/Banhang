<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="BEAN.Phone" %>
    <%@page import="DAO.ThemDienThoaiDAO"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>iStore VN</title>

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



		<!-- HEADER ROW -->
		
		<jsp:include page="Header.jsp"></jsp:include>
		
		<!-- HEADER ROW -->
		
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
			
			
	
			
			<section class="main-content">
				<div class="row">
					<div class="span12">													
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Phone <strong>Sản phẩm mới</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel" class="myCarousel carousel slide">
									<div class="carousel-inner">
									<div class="active item">
									<ul class="thumbnails">
										<c:forEach items="${listdienthoai}" var="phone" varStatus ="idx">
											
											<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="Productdetail_Controller?action=phone&id=${phone.idphone}"><img src="data:image/jpg;base64,${phone.hinhanh}" width="250" height="250" alt="" /></a></p>
														<a href="Productdetail_Controller?action=phone&id=${phone.idphone}" class="title"> ${phone.getName()}</a><br/>
														<a href="Productdetail_Controller?action=phone&id=${phone.idphone}" class="category">VN/A ${phone.getMemory()} GB</a>
														<p class="price"> ${phone.getGiatien1()} </p>
													</div>
												</li>
										
										
										</c:forEach>
									</ul>
									
										
											
										</div>
							
									</div>							
								</div>
							</div>						
						</div>
						
						<br/>
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Laptop <strong>Sản phẩm mới</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel" class="myCarousel carousel slide">
									<div class="carousel-inner">
									<div class="active item">
									<ul class="thumbnails">
										<c:forEach items="${listlaptop}" var="laptop" varStatus ="idx">
											
											<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="Productdetail_Controller?action=laptop&id=${laptop.malaptop} "><img src="data:image/jpg;base64,${laptop.hinhanh}" width="250" height="250" alt="" /></a></p>
														<a href="Productdetail_Controller?action=laptop&id=${laptop.malaptop}" class="title"> ${laptop.getName()}</a><br/>
														<a href="Productdetail_Controller?action=laptop&id=${laptop.malaptop}" class="category">${laptop.getChipdohoa()} </a>
														<p class="price"> ${laptop.getGiatien1()} </p>
													</div>
												</li>
										
										
										</c:forEach>
									</ul>
									
										
											
										</div>
							
									</div>							
								</div>
							</div>						
						</div>
						
						
						<br/>
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Watch <strong>Sản phẩm mới</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel" class="myCarousel carousel slide">
									<div class="carousel-inner">
									<div class="active item">
									<ul class="thumbnails">
										<c:forEach items="${listdongho}" var="dongho" varStatus ="idx">
											
											<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="Productdetail_Controller?action=dongho&id=${dongho.madongho}"><img src="data:image/jpg;base64,${dongho.hinhanh}" width="250" height="250" alt="" /></a></p>
														<a href="Productdetail_Controller?action=dongho&id=${dongho.madongho}" class="title"> ${dongho.getName()}</a><br/>
														<a href="Productdetail_Controller?action=dongho&id=${dongho.madongho}" class="category">${dongho.getCongnghemh()} </a>
														<p class="price"> ${dongho.getGiatien1()} </p>
													</div>
												</li>
										
										
										</c:forEach>
									</ul>
									
										
											
										</div>
							
									</div>							
								</div>
							</div>						
						</div>
						
						<br/>
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Ipad <strong>Sản phẩm mới</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel" class="myCarousel carousel slide">
									<div class="carousel-inner">
									<div class="active item">
									<ul class="thumbnails">
										<c:forEach items="${listipad}" var="ipad" varStatus ="idx">
											
											<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="Productdetail_Controller?action=ipad&id=${ipad.maipad}"><img src="data:image/jpg;base64,${ipad.hinhanh}" width="250" height="250" alt="" /></a></p>
														<a href="Productdetail_Controller?action=ipad&id=${ipad.maipad}" class="title"> ${ipad.getName()}</a><br/>
														<a href="Productdetail_Controller?action=ipad&id=${ipad.maipad}" class="category">${ipad.getDungluong()} </a>
														<p class="price"> ${ipad.getGiatien1()} </p>
													</div>
												</li>
										
										
										</c:forEach>
									</ul>
									
										
											
										</div>
							
									</div>							
								</div>
							</div>						
						</div>
						 
						
						<div class="row feature_box">						
							<div class="span4">
								<div class="service">
									<div class="responsive">	
										<img src="Template/Backend/themes/images/feature_img_2.png" alt="" />
										<h4>MODERN <strong>DESIGN</strong></h4>
										<p>Design is not just what it looks like and feels like. Design is how it works.</p>									
									</div>
								</div>
							</div>
							<div class="span4">	
								<div class="service">
									<div class="customize">			
										<img src="Template/Backend/themes/images/feature_img_1.png" alt="" />
										<h4>FREE <strong>SHIPPING</strong></h4>
										<p>Free delivery and returns are a major selling point for online retailers.</p>
									</div>
								</div>
							</div>
							<div class="span4">
								<div class="service">
									<div class="support">	
										<img src="Template/Backend/themes/images/feature_img_3.png" alt="" />
										<h4>APPLE CARE <strong>SUPPORT</strong></h4>
										<p>Apple Care products provide additional hardware service options and expert technical support from Apple.</p>
									</div>
								</div>
							</div>	
						</div>		
					</div>				
				</div>
			</section>

			<section id="footer-bar">
				<div class="row">
					
					<div class="span3">
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
					<div class="span3">
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
		<script src="Template/Backend/themes/js/jquery.flexslider-min.js"></script>
		<script type="Template/Backend/text/javascript">
			$(function() {
				$(document).ready(function() {
					$('.flexslider').flexslider({
						animation: "fade",
						slideshowSpeed: 4000,
						animationSpeed: 600,
						controlNav: false,
						directionNav: true,
						controlsContainer: ".flex-container" // the container that holds the flexslider
					});
				});
			});
		</script>
</body>
</html>