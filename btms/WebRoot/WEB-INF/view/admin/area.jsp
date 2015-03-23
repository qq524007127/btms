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
    
    <title>福位级别管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		app.addScript('area.js');
	</script>

  </head>
  
  <body>
   <table id="areaGrid"></table>
   <div id="addWindow" style="text-align: center;">
    	<form id="addForm" action="${pageContext.request.contextPath }/api/area_add.action" method="post">
	    	<p>
	    		<label for="addAreaName">区域名称：</label>
	    		<input id="addAreaName" name="areaName" class="easyui-validatebox" data-options="required:true,length:10">
	    	</p>
	    	<p>
	    		<label for="addAreaRow">行数：</label>
	    		<input name="areaRow" id="addAreaRow" class="easyui-numberbox" data-options="min:1,required:true">
	    	</p>
	    	<p>
	    		<label for="addAreaColumn">列数：</label>
	    		<input name="areaColumn" id="addAreaColumn" class="easyui-numberbox" data-options="min:1,required:true">
	    	</p>
	    	<p>
	    		<label for="addRemark">备注：</label>
	    		<textarea id="addRemark" name="remark" rows="3" cols="25"></textarea>
	    	</p>
	    </form>
    </div>
    <div id="initWindow" style="text-align: center;">
    	<form id="initForm" action="${pageContext.request.contextPath }/api/area_init.action" method="post">
	    	<p>
	    		<label for="initAreaName">区域名称：</label>
	    		<input id="initAreaName" name="areaName" class="easyui-validatebox" data-options="required:true,length:10">
	    	</p>
	    	<p>
	    		<label for="initAreaRow">区域行数：</label>
	    		<input name="areaRow" id="initAreaRow" class="easyui-numberbox" data-options="min:1,required:true">
	    	</p>
	    	<p>
	    		<label for="initAreaColumn">区域列数：</label>
	    		<input name="areaColumn" id="initAreaColumn" class="easyui-numberbox" data-options="min:1,required:true">
	    	</p>
	    	<p>
	    		<label for="initShelfRow">福位架行数：</label>
	    		<input name="shelfRow" id="initShelfRow" class="easyui-numberbox" data-options="min:1,required:true">
	    	</p>
	    	<p>
	    		<label for="initShelfColumn">福位架列数：</label>
	    		<input name="shelfColumn" id="initShelfColumn" class="easyui-numberbox" data-options="min:1,required:true">
	    	</p>
	    	<p>
	    		<label for="initRemark">备注：</label>
	    		<textarea id="initRemark" name="remark" rows="3" cols="25"></textarea>
	    	</p>
	    </form>
    </div>
    <div id="editWindow" style="text-align: center;">
    	<form id="editForm" action="${pageContext.request.contextPath }/api/area_edit.action" method="post">
	    	<input name="areaId" type="hidden">
	    	<p>
	    		<label for="editAreaName">区域名称：</label>
	    		<input id="editAreaName" name="areaName" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<label for="editAreaRow">行数：</label>
	    		<input name="areaRow" id="editAreaRow" class="easyui-numberbox" data-options="min:1,required:true">
	    	</p>
	    	<p>
	    		<label for="editAreaColumn">列数：</label>
	    		<input name="areaColumn" id="editAreaColumn" class="easyui-numberbox" data-options="min:1,required:true">
	    	</p>
	    	<p>
	    		<label for="editRemark">备注：</label>
	    		<textarea id="editRemark" name="remark" rows="3" cols="25"></textarea>
	    	</p>
	    </form>
    </div>
  </body>
</html>
