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
		app.addScript('member.js');
	</script>
	
  </head>
  
  <body>
 	<table id="memberGrid" data-options="toolbar:'#toolbarPanel'"></table>
 	<div id="toolbarPanel">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="showAddWindow()">添加会员</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="shwoPayWindow()">会员捐赠</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'">禁用</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'">启用</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-large-smartart'">导出</a>
		<span style="float:right;padding-right:15px;">
			<form id="searchForm" action="${pageContext.request.contextPath }/api/blessSeat_grid.action" method="post" style="padding:0;margin:0">
				<label>区域：<select id="areaCombobox" class="easyui-combo" data-options="width:'100px'"></select></label> 
				<label>级别：<select id="levelCombobox" class="easyui-combo" data-options="width:'100px'"></select></label> 
				<label>级别状态：
					<select id="leveledCombobox" name="levedState" class="easyui-combobox" data-options="width:80,panelHeight:80,editable:false">
						<option value="0">=全部=</option>
						<option value="1">已设置</option>
						<option value="2">未设置</option>
					</select>
				</label>
				<label>是否捐赠： 
					<select id="saledCombobox" class="easyui-combobox" data-options="width:80,panelHeight:80,editable:false">
						<option value="">=全部=</option>
						<option value="1">已捐赠</option>
						<option value="0">未捐赠</option>
					</select>
				</label> 
				<label>是否使用：
					<select id="usedCombobox" class="easyui-combobox" data-options="width:80,panelHeight:80,editable:false">
						<option value="">=全部=</option>
						<option value="1">已使用</option>
						<option value="0">未使用</option>
					</select>
				</label>
				<input id="searchBox" class="easyui-searchbox" data-options="searcher:'doSearch', prompt:'输入关键字搜索'" style="width:200px"></input> 
				<a id="doSearchBtn" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">查询</a> 
				<a id="clearSearchBtn" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearSearch()">清空查询条件</a>
			</form>
		</span>
	</div>
	<div id="setLevelWindow">
		<form id="setLevelForm" action="${pageContext.request.contextPath }/api/blessSeat_updateBSLevel.action" method="post" style="text-align: center;">
			<input name="ids" id="ids" type="hidden">
			<p>
				<label for="level">选择级别：</label>
				<select name="levelId"></select>
			<p>
		</form>
	</div>
  <div id="addWindow" style="text-align: center;">
    	<form id="addForm" action="${pageContext.request.contextPath }/api/member_add.action" method="post">
    		<ul class="form-item-container">
    			<li>
	    			<p>
			    		<label>会员名称：</label>
			    		<input id="editUserName" name="memberName" class="easyui-validatebox"  data-options="required:true">
			    	</p>
			    	<p>
			    		<label>名族：</label>
			    		<input id="editUserName" name="memberNational" class="easyui-validatebox"  data-options="required:true">
			    	</p>
    			</li>
    			<li>
	    			<p>
			    		<label>籍贯：</label>
			    		<input id="editUserName" name="memberNatPlace" class="easyui-validatebox"  data-options="required:true">
			    	</p>
		    		<p>
			    		<label>家庭地址：</label>
			    		<input id="editUserName" name="memberAddress" class="easyui-validatebox"  data-options="required:true">
			    	</p>
    			</li>
    			<li>
	    			<p>
			    		<label>出身日期：</label>
			    		<input id="editUserName" name="memberBirthday" class="easyui-datebox"  data-options="required:true,editable:false">
			    	</p>
			    	<p>
			    		<label>身份证号：</label>
			    		<input id="editUserName" name="memberIdentNum" class="easyui-validatebox"  data-options="required:true">
			    	</p>
    			</li>
    			<li>
	    			<p>
			    		<label>联系电话：</label>
			    		<input id="editUserName" name="memberTell" class="easyui-validatebox"  data-options="required:true">
			    	</p>
		    		<p>
			    		<label>工作单位：</label>
			    		<input id="editUserName" name="memberUnit" class="easyui-validatebox"  data-options="required:true">
			    	</p>
    			</li>
    			<li>
	    			<p>
			    		<label>性别：</label>
			    		<!-- <input id="editUserName" name="memberSex" class="easyui-validatebox"  data-options="required:true"> -->
			    		<select name="memberSex" class="easyui-combobox" data-options="editable:false,width:100,required:true">
			    			<option value="男">男</option>
			    			<option value="女">女</option>
			    			<option value="其它">其它</option>
			    		</select>
			    	</p>
			    	<p>
			    		<label>备用联系人姓名：</label>
			    		<input id="editUserName" name="spareName" class="easyui-validatebox"  data-options="required:true">
			    	</p>
    			</li>
    			<li>
		    		<p>
			    		<label>备用联系人电话：</label>
			    		<input id="editUserName" name="spareTell" class="easyui-validatebox"  data-options="required:true">
			    	</p>
    			</li>
    			<li class="clear-both">
	    			<label>备注：</label>
			    	<textarea rows="3" cols="50" name="memberRemark"></textarea>
    			</li>
    		</ul>
	    	<%-- <p>
	    		<span>
		    		<label>会员名称：</label>
		    		<input id="editUserName" name="memberName" class="easyui-validatebox"  data-options="required:true">
		    	</span>
		    	<span>
		    		<label>名族：</label>
		    		<input id="editUserName" name="memberNational" class="easyui-validatebox"  data-options="required:true">
		    	</span>
	    	</p>
	    	<p>
		    	<span>
		    		<label>籍贯：</label>
		    		<input id="editUserName" name="memberNatPlace" class="easyui-validatebox"  data-options="required:true">
		    	</span>
	    		<span>
		    		<label>家庭地址：</label>
		    		<input id="editUserName" name="memberAddress" class="easyui-validatebox"  data-options="required:true">
		    	</span>
		    </p>
		    <p>
		    	<span>
		    		<label>出身日期：</label>
		    		<input id="editUserName" name="memberBirthday" class="easyui-validatebox"  data-options="required:true">
		    	</span>
		    	<span>
		    		<label>身份证号：</label>
		    		<input id="editUserName" name="memberIdentNum" class="easyui-validatebox"  data-options="required:true">
		    	</span>
	    	</p>
	    	<p>
		    	<span>
		    		<label>联系电话：</label>
		    		<input id="editUserName" name="memberTell" class="easyui-validatebox"  data-options="required:true">
		    	</span>
	    		<span>
		    		<label>工作单位：</label>
		    		<input id="editUserName" name="memberUnit" class="easyui-validatebox"  data-options="required:true">
		    	</span>
	    	</p>
	    	<p>
		    	<span>
		    		<label>性别：</label>
		    		<input id="editUserName" name="memberSex" class="easyui-validatebox"  data-options="required:true">
		    	</span>
		    	<span>
		    		<label>备用联系人姓名：</label>
		    		<input id="editUserName" name="spareName" class="easyui-validatebox"  data-options="required:true">
		    	</span>
	    	</p>
	    	<p>
	    		<span>
		    		<label>备用联系人电话：</label>
		    		<input id="editUserName" name="spareTell" class="easyui-validatebox"  data-options="required:true">
		    	</span>
	    	</p>
	    	<p>
	    		<label>备注：</label>
		    	<textarea rows="3" cols="50" name="memberRemark"></textarea>
	    	</p> --%>
	    </form>
    </div>
    <%-- <div id="editWindow" style="text-align: center;">
    	<form id="editForm" action="${pageContext.request.contextPath }/api/shelf_edit.action" method="post">
	    	<input type="hidden" name="shelfId">
	    	<p>
	    		<span>
	    			<label for="editUserName">编号：</label>
	    			<input id="editUserName" disabled="false" name="shelfCode" class="easyui-validatebox"  data-options="required:true">
	    		</span>
	    		<span>
		    		<label for="editUserCode">所在区域：</label>
		    		<input id="editUserCode" name="shelfArea" class="easyui-validatebox" data-options="required:true">
	    		</span>
	    	</p>
	    	<p>
	    		<span>
		    		<label for="editUserCode">所在行数：</label>
		    		<input id="editUserCode" name="postionRow" class="easyui-validatebox" data-options="required:true">
	    		</span>
	    		<span>
	    			<label for="editUserCode">所在列数：</label>
	    			<input id="editUserCode" name="postionColumn" class="easyui-validatebox" data-options="required:true">
	    		</span>
	    	</p>
	    	<p>
	    		<span>
		    		<label for="editUserCode">总行数：</label>
		    		<input id="editUserCode" name="shelfRow" class="easyui-validatebox" data-options="required:true">
	    		</span>
	    		<span>
	    			<label for="editUserCode">总列数：</label>
	    			<input id="editUserCode" name="shelfColumn" class="easyui-validatebox" data-options="required:true">
	    		</span>
	    	</p>
	    	<p>
	    		<label for="editUserCode">备注：</label>
	    		<textarea rows="3" cols="50" name="remark"></textarea>
	    	</p>
	    </form>
    </div> --%>
  </body>
</html>
