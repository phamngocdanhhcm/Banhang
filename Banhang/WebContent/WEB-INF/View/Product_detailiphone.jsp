<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
        <%@page import="BEAN.Phone" %>
        <%@page import="BEAN.Laptop" %>
        <%@page import="BEAN.Ipad" %>
        <%@page import="BEAN.Watch" %>
        
    <%@page import="DAO.ThemDienThoaiDAO"%>
    <%@page import="DAO.ThemLaptopDAO"%>
    <%@page import="DAO.ThemIpadDAO"%>
    <%@page import="DAO.ThemDongHoDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin sản phẩm</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		
		<!-- bootstrap -->
		<link href="Template/Backend/bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="Template/Backend/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
		<link href="Template/Backend/themes/css/bootstrappage.css" rel="stylesheet"/>
		
		<!-- global styles -->
		<link href="Template/Backend/themes/css/main.css" rel="stylesheet"/>
		<link href="Template/Backend/themes/css/jquery.fancybox.css" rel="stylesheet"/>
				
		<!-- scripts -->
		<script src="Template/Backend/themes/js/jquery-1.7.2.min.js"></script>
		<script src="Template/Backend/bootstrap/js/bootstrap.min.js"></script>				
		<script src="Template/Backend/themes/js/superfish.js"></script>	
		<script src="Template/Backend/themes/js/jquery.scrolltotop.js"></script>
		<script src="Template/Backend/themes/js/jquery.fancybox.js"></script>
		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
		 <style type="text/css">
			a.button {
   			 -webkit-appearance: button;
   			 -moz-appearance: button;
   			 appearance: button;
 
   			 text-decoration: none;
   			 color: initial;
			}
    </style>   
