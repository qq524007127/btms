$(function() {
	$('#shelfGrid').datagrid({
		url : 'user/user_grid.action',
		columns : [ [ {
			field : 'shelfId',
			title : 'ID',
			width : 10,
			checkbox : true
		},{
			field : 'shelfCode',
			title : '编号',
			align: 'center',
			width: 15
		}, {
			field : 'shelfArea',
			title : '所在区域',
			width : 20,
			align : 'center'
		}, {
			field : 'sheltRow',
			title : '总行数',
			width : 15,
			align : 'center'
		}, {
			field : 'shelfColumn',
			title : '总列数',
			width : 15,
			align : 'center'
		}, {
			field : 'postionRow',
			title : '所在区域行',
			width : 15,
			align : 'center'
		}, {
			field : 'postionColumn',
			title : '所在区域列',
			width : 15,
			align : 'center'
		}, {
			field : 'valid',
			title : '是否有效',
			width : 15,
			formatter:function(value,row,index){
				if(value){
					return '有效';
				}
				return '<span style="color:red">无效</span>';
			},
			align : 'center'
		}, {
			field : 'remark',
			title : '备注',
			width : 50,
			align : 'center'
		}] ],
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				$('#addWindow').dialog({
					title : '添加用户',
					width : 350,
					height : 250,
					iconCls:'icon-add',
					modal:true,
					buttons : [ {
						text : '添加',
						iconCls : 'icon-ok',
						handler : function(){
							executAddUserAction();
						}
					} ]
				});
				$('#addForm').form('clear');
				$('#addPermit').prop('checked',true);
			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler:function(){
				var rows = $('#userGrid').datagrid('getChecked');
				if(rows.length != 1){
					$.messager.alert('','一次只能修改一行数据，请勿多选或少选');
					return;
				}
				showEditWin(rows[0]);
			}
		}, '-', {
			text : '重置密码',
			iconCls : 'icon-cancel',
			handler:function(){
				var rows = $('#userGrid').datagrid('getChecked');
				if(rows.length < 1){
					$.messager.alert('','请勾选需要操纵的数据');
					return;
				}
				var userIds = '';
				for(var i = 0; i < rows.length; i ++){
					userIds += rows[i].userId + ',';
				}
				userIds = userIds.trim().substring(0, userIds.length - 1);
				$.ajax({
					type : "post",
					url : "user/user_resetPassword.action",
					dataType : "text",
					data:{'userIds':userIds},
					success: function(data){
						data = $.parseJSON(data);
						$.messager.alert('',data.msg);
						if(data.success){
							$('#userGrid').datagrid('load');
						}
					}
				});
			}
		} ],
		fit : true,
		title : '福位架列表',
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true
	});
});

function executAddUserAction(){
	$('#addForm').form('submit',{
		success:function(data){
			data = $.parseJSON(data);
			$.messager.alert('',data.msg);
			if(data.success){
				$('#userGrid').datagrid('load');
				$('#addWindow').dialog('close');
			}
		}
	});
}

function showEditWin(user){
	$('#editWindow').dialog({
		title:'编辑用户',
		width:350,
		height:250,
		iconCls:'icon-edit',
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
							$('#userGrid').datagrid('load');
							$('#editWindow').dialog('close');
						}
					}
				});
			}
		}]
	});
	$('#editForm').form('clear');
	$('#editForm').form('load',user);
	$('#editPermit').prop('checked',user.permit);
	var roleIds = $('#editForm input[name="roleIds"]');
	var roles = user.roleSet;
	for(var j = 0; j < roles.length; j ++){
		for(var i=0; i< roleIds.length; i ++){
			if(roles[j].roleId == $(roleIds[i]).val()){
				$(roleIds[i]).prop('checked',true);
			}
		}
	}
}