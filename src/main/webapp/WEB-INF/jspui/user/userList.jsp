<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="request"></c:set>
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
            		<h2 class="user-title">用户管理</h2>
            		
            	</div>
            	<div class="form-div">
            		<form class="form-inline" method="post" action="${basePath }/user/findQuery">
					  <div class="form-group">
					    <label for="loginName">用户名：</label>
					    <input type="text"  name="name" class="form-control input-sm" id="loginName" placeholder="name">
					  </div>
					  <div class="form-group">
					    <label for="email">邮箱：</label>
					    <input type="email" name="email" class="form-control input-sm" id="email" placeholder="email">
					  </div>
					  <div class="form-group">
					    <label for="phone">手机号：</label>
					    <input type="text" name="phone" class="form-control input-sm" id="phone" placeholder="phone">
					  </div>
					  <div class="form-group">
					    <label for="status">状态：</label>
						   	<select class="form-control input-sm" name="status" id="status">
						   		<option value="">请选择</option>
						   		<option value="0">正常</option>
						   		<option value="1">禁用</option>
						   	</select> 
					   	</div>
					  <button type="submit" class="btn btn-default input-sm">查询</button>
					</form>
            	</div>
            	<div class="table-div">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>编号</th>
                                <th>登录名</th>
                                <th>用户名</th>
                                <th>邮箱</th>
                                <th>手机号</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="user" items="${userList }" varStatus="vs">
	                            <tr>
	                                <td>${vs.count }</td>
	                                <td>${user.loginName }</td>
	                                <td>${user.name }</td>
	                                <td>${user.email }</td>
	                                <td>${user.phone }</td>
	                                <td id="${user.id }">
	                                	<c:if test="${user.status == '0' }">
	                                		正常
	                                	</c:if>
										<c:if test="${user.status == '1' }">
	                                		禁用
	                                	</c:if>	                                	
	                                </td>
	                                <td>
	                                    <div class="btn-group" role="group">
	                                        <button type="button" class="btn btn-default dropdown-toggle input-sm" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                           	 操作
	                                            <span class="caret"></span>
	                                        </button>
	                                        <ul class="dropdown-menu">
	                                            <li><a href="${basePath }/user/editUser/${user.id}">编辑</a></li>
	                                            <c:if test="${user.status =='0' }">
		                                            <li><a onclick="updateStatus('${user.id}','1')">禁用</a></li>
	                                            </c:if>
	                                            <c:if test="${user.status =='1' }">
		                                            <li><a onclick="updateStatus('${user.id}','0')">启用</a></li>
	                                            </c:if>
	                                        </ul>
	                                    </div>
	                                </td>
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
    
	<script type="text/javascript">
		//获取要修改的节点ID与要修改的状态
		function updateStatus(id,status){
			if(window.confirm("你确定要修改吗？")){
				$.post("${basePath}/user/updateStatus",{"id":id,"status":status},function(msg){
					if(msg=="OK"){
						alert("修改成功!!!");
					}
				});
			}else{
				return false;
			}
		}
	</script>
</body>
</html>