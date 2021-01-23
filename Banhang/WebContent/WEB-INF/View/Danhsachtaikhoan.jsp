<%@page import="BEAN.Users"%>
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
<title>Danh sách tài khoản</title>
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
                                        <div class="title">Danh sách tài khoản.</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                <form action="DanhsachtaikhoanController" method = "get">
								<%=request.getAttribute("mess")!=null?request.getAttribute("mess"):"" %>
                                <table border=2 align="center">
								 	<thead>
								 		<th> Mã tài khoản </th>
								 		<th> Username </th>
								 		<th> Password </th>
								 		<th> Tên </th>
								 		<th> Email </th>
								  		<th> Số điện thoại </th>
								 		<th> Quyền </th>  
								 		<th> Xóa </th>
								 		  
								 	</thead>
								 	
								 	<tbody>
			
								 	<c:forEach items="${list}" var="taikhoan" varStatus ="idx">
								 		<tr>
								 			<td>${taikhoan.idusers}</td>
								 			<td>${taikhoan.username}</td>
								 			<td>${taikhoan.password}</td>
								 			<td>${taikhoan.name}</td>
								 			<td>${taikhoan.email}</td>
								 			<td>${taikhoan.phone}</td>
								 			
								 				<c:if test="${taikhoan.categoryid == 1}">
								 			<td>Thành viên</td>
								 			</c:if>
								 			
								 			<c:if test="${taikhoan.categoryid == 2}">
								 			<td>Admin</td>
								 			</c:if>
								 			
								 		 
								 			<td><a href="DanhsachtaikhoanController?action=xoa&id=${taikhoan.idusers}">Xóa</a> 
								 				 
								 			 </td>
								 			
								 			
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