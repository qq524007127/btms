$(function() {
	$('#moduleGrid').datagrid({
		url : 'module/module_grid.action',
		columns : [ [ {
			field : 'moduleId',
			title : 'ID',
			width : 100,
			checkbox : true
		}, {
			field : 'moduleName',
			title : '模块名称',
			width : 20,
			align : 'center'
		}, {
			field : 'pageUrl',
			title : '对应页面',
			sortable : true,
			width : 20,
			align : 'center'
		}, {
			field : 'permit',
			title : '有效',
			align : 'center',
			width : 10,
			formatter : function(value, row, index) {
				if (value) {
					return '有效';
				}
				return '<span style="color:red;">无效</span>';
			}
		}, {
			field : 'parentModule',
			title : '父模块',
			align : 'center',
			width : 30,
			formatter : function(value, row, index) {
				if (value) {
					return value.moduleName;
				}
			}
		}, {
			field : 'moduleSort',
			title : '排序',
			width : 10,
			align : 'center'
		}, {
			field : 'remark',
			title : '备注',
			width : 80,
			align : 'center'
		} ] ],
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : 'showAddWin'
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function(){
				var rows = $('#moduleGrid').datagrid('getChecked');
				if(rows.length != 1){
					$.messager.alert('','一次只能修改一行数据，请勿多选或少选');
					return;
				}
				showEditWin(rows[0]);
			}
		}, '-', {
			text : '禁用',
			iconCls : 'icon-remove',
			handler:function(){
				var rows = $('#moduleGrid').datagrid('getChecked');
				if(rows.length < 1){
					$.messager.alert('','请选择需要禁用的模块');
					return;
				}
				var moduleIds = "";
				for(var i = 0; i < rows.length; i ++){
					moduleIds += rows[i].moduleId + ",";
				}
				moduleIds = moduleIds.substring(0, moduleIds.length-1);
				console.log(moduleIds);
				$.ajax({
					type : "post",
					url : "module/module_disable.action",
					dataType : "json",
					data:{'moduleIds':moduleIds},
					success: function(data){
						data = $.parseJSON(data);
						$.messager.alert('',data.msg);
					}
				});
			}
		} ],
		fit : true,
		title : '模块列表',
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true
	});
});

function showAddWin() {
	$('#addWindow').dialog({
		title : '添加模块',
		iconCls : 'icon-add',
		modal : true,
		width : 350,
		height : 250,
		onOpen : function() {
			$('#addForm').form('clear');
		},
		buttons : [ {
			text : '添加',
			iconCls : 'icon-ok',
			handler : function() {
				$('#addForm').form('submit', {
					success : function(data) {
						data = $.parseJSON(data);
						$.messager.alert('', data.msg);
						$('#moduleGrid').datagrid('load');
					}
				});
			}
		}, {
			text : '重置',
			iconCls : 'icon-cancel',
			handler : function() {
				$('#addForm').form('clear');
			}
		} ]
	});

	$('#addRootModule').combobox({
		url : 'module/root_list.action',
		valueField : 'moduleId',
		textField : 'moduleName',
		width : 150,
		panelWidth : 200,
		editable : false
	});
}

function showEditWin(module) {
	$('#editForm').form('clear');
	$('#editForm').form('load',module);
	$('#editWindow').dialog({
		title : '修改模块',
		iconCls : 'icon-add',
		modal : true,
		width : 350,
		height : 250,
		onOpen : function() {
			$('#addForm').form('clear');
		},
		buttons : [ {
			text : '修改',
			iconCls : 'icon-ok',
			handler : function() {
				$('#editForm').form('submit', {
					success : function(data) {
						data = $.parseJSON(data);
						$.messager.alert('', data.msg);
						$('#moduleGrid').datagrid('reload');
					}
				});
			}
		}, {
			text : '重置',
			iconCls : 'icon-cancel',
			handler : function() {
				$('#editForm').form('clear');
			}
		} ]
	});

	$('#editRootModule').combobox({
		url : 'module/root_list.action',
		valueField : 'moduleId',
		textField : 'moduleName',
		width : 150,
		panelWidth : 200,
		editable : false
	});
}