var $ = function(id) {
    return document.getElementById(id);
};

var calculateFV = function(investment,rate,years) {
	var futureValue = investment;
    for (var i = 1; i <= years; i++ ) {
		futureValue += futureValue * rate / 100;
    }
    futureValue = futureValue.toFixed(2);
	return futureValue;
};

var processEntries = function() {
    var investment = parseFloat( $("investment").value );
    var rate = parseFloat( $("annual_rate").value );
    var years = parseInt( $("years").value );
	var allValid = true;
	
	if (isNaN(investment) || investment <= 0 || investment > 100000) {
		$("investment_error").firstChild.nodeValue = "Must be > 0 and <= 100000";
		allValid = false;
	}
	else {
		$("investment_error").firstChild.nodeValue = "";
	}
	if (isNaN(rate) || rate <= 0 || rate > 15) {
		$("rate_error").firstChild.nodeValue = "Must be > 0 and <= 15";
		allValid = false;
	}
	else {
		$("rate_error").firstChild.nodeValue = "";
	}
	if (isNaN(years) || years <= 0 || years > 50) {
		$("years_error").firstChild.nodeValue = "Must be > 0 and <= 50";
		allValid = false;
	}
	else {
		$("years_error").firstChild.nodeValue = "";
	}
	if (allValid) {
		$("future_value").value	= calculateFV(investment,rate,years);
	}
};

window.onload = function() {
    $("calculate").onclick = processEntries;
    $("investment").focus();
};