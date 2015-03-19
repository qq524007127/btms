$(function() {
	$('#blessSeatGrid').datagrid({
		url : 'api/blessSeat_grid.action',
		columns:[[{
			field:'bsId',
			width:10,
			checkbox:true
		},{
			field : 'bsCode',
			title : '编号',
			align: 'center',
			sortable:true,
			width: 10
		}, {
			field : 'shelfCode',
			title : '福位架编号',
			width : 10,
			align : 'center',
			sortable:true
			
		}, {
			field : 'shelfArea',
			title : '所在区域',
			width : 10,
			align : 'center',
			sortable:true
		}, {
			field : 'lev',
			title : '级别(价格)',
			width : 10,
			align : 'center',
			sortable:true,
			formatter:function(value){
				if(!value){
					return value;
				}
				return value.levName + '/' + value.levPrice;
			}
		}, {
			field : 'managExpense',
			title : '管理费',
			width : 10,
			sortable:true,
			align : 'center'
		}, {
			field : 'aa',
			title : '是否捐赠',
			width : 10,
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
			width : 50,
			align : 'center'
		}]],
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
		},
		onBeforeLoad:function(params){
			console.log(params);
			if(params.sort){
				switch (params.sort) {
				case 'shelfArea':
					params.sort = 'shelf.shelfArea';
					break;
				case 'shelfCode':
					params.sort = 'shelf.shelfCode';
					break;
				case 'lev':
					params.sort = 'lev.levPrice';
					break;
				default:
					break;
				}
			}
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