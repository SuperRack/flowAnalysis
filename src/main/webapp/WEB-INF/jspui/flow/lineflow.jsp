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
                    <li class="active-menu">
                        <a href="${basePath }/flow/findUpDownByPro"><i class="fa fa-dashboard"></i> 年份流量统计</a>
                    </li>
                    <li>
                        <a href="${basePath}/area/test"><i class="fa fa-bar-chart-o"></i> 地区流量统计</a>
                    </li>
					<li>
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
				 <div class="col-md-12" style="margin-bottom:20px;">
	                <h2 class="user-title">按年份流量分析</h2>
	                <ul class="nav nav-tabs">
	                	<li role="presentation"><a href="${basePath }/flow/findUpDownByPro">全部</a></li>
	                    <li role="presentation"><a href="${basePath }/flow/findFlowByPcPic">PC端流量</a></li>
	                    <li role="presentation" class="active"><a href="${basePath }/flow/findFlowByMobleLine">移动端流量</a></li>
	                </ul>
	            </div>
	            
	            <div class="seach-form" style="margin-left:20px;">
		            
	            </div>
	            <br/>
	            <h4 style="margin-left:20px;color:#d43f3a;">上行流量显示</h4><br/>
	            <div id="lineMain" style="margin-left:20px;width: 1100px;height:400px;"></div>
            	<br/>
            	<h4 style="margin-left:20px;color:#d43f3a;">下行流量显示</h4><br/>
	            <div id="lineMain2" style="margin-left:20px;width: 1100px;height:400px;"></div>
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
    <script src="${basePath }/js/echarts.min.js"></script>

 <script type="text/javascript">
 	var yearArr=new Array();
	//生成年份选择框
	for(i=2017;i>=2001;i--){
		var op=$("<option value="+i+">"+i+"</option>");
		$("#year").append(op);
	}
	for(i=2001;i<=2017;i++){
		yearArr.push(i);
	}	
</script>

<script type="text/javascript">		
	var app3 = echarts.init(document.getElementById('lineMain'));	
	option3 = {
	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:eval("("+'${prosJson }'+")")
	    },
	     toolbox: {
	   	    show:true,  //是否显示这个工具提示栏
	   	 	orient: 'vertical',
		    left: 'right',
	        top: 'center',
	   	    feature:{   //这个属性代表我们需要在工具栏中开启什么功能
	   	        dataView:{  //开启数据视图
	   	            show:true
	   	        },
	   	        restore:{   //开启还原功能
	   	            show:true
	   	        },
	   	        dataZoom:{  //开启数据缩放功能
	   	            show:true
	   	        },
	   	        saveAsImage:{   //保存图片的功能
	   	            show:true
	   	        },
	   	        magicType:{ //开启动态数据视图的切换
	   	            show:true
	   	        }
	   	    }
	   	},
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: yearArr
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: eval("("+'${lineDataUp }'+")")
	};
   app3.setOption(option3);
   
   
   
   //---------------------------------------------------
   
   var app = echarts.init(document.getElementById('lineMain2'));	
	option = {
	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:eval("("+'${prosJson }'+")")
	    },
	     toolbox: {
	   	    show:true,  //是否显示这个工具提示栏
	   	 	orient: 'vertical',
		    left: 'right',
	        top: 'center',
	   	    feature:{   //这个属性代表我们需要在工具栏中开启什么功能
	   	        dataView:{  //开启数据视图
	   	            show:true
	   	        },
	   	        restore:{   //开启还原功能
	   	            show:true
	   	        },
	   	        dataZoom:{  //开启数据缩放功能
	   	            show:true
	   	        },
	   	        saveAsImage:{   //保存图片的功能
	   	            show:true
	   	        },
	   	        magicType:{ //开启动态数据视图的切换
	   	            show:true
	   	        }
	   	    }
	   	},
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: yearArr
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: eval("("+'${lineDataDown }'+")")
	};
   app.setOption(option);
</script>
    
</body>
</html>