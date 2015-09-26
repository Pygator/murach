"use strict";
var localStoragePrototype = {
    get: function() { return localStorage.getItem(this.key); },
    set: function(str) { localStorage.setItem(this.key, str); },
    clear: function() { localStorage.setItem(this.key, ""); }
};

var storagePrototype = Object.create(localStoragePrototype);
    /* get and set methods use callback functions to determine their inner workings. 
     * They check to make sure a function has been passed, and call it if it has. 
     * Otherwise, they just pass along whatever was in storage (get) or whatever 
     * was passed in (set). */
storagePrototype.get = function(callback) {
    var storage = localStoragePrototype.get.call(this);
    if (callback && typeof callback === "function") {
        return callback(storage);
    } else {
        return storage;
    }
};
storagePrototype.set = function(storage, callback) {
    var storageString;
    if (callback && typeof callback === "function") {
        storageString = callback(storage);
    } else {
        storageString = storage.toString();
    }
    localStoragePrototype.set.call(this, storageString); 
};

var getStorage = function(key) {
    var t = Object.create(storagePrototype);
    t.key = key;
    return t;
};
