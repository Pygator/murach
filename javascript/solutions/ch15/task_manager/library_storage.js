"use strict";
myapp.prototype.localStorage = {
    get: function() { return localStorage.getItem(this.key); },
    set: function(str) { localStorage.setItem(this.key, str); },
    clear: function() { localStorage.setItem(this.key, ""); }
};

myapp.prototype.stringArrayStorage = Object.create(myapp.prototype.localStorage); // inherit
myapp.prototype.stringArrayStorage.get = function() {
    var str = myapp.prototype.localStorage.get.call(this) || "";
    return (str === "")? []: str.split("|");
};
myapp.prototype.stringArrayStorage.set = function(arr) {
    if (Array.isArray(arr)) {
        var str = arr.join("|"); 
        myapp.prototype.localStorage.set.call(this, str);
    }
};

myapp.storage.getTasks = function(key) {
    var storage = Object.create(myapp.prototype.stringArrayStorage); // inherit
    storage.key = key;                               // add own property
    return storage;
};
