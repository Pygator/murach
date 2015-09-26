$(document).ready(function() {
		   
	var slider = $("#image_list");                     // slider = ul element
	var leftProperty, newleftProperty;
		
	// the click event handler for the right button						
	$("#right_button").click(function() { 
		
		// get value of current left property
		leftProperty = parseInt(slider.css("left"));
		
		// determine new value of left property
		if (leftProperty - 100 <= -900) {
			newLeftProperty = 0; }
		else {
			newLeftProperty = leftProperty - 100; }
		
		// use the animate function to change the left property
		slider.animate( {left: newLeftProperty}, 1000);
		
	});  // end click
	
	// the click event handler for the left button
	$("#left_button").click(function() {
		
		// get value of current right property
		leftProperty = parseInt(slider.css("left"));
		
		// determine new value of left property
		if (leftProperty < 0) {
			newLeftProperty = leftProperty + 100;
		}
		else {
			newLeftProperty = -800;
		}
		
		// use the animate function to change the left property
		slider.animate( {left: newLeftProperty}, 1000);
						
	});  // end click		
}); // end ready