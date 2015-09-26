$(document).ready(function() {
	// add span element after each input element
	$(":text").after("<span>*</span>");
	
	// move focus to first text box
	$("#email_1").focus();
	
	// the handler for the click event of a submitbutton
	$("#email_form").submit(
		function(event) {
			var isValid = true;
			
			// validate the email entry with a regular expression
			var emailPattern = /\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}\b/;
			var email = $("#email_1").val();
			if (email == "") { 
				$("#email_1").next().text("This field is required.");
				isValid = false;
			} else if ( !emailPattern.test(email) ) {
				$("#email_1").next().text("Must be a valid email address.");
				isValid = false;
			} else {
				$("#email_1").next().text("");
			} 

			// validate the second email entry
			var email2 = $("#email_2").val();
			if (email2 == "") { 
				$("#email_2").next().text("This field is required.")
				isValid = false; 
			} else if (email !== email2 ) { 
				$("#email_2").next().text("Must equal first email entry.");
				isValid = false;
			} else {
				$("#email_2").next().text("");
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
			var state = $("#state").val();
			if (state == "") {
				$("#state").next().text("This field is required.");
				isValid = false;
			} else if ( state.length != 2 ) {
				$("#state").next().text("Use 2-character code.");
				isValid = false;
			}
			else {
				$("#state").next().text("");
			}	
						
			// validate the zip code entry (regular expression)
			var zip = $("#zip").val();
			if (zip == "") {
				$("#zip").next().text("This field is required.");
				isValid = false;
			} else if ( zip.length != 5 ) {
				$("#zip").next().text("Use 99999 format.");
				isValid = false;
			}
			else {
				$("#zip").next().text("");
			}
			
			// submit the form if all entries are valid 
			if (isValid == false) {
			 	event.preventDefault();				
			}
		} // end function
	);	// end submiy
}); // end ready