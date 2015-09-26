"use strict";
var $ = function(id) { return document.getElementById(id); };
var tasklist;

var addToTaskList = function() { 
    var taskTextbox = $("task");
    var newTask = new Task(taskTextbox.value);
    if (newTask.isValid()) {
        tasklist.add(newTask).save().reload().display();
        taskTextbox.value = "";
    } else { alert("Please enter a task."); }
    taskTextbox.focus();
};

var deleteFromTaskList = function() {  
    tasklist.delete(this.title).save().display(); // 'this' = clicked link
    $("task").focus();
};

var clearTaskList = function() {
    tasklist.clear();
    $("task").focus();
};

var boldExclamationPoint = function bold (node) {
    //if there are child nodes, loop them and call function for each one
    if (node.childNodes && node.childNodes.length > 0) {
        for(var i in node.childNodes) {
            bold(node.childNodes[i]); //recursion - calls itself
        }
    } else { // add bold tags if node has a an exclamation point
        if (node.nodeValue && node.nodeValue.indexOf("!") > -1) {
            var span = node.parentNode;
            span.innerHTML = '<b>' + node.nodeValue + '</b>';
        }
    }
};

window.onload = function() {
    $("add_task").onclick = addToTaskList;
    $("clear_tasks").onclick = clearTaskList;   
    $("bold").onclick = function() {
        //boldExclamationPoint(document); 
        boldExclamationPoint($("tasks"));
    };
    
    tasklist = createTaskList($("tasks"), deleteFromTaskList);
    tasklist.load().display(); 
    $("task").focus();
};