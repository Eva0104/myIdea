Date.prototype.Format = function (format) {
	var o = {
		"M+": this.getMonth() + 1, //获取月份
		"d+": this.getDate(), //获取日期
		"h+": this.getHours(), //获取小时数
		"m+": this.getMinutes(), //获取分钟数
		"s+": this.getSeconds(), //获取秒数
		"S": this.getMilliseconds() //获取毫秒数(0-999) 
	}

	if (/(y+)/.test(format)) {
		format = format.replace(
			RegExp.$1,
			(this.getFullYear() + "").substr(4 - RegExp.$1.length)
			);
	}

	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(
				RegExp.$1,
				RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length)
				);
		}
	}
	return format;
} 
