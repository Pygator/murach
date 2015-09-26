"use strict";
var localStoragePrototype = {
    get: function() { return localStorage.getItem(this.key); },
    set: function(str) { localStorage.setItem(this.key, str); },
    clear: function() { localStorage.setItem(this.key, ""); }
};

var stringArrayStoragePrototype = Object.create(localStoragePrototype); // inherit
stringArrayStoragePrototype.get = function() {
    var str = localStoragePrototype.get.call(this) || "";
    //return (str === "")? []: str.split("|");
    var reviver = function(key, value) {
        if (key === "date") { return new Date(value); } 
        else { return value; }
    };
    return (str === "")? []: JSON.parse(str, reviver);
};
stringArrayStoragePrototype.set = function(arr) {
    if (Array.isArray(arr)) {
        //var str = arr.join("|"); 
        var str = JSON.stringify(arr);
        localStoragePrototype.set.call(this, str);
    }
};

var getTaskStorage = function(key) {
    var storage = Object.create(stringArrayStoragePrototype); // inherit
    storage.key = key;                               // add own property
    return storage;
};
