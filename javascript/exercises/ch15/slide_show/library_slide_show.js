"use strict";
// create namespace
var myapp = myapp || {};

myapp.slideshow = (function() {
    // private variables and functions
    var timer, play = true, speed = 2000;  // private speed variable
    var nodes = { image: null, caption: null };
    var img = { cache: [], counter: 0 };   // private img.cache array
    
    var stopSlideShow = function() { clearInterval( timer ); };
    var displayNextImage = function() {
        img.counter = ++img.counter % img.cache.length;
        var image = img.cache[img.counter];
        var index = img.cache.indexOf(image); // get array index of the image object 
        
        nodes.image.src = image.src;
        nodes.caption.firstChild.nodeValue = image.title;
        nodes.caption.title = index;          // store index in caption span's title attribute
    };
    var setPlayText = function(btn) {
        btn.value = (play)? "Resume": "Pause";
    };
    // public slideshow object 
    var slideshow = {
        loadImages: function(slides) {
            var image;
            for ( var i = 0; i < slides.length; i++ ) {
                image = new Image();
                image.src = "images/" + slides[i].href;
                image.title = slides[i].title;
                img.cache.push( image );
            }
            return this;
        },
        startSlideShow: function() {
            if (arguments.length === 2) { 
                nodes.image = arguments[0]; 
                nodes.caption = arguments[1];
            }
            stopSlideShow(); 
            timer = setInterval(displayNextImage, speed);
            return this;
        },
        changeSpeed: function(newSpeed) {
            var ns = parseInt(newSpeed);
            speed = (ns < 200 || isNaN(ns))? 2000: ns;
            return this; 
        },
        createToggleHandler: function() {
            var that = this;
            
            return function() {
                if ( play ) { stopSlideShow(); } else { that.startSlideShow(); }
                setPlayText(this);
                play = ! play; 
            };
        }
    };
    /*** Add code here to make read-only accessor properties that return ***
     *** the private speed variable and the img.cache array              ***/  
   
    return slideshow;
})();