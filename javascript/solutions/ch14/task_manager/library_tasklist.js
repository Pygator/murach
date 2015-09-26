"use strict";
var createTaskList = function(div, handler) {
    //private variables and functions
    var tasks = [];
    var storage = getStorage("tasks_14");
    var sort = function() { tasks.sort(); };
    
    //private callback functions to pass to storage get and set methods
    var getTasks = function(storageString) {
        var strings = storageString.split("|");
        for (var i = 0; i < strings.length; i++) {
            // capitalize first word of task
            var space = strings[i].indexOf(" ");
            if (space === -1) {
                strings[i] = strings[i].toUpperCase(); // single word - capitalize whole thing
            } else {
                var word = strings[i].substring(0, space);
                var remaining = strings[i].substring(space);
                strings[i] = word.toUpperCase() + remaining;
            }
        }
        return strings;      
        //return (storageString === "")? []: storageString.split("|");
    };
    var setTasks = function(arr) { 
        return (Array.isArray(arr))? arr.join("|"): arr;
    };
    //public methods that have access to private variables and functions
    return {
        load: function() {
            if (tasks.length === 0) { tasks = storage.get(getTasks); } 
            return this;
        },
        reload: function() {
            tasks = storage.get(getTasks);
            return this;
        },
        save: function() {
            storage.set(tasks, setTasks); 
            return this;
        },
        add: function(task) {
            tasks.push(task);
            return this;
        },
        delete: function(i) {  
            sort();
            tasks.splice(i, 1);
            return this;
        },
        clear: function() {  
            tasks.length = 0;
            storage.clear();
            div.innerHTML = "";
            return this;
        },
        display: function() {
            sort();

            var html = "";
            for (var i in tasks) { 
                html = html.concat("<p>");
                html = html.concat("<a href='#' title='", i, "'>Delete</a>");
                html = html.concat("<span>", tasks[i].toString(), "</span>");
                html = html.concat("</p>");
            }
            div.innerHTML = html;
    
            var links = div.getElementsByTagName("a");
            for (var i = 0; i < links.length; i++) {
                links[i].onclick = handler;
            };
            return this;
        } 
    };
};
