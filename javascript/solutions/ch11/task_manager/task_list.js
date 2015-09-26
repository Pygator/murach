"use strict";
var $ = function(id) { return document.getElementById(id); };

var addToTaskList = function() { 
    var taskTextbox = $("task");
//    var newTask = new Task(taskTextbox.value);
	var newTask = getTask(taskTextbox.value);
    if (newTask.isValid()) {
        tasklist.add(newTask);
        tasklist.save();
        tasklist.display();
        taskTextbox.value = "";        
    } else {
        alert("Please enter a task.");
    }
    taskTextbox.focus();
};

var clearTaskList = function() {
    tasklist.clear();
    $("task").focus();
};

var deleteFromTaskList = function() {
    tasklist.delete(this.title); // 'this' = clicked link
    tasklist.save();
    tasklist.display(); 
    $("task").focus();
};

var editTaskListItem = function() {
    var newText = prompt("Please enter new text", tasklist.tasks[this.title]);  // 'this' = clicked link
//    var editedTask = new Task(newText);
	var editedTask = getTask(newText);
	if (editedTask.isValid()) {
		tasklist.edit(this.title, editedTask).save().display(); 
    	$("task").focus();
	}
	else {
		alert("Please enter a valid task");
	}
};

window.onload = function() {
    $("add_task").onclick = addToTaskList;
    $("clear_tasks").onclick = clearTaskList;   
    
    tasklist.displayDiv = $("tasks");
    tasklist.deleteClickHandler = deleteFromTaskList;
	tasklist.editClickHandler = editTaskListItem;
    
    tasklist.load();
    tasklist.display();
    
    $("task").focus();
};