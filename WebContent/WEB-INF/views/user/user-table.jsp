<%@page import="com.myclass.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="<%=request.getContextPath()%>/static/plugins/images/favicon.png">
<title>Pixel Admin</title>
<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/static/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Menu CSS -->
<link
	href="<%=request.getContextPath()%>/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<!-- animation CSS -->
<link href="<%=request.getContextPath()%>/static/css/animate.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/static/css/style.css"
	rel="stylesheet">
<!-- color CSS -->
<link
	href="<%=request.getContextPath()%>/static/css/colors/blue-dark.css"
	id="theme" rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/custom.css">
</head>
<body>
	<!-- SIDE BAR -->
	<jsp:include page="../layout/preloader.jsp"></jsp:include>

	<!-- Page Content -->
	<div id="wrapper">
		<jsp:include page="../layout/navigation.jsp"></jsp:include>
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Danh sách thành viên</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
						<a href="<%=request.getContextPath()%>/user/add"
							class="btn btn-sm btn-success">Thêm mới</a>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /row -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<div class="table-responsive">
								<table class="table" id="example">
									<thead>
										<tr>
											<th>STT</th>
											<th>FullName</th>
											<th>Email</th>
											<th>Avatar</th>
											<th>Role</th>
											<th>#</th>
										</tr>
									</thead>
									<%
										List<UserDto> users = (List<UserDto>) request.getAttribute("users");
									%>
									<tbody>
										<%
											for (UserDto user : users) {
										%>
										<tr>
											<td><%=user.getId()%></td>
											<td><%=user.getFullName()%></td>
											<td><%=user.getEmail()%></td>
											<td><%=user.getAvatar()%></td>
											<td><%=user.getRoleDesc()%></td>
											<td><a
												href="<%=request.getContextPath()%>/user/edit?id=<%=user.getId()%>"
												class="btn btn-sm btn-primary">Sửa</a> <a
												href="<%=request.getContextPath()%>/user/delete?id=<%=user.getId()%>"
												class="btn btn-sm btn-danger">Xóa</a> <a
												href="user-details.html" class="btn btn-sm btn-info">Xem</a>
											</td>
										</tr>
										<%
											}
										%>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
			<footer class="footer text-center"> 2018 &copy; myclass.com
			</footer>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/static/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/static/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script
		src="<%=request.getContextPath()%>/static/js/jquery.slimscroll.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/js/jquery.dataTables.js"></script>
	<!--Wave Effects -->
	<script src="<%=request.getContextPath()%>/static/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="<%=request.getContextPath()%>/static/js/custom.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
</body>
</html>