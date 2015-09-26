"use strict";
/*var Task = function(task) {    
    this.text = task;
};
Task.prototype.isValid = function() {
    if (this.text === "") { return false; } 
    else { return true; }
};
Task.prototype.toString = function() {
    // capitalize
    var first = this.text.substring(0,1);
    return first.toUpperCase() + this.text.substring(1);
};
*/
var taskPrototype = {
	isValid: function() {
	    if (this.text === "") { return false; } 
    	else { return true; }
	},
	toString: function() {
  	    var first = this.text.substring(0,1);
		return first.toUpperCase() + this.text.substring(1);
	}
};

var getTask = function(taskText) {
	var task = Object.create(taskPrototype);
	task.text = taskText;
	return task;
}