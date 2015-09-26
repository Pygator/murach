$(document).ready(function() {

	$("#faqs h1").click(function() {
		$(this).animate(
			       { fontSize: "650%", opacity: 1, left: "+=275" }, 2000 )  
		       .animate( 
			       { fontSize: "175%", left: "-=275" }, 1000 );
	}); // end click


/*	
	$("#faqs h1").click(function() {
		$(this).animate(
			{ fontSize: "650%", opacity: 1, left: "+=275" }, 2000 );  
		$(this).animate(
			{ fontSize: "175%", left: "-=275" }, 1000 );
	}); // end click
*/	

/*
	$("#faqs h1").click(function() {
		$(this).animate(
			{ fontSize: "650%", opacity: 1, left: "+=275" },
			2000,
			function() {
				$(this).animate(
					{ fontSize: "175%", left: "-=275" }, 1000
				); 
			} // end callback
		);
	}); // end click
*/
}); // end ready
