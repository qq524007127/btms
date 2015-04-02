(function(win){
	var deader = {};
	deader.init = function(){
		initDeaderGird();
	};
	
	deader.showAddWindow = function(){
		$('#addWindow').dialog({
			title:'添加使用者',
			iconCls:'icon-add',
			width:600,
			height:450,
			modal:true,
			buttons:[{
				text:'添加',
				iconCls:'icon-ok'
			}]
		});
	};
	
	function initDeaderGird(){
		$('#deaderGrid').datagrid({
			url:'api/deader_grid.action',
			columns : [ [ {
				field : 'userId',
				title : 'ID',
				width : 10,
				checkbox : true
			},{
				field : 'password',
				title : 'pass',
				hidden: true
			}, {
				field : 'userCode',
				title : '登陆账号',
				width : 20,
				align : 'center'
			}, {
				field : 'userName',
				title : '用户姓名',
				width : 30,
				align : 'center'
			}, {
				field : 'permit',
				title : '是否有效',
				width : 10,
				formatter:function(value,row,index){
					if(value){
						return '有效';
					}
					return '<span style="color:red">无效</span>';
				},
				align : 'center'
			}, {
				field : 'roleSet',
				title : '角色',
				width : 50,
				formatter:function(value, row ,index){
					if(value && value.length > 0){
						var retVal = '';
						for(var i = 0; i < value.length; i ++){
							retVal += value[i].roleName + '、';
						}
						return retVal;
					}
					return value;
				},
				align : 'center'
			}] ],
			fit : true,
			title : '使用者列表',
			fitColumns : true,
			rownumbers : true,
			striped : true,
			pagination : true
		});
	}
	win.deader = deader;
	$(function(){
		deader.init();
	});
})(window);

function showAddWindow(){
	deader.showAddWindow();
}