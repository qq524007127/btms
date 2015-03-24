(function(){
	var app = {};
	app.init = function(baseUrl){
		app.baseUrl = baseUrl;
		document.writeln('<link rel="stylesheet" type="text/css" href="'+baseUrl+'/easyui/themes/default/easyui.css" />');
		document.writeln('<link rel="stylesheet" type="text/css" href="'+baseUrl+'/easyui/themes/icon.css" />');
		document.writeln('<link rel="stylesheet" type="text/css" href="'+baseUrl+'/css/style.css" />');
		document.writeln('<script type="text/javascript" src="'+baseUrl+'/easyui/jquery.min.js" charset="UTF-8" ></script>');
		document.writeln('<script type="text/javascript" src="'+baseUrl+'/easyui/jquery.easyui.min.js" charset="UTF-8" ></script>');
		document.writeln('<script type="text/javascript" src="'+baseUrl+'/easyui/locale/easyui-lang-zh_CN.js" charset="UTF-8" ></script>');
		document.writeln('<link rel="shortcut icon" href="'+baseUrl+'/img/favicon.ico">');
	};
	app.addScript = function(script){
		if(!script){
			return;
		}
		document.writeln('<script type="text/javascript" src="'+app.baseUrl+'/js/'+script+'" charset="UTF-8" ></script>');
	};
	app.addStyle = function(style){
		if(!style){
			return;
		}
		document.writeln('<link rel="stylesheet" type="text/css" href="'+app.baseUrl+'/css/'+style+'" />');
	};
	window.app = app;
})(window);