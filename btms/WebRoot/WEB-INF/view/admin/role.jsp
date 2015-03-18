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
    
    <title>角色管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		app.addScript('role.js');
		//app.addStyle('style.css');
	</script>

  </head>
  
  <body>
    <table id="roleGrid"></table>
    <div id="addWindow" style="text-align: center;">
    	<form id="addForm" action="${pageContext.request.contextPath }/role/role_add.action" method="post">
	    	<p>
	    		<label for="addRoleName">角色名称：</label>
	    		<input id="addRoleName" name="roleName" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<label for="addRemark">备注：</label>
	    		<textarea name="remark" id="addRemark" cols="20" rows="3"></textarea>
	    	</p>
	    	<p>
	    		<s:iterator value="%{moduleList }" var="module">
	    			<input type="checkbox" name="moduleIds" value="${module.moduleId }" id="${module.moduleId }">
	    			<label for="${module.moduleId }">${module.moduleName }</label>
	    		</s:iterator>
	    	</p>
	    </form>
    </div>
    <div id="editWindow" style="text-align: center;">
    	<form id="editForm" action="${pageContext.request.contextPath }/role/role_edit.action" method="post">
	    	<input type="hidden" name="roleId">
	    	<p>	
	    		<label for="editRoleName">角色名称：</label>
	    		<input id="editRoleName" name="roleName" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<label for="editRemark">备注：</label>
	    		<textarea name="remark" id="editRemark" cols="20" rows="3"></textarea>
	    	</p>
	    	<p>
	    		<s:iterator value="%{moduleList }" var="module">
	    			<input type="checkbox" name="moduleIds" value="${module.moduleId }" id="${module.moduleId }">
	    			<label for="${module.moduleId }">${module.moduleName }</label>
	    		</s:iterator>
	    	</p>
	    </form>
    </div>
  </body>
</html>
