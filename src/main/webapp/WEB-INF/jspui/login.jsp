<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="base/base.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<title>流量分析-后台登录</title>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	 <div class="main">
		<div class="login-form">
			<h1>登录</h1>
			<div class="head">
				<img src="images/user.png" alt=""/>
			</div>
			<form action="${basePath }/user/login" method="post">
				<p class="login_error">${LOGIN_ERROR }</p>
				<input type="text" name="loginName" class="text" placeholder="用户名">
				<input type="password" name="pwd" class="text" placeholder="密码">
				<div class="submit">
					<input type="submit" value="LOGIN" >
				</div>
				<p>
					<a href="#">忘记密码</a>
				</p>
			</form>
			<c:set var="LOGIN_ERROR" value="" scope="session"></c:set>
		</div>
	</div>
</body>
</html>