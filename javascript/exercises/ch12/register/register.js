"use strict";
var registerForm;

window.onload = function() {
	//create validation object and set field messages
	registerForm = new RegisterForm();
	registerForm.resetForm();
	
	$("register").onclick = function() {
        if ( registerForm.validateForm() ) { 
		    // $("registration_form").submit();
            navigate.showResults();
        }
	};
	
	$("reset").onclick = function() {
	    registerForm.resetForm();
	};

    $("back").onclick = function() {
   	    navigate.showForm();
        registerForm.resetForm();
    };
};
