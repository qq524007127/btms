$(function(){
	initPanelComponent();
	initBlessSeatGrid();
	initTabletGrid();
	initExpensItemGrid();
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

/**
 * 提交表单
 */
function submitPayForm(){
	if(checkFormIsEmpty()){
		$.messager.alert('','请选择需要捐赠的项目后再提交！');
		return;
	}
	$.messager.confirm('提示','确然要提交吗？',function(flag){
		if(!flag){
			return;
		}
		$.messager.progress({
			text:'数据处理中...'
		});
		$('#payForm').form('submit',{
			success:function(data){
				$.messager.progress('close');
				data = $.parseJSON(data);
				$.messager.alert('',data.msg);
			}
		});
	});
}

/**
 * 检查是否选择了捐赠项目，如果没有则返回true，否则返回false,即检查表达是否为空
 * @returns
 */
function checkFormIsEmpty(){
	var tbNames = ['BsBuyList','tabletBuyList','itemBuyList'];
	for(var i = 0; i < tbNames.length; i ++){
		var tbody = $('#'+ tbNames[i] + ' tbody')[0];
		var tr = $(tbody).children('tr');
		if(tr.length > 0){
			return false;
		}
	}
	return true;
}

/**
 * 删除表格的行
 * @param obj
 */
function deletTR(obj){
	$(obj).parent().parent().remove();
}

function subtotal(obj,price,targetName){
	var tr = $(obj).parent().parent();
	var total = price * $(obj).val();
	var tds = $(tr).children('td');
	for(var i = 0; i < tds.length; i ++){
		var target = $(tds[i]).children('input[name='+targetName+']');
		if(target.length > 0){
			$(target).val(total);
			return;
		}
	}
}

/*=====================福位操作开始=========================*/
/**
 * 初始化福位列表
 */
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
			align:'center',
			sortable:true
		},{
			field:'lev',
			title:'所属级别',
			width:15,
			align:'center',
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
 * 显示福位选择窗口
 */
function showBSWindow(){
	$('#blessSeatWindow').dialog({
		width:900,
		height:400,
		modal:true
	});
	
	var bsIdInputs = $('#payForm input[name=blessSeatIds]');
	var queryParams = {};
	
	if(bsIdInputs.length > 0){
		var withoutIds = '';
		for(var i=0;i < bsIdInputs.length; i ++){
			withoutIds += $(bsIdInputs[i]).val() + ',';
		}
		
		queryParams.withoutIds = withoutIds.substring(0, withoutIds.length - 1);

	}

	$('#blessSeatGrid').datagrid({
		queryParams:queryParams
	});
	
	$('#BSGridSearchBox').searchbox('clear');
	$('#blessSeatGrid').datagrid('load');
}

/**
 * 搜索福位
 */
function doBSGridSearch(){
	var searchkey = $('#BSGridSearchBox').searchbox('getValue');
	var queryParams = $('#blessSeatGrid').datagrid('options').queryParams;
	if(searchkey){
		queryParams.searchKey = searchkey;
	}
	else{
		queryParams.searchKey = '';
	}
	$('#blessSeatGrid').datagrid({
		queryParams:queryParams
	});
	$('#blessSeatGrid').datagrid('load');
}


/**
 * 选择福位（普通捐赠），执行此回调方法
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
		template += '<td><input type="hidden" value="'+row.bsId+'" name="blessSeatIds">' + row.bsCode + '</td>';
		template += '<td>' + row.lev.levName + '</td>';
		template += '<td><input type="hidden" name="blessSeatPrices" value="'+row.lev.levPrice+'">' + row.lev.levPrice + '</td>';
		template += '<td><input type="hidden" value="0" name="blessSeatBuyTypes">捐赠</td>';
		template += '<td><input type="hidden" name="bsLeaseLongTime" value=0>/</td>';
		template += '<td><a href="javascript:void(0)" onclick="deletTR(this)">[删除]</a></td>';
		template += '</tr>';
	}
	$(tBody).append(template);
}

/**
 * 选择福位（租赁），执行此回调方法
 */
function checkBlessSeatOnLease(){
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
		template += '<td><input type="hidden" value="'+row.bsId+'" name="blessSeatIds">' + row.bsCode + '</td>';
		template += '<td>' + row.lev.levName + '</td>';
		template += '<td><input type="hidden" name="blessSeatPrices" value="'+row.lev.levPrice+'">/</td>';
		template += '<td><input type="hidden" value="1" name="blessSeatBuyTypes">租赁</td>';
		template += '<td><input name="bsLeaseLongTime" value=1></td>';
		template += '<td><a href="javascript:void(0)" onclick="deletTR(this)">[删除]</a></td>';
		template += '</tr>';
	}
	$(tBody).append(template);
}
/*=====================福位操作结束=========================*/


/*=====================牌位操作开始=========================*/
/**
 * 初始化牌位列表
 */
function initTabletGrid(){
	$('#tabletGrid').datagrid({
		url:'api/memberPay_tabletGrid.action',
		columns:[[{
			field:'tabletId',
			title:'ID',
			width:10,
			checkbox:true
		},{
			field:'tabletName',
			title:'牌位名称',
			align:'center',
			width:20
		},{
			field:'tabletPrice',
			title:'牌位价格',
			width:15,
			align:'center',
			sortable:true
		}, {
			field : 'editable',
			title : '年限是否可编辑',
			width : 20,
			align : 'center',
			sortable:true,
			formatter:function(value){
				if(value){
					return '可编辑';
				}
				return '不可编辑';
			}
		},{
			field:'tabletRemark',
			title:'备注',
			align:'center',
			width:30
		}]],
		toolbar:'#tlGridTB',
		fit:true,
		border:false,
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true
	});
}

/**
 * 显示牌位列表窗口
 */
function showTLWindow(){
	$('#tabletWindow').dialog({
		width:900,
		height:400,
		modal:true
	});
	var tlIdsInput = $('#payForm input[name=tabletIds]');
	var queryParams = {};
	if(tlIdsInput.length > 0){
		var withoutIds = '';
		for(var i = 0; i < tlIdsInput.length; i ++){
			withoutIds += $(tlIdsInput[i]).val() + ',';
		}
		queryParams.withoutIds = withoutIds.substring(0, withoutIds.length - 1);
	}
	$('#tabletGrid').datagrid({
		queryParams:queryParams
	});
	$('#TLGridSearchBox').searchbox('clear');
	$('#tabletGrid').datagrid('load');
}

/**
 * 牌位搜索
 */
function doTLGridSearch(){
	var searchKey = $('#TLGridSearchBox').searchbox('getValue');
	var queryParams  = $('#tabletGrid').datagrid('options').queryParams;
	if(searchKey){
		queryParams.searchKey = searchKey;
	}
	else{
		queryParams.searchKey = '';
	}
	$('#tabletGrid').datagrid({
		queryParams:queryParams
	});
	$('#tabletGrid').datagrid('load');
}

/**
 * 选择牌位
 */
function checkTablet(){
	var rows = $('#tabletGrid').datagrid('getChecked');
	if(rows.length < 1){
		$.messager.alert('','请选择需要捐赠的牌位');
		return;
	}
	$('#tabletWindow').dialog('close');
	
	var tBody = $("#tabletBuyList>tbody");
	var template = '';
	for(var i = 0; i < rows.length; i ++){
		var row = rows[i];
		template += '<tr>';
		template += '<td><input type="hidden" value="'+row.tabletId+'" name="tabletIds">' + row.tabletName + '</td>';
		template += '<td><input type="hidden" value="'+row.tabletPrice+'" name="tabletPrices">' + row.tabletPrice + '</td>';
		if(row.editable){
			template += '<td><input name="tabletBuyLongTime" value=1 onchange="subtotal(this,'+row.tabletPrice+',\'tabletTotalPrice\');"></td>';
		}
		else{
			template += '<td><input type="hidden" name="tabletBuyLongTime" value=1>1</td>';
		}
		template += '<td><input disabled=false name="tabletTotalPrice" value="'+row.tabletPrice+'"></td>';
		template += '<td><a href="javascript:void(0)" onclick="deletTR(this)">[删除]</a></td>';
		template += '</tr>';
	}
	$(tBody).append(template);
}
/*=====================牌位操作结束=========================*/


/*=====================其它收费项目操作开始=========================*/
/**
 * 初始化其它收费项目列表
 */
function initExpensItemGrid(){
	$('#expensItemGrid').datagrid({
		url : 'api/memberPay_expensItemGrid.action',
		columns:[[{
			field:'itemId',
			width:10,
			checkbox:true
		},{
			field : 'itemName',
			title : '项目名称',
			align: 'center',
			width: 20
		}, {
			field : 'itemPrice',
			title : '价格',
			width : 15,
			align : 'center',
			sortable:true
			
		}, {
			field : 'editAble',
			title : '年限是否可编辑',
			width : 20,
			align : 'center',
			sortable:true,
			formatter:function(value){
				if(value){
					return '可编辑';
				}
				return '不可编辑';
			}
		}, {
			field : 'itemRemark',
			title : '备注',
			width : 30,
			align : 'center'
		}]],
		toolbar:'#itemGridTB',
		fit : true,
		fitColumns : true,
		rownumbers : true,
		striped : true,
		pagination : true
	});
}
/**
 * 显示其他收费项目列表窗口
 */
function showItemWindow(){
	$('#expensItemWindow').dialog({
		width:900,
		height:400,
		modal:true
	});
	var params = {};
	$('#ItemSearchBox').searchbox('clear');
	$('#expensItemGrid').datagrid('load',params);
}

/**
 * 搜索其它收费项目
 */
function doItemGridSearch(){
	var searchKey = $('#ItemSearchBox').searchbox('getValue');
	var params = {};
	if(searchKey){
		params.searchKey = searchKey;
	}
	$('#expensItemGrid').datagrid('load',params);
}

/**
 * 选择收费项目
 */
function checkExpensItem(){
	var rows = $('#expensItemGrid').datagrid('getChecked');
	if(rows.length < 1){
		$.messager.alert('','请选择数据');
		return;
	}
	$('#expensItemWindow').dialog('close');
	var tBody = $("#itemBuyList>tbody");
	var template = '';
	for(var i = 0; i < rows.length; i ++){
		var row = rows[i];
		template += '<tr>';
		template += '<td><input type="hidden" value="'+row.itemId+'" name="itemIds">' + row.itemName;
		template += '<input type="hidden" name="itemNames" value="'+row.itemName+'"></td>';
		template += '<td><input type="hidden" value="'+row.itemPrice+'" name="itemPrices">' + row.itemPrice + '</td>';
		if(row.editAble){
			template += '<td><input name="itemBuyLongTime" value=1 onchange="subtotal(this,'+row.itemPrice+',\'itemTotalPrice\');"></td>';
		}
		else{
			template += '<td><input type="hidden" name="itemBuyLongTime" value=1>1</td>';
		}
		template += '<td><input disabled=false name="itemTotalPrice" value="'+row.itemPrice+'"></td>';
		template += '<td><a href="javascript:void(0)" onclick="deletTR(this)">[删除]</a></td>';
		template += '</tr>';
	}
	$(tBody).append(template);
}

/*=====================其它收费项目操作结束=========================*/