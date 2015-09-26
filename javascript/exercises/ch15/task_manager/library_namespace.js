// create the myapp namespace and the nested namespace creator function
var myapp = myapp || {};

myapp.addNamespace = function(namespace) {
    var currentName;
    var parent = this;
    var names = namespace.split(".");
 
    for (var i in names) {
        currentName = names[i];
        parent[currentName] = parent[currentName] || {};
        parent = parent[currentName];
    }
    return this;
}.bind(myapp);

// add the nested namespaces the application will use
// myapp.addNamespace("tasklist").addNamespace("Task"); //chain any additional namespaces you need
