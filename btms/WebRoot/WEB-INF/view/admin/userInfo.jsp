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
    
    <title>个人信息维护</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		app.addScript('userInfo.js');
	</script>
	<style type="text/css">
		.main-container {
			margin: 10px 0;
			padding: 20px;
			text-align: center;
		}
	</style>
  </head>
  
  <body class="main-container">
  	 <div title="密码修改" id="editPasswordPanel"  style="text-align:">
    	<form id="addForm" action="${pageContext.request.contextPath }/admin/userInfo_editPassword.action" method="post">
    		<table align="center" class="form-container">
    			<tr>
    				<td class="title"><label for="addUserName">旧密码：</label></td>
    				<td>
    					<input name="userId" type="hidden" value="${user.userId }">
    					<input id="addUserName" name="password" class="easyui-validatebox" data-options="required:true" type="password">
    				</td>
    			</tr>
    			<tr>
    				<td class="title"><label for="addUserName">新密码：</label></td>
    				<td>
    					<input id="addUserName" name="newPassword" id="newPassword" class="easyui-validatebox" data-options="required:true" type="password">
    				</td>
    			</tr>
    			<tr>
    				<td class="title"><label for="addUserName">重复新密码：</label></td>
    				<td>
    					<input id="addUserName" name="rePassword" id="rePassword" class="easyui-validatebox" data-options="required:true" type="password">
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" style="text-align: right;background-color: #dddddd; padding: 1px 15px">
    					<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'">修改</a>
    				</td>
    			</tr>
    		</table>
	    </form>
	</div>
</html>
