$(document).ready(function() {
	
	// runs when an h2 heading is clicked
    $("#faqs h2").click(function() {
		$(this).toggleClass("minus");
		if ($(this).attr("class") != "minus") {
		   	$(this).next().hide();
	   	}
	   	else {
	        $(this).next().show();
	   	}
    }); // end click
    
    // runs when the page is ready
    $("#faqs h1").animate( { fontSize: "650%", opacity: 1, left: "+=375" }, 1000 )  
		         .animate( { fontSize: "175%", left: "-=200" }, 1000 );
		    
	// runs when the top-level heading is clicked
	$("#faqs h1").click(function() {
		$(this).animate( { fontSize: "650%", opacity: 1, left: "+=375" }, 2000 )  
			   .animate( { fontSize: "175%", left: "-=200" }, 1000 );
	}); // end click
    
}); // end ready
