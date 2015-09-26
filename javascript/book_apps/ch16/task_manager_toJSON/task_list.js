"use strict";
var $ = function(id) { return document.getElementById(id); };
var tasks;

var displayTaskList = function() {
    var storage = localStorage.getItem("tasks_16_2") || null;
    tasks = JSON.parse(storage) || [];
    
    // display tasks
    $("task_list").value = tasks.join("\n");
    
    // set focus on task text box
    $("task").focus();
};

var addToTaskList = function() {   
    var task = $("task");
    var taskDate = $("task_date");
    var d = new Date(taskDate.value);

    if (task.value === "" || d === "" || d.toString() === "Invalid Date") {
        alert("Please enter a task and date.");
    } else {  
        // add task to array and local storage
        tasks.push( new Task(task.value, d) );
        localStorage.setItem("tasks_16_2", JSON.stringify(tasks));

        // clear text boxes and re-display tasks
        task.value = "";
        taskDate.value = "";
        displayTaskList();
    }
};

var clearTaskList = function() {
    tasks.length = 0;
    localStorage.setItem("tasks_16_2", "");
    displayTaskList();
};

window.onload = function() {
    $("add_task").onclick = addToTaskList;
    $("clear").onclick = clearTaskList;    
    displayTaskList();
};