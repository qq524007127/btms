(function($){
	$(function(){
		$.extend({
			openExcelPreview:function(url,param){
				var ExcelSheet;
				var wb;
				try {
					ExcelSheet = new ActiveXObject("Excel.Application");
					wb = ExcelSheet.Workbooks.open(url);
					wb.Activate;
					ExcelSheet.DisplayAlerts=false;
					ExcelSheet.Save();
					// 使EXCEL窗口可见
					ExcelSheet.Visible = true;
					ExcelSheet.ActiveSheet.PrintPreview();
					ExcelSheet.WorkBooks.Close();
					ExcelSheet.Quit();
				}catch(e) {
					if (ExcelSheet){
						alert('错误 : ' + e);
						ExcelSheet.Quit();
						return;
					}
					alert("请启用ActiveX控件设置!");
					return;
				}
			}
		});
	});
})(jQuery);