"use strict";
String.prototype.capitalize = String.prototype.capitalize || function() {
    var first = this.substring(0,1);
    return first.toUpperCase() + this.substring(1);
};
