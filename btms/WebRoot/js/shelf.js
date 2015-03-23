$(function() {
	$('#shelfGrid').datagrid({
		url : 'api/shelf_grid.action',
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
			width : 15,
			align : 'center'
		}, {
			field : 'shelfRow',
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
		},  {
			field : 'remark',
			title : '备注',
			width : 50,
			align : 'center'
		}] ],
		toolbar : [/* {
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
		}, '-', */{
			text : '修改',
			iconCls : 'icon-edit',
			handler:function(){
				var rows = $('#shelfGrid').datagrid('getChecked');
				if(rows.length != 1){
					$.messager.alert('','一次只能修改一行数据，请勿多选或少选');
					return;
				}
				showEditWin(rows[0]);
			}
		} ],
		fit : true,
		title : '福位架列表',
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true,
		loadFilter:function(data){
			var rows = [];
			for(var i = 0; i < data.rows.length; i ++){
				var row = data.rows[i];
				row.shelfArea = row.shelfArea.areaName;
				rows.push(row);
			}
			data = {'total':data.total,'rows':rows};
			return data;
		},
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
		title:'编辑信息',
		width:500,
		height:350,
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
}