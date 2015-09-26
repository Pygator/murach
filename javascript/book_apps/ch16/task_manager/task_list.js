"use strict";
var $ = function(id) { return document.getElementById(id); };
var tasks = [];

var displayTaskList = function() {
    // get tasks from storage and load them in tasks array
    var storage = localStorage.getItem("tasks_16_1") || null;
    tasks = JSON.parse(storage) || [];

    // create capitalized tasks 
    var capitalized = tasks.map(function(value){ 
        var first = value.task.substring(0,1);      // get first letter
        var remaining = value.task.substring(1);    // get remaining letters
        return {task: first.toUpperCase() + remaining, date: value.date };
    });
    // display capitalized tasks, set focus on task text box
    $("task_list").value = capitalized.reduce(function(prevValue, value) {
        return prevValue.concat(value.date, " - ", value.task, "\n");
    }, ""); // pass emtpy string as initial value
    $("task").focus();
};

var addToTaskList = function() {   
    var task = $("task");
    var taskDate = $("task_date");
    var d = new Date(taskDate.value);

    if (task.value === "" || d === "" || d.toString() === "Invalid Date"){
        alert("Please enter a task and date.");
    } else {  
        // add task to array and reset local storage
        tasks.push( {task: task.value, date: d.toDateString() } );
        localStorage.setItem("tasks_16_1", JSON.stringify(tasks));

        // clear text boxes and re-display tasks
        task.value = "";
        taskDate.value = "";
        displayTaskList();
    }
};

var clearTaskList = function() {
    tasks.length = 0;
    localStorage.setItem("tasks_16_1", "");
    displayTaskList();
};

window.onload = function() {
    $("add_task").onclick = addToTaskList;
    $("clear").onclick = clearTaskList;    
    displayTaskList();
};