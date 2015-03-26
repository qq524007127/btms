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
    
    <title>福位管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		app.addScript('tablet.js');
		app.addStyle('style.css');
	</script>
	
  </head>
  
  <body>
 	<table id="tabletGrid" data-options="toolbar:'#toolbarPanel'"></table>
 	<div id="tabletGridTB">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="doAddTablet()">添加</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="doEditTablet()">修改</a>
		<input id="searchBox" class="easyui-searchbox" data-options="searcher:'doSearch', prompt:'输入关键字搜索'" style="width:200px"></input> 
		<a id="doSearchBtn" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">查询</a> 
	</div>
	<div id="addWindow">
		<form id="addForm" action="${pageContext.request.contextPath }/api/tablet_add.action" method="post" style="text-align: center;">
			<p>
				<label>牌位名称：</label>
				<input name="tabletName" class="easyui-validatebox" data-options="required:true">
			</p>
			<p>
				<label>牌位价格：</label>
				<input name="tabletPrice" class="easyui-numberbox" data-options="required:true">
			</p>
			<p>
				<label for="addTabletEditable">是否可编辑：</label>
				<input id="addTabletEditable" type="checkbox" value=true name="editable">
				<label for="addTabletPermit">有效：</label>
				<input id="addTabletPermit" type="checkbox" value=true name="permit">
			</p>
			<p>
				<label>备注：</label>
				<textarea rows="3" cols="30" name="tabletRemark"></textarea>
			</p>
		</form>
	</div>
	<div id="editWindow">
		<form id="editForm" action="${pageContext.request.contextPath }/api/tablet_edit.action" method="post" style="text-align: center;">
			<p>
				<label>牌位名称：</label>
				<input type="hidden" name="tabletId">
				<input name="tabletName" class="easyui-validatebox" data-options="required:true">
			</p>
			<p>
				<label>牌位价格：</label>
				<input name="tabletPrice" class="easyui-numberbox" data-options="required:true">
			</p>
			<p>
				<label for="editTabletEditable">是否可编辑：</label>
				<input id="editTabletEditable" type="checkbox" value=true name="editable">
				<label for="editTabletPermit">有效：</label>
				<input id="editTabletPermit" type="checkbox" value=true name="permit">
			</p>
			<p>
				<label>备注：</label>
				<textarea rows="3" cols="30" name="tabletRemark"></textarea>
			</p>
		</form>
	</div>
  </body>
</html>
