<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Laptop</title>
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
                                        <div class="title">Thêm mới laptop.</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                <form action="ThemLaptopController" method="POST" enctype="multipart/form-data">
                                 <%=request.getAttribute("mess")!=null?request.getAttribute("mess"):" " %>
                                 
                                    <div class="sub-title">Tên</div>
                                    <div>
                                        <textarea class="form-control" name="name" placeholder="Tên laptop"></textarea>
                                    </div>
                                    <div class="sub-title">Thương hiệu</div>
                                    <div>
                                        <textarea class="form-control" name="brand" placeholder="Thương hiệu"></textarea>
                                    </div>
                                    
                                    <div class="sub-title">Dung lượng Ram</div>
                                    <div>
                                        <input type="number" class="form-control" name="ram" placeholder="Ram">
                                    </div>
                                    <div class="sub-title">Chip đồ họa rời</div>
                                    <div>
                                        <textarea class="form-control" name="chipdohoa" placeholder="Chip đồ họa rời"></textarea>
                                    </div>
                                    <div class="sub-title">Chuẩn phân giải</div>
                                    <div>
                                        <textarea class="form-control" name="phangiai" placeholder="Chuẩn phân giải"></textarea>
                                    </div>
                                    <div class="sub-title">Kích thước màn hình</div>
                                    <div>
                                        <input type="text" name="kichthuoc" class="form-control" placeholder="Kích thước màn hình">
                                    </div>
                                    <div class="sub-title">Series CPU</div>
                                    <div>
                                        <input type="text" class="form-control" name="series" placeholder="Series CPU">
                                    </div>
                                    <div class="sub-title">Detail</div>
                                    <div>
                                        <input type="text" class="form-control" name="detail" placeholder="Detail">
                                    </div>
                                       <div class="sub-title">Số lượng</div>
                                    <div>
                                    <input class="form-control" type="number" name="quantity" placeholder="Số lượng"/>
                                    </div>
                                    <br>
                                    <div class="sub-title">Price</div>
                                    <div>
                                    <input class="form-control" type="number" name="giatien" placeholder="Price"/>
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
      
     
               
			<footer><p>Cái này là em code nha thầy :> </p></footer>
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