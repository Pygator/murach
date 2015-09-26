"use strict";
var $ = function (id) { return document.getElementById(id); };

// the event handler for the click event of each h2 element
var toggle = function () {
    var h2 = this;                    // clicked h2 tag     
    var div = h2.nextElementSibling;  // h2 tag's sibling div tag

    // toggle plus and minus image in h2 elements by adding or removing a class
    if (h2.hasAttribute("class")) { 
        h2.removeAttribute("class");	
    } else { 
        h2.setAttribute("class", "minus"); 
    }

    // toggle div visibility by adding or removing a class
    if (div.hasAttribute("class")) { 
        div.removeAttribute("class");
    } else { 
        div.setAttribute("class", "open"); 
    } 
};

window.onload = function () {
    // get the h2 tags
    var faqs = $("faqs");
    var h2Elements = faqs.getElementsByTagName("h2");
    
    // attach event handler for each h2 tag	    
    for (var i = 0; i < h2Elements.length; i++ ) {
    	h2Elements[i].onclick = toggle;
    }
    // set focus on first h2 tag's <a> tag
    h2Elements[0].firstChild.focus();       
   
	// The function for the one-time timer   
    var hideMessage = function() {
	   	$("startup_message").setAttribute("class", "closed");
	   	clearTimeout(timer1);
	}
	// The function for the interval timer
	var counter = 0;
	var updateCounter = function() {
	    counter++;
	    document.getElementById("counter").firstChild.nodeValue = counter;
	}
	var timer1, timer2;
    timer1 = setTimeout(hideMessage, 5000);         // calling one-time function
    timer2 = setInterval( updateCounter, 1000 );    // calling the interval function
	/* 
    // With the one-time timer embedded as the first parameter
    var timer = setTimeout( 
    	function () {
    		$("startup_message").setAttribute("class", "closed");
    		clearTimeout(timer);
    	},
    	5000 );
    */
};
