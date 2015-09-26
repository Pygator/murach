"use strict";
var $ = function (id) { 
	return document.getElementById(id); 
}

window.onload = function () {
    var slidesNode = $("slides");    
    var captionNode = $("caption");
    var imageNode = $("slide");
        
    var slides = slidesNode.getElementsByTagName("img");
    
    // Start slide show
    var image, imageCounter = 0;
    var  timer = setInterval(
        function () { 
		    imageCounter = (imageCounter + 1) % slides.length;
		    image = slides[imageCounter];
		    imageNode.src = image.src;
		    captionNode.firstChild.nodeValue = image.alt;
        },
        2000);
}
