<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>
</head>
<body>
	<div class="container">
		<h1 class="form-heading">login Form</h1>
		<div class="login-form">
			
			<div class="main-div">
			<c:if test="${param.incorrectAccount !=null}">
			<div class="alert alert-danger">
				UserName or Password incorrect
			</div>
					</c:if>										
								
				<c:if test="${param.accessDenied !=null}">
			<div class="alert alert-danger">
				you Not Authorize
			</div>
					</c:if>								
																																								
<!-- 				<c:url var="post_url" value="/dang-nhap" /> -->

<%-- 				<form method="post" action="${post_url}" id="formlogin"> --%>
					<form action="j_spring_security_check" id="formLogin" method="post">
					<%-- <form action="<c:url value="/dang-nhap"/>" id="formLogin"
						method="post"> --%>
					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							name="j_username" placeholder="Tên đăng nhập">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="j_password" placeholder="Mật khẩu">
					</div>
					
					<input type="hidden" value=""  id="status" name="status" />
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>