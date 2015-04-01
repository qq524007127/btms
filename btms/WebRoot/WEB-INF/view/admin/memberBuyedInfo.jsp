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
    
    <title>会员捐赠项目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		//app.addScript('memberBuyedInfo.js');
	</script>

  </head>

<body>
	<div id="mainTabs" class="easyui-tabs" data-options="fit:true,border:false,selected:0">
		<div title="捐赠福位" data-options="fit:true,border:false">
			<iframe width=100% height=100% frameborder=0 src="admin/bsRecord.action?memberId=${memberId }">
		</div>
		<div title="捐赠牌位" data-options="fit:true,border:false">
			<iframe width=100% height=100% frameborder=0 src="admin/tabletRecord.action?memberId=${memberId }">
		</div>
	</div>
</body>
</html>
