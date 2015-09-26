$(document).ready(function() {
	/*
	$("#faqs h1").animate({
		fontSize: "275%",
		opacity: 1,
		left: 0
		},
		2000
	);  // end animate
	*/
	
	// with callback
	$("#faqs h1").animate(
		{ fontSize: "275%", opacity: 1, left: "+=175" }, 
		2000,
		function() {
			$("#faqs h2").next().fadeIn(1000).fadeOut(1000); 
		}
	);  // end animate
}); // end ready
