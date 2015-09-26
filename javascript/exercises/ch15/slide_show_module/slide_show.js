"use strict";
window.onload = function() { 
    var $ = function(id) { return document.getElementById(id); };
    
    var slides = [
        {href:"gear.jpg", title:"Fishing Gear"}, 
        {href:"plane.jpg", title:"Bush Plane"},
        {href:"release.jpg", title:"Catch and Release"},
        {href:"lunch.jpg", title:"Streamside Lunch"},
        {href:"dusk.jpg", title:"Day's End"}
    ];
	
    myapp.slideshow.loadImages(slides).startSlideShow($("image"), $("caption"));
    
    $("play_pause").onclick = myapp.slideshow.createToggleHandler();
    $("change_speed").onclick = function() {
        var msg = "Current speed is ".concat(myapp.slideshow.speed,
            " milliseconds.\n", 
            "Please enter a new speed in milliseconds (200 min).");
        var ms = prompt(msg, 2000);
        myapp.slideshow.changeSpeed(ms).startSlideShow();
    };
};