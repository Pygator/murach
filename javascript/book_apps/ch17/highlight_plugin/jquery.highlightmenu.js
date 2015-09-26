"use strict";
(function($){
    $.fn.highlightMenu = function() {
        return this.each(function() {
            var items = $(this).find("a");
            items.mouseover(function() {
                $(this).addClass("mouseover");
            });
            items.mouseout(function() {
                $(this).removeClass("mouseover");
            });
        });
    };
})(jQuery);

