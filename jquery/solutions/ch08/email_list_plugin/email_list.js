$(document).ready(function() {
	$("#email").focus();
	
	$("#email_form").validate({
		rules: {
			email_1: {
				required: true,
				email: true
			},
			email_2: {
				required: true,
				email: true,
				equalTo: "#email_1"
			},
			first_name: {
				required: true
			},
			last_name: {
				required: true
			},
			state: {
				required: true,
				rangelength: [2, 2]
			},
			zip: {
				required: true,
				digits: true,
				rangelength: [5, 5]
			}
		},
		messages: {
			email_2: {
				equalTo: "This entry must equal previous entry."
			},
			state: {
				rangelength: "Please enter a 2-character state code."
			},
			zip: {
				rangelength: "Please enter a 5-digit zip code."
			}	
		}
	}); // end validate
}); // end ready
