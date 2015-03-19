function submitInitShelf(){
	$('#initShelfForm').form('submit',{
		success:function (data){
			data = $.parseJSON(data);
			$.messager.alert('',data.msg);
		}
	});
}