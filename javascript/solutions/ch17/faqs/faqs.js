$(document).ready(function() {
    $("#faqs h2").click(function(evt) {
        $(this).toggleClass("minus");
//        if ($(this).attr("class") !== "minus") {
//            $(this).next().hide();
//        } else {
//            $(this).next().show();
//        }
        // get whether clicked panel should be open after toggle
        var shouldOpen = ($(this).attr("class") === "minus");
        
        // close all panels
        $("#faqs h2").removeClass("minus").next().hide();
        
        // if panel should be open, add minus class to the clicked 
        // h2 tag and open it's sibling div
        if (shouldOpen) { $(this).addClass("minus").next().show(); }
        
        evt.preventDefault();
    }); // end click
    
    //set focus on first <a> tag and open first panel
    $("#faqs a:first").focus();
    $("#faqs h2:first").addClass("minus").next().show();
}); // end ready
