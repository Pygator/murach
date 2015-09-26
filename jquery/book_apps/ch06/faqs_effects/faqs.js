$(document).ready(function() {
	
	$("#faqs h2").click(
		function() {
			$(this).toggleClass("minus");
		    $(this).next().slideToggle(1000);
	    }
    ); // end click
    
/*
	$("#faqs h2").click(
		function() {
			$(this).toggleClass("minus");
			if ($(this).attr("class") != "minus") {
		   		$(this).next().fadeOut(1000);
	   		}
	   		else {
	        	$(this).next().slideDown(1000);
	   		}
	   	}
    ); // end click
*/
}); // end ready
