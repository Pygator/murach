var $ = function (id) { return document.getElementById(id); }

var Tabs = function ( listId, contentsId ) {
    var that = this;
    this.listNode = $(listId);
    this.contentsNode = $(contentsId);

    // Retrieve tab links
    this.tabLinks = this.listNode.getElementsByTagName("a");
    if ( this.tabLinks.length == 0 ) {
       alert ("tabLinks has no entries");
    }
    
    // Retrieve contents divisions
    this.tabContents = this.contentsNode.getElementsByTagName("div");
    if ( this.tabContents.length == 0 ) {
       alert ("tabContents has no entries");
    }
        
    // Process tab links
    var i, node;
    for ( i = 0; i < this.tabLinks.length; i++ ) {
        node = this.tabLinks[i];

        // Attach event handler
        node.onclick = function (evt) {
            var link = this;
            if (!evt) evt = window.event;
            that.linkClick(evt, link);
        }
    }
}

Tabs.prototype.linkClick = function (evt, link) {
    var i, node, x;
    for ( i = 0; i < this.tabLinks.length; i++ ) {
        node = this.tabLinks[i];
        // node.setAttribute("class", "" );
        node.className = "";
        // Make the dotted lines go away...
        node.blur();
        if (node.getAttribute("id") == link.id) {
            x = i;
        }
    }
    //link.setAttribute("class", "active" );
    link.className = "active";
        
    for ( i = 0; i < this.tabContents.length; i++ ) {
        node = this.tabContents[i];
        //node.setAttribute("class", "hide" );
        node.className = "hide";
    }
    node=this.tabContents[x];
    //node.setAttribute("class", "" );
    node.className = "";
        
    // Cancel the default action of the event
    if ( evt.preventDefault ) {
        evt.preventDefault();
    } else {
        evt.returnValue = false;
    }
}