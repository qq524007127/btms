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
		app.addScript('user.js');
		//app.addStyle('style.css');
	</script>

  </head>
  
  <body>
   <table id="userGrid"></table>
   <div id="addWindow" style="text-align: center;">
    	<form id="addForm" action="${pageContext.request.contextPath }/api/user_add.action" method="post">
	    	<p>
	    		<label for="addUserName">用户名称：</label>
	    		<input id="addUserName" name="userName" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<label for="addUserCode">登陆账号：</label>
	    		<input id="addUserCode" name="userCode" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<input type="checkbox" id="addPermit" name="permit" value=true checked="true">
	    		<label for="addPermit">有效</label>
	    	</p>
	    	<p>
	    		<s:iterator value="%{roleList }" var="role">
	    			<input type="checkbox" name="roleIds" value="${role.roleId }" id="add${role.roleId }">
	    			<label for="add${role.roleId }">${role.roleName }</label>
	    		</s:iterator>
	    	</p>
	    </form>
    </div>
    <div id="editWindow" style="text-align: center;">
    	<form id="editForm" action="${pageContext.request.contextPath }/api/user_edit.action" method="post">
	    	<input type="hidden" name="userId">
	    	<input type="hidden" name="password">
	    	<p>
	    		<label for="editUserName">用户名称：</label>
	    		<input id="editUserName" name="userName" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<label for="editUserCode">登陆账号：</label>
	    		<input id="editUserCode" readonly="readonly" name="userCode" class="easyui-validatebox" data-options="required:true">
	    	</p>
	    	<p>
	    		<input type="checkbox" id="editPermit" name="permit" value=true checked="true">
	    		<label for="editPermit">有效</label>
	    	</p>
	    	<p>
	    		<s:iterator value="%{roleList }" var="role">
	    			<input type="checkbox" name="roleIds" value="${role.roleId }" id="edit${role.roleId }">
	    			<label for="edit${role.roleId }">${role.roleName }</label>
	    		</s:iterator>
	    	</p>
	    </form>
    </div>
  </body>
</html>
