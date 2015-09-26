"use strict";
(function($){
    $.fn.highlightMenu = function(options) {
        var o = $.extend({
            "mouseoverClass"  : "mouseover",
            "mouseoutClass"   : "mouseout",
            "useMouseout"     : true
        }, options);

        return this.each(function() {
            var items = $(this).find("a");
            items.mouseover(function() {
                $(this).addClass(o.mouseoverClass);
                if (o.useMouseout) { 
                    $(this).removeClass(o.mouseoutClass);
                }
            });
            items.mouseout(function() {
                $(this).removeClass(o.mouseoverClass);
                if (o.useMouseout) { 
                    $(this).addClass(o.mouseoutClass);
                }
            });
        });
    };
})(jQuery);

