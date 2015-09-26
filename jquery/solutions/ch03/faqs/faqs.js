"use strict";
var $ = function (id) { return document.getElementById(id); };

// the event handler for the click event of each <a> element
var toggle = function () {
    var link = this;                    // clicked <a> tag
    var h2 = link.parentNode;           // h2 tag that contains <a> tag     
    var div = h2.nextElementSibling;    // h2 tag's sibling div tag

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
    // get the <a> tags
    var faqs = $("faqs");
    var linkElements = faqs.getElementsByTagName("a");
    
    // attach event handler for each <a> tag	    
    for (var i = 0; i < linkElements.length; i++ ) {
    	linkElements[i].onclick = toggle;
    }
    // set focus on first <a> tag
    linkElements[0].focus();       
};
