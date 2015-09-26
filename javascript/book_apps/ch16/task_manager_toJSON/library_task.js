"use strict";
var Task = function(task, date) {    
    this.text = task;
    this.date = date;
};
Task.prototype.toJSON = function() {
    // get date parts
    var m = this.date.getMonth() + 1; // correct for zero-based month
    var d = this.date.getDate();
    var y = this.date.getFullYear();

    // get task parts
    var first = this.text.substring(0,1).toUpperCase();        
    var remaining = this.text.substring(1); 

    // return short date string and capitalized task
    return m + "/" + d + "/" + y + " - " + first + remaining;
};