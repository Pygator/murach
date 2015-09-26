"use strict";
window.onload = function() { 
    var $ = function(id) { return document.getElementById(id); };
    
    var slides = [
        {href:"casting1.jpg", title:"Casting 1"}, 
        {href:"casting2.jpg", title:"Casting 2"},
        {href:"catchrelease.jpg", title:"Catch and Release"},
        {href:"fish.jpg", title:"Fish"},
        {href:"lures.jpg", title:"Lures"}
    ];
    myapp.slideshow.speed = null;
    myapp.slideshow.slideShowSpeed = null;
    myapp.slideshow.loadImages(slides).startSlideShow($("image"), $("caption"));
    
    $("play_pause").onclick = myapp.slideshow.createToggleHandler();
    $("change_speed").onclick = function() {
        var msg = "Current speed is ".concat(myapp.slideshow.slideShowSpeed,
            " milliseconds.\n", 
            "Please enter a new speed in milliseconds (200 min).");
        var ms = prompt(msg, 2000);
        myapp.slideshow.changeSpeed(ms).startSlideShow();

    };
};