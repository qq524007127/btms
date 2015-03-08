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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h2>模块列表</h2>
  	<hr>
  	<s:iterator value="modList" var="module">
  		<p>
  			模块名称：${module.moduleName } | 模块页面：${module.pageUrl } | 模块描述：${module.remark } | 对应功能：
  			<s:iterator value="funs" var="fun"> 
  				<a href="function?funId=${fun.funId }">[${fun.funName }]</a>
  			</s:iterator>
  		</p>	
  	</s:iterator>
  </body>
</html>
