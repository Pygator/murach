"use strict";
var $ = function(id) { return document.getElementById(id); };

var changeSpeed = function(e) {
    // code to change the slide show speed goes here
	var milliseconds = prompt("Enter new slide show speed", "2000");
};

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
};