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
    
    <title>福位架平面展示图</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		* {
			font-family: "微软雅黑";
			font-size: 14px;
		}
		button {
			cursor: pointer;
		}
		.shelf-box {
			min-width:100px;
			min-height:100px;
			background-color: lime;
		}
	</style>

  </head>
  
  <body>
  	<div><a href="javascript:history.back()">后退</a></div>
    <s:if test="area != null">
    <table align="center" border="0" cellpadding="1" cellspacing="5">
    	<s:iterator begin="1" end="area.areaRow" step="1" var="row">
    	<tr style="text-align: center; vertical-align: middle;">
    		<s:iterator begin="1" end="area.areaColumn" step="1" var="column">
	    	<td style="padding: 5px; background-color: graytext;">
	    		<s:iterator value="shelfList" var="shelf">
	    			<s:if test="(#shelf.postionRow == #row) && (#shelf.postionColumn == #column)">
	    				<s:if test="#shelf.permit">
	    					<div class="shelf-box">
	    					<button>禁用</button>
	    				</s:if>
	    				<s:else>
	    					<div class="shelf-box" style="background-color: red">
	    					<button>启用</button>
	    				</s:else>
	    					<p><a href="${pageContext.request.contextPath }/blessSeatPlan.action?shelfId=${shelf.shelfId}">查看福位</a></p>
	    				</div>
	    			</s:if>
	    		</s:iterator>
	    	</td>
	    	</s:iterator>	
    	</tr>
    	</s:iterator>
    </table>
    </s:if>
  </body>
</html>
