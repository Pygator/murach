"use strict";
var $ = function (id) {
    return document.getElementById(id);
}
var calculateFV = function(investment, rate, years) {
	var futureValue = investment;
    for (var i = 1; i <= years; i++ ) {
		futureValue += futureValue * rate / 100;
    }
    futureValue = futureValue.toFixed(2);
	return futureValue;
}
var processEntries = function() {
    var investment = parseFloat( $("investment").value );
    var rate = parseFloat( $("annual_rate").value );
    var years = parseInt( $("years").value );
	
	if (isNaN(investment) || isNaN(rate) || isNaN(years)) {
		alert("One or more entries is invalid");
	}
	else {
		$("future_value").value	= calculateFV(investment, rate, years);
	}
}
window.onload = function () {
    $("calculate").onclick = processEntries;
    $("investment").focus();
}