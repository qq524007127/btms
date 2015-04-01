(function(win){
	var bsRecord = {};
	bsRecord.init = function(memberId){
		bsRecord.memberId = memberId;
		initComponents();
	};
	
	/**
	 * 初始化社会关系列表
	 */
	function initComponents(){
		var url = 'api/bsRecord_grid.action';
		if(bsRecord.memberId){
			url += '?memberId=' + bsRecord.memberId;
		}
		$('#bsRecordGrid').datagrid({
			url:url,
			columns : [ [ {
				field : 'bsRecId',
				title : 'ID',
				width : 10,
				checkbox : true
			},{
				field : 'bsCode',
				title : '福位编号',
				width: 15,
				sortable:true,
				align:'center'
			}, {
				field : 'bsPrice',
				title : '价格',
				width : 20,
				sortable:true,
				align : 'center',
				formatter:function(value){
					if(value){
						return value;
					}
				}
			}, {
				field : 'bsRecToltalPrice',
				title : '捐赠总价',
				width : 10,
				align : 'center',
				formatter:function(value,row,index){
					if(row.donatType == 'buy'){
						return value;
					}
					return '/';
				}
			}, {
				field : 'bsRecCreateDate',
				title : '捐赠(租赁)时间',
				width : 30,
				sortable:true,
				align : 'center'
			}, {
				field : 'donatLength',
				title : '租赁年限',
				width : 20,
				align : 'center',
				formatter:function(value,row,index){
					if(row.donatType == 'buy'){
						return '/';
					}
					return value;
				}
			}, {
				field : 'donatOverdue',
				title : '到期时间',
				width : 20,
				align : 'center',
				formatter:function(value,row,index){
					if(row.donatType == 'buy'){
						return '/';
					}
					return value;
				}
			}, {
				field : 'donatType',
				title : '捐赠方式',
				width : 20,
				sortable:true,
				align : 'center',
				formatter:function(value){
					if(value == 'lease'){
						return '租赁';
					}
					return '捐赠';
				}
			}, {
				field : 'payed',
				title : '是否已付款',
				width : 20,
				align : 'center',
				formatter:function(value){
					if(value){
						return '已付款';
					}
					return '未付款';
				}
			}] ],
			toolbar : [ {
				text : '退捐',
				iconCls : 'icon-remove',
				handler : function() {
					var rows = $('#bsRecordGrid').datagrid('getChecked');
					//if(rows)
				}
			}],
			rowStyler: function(index,row){
				if (!row.payed){
					return 'color:red;';
				}
			},
			loadFilter:function(data){
				for(var i = 0; i < data.rows.length; i ++){
					data.rows[i].bsCode = data.rows[i].blessSeat.bsCode;
					data.rows[i].bsPrice = data.rows[i].blessSeat.lev.levPrice;
				}
				return data;
			},
			onLoadError:function(){
				$.messager.alert('','加载数据出错了！');
			},
			onBeforeLoad:function(param){
				if(param.sort){
					switch (param.sort) {
					case 'bsCode':
						param.sort = 'blessSeat.bsCode';
						break;
					case 'bsPrice':
						param.sort = 'blessSeat.lev.levPrice';
						break;
					default:
						break;
					}
				}
			},
			fit : true,
			title : '捐赠福位列表',
			fitColumns : true,
			rownumbers : true,
			striped : true,
			pagination : true
		});
	}
	
	win.bsRecord = bsRecord;
})(window);