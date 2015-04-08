<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据汇总</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
		app.addScript('dataSummary.js');
	</script>

  </head>
  
  <body>
  	<table id="summaryGrid"></table>
  	<div id="toolbarPanel">
  		<a title="导出" class="easyui-linkbutton" data-options="iconCls:'icon-save'" id="downLoadBtn">导出</a>
  		<a title="打印" class="easyui-linkbutton" data-options="iconCls:'icon-print'" id="printBtn">打印</a>
  		<span style="padding-left: 25px;">
  			开始时间：
  			<input id="startDate" type="text" class="easyui-datebox" data-options="editable:false">
  			结束时间：
  			<input id="endDate" type="text" class="easyui-datebox" data-options="editable:false">
  			<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" id="searchBtn">查询</a>
  			<a class="easyui-linkbutton" data-options="iconCls:'icon-clear'" id="resetSearchBtn">清除查询条件</a>
  		</span>
  	</div>
  	<!-- <div>
  		<div>
  			
  		</div>
  		<table width="90%" align="center" border="1" cellpadding="1" cellspacing="0" style="text-align: center;">
  			<thead>
  				<tr>
  					<td>统计日期</td>
  					<td colspan="5">福位统计</td>
  					<td colspan="3">牌位统计</td>
  					<td colspan="2">管理费统计</td>
  					<td colspan="2">其它费用统计</td>
  				</tr>
  			</thead>
  			<tbody>
  				<tr>
  					<td></td>
  					<td>捐赠数量</td>
  					<td>捐赠金额</td>
  					<td>租赁数量</td>
  					<td>租赁金额</td>
  					<td>剩余数量</td>
  					<td>捐赠数量</td>
  					<td>捐赠金额</td>
  					<td>剩余数量</td>
  					<td>缴费数量</td>
  					<td>缴费金额</td>
  					<td>数量</td>
  					<td>金额</td>
  				</tr>
  			</tbody>
  			<tfoot>
  				<tr>
  					<td>小计</td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>今天到当前</td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  				</tr>
  			</tfoot>
  		</table>
  	</div> -->
  </body>
</html>
