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
    
    <title>福位区域平面图</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

<body>
	<div class="easyui-dialog" title="海源寺平面图" fit=true
		toolbar="#toolbarPanel" closable=false draggable=false">
		<div style="padding: 0; margin: 0; text-align: center;">
			<img alt="海源寺平面图" src="${pageContext.request.contextPath }/img/global_pic.gif" style="width: 100%; height: auto;">
			<s:iterator value="areaList" var="current">
				<a href="${pageContext.request.contextPath }/admin/shelfPlan.action?areaId=${current.areaId}">${current.areaName }</a>
				<hr>
			</s:iterator>
		</div>
	</div>
	<div id="toolbarPanel">
		<!-- <input class="easyui-searchbox"
			data-options="prompt:'输入关键字搜索',width:300,menu:'#searchboxMenu'"> -->
	</div>
	<div id="searchboxMenu">
		<div name="areaName">区域名称</div>
		<div name="shelfCode">福位架编号</div>
		<div name="bsCode">福位编号</div>
	</div>
</body>
</html>
