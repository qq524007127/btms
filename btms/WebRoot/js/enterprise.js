(function(win){
	var enter = {};
	enter.init = function(){
		enter.initSelfGrid();
		enter.initSearchBox();
	};
	enter.initSelfGrid = function(){
		$('#enterpriseGrid').datagrid({
			url : 'api/enterprise_grid.action',
			columns : [ [ {
				field : 'enterId',
				title : 'ID',
				width : 10,
				checkbox : true
			},{
				field : 'enterName',
				title : '企业名称',
				width: 15,
				align:'center'
			}, {
				field : 'enterAddress',
				title : '企业地址',
				width : 20,
				align : 'center'
			}, {
				field : 'busLisCode',
				title : '营业执照代码',
				width : 20,
				align : 'center'
			}, {
				field : 'legalPersonName',
				title : '法定代表人姓名',
				width : 20,
				align : 'center'
			}, {
				field : 'enterTell',
				title : '联系电话',
				width : 20,
				align : 'center'
			}, {
				field : 'spareName',
				title : '备用联系人',
				width : 20,
				align : 'center'
			}, {
				field : 'spareTell',
				title : '备用联系电话',
				width : 20,
				align : 'center'
			}, {
				field : 'enterPermit',
				title : '是否有效',
				width : 20,
				align : 'center',
				sortable : true,
				formatter:function(val){
					if(val){
						return '有效';
					}
					return '<span style="color:red;">无效</span>';
				}
			}, {
				field : 'enterRemark',
				title : '备注',
				width : 30,
				align : 'center'
			}] ],
			fit : true,
			title : '企业列表',
			fitColumns : true,
			rownumbers : true,
			striped : true,
			pagination : true
		});
	};
	
	enter.initSearchBox = function(){
		$('#enterpriseSearchBox').searchbox({
			width:300,
			prompt:'输入关键字搜索',
			searcher:function(value,name){
				enter.doSearch(value,name);
			},
			menu:'#searchboxMenu'
		});
	};
	
	enter.doSearch = function(searchValue, searchName){
		var param = {};
		if(searchName && searchValue){
			param.searchName = searchName;
			param.searchValue = searchValue;
		}
		$('#enterpriseGrid').datagrid('options').queryParams = param;
		$('#enterpriseGrid').datagrid('load');
	};
	
	enter.showAddEnterWindow = function (){
		$('#addWindow').dialog({
			title:'添加企业',
			width:650,
			height:380,
			modal:true,
			iconCls:'icon-add',
			buttons:[{
				text:'添加',
				iconCls:'icon-ok',
				handler:function(){
					$('#addForm').form('submit',{
						success:function(data){
							data = $.parseJSON(data);
							$.messager.alert('',data.msg);
							if(data.success){
								$('#addWindow').dialog('close');
								$('#enterpriseGrid').datagrid('load');
							}
						}
					});
				}
			},{
				text:'重置',
				iconCls:'icon-cancel',
				handler:function(){
					$('#addForm').form('reset');
				}
			}]
		});
		$('#addForm').form('reset');
	};
	
	enter.showEidtInfoWindow = function(){
		var rows = $('#enterpriseGrid').datagrid('getChecked');
		if(rows.length != 1){
			$.messager.alert('','一次只能修改一条数据，请勿多选或少选！');
			return;
		}
		$('#editWindow').dialog({
			title:'企业信息修改',
			width:650,
			height:380,
			modal:true,
			iconCls:'icon-edit',
			buttons:[{
				text:'修改',
				iconCls:'icon-ok',
				handler:function(){
					$('#editForm').form('submit',{
						success:function(data){
							data = $.parseJSON(data);
							$.messager.alert('',data.msg);
							if(data.success){
								$('#editWindow').dialog('close');
								$('#enterpriseGrid').datagrid('reload');
							}
						}
					});
				}
			}]
		});
		$('#editForm').form('reset');
		$('#editForm').form('load',rows[0]);
		$('#editForm input[name=enterPermit]').prop('checked',rows[0].enterPermit);
	};
	
	win.enterprise = enter;
	
	$(function(){
		enter.init();
	});
})(window);

function showAddWindow(){
	enterprise.showAddEnterWindow();
}

function showEditWindow(){
	enterprise.showEidtInfoWindow();
}

/**
 * 企业捐赠(企业缴费)
 */
function shwoPayWindow(){
	var rows = $('#enterpriseGrid').datagrid('getChecked');
	if(rows.length != 1){
		$.messager.alert('提示','一次只能操作一条数据，请勿多选或少选！');
		return;
	}
	
	if(!rows[0].enterPermit){
		$.messager.alert('提示','您选择的企业已无效，不能捐赠，请重新选择');
		return;
	}
	
	var href = 'admin/enterprisePay.action?enterId=' + rows[0].enterId;
	$('<div></div>').window({
		title:'企业捐赠',
		fit:true,
		modal:true,
		maximizable:false,
		minimizable:false,
		collapsible:false,
		draggable:false,
		content:'<iframe width=100% height=100% frameborder=0 src="'+href+'">'
	});
}