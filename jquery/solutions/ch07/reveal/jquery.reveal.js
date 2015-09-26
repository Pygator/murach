(function($){
	$.fn.reveal = function() {
		return this.each(function() {
			$(this).click(function() {
				$(this).toggleClass("minus");
				if ($(this).attr("class") != "minus") {
		   			$(this).next().slideUp(1000);
	   			}
	   			else {
	        		$(this).next().slideDown(1000);
	   			}			   				
			})
		});	
	}
})(jQuery);
