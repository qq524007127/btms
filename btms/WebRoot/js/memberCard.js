(function(win){
	var memberCard = {};
	memberCard.init = function(){
		memberCard.memberCardGridUrl = 'api/memberCard_grid.action';
		initMemberCardGrid();
	};
	function initMemberCardGrid(){
		$('#memberCardGrid').datagrid({
			url:memberCard.memberCardGridUrl,
			columns : [ [ {
				field : 'cardId',
				title : 'ID',
				width : 10,
				checkbox : true
			},{
				field : 'cardCode',
				title : '区域名称',
				width: 15,
				align:'center'
			}, {
				field : 'createDate',
				title : '办理时间',
				width : 20,
				sortable : true,
				align : 'center'
			}, {
				field : 'mem',
				title : '对应会员',
				width : 20,
				sortable : true,
				align : 'center',
				formatter:function(value){
					if(value){
						return value.memberName;
					}
				}
			}, {
				field : 'enterprise',
				title : '对应企业',
				width : 20,
				sortable : true,
				align : 'center',
				formatter:function(value){
					if(value){
						return value.enterName;
					}
				}
			}, {
				field : 'permit',
				title : '是否有效',
				width : 10,
				align : 'center',
				formatter:function(value){
					if(value){
						return '有效';
					}
					return '<span style="color:red;">无效</span>';
				}
			}, {
				field : 'remark',
				title : '备注',
				width : 30,
				align : 'center',
				formatter:function(value){
					if(value){
						return '<span title="'+value+'">'+value+'</span>';
					}
				}
			}] ],
			fit : true,
			title : '会员证列表',
			fitColumns : true,
			rownumbers : true,
			striped : true,
			pagination : true
		});
	}
	win.memberCard = memberCard;
	$(function(){
		memberCard.init();
	});
})(window);