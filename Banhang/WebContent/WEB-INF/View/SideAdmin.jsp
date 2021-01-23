<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <!-- Bootstrap Styles-->
    <link href="Template/Backend/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="Template/Backend/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="Template/Backend/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="Template/Backend/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="Template/Backend/assets/js/Lightweight-Chart/cssCharts.css"> 
</head>
<body>
	<nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a href="DanhsachtaikhoanController"><i class="fa fa-desktop"></i> Thành viên</a>
                    </li> 
					 
					 <li>
                        <a href="#"><i class="fa fa-sitemap"></i> Cập nhật sản phẩm<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="ThemDienThoaiForward">Điện thoại</a>
                            </li>
                            <li>
                                <a href="ThemLaptopForward">Laptop</a>
                            </li>
                            <li>
                                <a href="ThemIpadForward">Ipad</a>
                            </li>
                            <li>
                                <a href="ThemDongHoForward">Đồng hồ</a>
                            </li>
							</ul>
					</li>	
							
                    <li>
                        <a href="DanhsachdonhangForward"><i class="fa fa-qrcode"></i> Đơn đặt hàng</a>
                    </li>


                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> Kho<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="DanhsachdienthoaiForward">Điện thoại</a>
                            </li>
                            <li>
                                <a href="DanhsachlaptopForward">Laptop</a>
                            </li>
                            <li>
                                <a href="DanhsachipadForward">Ipad</a>
                            </li>
                            <li>
                                <a href="DanhsachdonghoForward">Đồng hồ</a>
                            </li>
                        </ul>
                    </li>
                    
                </ul>

            </div>

        </nav>
</body>
</html>