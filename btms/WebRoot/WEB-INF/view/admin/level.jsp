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
		app.addScript('level.js');
	</script>

  </head>
  
  <body>
   <table id="levelGrid"></table>
   <div id="addWindow" style="text-align: center;">
    	<form id="addForm" action="${pageContext.request.contextPath }/api/level_add.action" method="post">
	    	<p>
	    		<label for="addLevName">级别名称：</label>
	    		<input id="addLevName" name="levName" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<label for="addLevPice">价格：</label>
	    		<input name="levPrice" id="addLevPice" type="text" class="easyui-numberbox" data-options="min:1,precision:2,required:true">
	    	</p>
	    	<p>
	    		<label for="addMngPrice">管理费：</label>
	    		<input name="mngPrice" id="addMngPrice" type="text" class="easyui-numberbox" data-options="min:1,precision:2,required:true">
	    	</p>
	    	<p>
	    		<label for="addRemark">备注：</label>
	    		<textarea id="addRemark" name="remark" rows="3" cols="25"></textarea>
	    	</p>
	    </form>
    </div>
    <div id="editWindow" style="text-align: center;">
    	<form id="editForm" action="${pageContext.request.contextPath }/api/level_edit.action" method="post">
    		<input name="levId" type="hidden">
	    	<p>
	    		<label for="editLevName">级别名称：</label>
	    		<input id="editLevName" name="levName" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<label for="editLevPice">价格：</label>
	    		<input name="levPrice" id="editLevPice" type="text" class="easyui-numberbox" data-options="min:1,precision:2,required:true">
	    	</p>
	    	<p>
	    		<label for="editMngPrice">管理费：</label>
	    		<input name="mngPrice" id="editMngPrice" type="text" class="easyui-numberbox" data-options="min:1,precision:2,required:true">
	    	</p>
	    	<p>
	    		<label for="editRemark">备注：</label>
	    		<textarea id="editRemark" name="remark" rows="3" cols="25"></textarea>
	    	</p>
	    </form>
    </div>
  </body>
</html>
