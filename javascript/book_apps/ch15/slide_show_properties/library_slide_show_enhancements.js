"use strict";
// enhance the slideshow object using the module pattern:
(function(mod) {
    mod.changeSpeed = function(newSpeed) {
        this.slideShowSpeed = newSpeed;
        return this;
    };
})(myapp.slideshow); // invoke IIFE; import module to be augmented