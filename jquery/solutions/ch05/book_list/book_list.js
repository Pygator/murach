$(document).ready(function() {
    $("#categories h2").click(
       	function() {
			$(this).toggleClass("minus");
			if ($(this).attr("class") != "minus") {
	   			$(this).next().hide();
			}
			else {
	       		$(this).next().show();
			}
			
    		$("#image").attr("src", "");
    		// needed for IE so a placeholder isn't displayed for the image
    		$("#image").attr("style", "display:none;");    	}
    ); // end click
    
	$("#web_images a, #java_images a, #net_images a").each(function() {
		// get old and new urls
		var imageURL = $(this).attr("href");
		
		// preload images		
		var bookImage = new Image();
		bookImage.src = imageURL;
		
		// set up event handlers			
		$(this).click(function(evt) {
			$("#image").attr("src", imageURL);
			// needed for IE to display the image
			$("#image").attr("style", "style:block;");
    	 	
    		// cancel the default action of each link
    		evt.preventDefault();
  		}); // end click 
	}); // end each
}); // end ready