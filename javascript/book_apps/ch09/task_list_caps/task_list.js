"use strict";
var $ = function(id) { return document.getElementById(id); };

var tasks = [];

var displayTaskList = function() {
    // if there are no tasks in tasks array, check storage
    if (tasks.length === 0) {
        // get tasks from storage and convert to array if not empty
        var storage = localStorage.getItem("tasks") || "";
        if (storage.length > 0) { tasks = storage.split("|"); }
    }
    // if there are tasks in array, sort and create capitalized tasks 
    if (tasks.length > 0) {
        var capitalized = tasks.sort().map(function(value){ 
            var first = value.substring(0,1);       // get first letter
            var remaining = value.substring(1);     // get remaining letters
            return first.toUpperCase() + remaining; // capitalize 
        });
    }
    // display capitalized tasks or empty string and set focus on task text box
    $("task_list").value = capitalized && capitalized.join("\n") || "";
    $("task").focus();
};

var addToTaskList = function() {   
    var task = $("task");
    if (task.value === "") {
        alert("Please enter a task.");
    } else {  
        // add task to array and local storage
        tasks.push(task.value);
        localStorage.tasks = tasks.join("|");

        // clear task text box and re-display tasks
        task.value = "";
        displayTaskList();
    }
};

var clearTaskList = function() {
    tasks.length = 0;
    localStorage.tasks = "";
    displayTaskList();
};

window.onload = function() {
    $("add_task").onclick = addToTaskList;
    $("clear_tasks").onclick = clearTaskList;    
    displayTaskList();
};