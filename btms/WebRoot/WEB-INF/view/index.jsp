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
		.menu_container {
			width:200px;
			height: 100%;
		}
		
		.menu_container a {
			font-family:微软雅黑;
			width: 200px;
			text-align: left;
		}
		
		.menu_container a:visited,
		.menu_container a:hover {
			background-color: yellow;
			color:blue;
		}
		
	</style>
  </head>

<body class="easyui-layout">

	<div data-options="region:'north'" style="height:100px;">
		<div style="width:100%;height: 100%;">
			<div style="margin-left: 10px; float:left; padding-top: 15px">
				<h1>三月三海会寺灵塔管理系统</h1>
			</div>
			<div style="float: right; text-align: center; padding-right: 45px; padding-top: 40px;">
				<a href="${pageContext.request.contextPath }/admin/userLoginOut.action" style="color:red;font-weight: bold; font-size:16px">[退 出]</a>
			</div>
		</div>
	</div>
	
	<div data-options="region:'west',title:'您好：${user.userName} '" style="width:250px;">
		<div id="aa" class="easyui-accordion" data-options="fit:true,border:false" >
		    <s:iterator value="moduleList" var="rootMenu">
		    	<div title="${rootMenu.moduleName }" style="overflow:auto;padding:10px;">
		    		<s:iterator value="childSet" var="module">
						<p>
							<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'" onclick="onMenuItemClick('${module.moduleName}','${module.pageUrl}')">${module.moduleName}</a>
						</p>
					</s:iterator>
		    	</div>
			</s:iterator>
		    <%-- <div title="系统管理" style="overflow:auto;padding:10px;">
			    <div class="menu_container">
					<s:iterator value="moduleList" var="module">
						<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'" onclick="onMenuItemClick('${module.moduleName}','${module.pageUrl}')">${module.moduleName}</a>
					</s:iterator>
			    </div>
		    </div> --%>
		</div>
	</div>
	
	<div data-options="region:'center'">
		<div class="easyui-tabs" id="mainTabs" data-options="fit:true,border:false,selected:1" >
			<div title="首页" style="padding:5px;background:#eee;">
				
			</div>
		</div>
	</div>
	
	<div data-options="region:'south'" style="height:40px;"></div>
</body>
</html>
