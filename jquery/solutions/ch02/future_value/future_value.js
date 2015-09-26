"use strict";
var $ = function (id) {
    return document.getElementById(id);
}
// var calculateFV = function(investment,rate,years) {
function calculateFV(investment, rate, years) {
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
	
	if (isNaN(investment) || investment <= 0 || investment > 100000) {
		alert("Investment amount must be > 0 and <= 100000");
	}
	else if (isNaN(rate) || rate <= 0 || rate > 15) {
		alert("Interest rate must be > 0 and <= 15");
		allValid = false;
	}
	else if (isNaN(years) || years <= 0 || years > 50) {
		alert("Number of years must be > 0 and <= 50");
	}
	else {
		$("future_value").value	= calculateFV(investment, rate, years);
	}
}
var clearEntries = function() {
	$("investment").value = "";
    $("annual_rate").value = "";
    $("years").value = "";
	$("future_value").value = "";
}
window.onload = function () {
    $("calculate").onclick = processEntries;
    $("clear").onclick = clearEntries;
	$("investment").ondblclick = clearEntries;
    $("investment").focus();
}