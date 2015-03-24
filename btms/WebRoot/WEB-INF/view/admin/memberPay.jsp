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

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8"></script>
<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		app.addScript('memberPay.js');
		//app.addStyle('style.css');
	</script>

</head>

<body>
	<div id="mainPanel">
		<div id="memberInfoPanel">
			会员名称：${member.memberName }，身份证号：${member.memberIdentNum }
		</div>
		<div id="memberPayItemPanel">
			<div>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="showBSWindow()">捐赠福位</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="showTLWindow()">捐赠牌位</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="showItemWindow()">捐赠其它项目</a>
			</div>
		</div>
	</div>
	<div title="福位列表" id="blessSeatWindow">
		<table id="blessSeatGrid"></table>
	</div>
	<div title="牌位列表" id="tabletWindow">
		<table id="tabletGrid"></table>
	</div>
	<div title="其它收费项目列表" id="expensItemWindow">
		<table id="expensItemGrid"></table>
	</div>
</body>
</html>
