(function(win,$){
	$(function(){
		init();
	});
	function init(){
		$('#editPasswordPanel').panel({
			title:'密码修改',
			iconCls:'icon-edit',
			fit:false,
			width:400,
			height:220
		});
	}
})(window,$);