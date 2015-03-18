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
			width : 20,
			align : 'center'
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
			},
			align : 'center'
		}, {
			field : 'remark',
			title : '备注',
			width : 40,
			align : 'center'
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
			iconCls : 'icon-edit',
			handler:function(){
				var rows = $('#roleGrid').datagrid('getChecked');
				if(rows.length != 1){
					$.messager.alert('','一次只能修改一行数据，请勿多选或少选');
					return;
				}
				showEditWin(rows[0]);
			}
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

function showEditWin(role){
	$('#editWindow').dialog({
		title:'编辑角色',
		width:350,
		height:250,
		modal:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				$('#editForm').form('submit',{
					success:function(data){
						data = $.parseJSON(data);
						$.messager.alert('',data.msg);
						if(data.success){
							$('#roleGrid').datagrid('load');
							$('#editWindow').dialog('close');
						}
					}
				});
			}
		}]
	});
	$('#editForm').form('clear');
	$('#editForm').form('load',role);
	var moduleIds = $('#editForm input[name="moduleIds"]');
	var mods = role.modSet;
	for(var j = 0; j < mods.length; j ++){
		for(var i=0; i< moduleIds.length; i ++){
			if(mods[j].moduleId == $(moduleIds[i]).val()){
				$(moduleIds[i]).prop('checked',true);
			}
		}
	}
}