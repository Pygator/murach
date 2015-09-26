"use strict";
myapp.tasklist.sort = function(tasks) {
    var isArray = Array.isArray(tasks);
    if (isArray) {
        tasks.sort();
    }
    return isArray;
};

myapp.tasklist.display = function(tasks, div, handler) {
    var html = "";
    var isArray = myapp.tasklist.sort(tasks);
    
    if (isArray) {
        //create and load html string from sorted array
        for (var i in tasks) {
            html = html.concat("<p>");
            html = html.concat("<a href='#' title='", i, "'>Delete</a>");
            html = html.concat(tasks[i]);
            html = html.concat("</p>");
        }
        div.innerHTML = html;
        
        // get links, loop and add onclick event handler
        var links = div.getElementsByTagName("a");
        for (var i = 0; i < links.length; i++) {
            links[i].onclick = handler;
        }
    } 
};

myapp.tasklist.delete = function(tasks, i) {  
    var isArray = myapp.tasklist.sort(tasks);
    if (isArray) { tasks.splice(i, 1); }
};

myapp.tasklist.capitalize = function(task) {
    var first = task.substring(0,1);
    return first.toUpperCase() + task.substring(1);
};