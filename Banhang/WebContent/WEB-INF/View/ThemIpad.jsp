<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm ipad</title>
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
        <div id="page-wrapper" >

		
            <div id="page-inner"> 
                       <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Thêm mới Ipad.</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                <form action="ThemIpadController" method="POST" enctype="multipart/form-data">
                                 <%=request.getAttribute("mess")!=null?request.getAttribute("mess"):" " %>
                                    
                                    <div class="sub-title">Tên</div>
                                    <div>
                                        <textarea class="form-control" name="name" placeholder="Tên Ipad"></textarea>
                                    </div>
                                    <div class="sub-title">Brand</div>
                                    <div>
                                        <textarea class="form-control" name="brand" placeholder="Brand"></textarea>
                                    </div>
                                    <div class="sub-title">Dung lượng</div>
                                    <div>
                                        <textarea class="form-control" name="dungluong" placeholder="Dung lượng"></textarea>
                                    </div>
                                    <div class="sub-title">Hệ điều hành</div>
                                    <div>
                                        <textarea class="form-control" name="hedieuhanh" placeholder="Hệ điều hành"></textarea>
                                    </div>
                                    <div class="sub-title">Ram</div>
                                    <div>
                                          <input type="number" class="form-control" name="ram" placeholder="Ram">
                                    </div>
                                    <div class="sub-title">Detail</div>
                                    <div>
                                        <textarea class="form-control" name="detail" placeholder="Detail"></textarea>
                                    </div>
                                    <div class="sub-title">Số lượng</div>
                                    <div>
                                        <input type="number" class="form-control" name="soluong" placeholder="số lượng">
                                    </div>
                                    <div class="sub-title">Giá</div>
                                    <div>
                                        <input type="number" class="form-control" name="giatien" placeholder="Giá">
                                    </div>
                                    <div class="sub-title">Hình ảnh</div>
                                    <div>
                                    <input type="file" name="photo" accept="image/*" onchange="loadFile(event)"><br/>
                                    </div>
                                    
                            
                                    <br>
									<div class="actions"><input tabindex="9" class="btn btn-inverse large" type="submit" value="Thêm mới"></div>
                                   
                                  
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