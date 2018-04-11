function checkPermission() {
	var pers = [];
	$.ajax({
		type : 'get',
		url : '/permissions/owns',
		contentType : "application/json; charset=utf-8",
		async : false,
		success : function(data) {
			pers = data;
			$("[permission]").each(function() {
				var per = $(this).attr("permission");
				if ($.inArray(per, data) < 0) {
					$(this).hide();
				}
			});
		}
	});
	
	return pers;
}