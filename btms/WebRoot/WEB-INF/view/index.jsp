<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>昆明海会寺三月三灵塔管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="昆明海会寺三月三灵塔管理系统,昆明海会寺,海会寺,灵塔管理系统">
	<meta http-equiv="description" content="昆明海会寺三月三灵塔管理系统">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/index.js" charset="UTF-8"></script> 
	<style type="text/css">
		.menu_container {
			width:200px;
			height: 100%;
		}
		
		.menu_container a {
			font-family:微软雅黑;
			width: 200px;
			text-align: left;
		}
		
		
		.menu_container a:visited,
		.menu_container a:hover {
			background-color: yellow;
			color:blue;
		}
		
	</style>
	<script type="text/javascript">
		$(function(){
			//$.messager.alert('警告提示', '不能删除超级管理员用户！', 'warning');  
		});
		function getMoney(){
			$('#getMoney').dialog({
				width:300,
				height:170,
				modal:true,
				title:'会员缴费',
				buttons:[{
					text:'确定',
					iconCls:'icon-ok'
				},{
					text:'取消',
					iconCls:'icon-cancel'
				}]
			});
		}
	</script>
  </head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height:100px;">
		<h1 style="margin-left: 10px;margin-top: 30px; float:left;">三月三海会寺灵塔管理系统</h1>
		<div style="float: right; width:100px; text-align: center; margin-top: -20px">
			<a href="javascript:void(0)" style="color:red;font-weight: bold; font-size:16px">[退 出]</a>
		</div>
	</div>
	<div data-options="region:'west',title:'您好：${user.userName} '" style="width:250px;">
		<div id="aa" class="easyui-accordion" data-options="fit:true,border:false" >
			<!-- <div title="日常工作" style="overflow:auto;padding:10px;">
		    	<div class="menu_container">
		    		<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">福位管理</a>
		    		<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">福位架管理</a>
		    		<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">用户管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">会员管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">福位使用者管理</a>
		    	</div>
		    </div>
		    <div title="数据统计" style="overflow:auto;padding:10px;">
			    <div class="menu_container">
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">会员缴费</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">功德捐赠</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">福位出售</a>
			    	
			    </div>
		    </div> -->
		    <div title="系统管理" style="overflow:auto;padding:10px;">
			    <div class="menu_container">
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'" onclick="onMenuItemClick('模块管理','admin/module.action')">模块管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">菜单管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">角色管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">系统常量管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">系统参数设置</a>
			    </div>
		    </div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-tabs" id="mainTabs" data-options="fit:true,border:false,selected:1" >
			<div title="首页" style="padding:5px;background:#eee;">
				
			</div>
			<div title="缴费管理" data-options="closable:true" style="padding:5px">
				
				<table id="memberGrid"></table>
				<div id="memberGridToolbar">
					<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
					<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
					<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
					<span style="margin-left:20px;">
						<span>按条件查询:</span>
						<select id="cc" class="easyui-combobox" name="dept" data-options="editable:false" style="width:200px;">
						    <option value="aa">aitem1</option>
						    <option>bitem2</option>
						    <option>bitem3</option>
						    <option>ditem4</option>
						    <option>eitem5</option>
						</select>
						<input class="easyui-searchbox">
						<a id="btn" href="javascript:void(0)" onclick="doSearchMember()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
						<a id="btn" href="javascript:void(0)" onclick="cleanSearchParams()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">清楚查询条件</a>
					</span>
				</div>
				<script type="text/javascript">
					function doSearchMember(){
						$("#memberGrid").datagrid('load',{
							memberName:'会员',
							memSex:'女'
						});
					}
					function cleanSearchParams(){
						$("#memberGrid").datagrid('load',{});
					}
					$("#memberGrid").datagrid({
						url:'jsonTest.action',
						columns:[[
					        {field:'memId',title:'ID',width:100,checkbox:true},
					        {field:'memName',title:'姓名',width:20,align:'center'},
					        {field:'birthDay',title:'出生日期',sortable:true,width:20,align:'center'},
					        {field:'memSex',title:'性别',align:'center',width:10},
					        {field:'natPlace',title:'籍贯',align:'center',width:30},
					        {field:'memNational',title:'名族',width:80,align:'center'},
					    ]],
					    toolbar:'#memberGridToolbar',
					    queryParams: {
							searchKey: 'easyui',
							subject: 'datagrid'
						},
					    fit:true,
					    fitColumns:true,
					    title:'会员列表',
					    rownumbers:true,
					    striped:true,
					    pagination:true
					});
				</script>
			</div>
		</div>
	</div>
	<div data-options="region:'south'" style="height:40px;"></div>
	<div id="getMoney">
		<form action="" style="text-align: center;">
			<p>会员名称：<input type="text" value="会员名称"></p>
			<p>缴费金额：<input type="text" ></p>
		</form>
	</div>
</body>
</html>
