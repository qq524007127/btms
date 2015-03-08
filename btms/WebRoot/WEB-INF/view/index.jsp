<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${msg }</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="昆明海会寺极乐塔,昆明海会寺,海会寺,极乐塔">
	<meta http-equiv="description" content="昆明海会寺极乐塔后台管理系统">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/easyloader.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8"></script>
  </head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height:100px;"></div>
	<div data-options="region:'west',title:'您好：系统管理员'" style="width:250px;">
		<div id="aa" class="easyui-accordion" data-options="fit:true,border:false" style="width:300px;height:200px;">
		    <div title="系统管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
		        <h3 style="color:#0099FF;">Accordion for jQuery</h3>
		        <p>Accordion is a part of easyui framework for jQuery. 
		        It lets you define your accordion component on web page more easily.</p>
		    </div>
		    <div title="用户管理" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
		        content2
		    </div>
		    <div title="菜单管理">
		        content3
		    </div>
		</div>
	</div>
	<div data-options="region:'center'" style="padding:5px;background:#eee;"></div>
	<div data-options="region:'south'" style="height:40px;"></div>
</body>
</html>
