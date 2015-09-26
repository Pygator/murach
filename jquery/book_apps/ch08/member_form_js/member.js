$(document).ready(function() {
	// add span element after each input element
	$(":text, :password").after("<span></span>");
	
	// move focus to first text box
	$("#email").focus();
	
	// put today's date in the start_date text box
	var today = new Date();
	var month = today.getMonth() + 1; // Add 1 since months start at 0
	var day = today.getDate();
	var year = today.getFullYear();
	var dateText = ((month < 10) ? "0" + month : month) + "/"; // Pad month
	dateText += ((day < 10) ? "0" + day : day) + "/"; // Pad date
	dateText += year;
	$("#start_date").val(dateText);
	
	// the handler for the click event of a submit button
	$("#member_form").submit(
		function(event) {
			var isValid = true;
			
			// validate the email entry with a regular expression
			var emailPattern = /\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}\b/;
			var email = $("#email").val();
			if (email == "") { 
				$("#email").next().text("This field is required.");
				isValid = false;
			} else if ( !emailPattern.test(email) ) {
				$("#email").next().text("Must be a valid email address.");
				isValid = false;
			} else {
				$("#email").next().text("");
			} 
			// validate the password entry (regular expression)
			var password = $("#password").val();
			if ( password.length < 6) {
				$("#password").next().text("Must be 6 or more characters.");
				isValid = false;
			} else {
				$("#password").next().text("");
			}
			// validate the verify entry
			if ($("#verify").val() == "") { 
				$("#verify").next().text("This field is required.");
				isValid = false; 
			} else if ($("#verify").val() !== $("#password").val() ) { 
				$("#verify").next().text("Must equal first password entry.");
				isValid = false;
			} else {
				$("#verify").next().text("");
			}
			
			// validate the first name entry
			var firstName = $("#first_name").val().trim();
			if (firstName == "") {
				$("#first_name").next().text("This field is required.");
				isValid = false;
			} 
			else {
				$("#first_name").val(firstName);
				$("#first_name").next().text("");
			}
			// validate the last name entry
			var lastName = $("#last_name").val().trim();
			if (lastName == "") {
				$("#last_name").next().text("This field is required.");
				isValid = false;
			} 
			else {
				$("#last_name").val(lastName);
				$("#last_name").next().text("");
			}
			// validate the state entry
			$("#state").next().text("");
			
			// validate the zip code entry (regular expression)
			var zipPattern = /^\d{5}(-\d{4})?$/;
			var zip = $("#zip").val();
			if (zip == "") {
				$("#zip").next().text("This field is required.");
				isValid = false;
			} else if ( !zipPattern.test(zip) ) {
				$("#zip").next().text("Use either 99999 or 99999-9999 format.");
				isValid = false;
			}
			else {
				$("#zip").next().text("");
			}
			// validate the phone number (regular expression)
			if ($("#phone").val() == "") { 
				$("#phone").next().text("This field is required.");
				isValid = false; 
			} else {
				$("#phone").next().text("");
			}
			
			// validate the requested start date (regular expression)
			$("#start_date").next().text("");
			
			// prevent the submission of the form if any entries are invalid 
			if (isValid == false) {
				event.preventDefault();				
			}
		} // end function
	);	// end submit
}); // end ready