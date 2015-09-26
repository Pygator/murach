"use strict";
var $ = function(id) { return document.getElementById(id); };

window.onload = function() {  
    var slides = [
        {href:"images/gear.jpg", title:"Fishing Gear"}, 
        {href:"images/plane.jpg", title:"Bush Plane"},
        {href:"images/release.jpg", title:"Catch and Release"},
        {href:"images/lunch.jpg", title:"Streamside Lunch"},
        {href:"images/dusk.jpg", title:"Day's End"}
    ];
    //slideshow.speed = 500; //speeds up slide show
    //slideshow.speed = [];  //breaks slide show
    slideshow.loadImages(slides).startSlideShow($("image"), $("caption"));
    
    evt.attach($("play_pause"), "click", slideshow.togglePlay); 
};

//this app demos timers and events
//
//also will be adjusted later to demo closures - commented out code above
//shows how speed property is public and so can be changed or overwritten.
//closure version will make speed private, so can't change or overwrite it.
//Object.create version will make speed only accept numbers, so can change
//speed but not overwrite it.