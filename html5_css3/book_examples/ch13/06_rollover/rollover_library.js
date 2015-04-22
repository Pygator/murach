var $ = function (id) { return document.getElementById(id); }

var Rollover = function ( imageId, newImageURL ) {
    var that = this;
    this.newImageURL = newImageURL;
    this.image = $(imageId);

    // Validate node
    if ( ! this.image ) {
        throw new Error("Rollover: Image ID not found.");
    }
    if ( this.image.nodeType !== 1 || this.image.nodeName !== "IMG" ) {
        throw new Error("Rollover: Image ID is not an img tag.");
    }

    // Copy original image url
    this.oldImageURL = this.image.src;

    // Attach event handlers
    this.image.onmouseover = function () {
        that.image.src = that.newImageURL;
    }
    this.image.onmouseout = function () {
        that.image.src = that.oldImageURL;
    }
}