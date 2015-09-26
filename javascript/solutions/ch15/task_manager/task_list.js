"use strict";
/**** Use namespaces ****/
//myapp.$ = function(id) { return document.getElementById(id); };
//
//myapp.addToTaskList = function() { 
//    var taskTextbox = myapp.$("task");
//    var newTask = new myapp.Task(taskTextbox.value);
//    if (newTask.isValid()) {
//        myapp.tasklist.add(newTask).save().display();
//        taskTextbox.value = "";
//    } else {
//        alert("Please enter a task.");
//    }
//    taskTextbox.focus();
//};
//
//myapp.clearTaskList = function() {
//    myapp.tasklist.clear();
//    myapp.$("task").focus();
//};
//
//myapp.deleteFromTaskList = function() {  
//    myapp.tasklist.delete(this.title).save().display(); // 'this' = clicked link
//    myapp.$("task").focus();
//};
//
//window.onload = function() {
//    myapp.$("add_task").onclick = myapp.addToTaskList;
//    myapp.$("clear_tasks").onclick = myapp.clearTaskList;   
//
//    myapp.tasklist.displayDiv = myapp.$("tasks");
//    myapp.tasklist.deleteClickHandler = myapp.deleteFromTaskList;
//
//    myapp.tasklist.load().display(); 
//    myapp.$("task").focus();
//};

/**** Use an IIFE ****/
(function() {
    var $ = function(id) { return document.getElementById(id); };

    var addToTaskList = function() { 
        var taskTextbox = $("task");
        var newTask = new myapp.Task(taskTextbox.value);
        if (newTask.isValid()) {
            myapp.tasklist.add(newTask).save().display();
            taskTextbox.value = "";
        } else {
            alert("Please enter a task.");
        }
        taskTextbox.focus();
    };

    var clearTaskList = function() {
        myapp.tasklist.clear();
        $("task").focus();
    };

    var deleteFromTaskList = function() {  
        myapp.tasklist.delete(this.title).save().display(); // 'this' = clicked link
        $("task").focus();
    };

    window.onload = function() {
        $("add_task").onclick = addToTaskList;
        $("clear_tasks").onclick = clearTaskList;   

        myapp.tasklist.displayDiv = $("tasks");
        myapp.tasklist.deleteClickHandler = deleteFromTaskList;

        myapp.tasklist.load().display(); 
        $("task").focus();
    };
})(); // invoke IIFE
