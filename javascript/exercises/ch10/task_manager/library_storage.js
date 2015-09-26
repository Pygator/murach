"use strict";
var getStorage = function(key) {
    //get string from storage or an empty string if nothing in storage
    var storage = localStorage.getItem(key) || "";
    if (storage === "") { 
        return []; 
    } else {
        return storage.split("|");
    }
};

var setStorage = function(key, arr) {
    if (Array.isArray(arr)) {
        var storageString = arr.join("|"); 
        localStorage.setItem(key, storageString);
    }
};

var clearStorage = function(key) {
    localStorage.setItem(key, "");
};