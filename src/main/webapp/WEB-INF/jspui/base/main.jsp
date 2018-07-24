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
        <jsp:include page="./nav.jsp"></jsp:include>
        
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                    	<!-- class="active-menu" -->
                        <a href="${basePath }/flow/findUpDownByPro"><i class="fa fa-dashboard"></i> 年份流量统计</a>
                    </li>
                    <li>
                        <a href="${basePath }"><i class="fa fa-bar-chart-o"></i> 地区流量统计</a>
                    </li>
					<li>
                        <a href="${basePath }/user/findAll"><i class="fa fa-user fa-fw"></i> 用户管理模块</a>
                    </li>
                    <li>
                        <a href="${basePath }/area/findAll"><i class="fa fa-table"></i> 地区管理模块</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
            	<div class="row">
            	<div class="col-md-12">
                      <h1 class="page-header">
                          Dashboard <small>Summary of your App</small>
                      </h1>
						<ol class="breadcrumb">
						  <li><a href="#">Home</a></li>
						  <li><a href="#">Library</a></li>
						  <li class="active">Data</li>
						</ol>
                  </div>
            	<div class="col-md-12">
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-green green">
                            <div class="panel-left pull-left green">
                                <i class="fa fa-bar-chart-o fa-5x"></i>
                                
                            </div>
                            <div class="panel-right pull-right">
								<h3>8,457</h3>
                               <strong> Daily Visits</strong>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-blue blue">
                              <div class="panel-left pull-left blue">
                                <i class="fa fa-shopping-cart fa-5x"></i>
								</div>
                                
                            <div class="panel-right pull-right">
							<h3>52,10 </h3>
                               <strong> Sales</strong>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-red red">
                            <div class="panel-left pull-left red">
                                <i class="fa fa fa-comments fa-5x"></i>
                               
                            </div>
                            <div class="panel-right pull-right">
							 <h3>15,23 </h3>
                               <strong> Comments </strong>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-brown brown">
                            <div class="panel-left pull-left brown">
                                <i class="fa fa-users fa-5x"></i>
                                
                            </div>
                            <div class="panel-right pull-right">
							<h3>36,75 </h3>
                             <strong>No. of Visits</strong>

                            </div>
                        </div>
                    </div>
                </div>
            	<div class="col-md-12">
	                <div class="panel panel-default">
	                    <div class="panel-heading">系统资源统计分析</div>
	                    <div class="panel-body">
	                        <p>内存使用率:40%</p>
	                        <div class="progress">
	                            <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
	                                <span class="sr-only">40% Complete (success)</span>
	                            </div>
	                        </div>
	                        <p>数据库使用率:20%</p>
	                        <div class="progress">
	                            <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
	                                <span class="sr-only">20% Complete</span>
	                            </div>
	                        </div>
	                        <p>磁盘使用率:60%</p>
	                        <div class="progress">
	                            <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
	                                <span class="sr-only">60% Complete (warning)</span>
	                            </div>
	                        </div>
	                        <p>CUP使用率:80%</p>
	                        <div class="progress">
	                            <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
	                                <span class="sr-only">80% Complete (danger)</span>
	                            </div>
	                        </div>
	                    </div>
	                </div>
            	</div>
				<!-- 服务器状态  end-->
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
</body>
</html>