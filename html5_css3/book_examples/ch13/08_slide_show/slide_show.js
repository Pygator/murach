var slideShow;

window.onload = function () {
    var params = {
        listId     : "image_list",
        imageId    : "image",
        captionId  : "caption",
        previousId : "btn_previous",
        playId     : "btn_play",
        playPauseId: "img_play_pause",
        nextId     : "btn_next",
        speedId    : "btn_speed"
    }

    slideShow = new SlideShow( params );
}