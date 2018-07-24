<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath }" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>流量分析-后台管理</title>
    <!-- Bootstrap Styles-->
    <link href="${basePath }/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${basePath }/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${basePath }/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${basePath }/assets/css/custom-styles.css" rel="stylesheet" />
    <link href="${basePath }/css/myStyle.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>

<body>
    <div id="wrapper">
         <jsp:include page="../base/nav.jsp"></jsp:include>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                    	<!-- class="active-menu" -->
                        <a href="${basePath}/flow/findUpDownByPro"><i class="fa fa-dashboard"></i> 年份流量统计</a>
                    </li>
                    <li>
                        <a href="${basePath}/area/test"><i class="fa fa-bar-chart-o"></i> 地区流量统计</a>
                    </li>
					<li class="active-menu">
                        <a href="${basePath }/user/findAll"><i class="fa fa-user fa-fw"></i> 用户管理模块</a>
                    </li>
                    <li>
                        <a href="${basePath }/area/findParent"><i class="fa fa-table"></i> 地区管理模块</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
            	<div>
            		<h2 class="user-title">用户更新</h2>
            	</div>
				<div class="userUpdate">
					<form class="form-horizontal" method="post" action="${basePath }/user/update">
					  <input type="hidden" name="id" value="${user.id }">
					  <div class="form-group">
					    <label for="loginname" class="col-sm-2 control-label">登录名</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="loginName" value="${user.loginName }" id="loginname" placeholder="NewLoginName">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="name" class="col-sm-2 control-label">真实姓名</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="name" value="${user.name }" id="name" placeholder="name">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="pwd" class="col-sm-2 control-label">密码</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" name="pwd" id="pwd" placeholder="输入即修改原始密码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="email" class="col-sm-2 control-label">邮箱</label>
					    <div class="col-sm-10">
					      <input type="email" class="form-control" name="email" value="${user.email }" id="email" placeholder="new email">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="phone" class="col-sm-2 control-label">用户号码</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="phone" value="${user.phone }" id="phone" placeholder="new phone">
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-success"> &nbsp; 修&nbsp;改 &nbsp;</button> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					      <a href="javascript:history.back(-1)" class="btn btn-success"> &nbsp; 返&nbsp;回 &nbsp;</a>
					    </div>
					  </div>
					</form>
				</div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="${basePath }/assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="${basePath }/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="${basePath }/assets/js/jquery.metisMenu.js"></script>
    <!-- Custom Js -->
    <script src="${basePath }/assets/js/custom-scripts.js"></script>
	
	<c:if test="${updateStatus == 'ok' }">
		<script type="text/javascript">
			alert("用户信息修改成功!");
		</script>
	</c:if>
</body>
</html>