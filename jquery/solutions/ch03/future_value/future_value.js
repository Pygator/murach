"use strict";
var $ = function (id) {
    return document.getElementById(id);
}
var calculateFV = function(investment,rate,years) {
	var futureValue = investment;
    for (var i = 1; i <= years; i++ ) {
		futureValue += futureValue * rate / 100;
    }
    futureValue = futureValue.toFixed(2);
	return futureValue;
}
var processEntries = function() {
    var investment = parseFloat($("investment").value);
    var rate = parseFloat($("annual_rate").value);
    var years = parseInt($("years").value);
	var isValid = true;
	
	// validate the first entry
    if ($("investment").value == "") {
		$("investment").nextElementSibling.firstChild.nodeValue = "This field is required";
		isValid = false;
	}
	else if (isNaN(investment)) {
		$("investment").nextElementSibling.firstChild.nodeValue = "Must be numeric";
		isValid = false;
	}
	else if (isNaN(investment) || investment <= 0 || investment > 100000) {
		$("investment").nextElementSibling.firstChild.nodeValue = "Must be > 0 and <= 100000";
		isValid = false;
	}
	else {
		$("investment").nextElementSibling.firstChild.nodeValue = "";
	} 
	// validate the second entry
	if (isNaN(rate) || rate <= 0 || annual_rate > 15) {
		$("annual_rate").nextElementSibling.firstChild.nodeValue = "Must be > 0 and <= 15";
		isValid = false;
	}
	else {
		$("annual_rate").nextElementSibling.firstChild.nodeValue = "";
	}
	// validate the third entry
	if (isNaN(years) || years <= 0 || years > 50) {
		$("years").nextElementSibling.firstChild.nodeValue = "Must be > 0 and <= 50";
		isValid = false;
	}
	else {
		$("years").nextElementSibling.firstChild.nodeValue = "";
	}  
	// submit the form if all entries are valid
	if (isValid) 
	{
		$("future_value").value	= calculateFV(investment,rate,years);
	}
	else 
	{
		$("future_value").value = "";
	}
}
window.onload = function () {
    $("calculate").onclick = processEntries;
    $("investment").focus();
}