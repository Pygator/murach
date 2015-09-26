"use strict";
myapp.utility.$ = function(id) { return document.getElementById(id); };
// Use IIFE so that local variables, aliases, and event handlers aren't 
// added to global namespace but also aren't added to 'myapp' namespace
(function() {
    // create local variable
    var tasks = [];
    
    // create aliases
    var tasklist = myapp.tasklist;
    var u = myapp.utility;
    
    //define the display function
    var displayTasks = function() {
        if (tasks.length === 0) {
            tasks = u.storage.get("tasks_15");
        }
        tasklist.display(tasks, u.$("tasks"), deleteFromTaskList);
        u.$("task").focus();
    };
    
    //define the event handlers
    var addToTaskList = function() {    
        var task = u.$("task");
        if (task.value === "") {
            alert("Please enter a task.");
        } else {
            tasks.push(tasklist.capitalize(task.value));
            u.storage.set("tasks_15", tasks);

            task.value = "";
            displayTasks();
        }
    };
    var deleteFromTaskList = function() {
        tasklist.delete(tasks, this.title);
        u.storage.set("tasks_15", tasks);
        displayTasks();
    };
    var clearTaskList = function() {
        tasks.length = 0;
        u.storage.clear("tasks_15");
        u.$("tasks").innerHTML = "";
        u.$("task").focus();
    };
    
    //onload event
    window.onload = function() {
        u.$("add_task").onclick = addToTaskList;
        u.$("clear_tasks").onclick = clearTaskList;   
        displayTasks();
    };
})(); // invoke the IIFE