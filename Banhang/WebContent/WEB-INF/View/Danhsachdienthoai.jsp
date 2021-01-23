<%@page import="BEAN.Phone"%>
    <%@page import="DAO.ThemDienThoaiDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Danh sách điện thoại</title>


	
    <link href="Template/Backend/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="Template/Backend/assets/css/font-awesome.css" rel="stylesheet" />
	
    <link href="Template/Backend/assets/css/select2.min.css" rel="stylesheet" >
	<link href="Template/Backend/assets/css/checkbox3.min.css" rel="stylesheet" >
        <!-- Custom Styles-->
    <link href="Template/Backend/assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    	<script src="Template/Backend/themes/js/jquery-1.7.2.min.js"></script>
		<script src="Template/Backend/themes/js/jquery.twbsPagination.js" type="text/javascript"></script>
		<script src="Template/Backend/bootstrap/js/bootstrap.min.js"></script>				
		<script src="Template/Backend/themes/js/superfish.js"></script>	
	
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
                                        <div class="title">Danh sách điện thoại.</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                <form action="ThemDienThoaiController" method = "get">
								<%=request.getAttribute("mess")!=null?request.getAttribute("mess"):"" %>
                                <table border=2 align="center">
								 	<thead>
								 		<th> Mã đồng hồ </th>
								 		<th> Name </th>
								 		<th> Brand </th>
								 		<th> Quantity </th>
								 		<th> Color </th>
								 		<th> Memory </th>
								 		<th> Price </th>
								 		<th> More Detail </th>
								 		<th> Hình ảnh </th>
								 	</thead>
								
								  	<c:forEach items="${list}" var="phone" varStatus ="idx">  
									
									<tbody>		
								 		<tr>
								 			<td>${phone.getIdphone()}</td>
								 			<td>${phone.getName()}</td>
								 			<td>${phone.getBrand()}</td>
								 			<td>${phone.getQuantity()}</td>
								 			<td>${phone.getColor()}</td>
								 			<td>${phone.getMemory()}</td>
								 			<td>${phone.getGiatien1()}</td>		 			
								 			<td>${phone.getMoredetail() }</td>
								 			<td><img src="data:image/jpg;base64,${phone.getHinhanh()}" width="150" height="150"/> </td>
								 			
								 			<td><a href="ThemDienThoaiController?action=xoa&id=${phone.getIdphone()}">Xóa</a> 
								 				<a href="SuaDienThoaiController?action=sua&id=${phone.getIdphone()}">Sửa</a> 
								 			 </td>
								 			
								 			
								 		</tr>
							
								  	</c:forEach> 
							 		</tbody>
														 		
 								</table>
                      
                          
							</div>
								
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