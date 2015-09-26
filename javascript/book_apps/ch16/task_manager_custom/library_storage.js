"use strict";
var getTasks = function() {
    var reviver = function(key, value) {
        if (key === "") { // value is the array of task objects
            // sort tasks by date
            value.sort(function(a,b){ return a.date - b.date; });
            
            // add a display string that combines short date and task
            value.display = value.reduce(function(prevValue, value) {
                return prevValue.concat(value.date.short, 
                " - ", value.task, "\n");
            }, ""); // pass emtpy string as initial value to reduce method
            
            return value;
        } else { 
            var dt = new Date(value);
            if (dt.toString() === "Invalid Date") { return value; } 
            else { 
                var m = dt.getMonth() + 1; // correct for zero-based month           
                dt.short = m + "/" + dt.getDate() + "/" + dt.getFullYear();
                return dt; 
            }
        }
    };
    var storage = localStorage.getItem("tasks_16_3") || "";
    return (storage === "")? []: JSON.parse(storage, reviver);
};

var setTasks = function(tasks) {
    var replacer = function(key, value) {
        if (key === "") return value;

        if (typeof value === "string") {
            // capitalize and return
            var first = value.substring(0,1).toUpperCase();       
            var remaining = value.substring(1);     
            return first + remaining;  
        } else { return value; }
    };
    var json = JSON.stringify(tasks, replacer);
    localStorage.setItem("tasks_16_3", json);
};

var clearTasks = function() {
    localStorage.setItem("tasks_16_3", "");
};