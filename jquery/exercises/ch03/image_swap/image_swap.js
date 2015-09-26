"use strict";
var $ = function (id) { 
	return document.getElementById(id); 
}

var swap = function(evt) {
	var link = this;
	var captionNode = $("caption");
	var imageNode = $("image");

	imageNode.src = link.getAttribute("href");
	captionNode.firstChild.nodeValue=link.getAttribute("title");
	
	// Cancel the default action of the event
	if (!evt) { evt = window.event; }
	if ( evt.preventDefault ) {
	    evt.preventDefault();          // DOM compliant code
	}
	else {
	    evt.returnValue = false;
	}	
}

window.onload = function () {
    var listNode = $("image_list");
    var imageLinks = listNode.getElementsByTagName("a");
    
    // Process image links
    var i, linkNode, image;
    for ( i = 0; i < imageLinks.length; i++ ) {

        // Attach event handler
        linkNode = imageLinks[i];
        linkNode.onclick = swap;

        // Preload image
        image = new Image();
        image.src = linkNode.getAttribute("href");
    }
    imageLinks[0].focus();
}
