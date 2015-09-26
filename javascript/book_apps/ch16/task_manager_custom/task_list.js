"use strict";
var $ = function(id) { return document.getElementById(id); };
var tasks;

var displayTaskList = function() {
    // get tasks from storage
    tasks = getTasks();
    
    // display tasks, or empty string if no tasks
    $("task_list").value = (tasks.display)? tasks.display: "";

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
        tasks.push( { task: task.value, date: d } );
        setTasks(tasks);

        // clear text boxes and re-display tasks
        task.value = "";
        taskDate.value = "";
        displayTaskList();
    }
};
var clearTaskList = function() {
    tasks.length = 0;
    clearTasks();
    displayTaskList();
};
window.onload = function() {
    $("add_task").onclick = addToTaskList;
    $("clear_tasks").onclick = clearTaskList;    
    displayTaskList();
};
