$(document).ready(function() {
    $("#faqs h2").click(function(evt) {
		$(this).toggleClass("minus");
		if ($(this).attr("class") != "minus") {
		   	$(this).next().hide();
	   	}
	   	else {
	        $(this).next().show();
	   	}
		evt.preventDefault();
    }); // end click
	$("#faqs a:first").focus();
}); // end ready
