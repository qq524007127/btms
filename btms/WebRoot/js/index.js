function onMenuItemClick(title,pageUrl){
	if($('#mainTabs').tabs('exists',title)){
		$('#mainTabs').tabs('select',title);
		return;
	}
	$('#mainTabs').tabs('add',{
		title:title,
		content:'<iframe width=100% height=99% frameborder=0 src="'+pageUrl+'">',
		closable:true,
		style:{
			padding:5
		}
	});
};