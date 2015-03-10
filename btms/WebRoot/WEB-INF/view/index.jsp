<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>昆明海会寺极乐塔后台管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="昆明海会寺极乐塔,昆明海会寺,海会寺,极乐塔">
	<meta http-equiv="description" content="昆明海会寺极乐塔后台管理系统">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js" charset="UTF-8" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/app.js" charset="UTF-8"></script>
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
		<h1 style="margin-left: 10px;margin-top: 30px">昆明海会寺极乐塔后台管理系统</h1>
		<div style="float: right; width:100px; text-align: center; margin-top: -20px">
			<a href="javascript:void(0)" style="color:red;font-weight: bold; font-size:16px">[退 出]</a>
		</div>
	</div>
	<div data-options="region:'west',title:'您好：系统管理员'" style="width:250px;">
		<div id="aa" class="easyui-accordion" data-options="fit:true,border:false" >
			<div title="日常工作" style="overflow:auto;padding:10px;">
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
		    </div>
		    <div title="系统管理" style="overflow:auto;padding:10px;">
			    <div class="menu_container">
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">菜单管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">角色管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">模块管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">系统常量管理</a>
			    	<a class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">系统参数设置</a>
			    </div>
		    </div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-tabs" data-options="fit:true,border:false,selected:4" >
			<div title="首页" style="padding:background:#eee;">
				${msg }
			</div>
			<div title="系统管理" data-options="closable:true" style="padding:background:#eee;">
			</div>
			<div title="会员管理" data-options="closable:true" style="padding:background:#eee;">
			</div>
			<div title="缴费管理" data-options="closable:true" style="padding:background:#eee;padding:5px">
				<table id="moneyGrid" class="easyui-datagrid" data-options="fit:true,border:false,toolbar:'#moneyToolbar',
					pagination:true,rownumbers:true,fitColumns:true,striped:true" title="缴费列表">
					<thead>
						<tr>
							<th field="userId" width="150" data-options="checkbox:true">ID</th>
							<th field="用户ID" width="150" >会员ID</th>
							<th field="用户名称" width="200" >会员名称</th>
							<th field="登陆账号" width="250">缴费时间</th>
							<th field="登陆密码" width="150">缴费金额(元)</th>
							<th field="有效" width="150">下次缴费时间</th>
							<th field="name6" width="450">是否缴费</th>
						</tr>                          
					</thead>                           
					<tbody>                            
						<%
							for(int i = 1; i < 40; i ++){
						%>
						<tr>  
							<td>ID</td>                
							<td>会员ID</td>                          
							<td>会员XXX</td>                           
							<td>2015-1-2</td>          
							<td>5000</td>            
							<td>2016-1-2</td>            
							<td>已缴费</td>  
						</tr>
						<%	
							}
						 %>                         
					</tbody>                           
				</table>
				<div id="moneyToolbar">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="getMoney()">捐赠</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
					<input id="ss" class="easyui-searchbox" style="width:300px" data-options="prompt:'输入关键字搜索'"></input>
				</div>
			</div>
			<div title="福位管理" data-options="closable:true" style="padding:background:#eee;">
				<table id="userGrid" class="easyui-datagrid" data-options="fit:true,border:false,toolbar:'#fuweiToolBar',
					pagination:true,rownumbers:true,fitColumns:true,striped:true" title="用户列表">
					<thead>
						<tr>
							<th field="userId" width="150" data-options="checkbox:true">ID</th>
							<th field="用户ID" width="150" >福位ID</th>
							<th field="用户名称" width="200" >福位名称</th>
							<th field="登陆账号" width="250">所在方位</th>
							<th field="登陆密码" width="150">所属级别</th>
							<th field="登陆密码" width="150">福位架</th>
							<th field="有效" width="150">所在层</th>
							<th field="name6" width="150">所在列</th>
							<th field="name6" width="150">是否已捐赠</th>
						</tr>                          
					</thead>                           
					<tbody>                            
						<%
							for(int i = 1; i < 40; i ++){
						%>
						<tr>      
							<td>ID</td>            
							<td>福位ID</td>                
							<td>福位XXX</td>                         
							<td>东、南、西、北、中</td>            
							<td>1-99级</td>            
							<td>福位架XXX</td>            
							<td>第X层</td>                 
							<td>第X列</td>          
							<td>已捐赠或未捐赠</td>  
						</tr>
						<%	
							}
						 %>                         
					</tbody>                           
				</table>
				<div id="fuweiToolBar">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">位置</a>
					<input id="ss" class="easyui-searchbox" style="width:300px" data-options="prompt:'输入关键字搜索'"></input>
				</div>
			</div>
			<div title="用户管理" data-options="closable:true" style="padding:background:#eee;padding: 5px">
				
				<table id="userGrid" class="easyui-datagrid" data-options="fit:true,border:false,toolbar:'#toolbar',
					pagination:true,rownumbers:true,fitColumns:true,striped:true" title="用户列表">
					<thead>
						<tr>
							<th field="userId" width="150" data-options="checkbox:true">ID</th>
							<th field="用户ID" width="150" >用户ID</th>
							<th field="用户名称" width="200" >用户名称</th>
							<th field="登陆账号" width="250">登陆账号</th>
							<th field="登陆密码" width="150">登陆密码</th>
							<th field="有效" width="150">有效</th>
							<th field="name6" width="450">描述</th>
						</tr>                          
					</thead>                           
					<tbody>                            
						<%
							for(int i = 1; i < 40; i ++){
						%>
						<tr>                  
							<td>ID</td>                
							<td>用户ID</td>                         
							<td>用户名称</td>            
							<td>登陆账号</td>            
							<td>登陆密码</td>            
							<td>有效</td>            
							<td>这是一个测试用户，用于开发测试使用...</td>  
						</tr>
						<%	
							}
						 %>                         
					</tbody>                           
				</table>
				<div id="toolbar">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
					<input id="ss" class="easyui-searchbox" style="width:300px" data-options="prompt:'输入关键字搜索'"></input>
				</div>
			</div>
			<div title="角色管理" data-options="closable:true" style="padding:background:#eee;">
			</div>
			<div title="模块管理" data-options="closable:true" style="padding:background:#eee;">
			</div>
			<div title="系统常量管理" data-options="closable:true" style="padding:background:#eee;">
			</div>
			<div title="系统参数设置" data-options="closable:true" style="padding:background:#eee;">
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
