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
    
    <title>福位架平面图</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8" ></script>
	<script type="text/javascript">
		app.init('${pageContext.request.contextPath}');
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		* {
			font-family: "微软雅黑";
			font-size: 14px;
		}
		.box {
			min-width:100px;
			min-height:80px;
		}
		.box .box-content {
			text-align: left;
			font-size: 12px;
		}
		.target-info {
			font-family: "微软雅黑";
			font-size: 12px;
		}
		.enable {
			min-wiight:100px;
			background-color: #E0ECFF;
		}
		
		.disable {
			min-widght:100px;
			background-color: red;
		}
	</style>
	
	<script type="text/javascript">
		function addShelf(){
			
		}
		
		//启用
		function setEnable(){
			if(!checkFrom()){
				$.messager.alert('', '请选择需要操作的数据！');
				return;
			}
			$('#mainForm').form('submit',{
				url:'api/shelfPlan_enable.action',
				success:function(data){
					data = $.parseJSON(data);
					if(data.success){
						location.reload();
					}
					else{
						$.messager.alert('',data.msg);
					}
				}
			});
		}
		
		function setDisable(){
			if(!checkFrom()){
				$.messager.alert('', '请选择需要操作的数据！');
				return;
			}
			$.messager.confirm('警告','设置福位架无效后，此福位架上对应的福位也就不可用，请谨慎使用。是否继续？',function(flag){
				$('#mainForm').form('submit',{
					url:'api/shelfPlan_disable.action',
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							location.reload();
						}
						else{
							$.messager.alert('',data.msg);
						}
					}
				});
			});
		}
		
		function checkFrom(){
			return $('#mainForm input[name=shelfIds]:checked').length < 1 ? false : true;
		}
	</script>

  </head>
  
  <body>
  	<div class="easyui-dialog" title="福位架平面图" fit=true toolbar="#toolbarPanel" closable=false draggable=false">
  		<form action="" method="post" id="mainForm">
	  		<s:if test="area != null">
	    	<table align="center" border="0" cellpadding="1" cellspacing="5">
	    	<s:iterator begin="1" end="area.areaRow" step="1" var="row">
	    	<tr style="text-align: center; vertical-align: middle;">
	    		<s:iterator begin="1" end="area.areaColumn" step="1" var="column">
		    	<td style="padding: 5px; background-color: graytext;">
		    		<s:iterator value="shelfList" var="shelf">
		    			<s:if test="(#shelf.postionRow == #row) && (#shelf.postionColumn == #column)">
		    				<s:if test="#shelf.permit">
		    					<div class="box enable">
		    				</s:if>
		    				<s:else>
		    					<div class="box disable">
		    				</s:else>
		    					<div class="box-content">
		    						<p><input type="checkbox" name="shelfIds" value="${shelf.shelfId}" ></p>
		    						<p>
		    							<a href="${pageContext.request.contextPath }/admin/blessSeatPlan.action?shelfId=${shelf.shelfId}">查看福位</a>
		    						</p>
		    					</div>
		    				</div>
		    			</s:if>
		    		</s:iterator>
		    	</td>
		    	</s:iterator>	
	    	</tr>
	    	</s:iterator>
	    </table>
	    </s:if>
  		</form>
  	</div>
  	<div id="toolbarPanel">
  		<a class="easyui-linkbutton" iconCls="icon-back" onClick="history.back()">返回</a>
  		<a class="easyui-linkbutton" iconCls="icon-add" onClick="addShelf()">添加福位福位架</a>
  		<a class="easyui-linkbutton" iconCls="icon-ok" onClick="setEnable()">设为有效</a>
  		<a class="easyui-linkbutton" iconCls="icon-cancel" onClick="setDisable()">设为无效</a>
  		<a class="easyui-linkbutton" iconCls="icon-reload" onClick="location.reload()">刷新</a>
  	</div>
  </body>
</html>
