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
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="renderer" content="webkit">
	<meta content="always" name="referrer">     
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
			margin: 4px 0;
			padding: 0;
		}
		
		.menu-item-content{
			color: white;
			margin: 0 5px;
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
		
		.loginout-button {
			width: 64px;
			height:100px;
			background:url("${pageContext.request.contextPath}/img/large-exit.png") no-repeat center center;
			margin: 0 18px;
			display: block;
		}
		
		.loginout-button:hover {
			filter:alpha(opacity=90); 
			opacity:0.9;
		}
		
		.loginout-button:active {
			filter:alpha(opacity=50); 
			opacity:0.5;
		}
		
	</style>
  </head>

<body class="easyui-layout">

	<div data-options="region:'north',border:false" style="height:100px;">
		<div class="main-header">
			<ul class="main-header-content">
				<li class="left">
					<span class="main-header-logo"></span>
				</li>
				<li class="left">
					<span class="main-header-title">三月三海会寺灵塔管理系统</span>
				</li>
				<li class="right">
					<a title="退出" href="javascript:void(0)" class="loginout-button" onClick="exitApp()"></a>
				</li>
				<li class="right">
					<div class="main-header-timer">当前时间：<span id="timeContainer"><s:date name="now" format="yyyy-MM-dd HH:mm:ss"/></span></div>
				</li>
			</ul>
		</div>
	</div>
	
	<div data-options="region:'west',split:true" title="您好：${user.userName}" style="width:250px;">
		<div id="menu-panel" class="easyui-accordion" data-options="fit:true,border:false" >
			<s:bean name="com.sunjee.btms.common.ModuleComparator" id="moduleComparator"></s:bean>
		    <s:iterator value="moduleList" var="rootMenu">
		    	<div title="${rootMenu.moduleName }" data-options="iconCls:'icon-menu'">
		    		<s:sort comparator="moduleComparator" source="childSet">
		    		<s:iterator id="module">
			    		<a class="menu-item" onclick="onMenuItemClick('${module.moduleName}','${module.pageUrl}')" href="javascript:void(0)">
			    			<div class="menu-item-content">
			    				<span class="icon-container icon-menu-item left"></span>
			    				<span class="menu-text left">${module.moduleName}</span>
			    			</div>
			    		</a>
					</s:iterator>
					</s:sort>
		    	</div>
			</s:iterator>
		</div>
	</div>
	
	<div data-options="region:'center'">
		<div id="mainTabs" class="easyui-tabs" data-options="fit:true,border:false">
			<div title="首页" style="padding:5px;background:#eee;">
				<div class="easyui-panel" fit=true>
					<h1 style="text-align: center;margin: 50px auto; font-size: 20px;">欢迎使用昆明梵彩文化发展有限公司，三月三海会寺灵塔管理系统</h1>
				</div>
			</div>
		</div>
	</div>
	
	<div data-options="region:'south',border:false" style="height:40px;">
		<div class="main-footer">
			&copy;<s:date name="now" format="yyyy"/> 昆明梵彩文化发展有限公司 <!-- &nbsp;&nbsp;<a href="javascript:void(0)">联系我们</a> -->
		</div>
	</div>
</body>
</html>
