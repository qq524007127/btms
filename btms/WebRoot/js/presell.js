(function($) {

	$(function() {
		initGridToolbar();
		initPrsellGrid();
	});

	function initGridToolbar() {
		$('#presellGridSearchBox').searchbox({
			width : 300,
			prompt : '输入关键字搜索',
			menu : '#searchboxMenu',
			searcher : function(value, name) {
				var param = {};
				if (name && value) {
					param.searchName = name;
					param.searchValue = value;
				}
				$('#presellGrid').datagrid('load', param);
			}
		});

		$('#presellBtn').click(function() {
			$('#presellWindow').dialog('open');
			$('#addForm').form('reset');
		});

		$('#cashBtn').click(function(){
			var rows = $('#presellGrid').datagrid('getChecked');
			if (rows.length != 1) {
				$.messager.alert('', '一次只能操作一条数据,请勿都选或少选');
				return;
			}
			var ps = rows[0];
			var href='admin/presell.action?memberId';
			$('#cashDialog').dialog({
				width:600,
				height:400,
				title:'选择福位',
				iconCls:'icoc-ok',
				modal:true,
				content:'<iframe width=100% height=100% frameborder=0 src="'+href+'">',
				onOpen:function(){
					alert('open');
				},
				onClose:function(){
					$('#cashDialog').html('');
					$('#presellGrid').datagrid('load');
				}
			});
		});
		
		$('#printBtn').click(function(){
			var rows = $('#presellGrid').datagrid('getChecked');
			if (rows.length != 1) {
				$.messager.alert('', '一次只能打印一条数据,请勿都选或少选');
				return;
			}
			var url = window.app.host + "/download/payInfo.action?payRecId=" + rows[0].pRecord.payRecId;
			$.openExcelPreview(url,{});
		});
		
		$('#cancelBtn').click(function() {
			var rows = $('#presellGrid').datagrid('getChecked');
			if (rows.length < 1) {
				$.messager.alert('', '请选择数据');
				return;
			}
			var psIds = '';
			for (var i = 0; i < rows.length; i++) {
				if(rows[i].cash){
					$.messager.alert('','编号为："' + rows[i].orderCode + '"的预订单已经兑换福位，不能取消。');
					return;
				}
				psIds += rows[i].psId + ",";
			}
			$.post('api/presell_cancel.action', {
				psIds : psIds
			}, function(data) {
				data = $.parseJSON(data);
				$.messager.show({
					msg : data.msg
				});
				if (data.success) {
					$('#presellGrid').datagrid('load');
				}
			}, 'text');
		});
	}
	
	function initPrsellGrid() {
		$('#presellGrid').datagrid({
			url : 'api/presell_grid.action',
			columns : [ [ {
				field : 'psId',
				title : 'ID',
				width : 10,
				checkbox : true
			}, {
				field : 'orderCode',
				title : '订单号',
				width : 20,
				align : 'center'
			}, {
				field : 'psPrice',
				title : '预定单价',
				width : 15,
				align : 'center'
			}, {
				field : 'psCount',
				title : '预定数量',
				width : 20,
				sortable : true,
				align : 'center'
			}, {
				field : 'totalPrice',
				title : '预定总价',
				width : 20,
				sortable : true,
				align : 'center'
			}, {
				field : 'pRecord',
				title : '预定时间',
				width : 30,
				align : 'center',
				formatter : function(value) {
					if (value) {
						return value.payDate;
					}
				}
			}, {
				field : 'cash',
				title : '是否兑现',
				width : 20,
				sortable : true,
				align : 'center',
				formatter : function(value) {
					if (value) {
						return '已兑现';
					}
					return '未兑现';
				}
			} ] ],
			toolbar : '#toolbarPanel',
			fit : true,
			title : '预定列表',
			fitColumns : true,
			pageSize : 20,
			rownumbers : true,
			striped : true,
			pagination : true
		});
	}
	
})(jQuery);

function submitForm() {
	$('#addForm')
			.form(
					'submit',
					{
						success : function(data) {
							data = $.parseJSON(data);
							$.messager.show({
								msg : data.msg
							});
							if (data.success) {
								$('#presellWindow').dialog('close');
								$('#presellGrid').datagrid('load');
								$.messager.confirm('','预定成功是否现在打印预定清单',function(flag) {
													if (flag) {
														var result = data.attribute;
														var url = window.app.host
																+ "/download/payInfo.action?payRecId="
																+ result.payRecId;
														$.openExcelPreview(url,
																{});
													}
												});
							}
						}
					});
}

function sumTotalPrice() {
	var countInput = $('#psCount');
	var priceInput = $('#psPrice');
	var totalPrice = $('#addForm input[name=totalPrice]');
	alert(countInput.val() + " || " + priceInput.val() + " || "
			+ totalPrice.val() + " || " + $('#memberId').val());
	totalPrice.val(countInput.val() * priceInput.val());
}
