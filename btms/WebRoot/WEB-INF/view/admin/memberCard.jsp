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
		app.addScript('memberCard.js');
	</script>
	
  </head>
  
  <body>
 	<table id="memberCardGrid" data-options="toolbar:'#toolbarPanel'"></table>
 	<%-- 工具栏 --%>
 	<div id="toolbarPanel">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="showAddWindow()">办理会员证</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="showEidtWindow()">会员证挂失</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="removeDeader()">会员证补办</a>
		<span style="margin-left:50px;">
			<input id="deaderGridSearchbox" class="easyui-searchbox" data-options="prompt:'输入关键字搜索',menu:'#searchboxMenu'" style="width:300px"></input>
			<div id="searchboxMenu"> 
				<div name="cardCode">会员证编号</div>
		    	<div name="mem.memberName">会员姓名</div>
		    	<div name="enterprise.enterName">企业名称</div>
			</div>
		</span>
	</div>
	
	
    <!-- 会员选择窗口 -->
    <div id="checkBlessSeatWindow">
    	<table id="blessSeatGrid"></table>
    	<div id="blessSeatGridTB">
    		<a id="checkBSButton">选择</a>
    		<input id="blessSeatGridSearchbox">
    		<div id="bsgridSearchboxMenu">
    			<div name="bsCode">福位编号</div>
    		</div>
    	</div>
    </div>
    
    <!-- 企业选择窗口 -->
    <div id="checkBlessSeatWindow">
    	<table id="blessSeatGrid"></table>
    	<div id="blessSeatGridTB">
    		<a id="checkBSButton">选择</a>
    		<input id="blessSeatGridSearchbox">
    		<div id="bsgridSearchboxMenu">
    			<div name="bsCode">福位编号</div>
    		</div>
    	</div>
    </div>
</html>
