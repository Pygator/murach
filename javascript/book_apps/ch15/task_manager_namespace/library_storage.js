"use strict";
myapp.utility.storage.get = function(key) {
    //get string from storage or an empty string if nothing in storage
    var storage = localStorage.getItem(key) || "";
    if (storage === "") { 
        return []; 
    } else {
        return storage.split("|");
    }
};

myapp.utility.storage.set = function(key, arr) {
    if (Array.isArray(arr)) {
        var storageString = arr.join("|"); 
        localStorage.setItem(key, storageString);
    }
};

myapp.utility.storage.clear = function(key) {
    localStorage.setItem(key, "");
};