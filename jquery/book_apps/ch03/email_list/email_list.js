"use strict";
var $ = function (id) {
    return document.getElementById(id);
}
var joinList = function () {
	var emailAddress1 = $("email_address1");
	var emailAddress2 = $("email_address2");
	var firstName = $("first_name");
	var isValid = true;
	
	// validate the first entry
	if (emailAddress1.value == "") { 
		emailAddress1.nextElementSibling.firstChild.nodeValue = "This field is required.";
		isValid = false;
	} else {
		emailAddress1.nextElementSibling.firstChild.nodeValue = "";
	} 
	
	// validate the second entry
	if (emailAddress2.value == "") { 
		emailAddress2.nextElementSibling.firstChild.nodeValue = "This field is required.";
		isValid = false; 
	} else if (emailAddress1.value !== emailAddress2.value) { 
		emailAddress2.nextElementSibling.firstChild.nodeValue = "This entry must equal first entry.";
		isValid = false;
	} else {
		emailAddress2.nextElementSibling.firstChild.nodeValue = "";
	}
	
	// validate the third entry  
	if (first_name.value == "") {
		first_name.nextElementSibling.firstChild.nodeValue = "This field is required.";
		isValid = false;
	} else {
		first_name.nextElementSibling.firstChild.nodeValue = "";
	}  
	
	// submit the form if all entries are valid
	if (isValid) {
		$("email_form").submit(); 
	}
}
window.onload = function () {
    $("join_list").onclick = joinList;
    $("email_address1").focus();
}
