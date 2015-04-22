<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>昆明海会寺三月三灵塔管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="昆明海会寺三月三灵塔管理系统,昆明海会寺,海会寺,灵塔管理系统">
	<meta http-equiv="description" content="昆明海会寺三月三灵塔管理系统">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		app.addScript('index.js');
		//app.addStyle('style.css');
	</script>
	<style type="text/css">
		.menu-item {
			display: block;
			margin: 0;
			padding: 0;
		}
		
		.menu-item-content{
			color: white;
			margin: 5px;
			padding: 5px;
			height:26px;
			line-height:26px;
			padding-left:10px;
			background-color: #008866;
			color: #CCEEFF;
		}
		
		.menu-item .menu-text {
			font-size: 13px;
			margin: 0;
			padding: 0 5px;
		}
		.menu-item:hover .menu-item-content{
			background-color: #CCEEFF;
			color: #008866;
		}
		.main-header {
			background-color: #008866;
			color: #CCEEFF;
			margin: 0;
			padding: 0;
			height: 100px;
			line-height: 100px;
		}
		.main-header-logo{
			background:url('${pageContext.request.contextPath}/img/logo.png') no-repeat center center;
			width: 64px;
			height:100px;
			margin: auto 10px;
		}
		.main-header .title .main-header-title{
			font-size: 20px;
			padding:0 5px;
			font-weight: bold;
		}
		.main-header-time {
			font-size: 14px;
			font-weight: bold;
			padding-right: 20px;
		}
		.main-footer {
			background-color: #008866;
			color: #CCEEFF;
			margin: 0;
			padding: 0;
			height: 40px;
			line-height: 40px;
			text-align: center;
		}
		.exit-btn {
			width: 62px;
			height: 62px;
			margin-right: 15px;
			cursor: pointer;
		}
	</style>
  </head>

<body class="easyui-layout">

	<div data-options="region:'north',border:false" style="height:100px;">
		<div class="main-header">
			<div class="title">
				<span class="left main-header-logo"></span>
				<span class="left main-header-title">三月三海会寺灵塔管理系统</span>
				
				<span class="exit-btn icon-large-exit right" title="退出" onClick="exitApp()">
					<div style="height: 100px; line-height: 100px;">
						<img alt="退出" src="${pageContext.request.contextPath }/img/large-exit.png">
					</div>
				</span>
				<span class="right main-header-time">
					<div>当前时间：<span id="timeContainer"><s:date name="now" format="yyyy-MM-dd HH:mm:ss"/></span></div>
				</span>
			</div>
		</div>
	</div>
	
	<div data-options="region:'west',split:true" title="您好：${user.userName}" style="width:250px;">
		<div id="menu-panel" class="easyui-accordion" data-options="fit:true,border:false" >
		    <s:iterator value="moduleList" var="rootMenu">
		    	<div title="${rootMenu.moduleName }" data-options="iconCls:'icon-menu'">
		    		<s:iterator value="childSet" var="module">
			    		<a class="menu-item" onclick="onMenuItemClick('${module.moduleName}','${module.pageUrl}')" href="javascript:void(0)">
			    			<div class="menu-item-content">
			    				<span class="icon-container icon-menu-item left"></span>
			    				<span class="menu-text left">${module.moduleName}</span>
			    			</div>
			    		</a>
					</s:iterator>
		    	</div>
			</s:iterator>
		</div>
	</div>
	
	<div data-options="region:'center'">
		<div id="mainTabs" class="easyui-tabs" data-options="fit:true,border:false">
			<div title="首页" style="padding:5px;background:#eee;">
				
			</div>
		</div>
	</div>
	
	<div data-options="region:'south',border:false" style="height:40px;">
		<div class="main-footer">
			&copy;<s:date name="now" format="yyyy-MM-dd"/> 昆明海会寺
		</div>
	</div>
</body>
</html>
