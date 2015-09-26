"use strict";
var $ = function(id) { return document.getElementById(id); };

//var changeSpeed = function(e) {
//    var msg = "Current speed is ".concat(slideshow.speed, 
//            " milliseconds.\nPlease enter a new speed in milliseconds.");
//    var milliseconds = prompt(msg, "2000");
//    
//    if (isNaN(milliseconds)) { 
//	    alert ("Please enter a number"); 
//	}
//    else {
//        slideshow.speed = milliseconds;
//        slideshow.stopSlideShow().startSlideShow();
//    } 
//    evt.preventDefault(e);
//};

window.onload = function() {  
     var slides = [
        {href:"images/gear.jpg", title:"Fishing Gear"}, 
        {href:"images/plane.jpg", title:"Bush Plane"},
        {href:"images/release.jpg", title:"Catch and Release"},
        {href:"images/lunch.jpg", title:"Streamside Lunch"},
        {href:"images/dusk.jpg", title:"Day's End"}
    ];
    slideshow.loadImages(slides).startSlideShow($("image"), $("caption"));
    
    evt.attach($("play_pause"), "click", slideshow.togglePlay); 
    evt.attach($("change_speed"), "click", slideshow.changeSpeed); 
};