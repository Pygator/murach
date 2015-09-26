"use strict";

// augment the slideshow object using the module pattern:
//  - use an immediately invoked function expression (IIFE)
//  - import the module to be augmented by passing it as an argument to the 
//      IIFE (it will be variable 'mod')
//  - add properties or methods to the module
(function(mod) {
    mod.changeSpeed = function(speed) {
        var newSpeed = parseInt(speed);
        this.speed = (newSpeed < 200 || isNaN(newSpeed))? 2000: newSpeed;
        return this; // so method can be chained
    };
})(myapp.slideshow); // invoke IIFE; import module to be augmented