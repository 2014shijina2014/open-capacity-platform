function checkCron() {
	var cron = $("#cron").val();
	if (cron != "") {
		$.ajax({
			type : 'get',
			url : '/jobs?cron=' + cron,
			success : function(data) {
				var msg = "正确";
				if (!data) {
					msg = "cron表达式不对";
				}
				layer.msg(msg, {
					shift : -1,
					time : 1000
				}, function() {
				});
			}
		});
	} else {
		layer.msg("cron表达式不能为空", {
			shift : -1,
			time : 1000
		}, function() {
		});
	}
}

function initBeanNames() {
	$.ajax({
		type : 'get',
		url : '/jobs/beans',
		async : false,
		success : function(data) {
			var select = $("#springBeanName");
			for (var i = 0; i < data.length; i++) {
				var v = data[i];
				select.append("<option value='" + v + "'>" + v + "</option>")
			}
			
			$("#springBeanName").selectpicker('refresh');
		}
	});
}

function showMethods() {
	var val = $("#springBeanName").val();
	if (val == "") {
		return;
	}

	$.ajax({
		type : 'get',
		url : '/jobs/beans/' + val,
		async : false,
		success : function(data) {
			var select = $("#methodName");
			select.empty();
			if (data.length == 0) {
				return;
			}

			for (var i = 0; i < data.length; i++) {
				var v = data[i];
				select.append("<option value='" + v + "'>" + v + "</option>")
			}
		}
	});
}