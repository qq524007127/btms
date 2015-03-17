$(function() {
	$('#roleGrid').datagrid({
		url : 'role/role_grid.action',
		columns : [ [ {
			field : 'roleId',
			title : 'ID',
			width : 10,
			checkbox : true
		}, {
			field : 'roleName',
			title : '角色名称',
			width : 20
		}, {
			field : 'modSet',
			title : '权限',
			width : 30,
			formatter : function(value, row, index) {
				if(!value){
					return;
				}
				var retVal = '';
				for(var i = 0; i < value.length; i ++){
					retVal += value[i].moduleName + "、";
				}
				return retVal;
				//return retVal.length > 1 ? retVal.subString(0,retVal.length - 1): retVal;
			}
		}, {
			field : 'remark',
			title : '备注',
			width : 40
		} ] ],
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				$('#addWindow').dialog({
					title : '添加角色',
					width : 350,
					height : 250,
					modal:true,
					buttons : [ {
						text : '添加',
						iconCls : 'icon-ok',
						handler : function(){
							executAddRoleAction();
						}
					} ]
				});
				$('#addForm').form('clear');
			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit'
		} ],
		fit : true,
		title : '角色列表',
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true
	});
});

function executAddRoleAction(){
	$('#addForm').form('submit',{
		success:function(data){
			data = $.parseJSON(data);
			console.log(data);
			$.messager.alert('',data.msg);
			if(data.success){
				$('#roleGrid').datagrid('load');
			}
		}
	});
}