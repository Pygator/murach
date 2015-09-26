$(document).ready(function() {
	var nextSlide = $("#slides img:first-child");
	var nextCaption;
	var nextSlideSource;
		
	// Start slide show
    timer1 = setInterval(
        function () {
        	$("#caption").hide(1000);   
        	$("#slide").slideUp(2000,
           		function () {
           	     	if (nextSlide.next().length == 0) {
						nextSlide = $("#slides img:first-child");
					}
					else {
						nextSlide = nextSlide.next();
					}
					nextSlideSource = nextSlide.attr("src");
					nextCaption = nextSlide.attr("alt");
					$("#caption").text(nextCaption).show(1000);
					$("#slide").attr("src", nextSlideSource).slideDown(2000);					
				}
			)
		}, 
		5000
	);
})