</head>
<body>


		     <%
        Phone phone = new Phone();
		ThemDienThoaiDAO daodienthoai = new ThemDienThoaiDAO();
		ThemLaptopDAO daolaptop = new ThemLaptopDAO();
		ThemIpadDAO daoipad = new ThemIpadDAO();
		ThemDongHoDAO daodongho = new ThemDongHoDAO();
        phone = (Phone) request.getAttribute("listphone");        
        
        Laptop laptop = new Laptop();
        laptop = (Laptop) request.getAttribute("listlaptop");
        Watch watch = new Watch();
        watch = (Watch) request.getAttribute("listdongho");
        Ipad ipad = new Ipad();
        ipad = (Ipad) request.getAttribute("listipad");
        
       
        List<Phone> list1 = daodienthoai.getProductRandom();
		
		List<Phone> list2 = daodienthoai.getProductSeller();
		List<Laptop> list3 = daolaptop.getProductRandom();
		List<Laptop> list4 = daolaptop.getProductSeller();
		List<Ipad> list5 = daoipad.getProductRandom();
		List<Ipad> list6 = daoipad.getProductSeller();
		List<Watch> list7 = daodongho.getProductRandom();
		List<Watch> list8 = daodongho.getProductSeller();
        %>

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
				<h4><span>Product Detail</span></h4>
			</section>		
			<section class="main-content">				
				<div class="row">						
					<div class="span9">
					<form action="AddToCartController" method="post">
					 <c:if test = "${sanpham == 'phone'}" > 
						<div class="row">
							<div class="span4">
								<input type="hidden" value="<%=phone.getIdphone() %>" name="idphone" /> 										
								<a class="thumbnail" data-fancybox-group="group1" title="<%=phone.getName()%>"><img src="data:image/jpg;base64,<%=phone.getHinhanh()%>"/></a>
							</div>
							<div class="span5">
								<address>
									<strong>Brand:</strong> <span><%=phone.getBrand()%></span><br>
									<strong>Product Name:</strong> <span><%=phone.getName()%></span><br>
									<strong>More Details:</strong> <span>VN/A <%=phone.getMemory()%> GB</span><br>
									<%
									if(phone.getQuantity() > 0 )
									{
										
									
									%>
									<strong>Availability:</strong> <span>Available</span><br>
										<form class="form-inline">
											<p>&nbsp;</p>
											<label>Quantity:</label>
											<input type="number" name="quantity" value = "1"  class="span1" placeholder="1">
										</form>			
										</address>	
										<h4><strong>Price: </strong><span><%=phone.getGiatien1()%></span></h4>	
										<button class="btn btn-inverse" type="submit" >Add to cart</button>
										
										<%
									}
									else {
										
										%>
										<strong>No Availability:</strong> <span>No Available</span><br>
											</address>		
											<h4><strong>Price: </strong><span><%=phone.getGiatien1()%></span></h4>
										<%
									}
										%>							
														
								
							</div>						
						</div>
						<div class="row">
							<div class="span9">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a href="#home">Description</a></li>
									<li class=""><a href="#profile">Additional Information</a></li>
								</ul>							 
								<div class="tab-content">
									<div class="tab-pane active" id="home"><%=phone.getMoredetail()%></div>
									<div class="tab-pane" id="profile">
										<table class="table table-striped shop_attributes">	
											<tbody>
												<tr class="">
													<th>Color</th>
													<td><%=phone.getColor()%></td>
												</tr>		
												<tr class="alt">
													<th>Memory</th>
													<td><%=phone.getMemory()%></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>							
							</div>						
							<div class="span9">	
								<br>
								<h4 class="title">
									<span class="pull-left"><span class="text"><strong>Related</strong> Products</span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel-1" data-slide="prev"></a><a class="right button" href="#myCarousel-1" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-1" class="carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails listing-products">
												<c:forEach items="${listdienthoai1}" var="phone" varStatus ="idx">
											
											<li class="span4">
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
						</c:if>
						
						<c:if test = "${sanpham == 'dongho'}" > 
						<div class="row">
							<div class="span4">
								<input type="hidden" value="<%=watch.getMadongho()%>" name="madongho" /> 										
								<a class="thumbnail" data-fancybox-group="group1" title="<%=watch.getName()%>"><img src="data:image/jpg;base64,<%=watch.getHinhanh()%>"/></a>
							</div>
							<div class="span5">
								<address>
									<strong>Brand:</strong> <span><%=watch.getBrand()%></span><br>
									<strong>Product Name:</strong> <span><%=watch.getName()%></span><br>
									<strong>More Details:</strong> <span><%=watch.getHedieuhanh()%></span><br>
									<%
									if(watch.getSoluong() >= 0 )
									{
										
									
									%>
									<strong>Availability:</strong> <span>Available</span><br>
										<form class="form-inline">
											<p>&nbsp;</p>
											<label>Quantity:</label>
											<input type="number" name="quantity" value = "1"  class="span1" placeholder="1">
										</form>		
										<%
									}
									else {
										
										%>
										<strong>Availability:</strong> <span>Available</span><br>
										<%
									}
										%>							
								</address>									
								<h4><strong>Price: </strong><span><%=watch.getGiatien1()%></span></h4>
								<button class="btn btn-inverse" type="submit" >Add to cart</button>
							</div>						
						</div>
						<div class="row">
							<div class="span9">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a href="#home">Description</a></li>
									<li class=""><a href="#profile">Additional Information</a></li>
								</ul>							 
								<div class="tab-content">
									<div class="tab-pane active" id="home"><%=watch.getDetail()%></div>
									<div class="tab-pane" id="profile">
										<table class="table table-striped shop_attributes">	
											<tbody>
												<tr class="">
													<th>Màn Hình</th>
													<td><%=watch.getManhinh()%></td>
												</tr>		
												<tr class="alt">
													<th>Công nghệ màn hình</th>
													<td><%=watch.getCongnghemh()%></td>
												</tr>
												<tr class="alt">
													<th>Hệ điều hành</th>
													<td><%=watch.getHedieuhanh()%></td>
												</tr>
												<tr class="alt">
													<th>Brand</th>
													<td><%=watch.getBrand()%></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>							
							</div>						
							<div class="span9">	
								<br>
								<h4 class="title">
									<span class="pull-left"><span class="text"><strong>Related</strong> Products</span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel-1" data-slide="prev"></a><a class="right button" href="#myCarousel-1" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-1" class="carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails listing-products">
										<c:forEach items="${listdongho1}" var="dongho" varStatus ="idx">
											
											<li class="span4">
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
						</c:if>
						
						
						<c:if test = "${sanpham == 'ipad'}" > 
						<div class="row">
							<div class="span4">
								<input type="hidden" value="<%=ipad.getMaipad()%>" name="maipad" /> 										
								<a class="thumbnail" data-fancybox-group="group1" title="<%=ipad.getName()%>"><img src="data:image/jpg;base64,<%=ipad.getHinhanh()%>"/></a>
							</div>
							<div class="span5">
								<address>
									<strong>Brand:</strong> <span><%=ipad.getBrand()%></span><br>
									<strong>Product Name:</strong> <span><%=ipad.getName()%></span><br>
									<strong>More Details:</strong> <span><%=ipad.getHedieuhanh()%></span><br>
									<%
									if(ipad.getSoluong() >= 0 )
									{
										
									
									%>
									<strong>Availability:</strong> <span>Available</span><br>
										<form class="form-inline">
											<p>&nbsp;</p>
											<label>Quantity:</label>
											<input type="number" name="quantity" value = "1"  class="span1" placeholder="1">
										</form>		
										<%
									}
									else {
										
										%>
										<strong>Availability:</strong> <span>Available</span><br>
										<%
									}
										%>							
								</address>									
								<h4><strong>Price: </strong><span><%=ipad.getGiatien1()%></span></h4>
								<button class="btn btn-inverse" type="submit" >Add to cart</button>
							</div>						
						</div>
						<div class="row">
							<div class="span9">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a href="#home">Description</a></li>
									<li class=""><a href="#profile">Additional Information</a></li>
								</ul>							 
								<div class="tab-content">
									<div class="tab-pane active" id="home"><%=ipad.getDetail()%></div>
									<div class="tab-pane" id="profile">
										<table class="table table-striped shop_attributes">	
											<tbody>
												<tr class="">
													<th>Dung lượng</th>
													<td><%=ipad.getDungluong()%></td>
												</tr>		
												<tr class="alt">
													<th>Ram</th>
													<td><%=ipad.getRam()%></td>
												</tr>
												<tr class="alt">
													<th>Hệ điều hành</th>
													<td><%=ipad.getHedieuhanh()%></td>
												</tr>
												<tr class="alt">
													<th>Brand</th>
													<td><%=ipad.getBrand()%></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>							
							</div>						
							<div class="span9">	
								<br>
								<h4 class="title">
									<span class="pull-left"><span class="text"><strong>Related</strong> Products</span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel-1" data-slide="prev"></a><a class="right button" href="#myCarousel-1" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-1" class="carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails listing-products">
										<c:forEach items="${listipad1}" var="ipad" varStatus ="idx">
											
											<li class="span4">
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
						</c:if>
						
						<c:if test = "${sanpham == 'laptop'}" > 
						<div class="row">
							<div class="span4">
								<input type="hidden" value="<%=laptop.getMalaptop() %>" name="malaptop" /> 										
								<a class="thumbnail" data-fancybox-group="group1" title="<%=laptop.getName()%>"><img src="data:image/jpg;base64,<%=laptop.getHinhanh()%>"/></a>
							</div>
							<div class="span5">
								<address>
									<strong>Brand:</strong> <span><%=laptop.getBrand()%></span><br>
									<strong>Product Name:</strong> <span><%=laptop.getName()%></span><br>
									<strong>More Details:</strong> <span><%=laptop.getRam()%> GB</span><br>
									<%
									if(laptop.getSoluong() >= 0 )
									{
										
									%>
									<strong>Availability:</strong> <span>Available</span><br>
										<form class="form-inline">
											<p>&nbsp;</p>
											<label>Quantity:</label>
											<input type="number" name="quantity" value = "1"  class="span1" placeholder="1">
										</form>		
										<%
									}
									else {
										
										%>
										<strong>Availability:</strong> <span>Available</span><br>
										<%
									}
										%>							
								</address>									
								<h4><strong>Price: </strong><span><%=laptop.getGiatien1()%></span></h4>
								<button class="btn btn-inverse" type="submit" >Add to cart</button>
							</div>						
						</div>
						
						<div class="row">
							<div class="span9">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a href="#home">Description</a></li>
									<li class=""><a href="#profile">Additional Information</a></li>
								</ul>							 
								<div class="tab-content">
									<div class="tab-pane active" id="home"><%=laptop.getDetail()%></div>
									<div class="tab-pane" id="profile">
										<table class="table table-striped shop_attributes">	
											<tbody>
												<tr class="">
													<th>Chip đồ họa</th>
													<td><%=laptop.getChipdohoa()%></td>
												</tr>		
												<tr class="alt">
													<th>Phân giải</th>
													<td><%=laptop.getPhangiai()%></td>
												</tr>
												<tr class="alt">
													<th>Kích thước</th>
													<td><%=laptop.getKichthuoc()%></td>
												</tr>
												<tr class="alt">
													<th>Series</th>
													<td><%=laptop.getSeries()%></td>
												</tr>
												
											</tbody>
										</table>
									</div>
								</div>							
							</div>						
							<div class="span9">	
								<br>
								<h4 class="title">
									<span class="pull-left"><span class="text"><strong>Related</strong> Products</span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel-1" data-slide="prev"></a><a class="right button" href="#myCarousel-1" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-1" class="carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails listing-products">
													<c:forEach items="${listlaptop1}" var="laptop" varStatus ="idx">
											
											<li class="span4">
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
										<div class="item">
											<ul class="thumbnails listing-products">
												<li class="span3">
													<div class="product-box">
																								
														<a href="product_detail.html"><img alt="" src="Template/Backend/themes/images/iPhone/11 Pro Max Gold.jpg"></a><br/>
														<a href="product_detail.html" class="title">iPhone 11 Pro Max</a><br/>
														<a href="#" class="category">VN/A 512GB</a>
														<p class="price">$1599</p>
													</div>
												</li>       
												<li class="span3">
													<div class="product-box">
																								
														<a href="product_detail.html"><img alt="" src="Template/Backend/themes/images/iPhone/11 Pro Max Gold.jpg"></a><br/>
														<a href="product_detail.html" class="title">iPhone 11 Pro Max</a><br/>
														<a href="#" class="category">VN/A 512GB</a>
														<p class="price">$1599</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
																								
														<a href="product_detail.html"><img alt="" src="Template/Backend/themes/images/iPhone/11 Pro Max Gold.jpg"></a><br/>
														<a href="product_detail.html" class="title">iPhone 11 Pro Max</a><br/>
														<a href="#" class="category">VN/A 512GB</a>
														<p class="price">$1599</p>
													</div>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
						</c:if>
						
						
						</form>

					</div>
					<div class="span3 col">
						
						<div class="block">
							<h4 class="title">
								<span class="pull-left"><span class="text">Randomize</span></span>
								<span class="pull-right">
									<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
								</span>
							</h4>
							<div id="myCarousel" class="carousel slide">
								<div class="carousel-inner">
								<c:if test="${sanpham == 'phone'}">
									<%for(Phone phone1:list1)
								{
								%>
								<div class="item">
										<ul class="thumbnails listing-products">
											<li class="span3">
												<div class="product-box">										
													<p><a href="Productdetail_Controller?action=phone&id=<%=phone1.getIdphone() %>"><img src="data:image/jpg;base64,<%=phone1.getHinhanh() %>" width="250" height="250" alt="" /></a></p>
													<a href="Productdetail_Controller?action=phone&id=<%=phone1.getIdphone() %>" class="title"> <%=phone1.getName() %></a><br/>
													<a href="Productdetail_Controller?action=phone&id=<%=phone1.getIdphone() %>" class="category">VN/A <%=phone1.getMemory() %>  GB</a>
													<p class="price"> <%=phone1.getGiatien1() %> </p>
												</div>
											</li>
										</ul>
									</div>		
										<%
							}
							%>							
								
								</c:if>
								
								<c:if test="${sanpham == 'laptop'}">
								<%for(Laptop laptop1:list3)
								{
								%>
								<div class="item">
										<ul class="thumbnails listing-products">
											<li class="span3">
												<div class="product-box">										
													<p><a href="Productdetail_Controller?action=laptop&id=<%=laptop1.getMalaptop() %>"><img src="data:image/jpg;base64,<%=laptop1.getHinhanh() %>" width="250" height="250" alt="" /></a></p>
													<a href="Productdetail_Controller?action=laptop&id=<%=laptop1.getMalaptop() %>" class="title"> <%=laptop1.getName() %></a><br/>
													<a href="Productdetail_Controller?action=laptop&id=<%=laptop1.getMalaptop() %>" class="category"> <%=laptop1.getSeries()%></a>
													<p class="price"> <%=laptop1.getGiatien1() %> </p>
												</div>
											</li>
										</ul>
									</div>		
										<%
							}
							%>		
									</c:if>
									<c:if test="${sanpham == 'ipad'}">
									<%for(Ipad ipad1:list5)
								{
								%>
								<div class="item">
										<ul class="thumbnails listing-products">
											<li class="span3">
												<div class="product-box">										
													<p><a href="Productdetail_Controller?action=ipad&id=<%=ipad1.getMaipad() %>"><img src="data:image/jpg;base64,<%=ipad1.getHinhanh() %>" width="250" height="250" alt="" /></a></p>
													<a href="Productdetail_Controller?action=ipad&id=<%=ipad1.getMaipad() %>" class="title"> <%=ipad1.getName() %></a><br/>
													<a href="Productdetail_Controller?action=ipad&id=<%=ipad1.getMaipad() %>" class="category"><%=ipad1.getHedieuhanh() %></a>
													<p class="price"> <%=ipad1.getGiatien1() %> </p>
												</div>
											</li>
										</ul>
									</div>		
										<%
							}
							%>				
									</c:if>
									
									<c:if test="${sanpham == 'dongho'}">
									<%
									 for(Watch watch1:list7)
									{
									%>
									<div class="item">
											<ul class="thumbnails listing-products">
												<li class="span3">
													<div class="product-box">										
														<p><a href="Productdetail_Controller?action=ipad&id=<%=watch1.getMadongho() %>"><img src="data:image/jpg;base64,<%=watch1.getHinhanh() %>" width="250" height="250" alt="" /></a></p>
														<a href="Productdetail_Controller?action=ipad&id=<%=watch1.getMadongho()%>" class="title"> <%=watch1.getName() %></a><br/>
														<a href="Productdetail_Controller?action=ipad&id=<%=watch1.getMadongho()%>" class="category"><%=watch1.getHedieuhanh() %></a>
														<p class="price"> <%=watch1.getGiatien1() %> </p>
													</div>
												</li>
											</ul>
										</div>		
											<%
								}
								%>						
									</c:if>
		
								</div>
							</div>
						</div>
						<div class="block">								
							<h4 class="title"><strong>Best</strong> Seller</h4>								
							<ul class="small-product">
								<c:if test="${sanpham == 'phone'}">
								<%
							for(Phone phone1:list2)
							{
							%>
								<li>
									<a href="Productdetail_Controller?action=phone&id=<%=phone1.getIdphone() %>" title="">
										<img src="data:image/jpg;base64,<%=phone1.getHinhanh() %>" width="250" height="250" alt="">
									</a>
									<a href="Productdetail_Controller?action=phone&id=<%=phone1.getIdphone() %>"><%=phone1.getName()%></a>
								</li>
								<%
								}%>
								
								</c:if>
								
								<c:if test="${sanpham == 'laptop'}">
									<%
								for(Laptop laptop1:list4)
								{
								%>
									<li>
										<a href="Productdetail_Controller?action=laptop&id=<%=laptop1.getMalaptop() %>" title="">
											<img src="data:image/jpg;base64,<%=laptop1.getHinhanh() %>" width="250" height="250" alt="">
										</a>
										<a href="Productdetail_Controller?action=laptop&id=<%=laptop1.getMalaptop() %>"><%=laptop1.getName()%></a>
									</li>
								<%
								}%>
								
								</c:if>
								
								<c:if test="${sanpham == 'ipad'}">
									<%
							for(Ipad ipad1:list6)
							{
							%>
								<li>
									<a href="Productdetail_Controller?action=ipad&id=<%=ipad1.getMaipad() %>" title="">
										<img src="data:image/jpg;base64,<%=ipad1.getHinhanh() %>" width="250" height="250" alt="">
									</a>
									<a href="Productdetail_Controller?action=ipad&id=<%=ipad1.getMaipad() %>"><%=ipad1.getName()%></a>
								</li>
								<%
								}%>
								
								</c:if>
								
								<c:if test="${sanpham == 'dongho'}">
								
								<%
							for(Watch watch1:list8)
							{
							%>
								<li>
									<a href="Productdetail_Controller?action=dongho&id=<%=watch1.getMadongho() %>" title="">
										<img src="data:image/jpg;base64,<%=watch1.getHinhanh() %>" width="250" height="250" alt="">
									</a>
									<a href="Productdetail_Controller?action=dongho&id=<%=watch1.getMadongho() %>"><%=watch1.getName()%></a>
								</li>
								<%
								}%>
								
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</section>			
			<section id="footer-bar">
				<div class="row">
				
					<div class="span3">
						<h4>Product</h4>
						<ul class="nav">
							<li><a href="phone.html">Phone</a></li>
							<li><a href="tablet.html">Tablet</a></li>
							<li><a href="macbook.html">Macbook</a></li>
							<li><a href="watch.html">Watch</a></li>
						</ul>
					</div>
					<div class="span3">
						<h4>Account</h4>
						<ul class="nav">
							<li><a href="register.html">Login & Register</a></li>
							<li><a href="cart.html">Cart</a></li>
							<li><a href="checkout.html">Checkout</a></li>
							
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
			$(function () {
				$('#myTab a:first').tab('show');
				$('#myTab a').click(function (e) {
					e.preventDefault();
					$(this).tab('show');
				})
			})
			$(document).ready(function() {
				$('.thumbnail').fancybox({
					openEffect  : 'none',
					closeEffect : 'none'
				});
				
				$('#myCarousel-2').carousel({
                    interval: 2500
                });								
			});
		</script>
</body>
</html>