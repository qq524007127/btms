$(function() {
	initBlessSeatGrid();
	//initSearchComponents();
});

/**
 * 初始化福位列表
 */
function initBlessSeatGrid(){
	$('#memberGrid').datagrid({
		url : 'api/member_grid.action',
		columns:[[{
			field:'memberId',
			width:10,
			checkbox:true
		},{
			field : 'memberName',
			title : '会员姓名',
			align: 'center',
			sortable:true,
			width: 10
		}, {
			field : 'memberIdentNum',
			title : '身份证号',
			width : 20,
			align : 'center',
			sortable:true
		}, {
			field : 'memberCard',
			title : '会员证号',
			width : 15,
			align : 'center',
			sortable:true,
			formatter:function(value){
				if(value){
					return value.memCode;
				}
			}
		}, {
			field : 'memberSex',
			title : '性别',
			width : 10,
			align : 'center',
			sortable:true
		}, {
			field : 'memberTell',
			title : '联系电话',
			width : 15,
			align : 'center'
		}, {
			field : 'bsRecordSet',
			title : '捐赠福位',
			width : 25,
			sortable:true,
			align : 'center'
		}, {
			field : 'tlRecSet',
			title : '捐赠牌位',
			width : 25,
			sortable:true,
			align : 'center'
		}, {
			field : 'memberPermit',
			title : '是否有效',
			width : 10,
			sortable:true,
			align : 'center',
			formatter:function(value){
				if(value){
					return '有效';
				}
				return '<span style="color:red;">无效</span>';
			}
		},/* {
			field : 'aa',
			title : '是否已捐赠',
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
				return '<span style="color:red;">已使用</span>';
			}
		},*/ {
			field : 'memberRemark',
			title : '备注',
			width : 50,
			align : 'center'
		}]],
		fit : true,
		title : '会员列表',
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true/*,
		loadFilter:function(data){
			var rows = [];
			for(var i = 0; i < data.rows.length; i ++){
				var row = data.rows[i];
				row.shelfCode = row.shelf.shelfCode;
				row.shelfArea = row.shelf.shelfArea.areaName;
				rows.push(row);
			}
			data = {'total':data.total,'rows':rows};
			return data;
		},
		onBeforeLoad:function(params){
			if(params.sort){
				switch (params.sort) {
				case 'shelfArea':
					params.sort = 'shelf.shelfArea.areaName';
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
		}*/
	});
}

/**
 * 初始化查询条件
 */
function initSearchComponents(){
	$('#areaCombobox').combobox({
		url:'api/getAreas.action',
		valueField:'areaId',
		textField:'areaName',
		editable:false,
		width:80,
		panelHeight:150
	});
	$('#levelCombobox').combobox({
		url:'api/getLevels.action',
		valueField:'levId',
		textField:'levName',
		editable:false,
		panelHeight:150,
		panelWidth:150,
		formatter:function(value){
			return value.levName + '/' + value.levPrice;
		}
	});
	
	$('#setLevelForm [name=levelId]').combobox({
		url:'api/getLevels.action',
		valueField:'levId',
		textField:'levName',
		editable:false,
		width:100,
		panelHeight:150,
		panelWidth:150,
		required:true,
		formatter:function(value){
			return value.levName + '/' + value.levPrice;
		}
	});
}

/**
 * 执行搜索
 */
function doSearch(){
	var areaId = $('#areaCombobox').combobox('getValue');
	var levelId = $('#levelCombobox').combobox('getValue');
	var levedState = $('#leveledCombobox').combobox('getValue');
	var isSaled = $('#saledCombobox').combobox('getValue');
	var isUsed = $('#usedCombobox').combobox('getValue');
	var searchKey = $('#searchBox').searchbox('getValue');
	
	
	var queryParams = {};
	queryParams.levedState = levedState;
	if(searchKey && searchKey.trim()){
		queryParams.searchKey = searchKey;
	}
	if(areaId){
		queryParams.areaId = areaId;
	}
	if(levelId){
		queryParams.levelId = levelId;
	}
	
	$('#blessSeatGrid').datagrid('load',queryParams);
}

function clearSearch(){
	$('#searchForm').form('reset');
	$('#blessSeatGrid').datagrid('load',{
		queryParams:{}
	});
}

/**
 * 添加会员
 */
function showAddWindow(){
	$('#addWindow').dialog({
		title:'添加会员',
		iconCls:'icon-add',
		width:600,
		height:350,
		modal:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				$('#addForm').form('submit',{
					success:function(data){
						data=$.parseJSON(data);
						$.messager.alert('',data.msg);
						if(data.success){
							$('#addWindow').dialog('close');
							$('#memberGrid').datagrid('load');
						}
					}
				});
			}
		},{
			text:'重置',
			iconCls:'icon-cancel',
			handler:function(){
				$('#addForm').form('clear');
			}
		}]
	});
	$('#addForm').form('clear');
}

/**
 * 会员捐赠(会员缴费)
 */
function shwoPayWindow(){
	var rows = $('#memberGrid').datagrid('getChecked');
	if(rows.length != 1){
		$.messager.alert('提示','一次只能捐赠一个会员，请勿多选或少选！');
		return;
	}
	var href = 'admin/memberPay.action?memberId=' + rows[0].memberId;
	$('<div></div>').window({
		title:'会员捐赠',
		fit:true,
		modal:true,
		maximizable:false,
		minimizable:false,
		collapsible:false,
		content:'<iframe width=100% height=100% frameborder=0 src="'+href+'">'
	});
}