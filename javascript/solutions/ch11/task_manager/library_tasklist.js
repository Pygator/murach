"use strict";
var tasklist = {
    tasks: [],
    storage: getTaskStorage("tasks_11"),
    displayDiv: null,
    deleteClickHandler: null,
	editClickHandler: null,
	
    load: function() {
        if (this.tasks.length === 0) {
            tasklist.tasks = this.storage.get();
        }
		return this;
    },
    save: function() {
        this.storage.set(this.tasks);
		return this;
    },
	sort: function() {
        this.tasks.sort();
		return this;
    },
    add: function(task) {
        this.tasks.push(task);
		return this;
    },
    delete: function(i) {
        this.sort();
        this.tasks.splice(i, 1);
		return this;
    },
	edit: function(i, task) {
		this.tasks[i] = task.toString();
		return this;
	},
    clear: function() {
        this.tasks.length = 0;
        this.storage.clear();
        this.displayDiv.innerHTML = "";
		return this;
    },
    display: function() {
        var html = "";
        this.sort();

        //create and load html string from sorted array
        for (var i in this.tasks) {
            html = html.concat("<p>");
            html = html.concat("<a href='#' title='", i, "'>Delete</a>");
			html = html.concat("<a href='#' title='", i, "'>Edit</a>");
            html = html.concat(this.tasks[i]);
            html = html.concat("</p>");
        }
        this.displayDiv.innerHTML = html;

        // get links, loop and add onclick event handler
        var links = this.displayDiv.getElementsByTagName("a");	
        for (var i = 0; i < links.length; i++) {
			if (links[i].innerHTML === "Delete") {
                links[i].onclick = this.deleteClickHandler;
            } else {
                links[i].onclick = this.editClickHandler;
            }
        }
		return this;
    }
};