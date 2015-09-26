(function($){
	$.fn.displaySelection = function() {
		return this.each(function() {
			alert("The text for the selection is '" + $(this).text() + "'");
		});	
	}
})(jQuery);
