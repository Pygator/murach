$(document).ready(function() {
	// the call to the plugin method
	$("#faqs h2").displaySelection();
	 
	// setting up the click event handler for the h2 elements
    $("#faqs h2").click(function() {
		$(this).toggleClass("minus");
		if ($(this).attr("class") != "minus") {
		   	$(this).next().slideUp(1000);
	   	}
	   	else {
	        $(this).next().slideDown(1000);
	   	}
    }); // end click
}); // end ready
