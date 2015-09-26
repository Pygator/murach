/*!
 * jQuery menu highlight plugin
 * Original author: Zak Ruvalcaba for Murach Publishing
 * Further changes, comments: zak@modulemedia.com
 * Licensed under the MIT license
 */
(function($){
	$.fn.highlightMenu = function(options) {
		
		var defaults = $.extend({
			"bgColor" 			: "#000000",
			"color" 			: "#ffffff",
			"hoverBgColor" 		: "#cccccc",
			"hoverColor" 		: "#000000",
			"linkWidth" 		: "125px",
		}, options);
			
		return this.each(function() {
		
			var items = $("li a");
			var o = defaults;

			items.css("font-family", "arial, helvetica, sans-serif")
				 .css("font-weight", "bold")
				 .css("text-decoration", "none")
				 .css("background-color", o.bgColor)
				 .css("color", o.color)
				 .css("width", o.linkWidth);

			items.mouseover(function() {
            	$(this).css("background-color", o.hoverBgColor)
					   .css("color", o.hoverColor);
            });
				
			items.mouseout(function() {
            	$(this).css("background-color", o.bgColor)
					   .css("color", o.color);;
			});
		});
		
	}
})(jQuery);