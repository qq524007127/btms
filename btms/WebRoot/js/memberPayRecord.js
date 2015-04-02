(function(win){
	var memberPay = {};
	memberPay.init = function(memberId){
		memberPay.memberId = memberId;
		initPayRecordGrid();
	};
	/**
	 * 初始化捐赠福位列表
	 */
	function initPayRecordGrid(){
		var url = 'api/memberPayRecord_grid.action';
		if(memberPay.memberId){
			url += '?memberId=' + memberPay.memberId;
		}
		$('#payRecordGrid').datagrid({
			url:url,
			columns : [ [{
				field : 'payDate',
				title : '收款时间',
				width: 15,
				sortable:true,
				align:'center'
			}, {
				field : 'totalPrice',
				title : '收款金额',
				width : 20,
				sortable:true,
				align : 'center'
			}, {
				field : 'payUser',
				title : '收款人',
				width : 10,
				align : 'center',
				formatter:function(value){
					if(value){
						return value.userName;
					}
				}
			},  {
				field : 'payRecId',
				title : '操作',
				width : 10,
				align : 'center',
				formatter:function(value){
					if(!value){
						return;
					}
					var href = 'admin/payInfo.action?payRecId=' + value;
					return '<a title="打印" class="icon-print" target="_blank" href="'+href+'">&nbsp;&nbsp;&nbsp;&nbsp;</a>';
				}
			}] ],
			loadFilter:function(data){
				for(var i = 0; i < data.rows.length; i ++){
					
				}
				return data;
			},
			onLoadError:function(){
				$.messager.alert('','加载数据出错了！');
			},
			singleSelect:true,
			fit : true,
			title : '缴费记录',
			fitColumns : true,
			rownumbers : true,
			striped : true,
			pagination : true
		});
	}
	
	win.memberPay = memberPay;
})(window);