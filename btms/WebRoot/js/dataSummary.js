(function(win, $) {
	$(function() {
		initSummaryGrid();
		initGridToolbar();
	});

	function initGridToolbar() {

		var startDateCtr = $('#startDate');
		var endDateCtr = $('#endDate');

		$('#downLoadBtn').click(function() {
			url = win.app.baseUrl + '/dataSummary/summaryFile.action?';
			var start = startDateCtr.datebox('getValue');
			var end = endDateCtr.datebox('getValue');
			url += 'startDate=' + (start ? start : '');
			url += '&endDate=' + (end ? end : '');
			win.open(url);
		});

		$('#printBtn').click(function() {

		});

		$('#searchBtn').click(function() {
			var param = {};
			var start = startDateCtr.datebox('getValue');
			var end = endDateCtr.datebox('getValue');
			if (start) {
				param.startDate = start;
			}
			if (end) {
				param.endDate = end;
			}
			datagridSearch(param);
		});

		$('#resetSearchBtn').click(function() {
			startDateCtr.datebox('clear');
			endDateCtr.datebox('clear');
			datagridSearch(null);
		});
	}

	function datagridSearch(param) {
		if (param) {
			$('#summaryGrid').datagrid('load', param);
			return;
		}
		$('#summaryGrid').datagrid('load', {});
	}

	/**
	 * 初始化汇总列表
	 */
	function initSummaryGrid() {
		$('#summaryGrid').datagrid({
			url : 'api/dataSummary_grid.action',
			columns : [ [ {
				title : '',
				colspan : 1
			}, {
				title : "福位统计",
				colspan : 4
			}, {
				title : "牌位统计",
				colspan : 2
			}, {
				title : "管理费统计",
				colspan : 2
			}, {
				title : "会员费统计",
				colspan : 2
			}, {
				title : "其它费用统计",
				colspan : 2
			}, {
				title : '',
				colspan : 1
			} ], [ {
				field : 'createDate',
				title : '统计日期',
				width : 10,
				sortable : true,
				align : 'center'
			}, {
				field : 'bsBuyCount',
				title : '捐赠数量',
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'bsBuyTotalPrice',
				title : '捐赠金额',
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'bsLeaseCount',
				title : '租赁数量',
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'bsLeaseTotalPrice',
				title : "租赁金额",
				align : 'center',
				sortable : true,
				width : 10
			}/*
				 * ,{ field : 'bsSurplus', title : "剩余数量", align:'center',
				 * width:10 }
				 */, {
				field : 'tbltBuyCount',
				title : "捐赠数量",
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'tblTotalPrice',
				title : "捐赠金额",
				align : 'center',
				sortable : true,
				width : 10
			}/*
				 * ,{ field : 'tblSurplus', title : "剩余数量", align:'center',
				 * width:10 }
				 */, {
				field : 'memberCount',
				title : "缴费数量",
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'memberTotalPrice',
				title : "缴费金额",
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'mngRecCount',
				title : "缴费数量",
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'mngTotalPrice',
				title : "缴费金额",
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'itemCount',
				title : "数量",
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'itemTotalPrice',
				title : "金额",
				align : 'center',
				sortable : true,
				width : 10
			}, {
				field : 'total',
				title : "小计",
				align : 'center',
				sortable : true,
				width : 10
			} ] ],
			toolbar : '#toolbarPanel',
			fit : true,
			title : '数据汇总表',
			fitColumns : true,
			rownumbers : true,
			pagination : true,
			striped : true
		});
	}
})(window, $);