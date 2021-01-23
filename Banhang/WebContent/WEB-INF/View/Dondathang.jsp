<%@page import="BEAN.Phone"%>
    <%@page import="DAO.ThemDienThoaiDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Đơn đặt hàng.</title>


	
    <link href="Template/Backend/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="Template/Backend/assets/css/font-awesome.css" rel="stylesheet" />
	
    <link href="Template/Backend/assets/css/select2.min.css" rel="stylesheet" >
	<link href="Template/Backend/assets/css/checkbox3.min.css" rel="stylesheet" >
        <!-- Custom Styles-->
    <link href="Template/Backend/assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   
       <style type="text/css">
        table, th, td{
            border:1px solid #ccc;
        }
        table{
            border-collapse:collapse;
            width:100%;
        }
        th, td{
            text-align:left;
            padding:10px;
        }
        tr:hover{
            background-color:#ddd;
            cursor:pointer;
        }
      
    </style>
</head>
<body>


	    <div id="wrapper">

		<jsp:include page="HeaderAdmin.jsp"></jsp:include>
        <!--/. NAV TOP  -->
   		<jsp:include page="SideAdmin.jsp"></jsp:include>
        <!-- /. NAV SIDE  -->
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >

		
            <div id="page-inner"> 
                       <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Danh sách đơn đặt hàng</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                <form action="ThemDienThoaiController" method = "get">
                                <table border=2 align="center">
								 	<thead>
								 		<th> Xóa </th>
								 		<th> Mã đơn hàng </th>
								 		<th> Tên khách hàng </th>
								 		<th> Số điện thoại </th>
								 		<th> Địa chỉ </th>
								 		<th> Email </th>
								 		<th> Tổng tiền </th>
								 		<th> Chi tiết đơn hàng </th>
								 		<th> Tình trạng</th>
								 	</thead>
								 	
								 	<tbody>
			
								 	<c:forEach items="${list}" var="donhang" varStatus ="idx">
								 		
								 		
								 		<tr>
								 			<c:if test = "${donhang.tinhtrang == 'notconfirm'}" > 
								 			<td><a href="DanhsachdonhangController?action=xoa&id=${donhang.madonhang}"> Xóa </a>   </td> 
								 			</c:if>
								 			<c:if test = "${donhang.tinhtrang == 'confirm'}" > 
								 			<td></td> 
								 			</c:if>
								 			<td>${donhang.madonhang}</td>
								 			<td>${donhang.tenkhachhang}</td>
								 			<td>${donhang.sodienthoai}</td>
								 			<td>${donhang.diachi}</td>
								 			<td>${donhang.email}</td>
								 			<td>${donhang.tongtien}</td>
								 			
								 			<td>
								 			<a href="ChitietdonhangController?action=chitietdonhang&id=${donhang.madonhang}">Xem</a> 
								 			 </td>
								 			 
								 			<c:if test = "${donhang.tinhtrang == 'notconfirm'}" > 
								 			 <td>
								 			<a href="DanhsachdonhangController?action=xacnhan&id=${donhang.madonhang}">Xác nhận</a> 
											</td>
								 			</c:if>
								 			
								 			<c:if test = "${donhang.tinhtrang == 'confirm'}" > 
								 			
								 			<td>Đã xác nhận</td> 
											
								 			</c:if>
								 			
								 		</tr>
								 		
								 	</c:forEach>
							 	</tbody>
 								</table>
                                  
                                 </form>
                                </div>
                            </div>
                        </div>
                    </div>
      
     
               
			<footer><p></p></footer>
			</div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>

    <script src="Template/Backend/assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="Template/Backend/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="Template/Backend/assets/js/jquery.metisMenu.js"></script>
	<script src="Template/Backend/assets/js/select2.full.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	  $(".selectbox").select2();
	});
	</script>
      <!-- Custom Js -->
    <script src="Template/Backend/assets/js/custom-scripts.js"></script> 
	
		
</body>
</html>