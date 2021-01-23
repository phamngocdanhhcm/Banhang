<%@page import="DB.DBConnection"%>
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
        <%@page import="DB.DBConnection" %>
        
    <%@page import="DAO.ThemDienThoaiDAO"%>
    <%@page import="DAO.ThemLaptopDAO"%>
    <%@page import="DAO.ThemIpadDAO"%>
    <%@page import="DAO.ThemDongHoDAO"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>Đồng Hồ</title>
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
		<script src="Template/Backend/themes/js/jquery.twbsPagination.js" type="text/javascript"></script>
		<script src="Template/Backend/bootstrap/js/bootstrap.min.js"></script>				
		<script src="Template/Backend/themes/js/superfish.js"></script>	
	
		<style>
		ul.pagination {
		    display: inline-block;
		    padding: 0;
		    margin: 0;
		}
		
		ul.pagination li {display: inline;}
		
		ul.pagination li a {
		    color: black;
		    float: left;
		    padding: 8px 16px;
		    text-decoration: none;
		}
		</style>
	
</head>
<body>

		<%
			Connection conn =  DBConnection.CreateConnection();
			ThemDongHoDAO daodongho = new ThemDongHoDAO();
			List<Watch> arr = daodongho.getAll(conn);
			int start = 0 , end = 9;
			if(arr.size() < 9)
			{
				end = arr.size();
			}
			else {
				
			}
			if(request.getParameter("start") != null)
			{
				start = Integer.parseInt(request.getParameter("start"));
			}
			if(request.getParameter("end") != null)
			{
				end = Integer.parseInt(request.getParameter("end"));
			}
			List<Watch> list = daodongho.getListByPage(arr, start, end);
			List<Watch> list1 = daodongho.getProductRandom();
			
			List<Watch> list2 = daodongho.getProductSeller();
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
			
				<h4><span>Phone products	</span></h4>
			</section>
			<section class="main-content">
				
				<div class="row">	
								
					<div class="span9">	
											
						<ul class="thumbnails listing-products">
						<%
				for(Watch watch: list)
				{
				%>		
							<li class="span3">
							<div class="product-box">
								<span class="sale_tag"></span>
								<p><a href="Productdetail_Controller?action=dongho&id=<%=watch.getMadongho() %>"><img src="data:image/jpg;base64,<%=watch.getHinhanh() %>" width="250" height="250" alt="" /></a></p>
								<a href="Productdetail_Controller?action=dongho&id=<%=watch.getMadongho() %>" class="title"> <%=watch.getName() %></a><br/>
								<a href="Productdetail_Controller?action=dongho&id=<%=watch.getMadongho() %>" class="category"><%=watch.getHedieuhanh() %> </a>
								<p class="price"> <%=watch.getGiatien1() %> </p>
							</div>
							</li>
							
							
							<%
				}
				%>  
						</ul>		
						<div style="clear:both"></div>
						<ul class="pagination">
							<%
								int a , b;
								int limit = arr.size() / 9 ;
								if(limit * 9 < arr.size())
								{
									limit += 1;
									
								}
								for(int i = 1 ; i <= limit ; i++)
								{
									a = (i-1)*9;
									b = i * 9;
									if(b>arr.size())
									{
										b= arr.size();
									}
								
							%>
							<li> <a href="DonghoForward?start=<%=a%>&end=<%=b%>"><%=i%></a></li>
							<%
								}
							%>
						</ul>						
						<hr>
						
							 
				
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
									<%
									 for(Watch watch:list1)
									{
									%>
									<div class="item">
											<ul class="thumbnails listing-products">
												<li class="span3">
													<div class="product-box">										
														<p><a href="Productdetail_Controller?action=ipad&id=<%=watch.getMadongho() %>"><img src="data:image/jpg;base64,<%=watch.getHinhanh() %>" width="250" height="250" alt="" /></a></p>
														<a href="Productdetail_Controller?action=ipad&id=<%=watch.getMadongho()%>" class="title"> <%=watch.getName() %></a><br/>
														<a href="Productdetail_Controller?action=ipad&id=<%=watch.getMadongho()%>" class="category"><%=watch.getHedieuhanh() %></a>
														<p class="price"> <%=watch.getGiatien1() %> </p>
													</div>
												</li>
											</ul>
										</div>		
											<%
								}
								%>						
								</div>
							</div>
						</div>
						<div class="block">								
							<h4 class="title"><strong>Best</strong> Seller</h4>								
							<ul class="small-product">
								<%
							for(Watch watch:list2)
							{
							%>
								<li>
									<a href="Productdetail_Controller?action=dongho&id=<%=watch.getMadongho() %>" title="">
										<img src="data:image/jpg;base64,<%=watch.getHinhanh() %>" width="250" height="250" alt="">
									</a>
									<a href="Productdetail_Controller?action=dongho&id=<%=watch.getMadongho() %>"><%=watch.getName()%></a>
								</li>
								<%
								}%>
							</ul>
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
		
		
	<div class="container">
    <nav aria-label="Page navigation">
        <ul class="pagination" id="pagination"></ul>
    </nav>
	</div>

		<script src="Template/Backend/themes/js/common.js"></script>
</body>
</html>