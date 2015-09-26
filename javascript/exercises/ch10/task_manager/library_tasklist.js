"use strict";
var sortTaskList = function(tasks) {
    var isArray = Array.isArray(tasks);
    if (isArray) {
        tasks.sort();
    }
    return isArray;
};

var displaySortedTaskList = function(tasks, div, handler) {
    var html = "";
    var isArray = sortTaskList(tasks);
    
    if (isArray) {
        //create and load html string from sorted array
        for (var i in tasks) {
            html = html.concat("<p>");
            html = html.concat("<a href='#' id='", i, "'>Delete</a>");
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

var deleteTask = function(tasks, i) {  
    var isArray = sortTaskList(tasks);
    if (isArray) { tasks.splice(i, 1); }
};

var editTask = function(tasks, i, newText) {
    /* code goes here */
};

var capitalizeTask = function(task) {
    var first = task.substring(0,1);
    return first.toUpperCase() + task.substring(1);
};