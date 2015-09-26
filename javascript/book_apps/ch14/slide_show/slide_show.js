"use strict";
var $ = function(id) { return document.getElementById(id); };

window.onload = function() { 
    // create the slideshow object 
    var slideshow = createSlideshow();
    
    var slides = [
    	{href:"gear.jpg", title:"Fishing Gear"}, 
        {href:"plane.jpg", title:"Bush Plane"},
        {href:"release.jpg", title:"Catch and Release"},
        {href:"lunch.jpg", title:"Streamside Lunch"},
        {href:"dusk.jpg", title:"Day's End"}
    ];
    //slideshow.speed = 500; //adds a new property called speed - doesn't do anything
    //slideshow.speed = [];  //ditto
    slideshow.loadImages(slides).startSlideShow($("image"), $("caption"));
    
    $("play_pause").onclick = slideshow.createToggleHandler();
};

//this app adjusts the previous slide show to use a closure to make many
//of the properties and functions from the earlier app private. Now the speed
//property is private, so trying to access it doesn't work.