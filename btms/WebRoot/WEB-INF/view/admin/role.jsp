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
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/role.js" charset="UTF-8" ></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
    <%-- <div id="editWindow" style="text-align: center;">
    	<form id="editForm" action="${pageContext.request.contextPath }/module/module_edit.action" method="post">
	    	<input type="hidden" name="moduleId">
	    	<p>	
	    		<label for="editModuleName">模块名称：</label>
	    		<input type="text" name="moduleName" id="editModuleName" required="true"/>
	    	</p>
	    	<p>
	    		<label for="editPageUrl">页面地址：</label>
	    		<input type="text" name="pageUrl" id="editPageUrl" />
	    	</p>
	    	<p>
	    		<label for="editRootModule">父模块：</label>
	    		<select name="parentModule.moduleId" id="editRootModule">
	    			<option value=""></option>
	    		</select>
	    	</p>
	    	<p>
	    		<input type="checkbox" name="permit" id="editPermit" value=false />
	    		<label for="editPermit">无效</label>
	    	</p>
	    </form>
    </div> --%>
  </body>
</html>
