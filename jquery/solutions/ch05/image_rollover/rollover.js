$(document).ready(function() {
	$("#image_rollovers img").each(function() {
		// get old and new urls
		var oldURL = $(this).attr("src");
		var newURL = $(this).attr("id");
		
		// preload rollover image		
		var rolloverImage = new Image();
		rolloverImage.src = newURL;
		
		// set up event handlers
		$(this).mouseover(function() {
				$(this).attr("src", newURL);
		});// end mouseover
		
		$(this).mouseout(function() {
				$(this).attr("src", oldURL);
		}); // end mouseout
					
/*		$(this).hover(
			function() {
				$(this).attr("src", newURL);
			},
			function() {
				$(this).attr("src", oldURL);
			}
		); // end hover
*/
	}); // end each
}); // end ready