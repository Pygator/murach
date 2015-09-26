"use strict";
// create the namespace used by the application
var myapp = myapp || {};

// create a single slideshow object with private state using the module pattern 
myapp.slideshow = (function() {
    // private variables and functions
    var timer, play = true;
    var nodes = { image: null, caption: null };
    var img = { cache: [], counter: 0 };
    
    var stopSlideShow = function() { clearInterval( timer ); };
    var displayNextImage = function() {
        img.counter = ++img.counter % img.cache.length;
        var image = img.cache[img.counter];
        nodes.image.src = image.src;
        nodes.caption.firstChild.nodeValue = image.title;
    };
    var setPlayText = function(btn) {
        btn.value = (play)? "Resume": "Pause";
    };
    // public properties/methods - make speed public so it's accessible to
    // outside code 
    return {
        speed: 2000, 
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
            stopSlideShow(); // stop any previously running slideshow
            timer = setInterval(displayNextImage, this.speed);
            return this;
        },
        createToggleHandler: function() {
            var that = this;
            // closure to be used as the click event handler
            return function() {
                // the value of 'this' is the clicked button
                if ( play ) { stopSlideShow(); } else { that.startSlideShow(); }
                setPlayText(this);
                play = ! play; //toggle play flag
            };
        }
    };
})();