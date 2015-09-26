"use strict";

/*** augment the slideshow object using the module pattern:                       ***
 ***  - add an immediately invoked function expression (IIFE)                     ***
 ***  - pass a parameter to the IIFE that will hold the module to be augmented    ***
 ***  - import the module to be augmented by passing it as an argument when you   ***
 ***      invoke the IIFE (it will populate the parameter in the last step)       ***
 ***  - add the changeCaption method and return the parameter holding the module  ***/

(function(mod) {
    mod.changeCaption = function(index, caption) {
        var image = mod.getImages[index];
        image.title = caption;
        return mod; // so method can be chained
    };
})(myapp.slideshow); // invoke IIFE; import module to be augmented