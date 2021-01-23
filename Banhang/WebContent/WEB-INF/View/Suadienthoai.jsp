<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="BEAN.Phone" %>
    <%@page import="DAO.ThemDienThoaiDAO"%>
<!DOCTYPE html>
<html>
 
<head>
<meta charset="UTF-8">
<title>Sửa điện thoại</title>
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
        Phone phone = new Phone();
        phone = (Phone) request.getAttribute("list");        %>
         
        <div id="page-wrapper" >

		
            <div id="page-inner"> 
                       <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Sửa thông tin điện thoại.</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                <form action="SuaDienThoaiController" method = "POST" enctype="multipart/form-data">
                                	
                                	<div class="sub-title">Mã điện thoại</div>
                                    <div>
                                    <input class="form-control" type="number" readonly="readonly" name="idphone" value="<%=phone.getIdphone()%>"/>
                                    </div>       
                                    <div class="sub-title">Tên điện thoại</div>
                                    <div>
                                        <input type="text" name="name" class="form-control" value="<%=phone.getName()%>">
                                    </div>
                                    <div class="sub-title">Brand</div>
                                    <div>
                                        <input type="text" class="form-control" name="brand" value="<%=phone.getBrand()%>">
                                    </div>
                                    
                                    <div class="sub-title">More Detail</div>
                                    <div>
                                        <input type="text" class="form-control" name="moredetail" value="<%=phone.getMoredetail()%>">
                                    </div>

                                    <div class="sub-title">Color</div>
                                    <div>
                                         <input type="text" class="form-control" name="color" value="<%=phone.getColor()%>">
                                    </div>
                                    <div class="sub-title">Memory</div>
                                    <div>
                                         <input type="number" class="form-control" name="memory" value="<%=phone.getMemory()%>">
                                    </div>
                                    <div class="sub-title">Số lượng</div>
                                    <div>
                                    <input class="form-control" type="number" name="quantity" value="<%=phone.getQuantity()%>"/>
                                    </div>
                                    <br>
                                    <div class="sub-title">Price</div>
                                    <div>
                                    <input class="form-control" type="number" name="giatien" value="<%=phone.getGiatien()%>"/>
                                    </div>
                                    
                                    <div class="sub-title">Hình ảnh</div>
                                    <div>
                                    <img src="data:image/jpg;base64,<%=phone.getHinhanh()%>" width="150" height="150"/>
                                    </div>
                                    <div>
                                    <input class="form-control" type="hidden" name="hinhanh" value="<%=phone.getInputStream()%>"/>
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
									<button> <a href="DanhsachdienthoaiForward">Quay lại</a></button>
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