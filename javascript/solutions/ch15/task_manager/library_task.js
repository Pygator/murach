"use strict";
myapp.Task = function(task) {    
    this.text = task;
};
myapp.Task.prototype.isValid = function() {
    if (this.text === "") { return false; } 
    else { return true; }
};
myapp.Task.prototype.toString = function() {
    return this.text.capitalize();
};