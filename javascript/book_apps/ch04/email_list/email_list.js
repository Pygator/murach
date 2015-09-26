"use strict";
var $ = function(id) {
    return document.getElementById(id);
};
var joinList = function() {
    var emailAddress1 = $("email_address1").value;
    var emailAddress2 = $("email_address2").value;
    var firstName = $("first_name").value;
    var isValid = true;

    // validate the first entry
    if (emailAddress1 === "") { 
        $("email_address1_error").firstChild.nodeValue = 
            "This field is required.";
        isValid = false;
    } else {
        $("email_address1_error").firstChild.nodeValue = "";
    } 

    // validate the second entry
    if (emailAddress2 === "") { 
        $("email_address2_error").firstChild.nodeValue = 
            "This field is required.";
        isValid = false; 
    } else if (emailAddress1 !== emailAddress2) { 
        $("email_address2_error").firstChild.nodeValue = 
            "This entry must equal first entry.";
        isValid = false;
    } else {
        $("email_address2_error").firstChild.nodeValue = "";
    }

    // validate the third entry  
    if (firstName === "") {
        $("first_name_error").firstChild.nodeValue = 
            "This field is required.";
        isValid = false;
    } else {
        $("first_name_error").firstChild.nodeValue = "";
    }  

    // submit the form if all entries are valid
    if (isValid) {
        $("email_form").submit(); 
    }
};

window.onload = function() {
    $("join_list").onclick = joinList;
    $("email_address1").focus();
};
