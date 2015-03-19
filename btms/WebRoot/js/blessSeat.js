$(function() {
	$('#blessSeatGrid').datagrid({
		url : 'api/blessSeat_grid.action',
		columns : [ [ {
			field : 'bsfId',
			title : 'ID',
			width : 5,
			checkbox : true
		},{
			field : 'bsCode',
			title : '编号',
			align: 'center',
			width: 10
		}, {
			field : 'shelfCode',
			title : '福位架编号',
			width : 10,
			align : 'center'
		}, {
			field : 'shelfArea',
			title : '所在区域',
			width : 5,
			align : 'center'
		}, {
			field : 'lev',
			title : '级别(价格)',
			width : 15,
			align : 'center'
		}, {
			field : 'managExpense',
			title : '管理费',
			width : 10,
			align : 'center'
		}, {
			field : 'aa',
			title : '是否捐赠',
			width : 5,
			align : 'center'
		}, {
			field : 'deader',
			title : '是否已使用',
			width : 10,
			align : 'center',
			formatter:function(value){
				if(!value){
					return '未使用';
				}
				return '已使用';
			}
		}, {
			field : 'remark',
			title : '备注',
			width : 150,
			align : 'center'
		}] ],
		toolbar : [{
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
		title : '福位列表',
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true,
		loadFilter:function(data){
			var rows = [];
			for(var i = 0; i < data.rows.length; i ++){
				var row = data.rows[0];
				row.shelfCode = row.shelf.shelfCode;
				row.shelfArea = row.shelf.shelfArea;
				rows.push(row);
			}
			data = {'total':data.total,'rows':rows};
			return data;
		}
	});
});

/*function executAddUserAction(){
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
}*/