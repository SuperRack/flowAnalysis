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

	<!-- treeTable  树形表格 -->
	<link href="${basePath }/treeTable/themes/vsStyle/treeTable.min.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div id="wrapper">
         <jsp:include page="../base/nav.jsp"></jsp:include>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="${basePath}/flow/findUpDownByPro"><i class="fa fa-dashboard"></i> 年份流量统计</a>
                    </li>
                    <li>
                        <a href="${basePath}/area/test"><i class="fa fa-bar-chart-o"></i> 地区流量统计</a>
                    </li>
					<li>
                        <a href="${basePath }/user/findAll"><i class="fa fa-user fa-fw"></i> 用户管理模块</a>
                    </li>
                    <li class="active-menu">
                        <a href="${basePath }/area/findParent"><i class="fa fa-table"></i> 地区管理模块</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
            	<div>
            		<h2 class="user-title">地区信息管理</h2>
            	</div>
            	<div class="table-div">
                    <table id="treeTable" class="table table-striped table-bordered table-condensed">
                        <thead>
                            <tr>
                            	<th>编号</th>
                                <th>ID值</th>
                                <th>地区名称</th>
                                <th>上级地区</th>
                            </tr>
                        </thead>
                        <tbody id="treeTableList">
                        	<c:forEach var="area" items="${areas}" varStatus="vs">
	                            <tr id="${area.id }" pId="${area.parentId }">
	                                <td>${vs.count }</td>
	                                <td>${area.id }</td>
	                                <td>${area.name }</td>
	                                <td>${area.parentId }</td>
	                            </tr>
	                         </c:forEach>
                        </tbody>
                    </table>
                </div>
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
    <script src="${basePath }/treeTable/jquery.treeTable.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$("#treeTable").treeTable({expandLevel : 1});
	</script>
</body>
</html>