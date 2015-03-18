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
    
    <title>模块管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		app.addScript('module.js');
		//app.addStyle('style.css');
	</script>
  </head>
  
  <body>
    <table id="moduleGrid"></table>
    <div id="addWindow" style="text-align: center;">
    	<form id="addForm" action="${pageContext.request.contextPath }/module/module_add.action" method="post">
	    	<p>
	    		<label for="addModuleName">模块名称：</label>
	    		<input type="text" name="moduleName" id="addModuleName" required="true"/>
	    	</p>
	    	<p>
	    		<label for="addPageUrl">页面地址：</label>
	    		<input type="text" name="pageUrl" id="addPageUrl" />
	    	</p>
	    	<p>
	    		<label for="addRootModule">父模块：</label>
	    		<select name="parentModule.moduleId" id="addRootModule">
	    			<option value=""></option>
	    		</select>
	    	</p>
	    	<p>
	    		<input type="checkbox" name="permit" id="addPermit" value=false />
	    		<label for="addPermit">无效</label>
	    	</p>
	    </form>
    </div>
    <div id="editWindow" style="text-align: center;">
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
    </div>
  </body>
</html>
