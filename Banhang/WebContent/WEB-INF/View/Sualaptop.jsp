<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="BEAN.Laptop" %>
    <%@page import="DAO.ThemLaptopDAO"%>
<!DOCTYPE html>
<html>
 
<head>
<meta charset="UTF-8">
<title>Sửa Laptop</title>
    <link href="Template/Backend/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="Template/Backend/assets/css/font-awesome.css" rel="stylesheet" />
	
    <link href="Template/Backend/assets/css/select2.min.css" rel="stylesheet" >
	<link href="Template/Backend/assets/css/checkbox3.min.css" rel="stylesheet" >
        <!-- Custom Styles-->
    <link href="Template/Backend/assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   
   
   <script>
            var loadFile = function (event) {
                var reader = new FileReader();
                reader.onload = function () {
                    var output = document.getElementById('output');
                    output.src = reader.result;
                };
                reader.readAsDataURL(event.target.files[0]);
            };// code display image upload
   </script>
   
</head>
<body>
	    <div id="wrapper">

		<jsp:include page="HeaderAdmin.jsp"></jsp:include>
        <!--/. NAV TOP  -->
   		<jsp:include page="SideAdmin.jsp"></jsp:include>
        <!-- /. NAV SIDE  -->
        <!-- /. NAV SIDE  -->
        <%
        Laptop laptop = new Laptop();
        laptop = (Laptop) request.getAttribute("list");        %>
         
        <div id="page-wrapper" >

		
            <div id="page-inner"> 
                       <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Sửa Laptop.</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                <form action="SualaptopController" method = "POST" enctype="multipart/form-data">
                                	
                                	<div class="sub-title">Mã laptop</div>
                                   <div>
                                        <input type="text" name="malaptop" readonly="readonly" class="form-control" value="<%=laptop.getMalaptop()%> ">
                                    </div>
                                    <div class="sub-title">Tên Laptop</div>
                                    <div>
                                        <input type="text" name="name" class="form-control" value="<%=laptop.getName()%>">
                                    </div>
                                    <div class="sub-title">Brand</div>
                                    <div>
                                        <input type="text" class="form-control" name="brand" value="<%=laptop.getBrand()%>">
                                    </div>
                                    
                                    <div class="sub-title">Ram</div>
                                    <div>
                                        <input type="number" class="form-control" name="ram" value="<%=laptop.getRam()%>">
                                    </div>

                                    <div class="sub-title">Chip đồ họa</div>
                                    <div>
                                         <input type="text" class="form-control" name="chipdohoa" value="<%=laptop.getChipdohoa()%>">
                                    </div>
                                    <div class="sub-title">Phân giải</div>
                                    <div>
                                         <input type="text" class="form-control" name="phangiai" value="<%=laptop.getPhangiai()%>">
                                    </div>
                                    <div class="sub-title">Kích thước</div>
                                    <div>
                                    <input type="text" class="form-control" name="kichthuoc" value="<%=laptop.getKichthuoc()%>">
                                    </div>
                                     <div class="sub-title">Series</div>
                                    <div>
                                    <input type="text" class="form-control" name="series" value="<%=laptop.getSeries()%>">
                                    </div>
                                     <div class="sub-title">Detail</div>
                                    <div>
                                    <input type="text" class="form-control" name="detail" value="<%=laptop.getDetail()%>">
                                    </div>
                                    <br>
                                    <div class="sub-title">Số lượng</div>
                                    <div>
                                    <input class="form-control" type="number" name="soluong" value="<%=laptop.getSoluong()%>"/>
                                    </div>
                                    <br>
                                    <div class="sub-title">Price</div>
                                    <div>
                                    <input class="form-control" type="number" name="giatien" value="<%=laptop.getGiatien()%>"/>
                                    </div>
                                    
                                    <div class="sub-title">Hình ảnh</div>
                                    <div>
                                    <img src="data:image/jpg;base64,<%=laptop.getHinhanh()%>" width="150" height="150"/>
                                    </div>
                                    <div>
                                    <input class="form-control" type="hidden" name="hinhanh" value="<%=laptop.getInputStream()%>"/>
                                    </div>
                                    <div>
                                    </div>
                                    <div>
                                    <input type="file" name="photo" accept="image/*" onchange="loadFile(event)"><br/>
                                    </div>
                              
                                    <br>
									<div class="actions">
									<input tabindex="9" class="btn btn-inverse large" type="submit" value="Sửa">
									</div>
									<br>
									<div>
									<button> <a href="DanhsachlaptopForward">Quay lại</a></button>
									</div>
                                 </form>
                                 
                                </div>
                            </div>
                        </div>
                    </div>
      
     
               
			<footer><p> </p></footer>
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