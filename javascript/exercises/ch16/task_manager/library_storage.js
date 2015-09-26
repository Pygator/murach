"use strict";
var localStoragePrototype = {
    get: function() { return localStorage.getItem(this.key); },
    set: function(str) { localStorage.setItem(this.key, str); },
    clear: function() { localStorage.setItem(this.key, ""); }
};

var stringArrayStoragePrototype = Object.create(localStoragePrototype); // inherit

stringArrayStoragePrototype.get = function() {
    var str = localStoragePrototype.get.call(this) || "";
    return (str === "")? []: str.split("|");
};
stringArrayStoragePrototype.set = function(arr) {
    if (Array.isArray(arr)) {
        var str = arr.join("|"); 
        localStoragePrototype.set.call(this, str);
    }
};

var getTaskStorage = function(key) {
    var storage = Object.create(stringArrayStoragePrototype); // inherit
    storage.key = key;                               // add own property
    return storage;
};
