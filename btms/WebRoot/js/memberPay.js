$(function(){
	initPanelComponent();
	initBlessSeatGrid();
});

function initPanelComponent(){
	$('#mainPanel').panel({
		border:false,
		fit:true
	});
	$('#memberInfoPanel').panel({
		title:'会员信息',
		height:'20%',
		width:'100%',
		border:false
	});
	$('#memberPayItemPanel').panel({
		title:'捐赠项目',
		height:'80%',
		width:'100%',
		border:false
	});
}

function initBlessSeatGrid(){
	$('#blessSeatGrid').datagrid({
		url:'api/memberPay_blessSeatGrid.action',
		columns:[[{
			field:'bsId',
			title:'ID',
			width:10,
			checkbox:true
		},{
			field:'bsCode',
			title:'福位编号',
			width:20,
			sortable:true
		},{
			field:'lev',
			title:'所属级别',
			width:15,
			sortable:true,
			formatter:function(value){
				if(value){
					return value.levName + "/" + value.levPrice;
				}
			}
		}]],
		toolbar:'#bsGridTB',
		onBeforeLoad:function(params){
			if(params.sort){
				switch (params.sort) {
				case 'lev':
					params.sort = 'lev.levPrice';
					break;
				default:
					break;
				}
			}
		},
		fit:true,
		border:false,
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true
	});
}

/**
 * 选择福位，执行此回调方法
 */
function checkBlessSeat(){
	var rows = $('#blessSeatGrid').datagrid('getChecked');
	if(rows.length < 1){
		$.messager.alert('','请选择需要捐赠的福位');
		return;
	}
	$('#blessSeatWindow').dialog('close');
	
	var tBody = $("#BsBuyList>tbody");
	var template = '';
	for(var i = 0; i < rows.length; i ++){
		var row = rows[i];
		template += '<tr>';
		template += '<input type="hidden" value="'+row.bsId+'" name="bsId">';
		template += '<input type="hidden" value="'+row.lev.levPrice+'" disabled=false name="bsPrice" style="border:none;">';
		template += '<td>' + row.bsCode + '</td>';
		template += '<td>' + row.lev.levName + '</td>';
		template += '<td>' + row.lev.levPrice + '</td>';
		template += '<td><a href="javascript:void(0)" onclick="deletTR(this)">[删除]</a></td>';
		template += '</tr>';
	}
	$(tBody).append(template);
}

function deletTR(obj){
	$(obj).parent().parent().remove();
}

/**
 * 搜索福位
 */
function doBSGridSearch(){
	var searchkey = $('#BSGridSearchBox').searchbox('getValue');
	var params = {};
	if(searchkey){
		params.searchKey = searchkey;
		var queryParams = $('#blessSeatGrid').datagrid('options').queryParams;
		if(queryParams.bsIds){
			params.bsIds = queryParams.bsIds;
		}
	}
	$('#blessSeatGrid').datagrid('load',params);
}

function showBSWindow(){
	$('#blessSeatWindow').dialog({
		width:900,
		height:400,
		modal:true
	});
	var bsIds = '';
	var bsIdInputs = $('#payForm input[name=bsId]');
	for(var i=0;i < bsIdInputs.length; i ++){
		bsIds += $(bsIdInputs[i]).val() + ',';
	}

	var options = $('#blessSeatGrid').datagrid('options');
	if(bsIdInputs){
		$('#blessSeatGrid').datagrid({
			queryParams:{
				bsIds:bsIds
			}
		});
	}
	else{
		$('#blessSeatGrid').datagrid({
			queryParams:{}
		});
	}
	
	$('#BSGridSearchBox').searchbox('clear');
	$('#blessSeatGrid').datagrid('load');
	console.log(options.queryParams);
}

function showTLWindow(){
	$('#tabletWindow').dialog({
		width:900,
		height:600,
		modal:true
	});
}

function showItemWindow(){
	$('#expensItemWindow').dialog({
		width:900,
		height:600,
		modal:true
	});
}