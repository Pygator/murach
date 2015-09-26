$(document).ready(function() {
	$("#faqs h1").animate(
			{ fontSize: "650%", opacity: 1, left: "+=275" }, 2000 )  
		.animate(
			{ fontSize: "175%", left: "-=275", }, 1000 );
	
    $("#faqs h2").click(function() {
		$(this).toggleClass("minus");
		if ($(this).attr("class") != "minus") {
		   	$(this).next().slideUp(1000);
	   	}
	   	else {
	        $(this).next().slideDown(1000);
	   	}
    }); // end click
});  // end ready
