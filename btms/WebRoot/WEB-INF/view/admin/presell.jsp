<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>福位级别管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit">
<meta content="always" name="referrer">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8"></script>
<script type="text/javascript">
	app.init('${pageContext.request.contextPath}');
	app.addScript('presell.js');
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/plugs/excelPrinter.js" charset="UTF-8" ></script>
</head>

<body>
	<table id="presellGrid"></table>
	<div id="toolbarPanel">
		<a class="easyui-linkbutton" iconCls="icon-add" id="presellBtn">预定</a>
		<a class="easyui-linkbutton" iconCls="icon-ok" id="cashBtn">兑现</a>
		<a class="easyui-linkbutton" iconCls="icon-print" id="printBtn">打印订单</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" id="cancelBtn">取消预定</a>
		<span style="margin-left:50px;">
			<input id="presellGridSearchBox">
		</span>
	</div>
	<div id="searchboxMenu">
		<div name="orderCode">订单号</div>
	</div>
	<div id="presellWindow" class="easyui-dialog" width="400" height="200"
		title="会员捐赠" data-options="iconCls:'icon-add',closed:true,modal:true,buttons:[{
											text:'确认',
											iconCls:'icon-ok',
											handler:submitForm
										}]">
		<form id="addForm" action="api/presell_addByMember.action" method="post">
			<input name="memberId" id="memberId" type="hidden"
				value="${memberId }">
			<table align="center" class="form-container">
				<tr>
					<td class="title"><label>数量：</label></td>
					<td><input name="psCount" type="text" class="easyui-numberbox" id="psCount" onchange="sumTotalPrice()"
						value="1" data-options="min:1,precision:0"></td>
					<td class="title"><label>单价：</label></td>
					<td><input type="text" name="psPrice" class="easyui-numberbox" id="psPrice" onchange="sumTotalPrice()"
						value="9000" data-options="min:1"></td>
				</tr>
				<tr>
					<td class="title"><label>总价：</label></td>
					<td colspan="3"><input name="totalPrice" type="text"
						class="easyui-numberbox" value="9000" readonly="readonly"
						data-options="min:1,precision:0"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="cashDialog"></div>
	
	<div id="blessSeatGridWin" class="easyui-dialog" width="650" height="350"
		title="选择福位" iconCls="icoc-ok" modal=true closed=true>
		<table id="bsGrid"></table>
		<div id="bsgridToolbarPanel">
			<a class="easyui-linkbutton" iconCls="icon-ok">选择</a>
			<span>
				<input id="bsgridSearchbox"> 
			</span>
		</div>
		<div id="bsgridsearchboxMenu">
			<div name="bsCode">福位编号</div>
		</div>
	</div>
	
</body>
</html>
