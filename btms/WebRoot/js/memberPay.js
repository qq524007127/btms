$(function(){
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
});

function showBSWindow(){
	$('#blessSeatWindow').dialog({
		width:900,
		height:600,
		modal:true
	});
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