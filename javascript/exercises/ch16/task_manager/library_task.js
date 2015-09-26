"use strict";
var Task = function(task) {    
    this.text = task;
};
Task.prototype.isValid = function() {
    if (this.text === "") { return false; } 
    else { return true; }
};
Task.prototype.toString = function() {
    return this.text.capitalize();
};