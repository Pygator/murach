$(document).ready(function() {
	$("#faqs h1").animate(
			{ fontSize: "650%", opacity: 1, left: "+=275", color: "red", backgroundColor: "blue" }, 2000 )  
		.animate(
			{ fontSize: "175%", left: "-=275", color: "blue", backgroundColor: "white" }, 1000 );
	
    $("#faqs h2").click(function() {
		$(this).toggleClass("minus");
		if ($(this).attr("class") != "minus") {
		   	$(this).next().hide("puff", 1500);
	   	}
	   	else {
	        $(this).next().show("bounce", 500);
	   	}
    }); // end click
});  // end ready
