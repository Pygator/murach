(function($){
    $.fn.reveal = function() {
        return this.each(function() {
            $(this).click(function(evt) {
                $(this).toggleClass("minus");
                if ($(this).attr("class") !== "minus") {
                    $(this).next().hide();
                } else {
                    $(this).next().show();
                }
				evt.preventDefault();
            });
        });	
    };
})(jQuery);
