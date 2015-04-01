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
		var url = 'api/bsRecord_blessSeatGrid.action';
		if(bsRecord.memberId){
			url += '?memberId=' + bsRecord.memberId;
		}
		$('#bsRecordGrid').datagrid({
			url:url,
			columns : [ [ {
				field : 'bsId',
				title : 'ID',
				width : 10,
				checkbox : true
			},{
				field : 'bsCode',
				title : '福位编号',
				width: 15,
				align:'center'
			}, {
				field : 'lev',
				title : '价格',
				width : 20,
				align : 'center',
				formatter:function(value){
					if(value){
						return value.levPrice;
					}
				}
			}, {
				field : 'totalPrice',
				title : '捐赠总价',
				width : 10,
				align : 'center'
			}, {
				field : 'createDate',
				title : '捐赠(租赁)时间',
				width : 30,
				align : 'center'
			}, {
				field : 'donatLength',
				title : '租赁年限',
				width : 20,
				align : 'center'
			}, {
				field : 'donatOverdue',
				title : '到期时间',
				width : 20,
				align : 'center'
			}, {
				field : 'donaType',
				title : '捐赠方式',
				width : 20,
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
			}/*, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler:function(){
					var rows = $('#relationGrid').datagrid('getChecked');
					if(rows.length != 1){
						$.messager.alert('','一次只能修改一行数据，请勿多选或少选');
						return;
					}
					showEditWin(rows[0]);
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler:function(){
					var rows = $('#relationGrid').datagrid('getChecked');
					if(rows.length < 1){
						$.messager.alert('','请选需要删除的数据');
						return;
					}
					$.messager.confirm('警告','确定要删除所选数据吗？',function(flag){
						if(flag){
							var ids = '';
							for(var i = 0; i < rows.length; i ++){
								ids += rows[i].relId + ',';
							}
							ids = ids.substring(0, ids.length - 1);
							$.ajax({
								url:'api/relation_delete.action',
								type:'POST',
								data:{
									ids:ids
								},
								success:function(data){
									data = $.parseJSON(data);
									$.messager.alert('',data.msg);
									if(data.success){
										$('#relationGrid').datagrid('load');
									}
								}
							});
						}
					});
				}
			}*/],
			loadFilter:function(data){
				var dg = {};
				dg.total = data.total;
				var dataRows = data.rows;
				var rows = [];
				for(var i = 0; i < dataRows.length; i ++){
					var bs = dataRows[i];
					var br = bs.curBr;
					bs.totalPrice = br.bsRecToltalPrice;
					bs.createDate = br.bsRecCreateDate;
					bs.donatLength = br.donatLength;
					bs.donatOverdue = br.donatOverdue;
					bs.donaType = br.donatType;
					bs.payed = br.payed;
					if(br.donatType == 'lease'){
						bs.totalPrice = '/';
					}
					else{
						bs.donatLength = '/';
						bs.donatOverdue = '/';
					}
					bs.curBr = null;
					rows.push(bs);
				}
				dg.rows = rows;
				return dg;
			},
			rowStyler: function(index,row){
				if (!row.payed){
					return 'color:red;';
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